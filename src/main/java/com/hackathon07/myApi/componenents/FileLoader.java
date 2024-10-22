package com.hackathon07.myApi.componenents;

import com.hackathon07.myApi.model.NoiseDataModel;
import com.hackathon07.myApi.model.UbicationModel;
import com.hackathon07.myApi.repositories.NoiseDataRepository;
import com.hackathon07.myApi.repositories.UbicationRepository;
import com.hackathon07.myApi.enums.CsvField;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;

@Component
public class FileLoader implements CommandLineRunner {

    @Autowired
    UbicationRepository ubicationRepo;

    @Autowired
    NoiseDataRepository noiseDataRepo;

    @Value("${csvImport.reset}")
    private boolean reset;

    @Value("${csvImport.readLocations}")
    private boolean readLocations;

    @Value("${csvImport.folder}")
    private String folder;

    @Value("${csvImport.name}")
    private String fileName;

    @Override
    public void run(String... args) {

        File file = new File(folder, fileName);

        if (file.exists() && !file.isDirectory()) {
            if (reset){
                noiseDataRepo.deleteAll();
                if (readLocations) ubicationRepo.deleteAll();
            }
            try {
                if (readLocations) saveUbicationsListFromCSV(file);
                processNoiseDataCSV(file);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private void saveUbicationsListFromCSV(File file) throws IOException {

        Set<UbicationModel> ubications = new HashSet<>();

        try (CSVReader reader = new CSVReader(new FileReader(file))) {
            String[] data;
            data = reader.readNext();
            while ((data = reader.readNext()) != null) {
                String name = data[CsvField.NAME.getColumn()];
                double longitude = Double.parseDouble(data[CsvField.LONGITUDE.getColumn()].replace(",","."));
                double latitude = Double.parseDouble(data[CsvField.LATITUDE.getColumn()].replace(",","."));

                UbicationModel ubication = new UbicationModel();
                ubication.setName(name);
                ubication.setLongitude(longitude);
                ubication.setLatitude(latitude);
                ubications.add(ubication);
            }
            ubicationRepo.saveAll(ubications);
        } catch (CsvValidationException e) {
            throw new RuntimeException(e);
        }
    }

    private void processNoiseDataCSV(File file) throws IOException {
        List<UbicationModel> ubications = ubicationRepo.findAll();
        List<NoiseDataModel> noiseData = new ArrayList<>();

        try (CSVReader reader = new CSVReader(new FileReader(file))) {
            String[] data;
            data = reader.readNext();
            while ((data = reader.readNext()) != null) {

                NoiseDataModel noiseDataEntry = new NoiseDataModel();
                noiseDataEntry.setDate(convertToDate(data[CsvField.YEAR.getColumn()], data[CsvField.MONTH.getColumn()], data[CsvField.DAY.getColumn()]));
                noiseDataEntry.setNoiseLevel(Integer.parseInt(data[CsvField.LEVEL.getColumn()]));
                noiseDataEntry.setHour(Integer.parseInt(data[CsvField.HOUR.getColumn()]));
                noiseDataEntry.setDBs(Double.parseDouble(data[CsvField.DBS.getColumn()]));
                String name = data[CsvField.NAME.getColumn()];
                UbicationModel ubication = ubications.stream().filter(u -> u.getName().equalsIgnoreCase(name)).findFirst().orElse(null);
                noiseDataEntry.setUbication(ubication);
                noiseData.add(noiseDataEntry);

                if (noiseData.size() > 500){
                    noiseDataRepo.saveAll(noiseData);
                    noiseData.clear();
                }

            }
            noiseDataRepo.saveAll(noiseData);
        } catch (CsvValidationException e) {
            throw new RuntimeException(e);
        }
    }



    public static Date convertToDate(String year, String month, String day) {
        LocalDate localDate = LocalDate.of(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day));
        return Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
    }

}
