package com.hackathon07.myApi.componenents; // Declaración del paquete en el que se encuentra la clase

import com.hackathon07.myApi.model.NoiseDataModel; // Importa el modelo para datos de ruido
import com.hackathon07.myApi.model.UbicationModel; // Importa el modelo para ubicaciones
import com.hackathon07.myApi.repositories.NoiseDataRepository; // Importa el repositorio de datos de ruido
import com.hackathon07.myApi.repositories.UbicationRepository; // Importa el repositorio de ubicaciones
import com.hackathon07.myApi.enums.CsvField; // Importa la enumeración de campos CSV
import com.opencsv.CSVReader; // Importa la clase CSVReader de OpenCSV
import com.opencsv.exceptions.CsvValidationException; // Importa la excepción de validación de CSV
import org.springframework.beans.factory.annotation.Autowired; // Importa la anotación para inyección de dependencias
import org.springframework.beans.factory.annotation.Value; // Importa la anotación para leer valores de propiedades
import org.springframework.boot.CommandLineRunner; // Importa la interfaz para ejecutar código al inicio
import org.springframework.stereotype.Component; // Importa la anotación de componente

import java.io.BufferedReader; // Importa la clase BufferedReader (no utilizada aquí)
import java.io.File; // Importa la clase File
import java.io.FileReader; // Importa la clase FileReader
import java.io.IOException; // Importa la clase IOException para manejo de excepciones
import java.nio.file.Files; // Importa la clase Files (no utilizada aquí)
import java.nio.file.Paths; // Importa la clase Paths (no utilizada aquí)
import java.time.LocalDate; // Importa la clase LocalDate para manejo de fechas
import java.time.ZoneId; // Importa la clase ZoneId para zonas horarias
import java.util.*; // Importa todas las clases de utilidades, como List, Set, etc.

@Component // Anotación para declarar la clase como un componente Spring
public class FileLoader implements CommandLineRunner { // Implementa CommandLineRunner para ejecutar código al inicio

    @Autowired // Inyección automática del repositorio de ubicaciones
    UbicationRepository ubicationRepo;

    @Autowired // Inyección automática del repositorio de datos de ruido
    NoiseDataRepository noiseDataRepo;

    @Value("${csvImport.reset}") // Lee el valor de la propiedad 'csvImport.reset'
    private boolean reset;

    @Value("${csvImport.readLocations}") // Lee el valor de la propiedad 'csvImport.readLocations'
    private boolean readLocations;

    @Value("${csvImport.folder}") // Lee la ruta del folder donde se encuentran los archivos CSV
    private String folder;

    @Value("${csvImport.name}") // Lee el nombre del archivo CSV
    private String fileName;

    @Override
    public void run(String... args) { // Método que se ejecuta al inicio de la aplicación

        File file = new File(folder, fileName); // Crea un objeto File con la ruta y el nombre del archivo

        // Verifica si el archivo existe y no es un directorio
        if (file.exists() && !file.isDirectory()) {
            // Si se debe reiniciar los datos
            if (reset){
                noiseDataRepo.deleteAll(); // Borra todos los datos de ruido
                if (readLocations) ubicationRepo.deleteAll(); // Borra todas las ubicaciones si se indica
            }
            try {
                // Si se deben leer ubicaciones, llama a la función correspondiente
                if (readLocations) saveUbicationsListFromCSV(file);
                // Procesa los datos de ruido desde el archivo CSV
                processNoiseDataCSV(file);
            } catch (IOException e) {
                throw new RuntimeException(e); // Lanza una excepción en caso de error
            }
        }
    }

    private void saveUbicationsListFromCSV(File file) throws IOException { // Método para guardar ubicaciones desde CSV

        Set<UbicationModel> ubications = new HashSet<>(); // Usa un conjunto para evitar duplicados

        try (CSVReader reader = new CSVReader(new FileReader(file))) { // Inicializa el lector CSV
            String[] data; // Array para almacenar los datos de cada línea
            data = reader.readNext(); // Lee la primera línea (encabezados)
            // Lee las siguientes líneas
            while ((data = reader.readNext()) != null) {
                // Extrae los datos de nombre, longitud y latitud
                String name = data[CsvField.NAME.getColumn()]; // Obtiene el nombre de la ubicación
                double longitude = Double.parseDouble(data[CsvField.LONGITUDE.getColumn()].replace(",",".")); // Convierte a doble
                double latitude = Double.parseDouble(data[CsvField.LATITUDE.getColumn()].replace(",",".")); // Convierte a doble

                // Crea una nueva instancia de UbicationModel y la configura
                UbicationModel ubication = new UbicationModel();
                ubication.setName(name);
                ubication.setLongitude(longitude);
                ubication.setLatitude(latitude);
                ubications.add(ubication); // Agrega al conjunto
            }
            ubicationRepo.saveAll(ubications); // Guarda todas las ubicaciones en la base de datos
        } catch (CsvValidationException e) {
            throw new RuntimeException(e); // Lanza una excepción en caso de error
        }
    }

    private void processNoiseDataCSV(File file) throws IOException { // Método para procesar datos de ruido desde CSV
        List<UbicationModel> ubications = ubicationRepo.findAll(); // Obtiene todas las ubicaciones de la base de datos
        List<NoiseDataModel> noiseData = new ArrayList<>(); // Lista para almacenar datos de ruido

        try (CSVReader reader = new CSVReader(new FileReader(file))) { // Inicializa el lector CSV
            String[] data; // Array para almacenar los datos de cada línea
            data = reader.readNext(); // Lee la primera línea (encabezados)
            // Lee las siguientes líneas
            while ((data = reader.readNext()) != null) {
                // Crea una nueva instancia de NoiseDataModel y la configura
                NoiseDataModel noiseDataEntry = new NoiseDataModel();
                noiseDataEntry.setDate(convertToDate(data[CsvField.YEAR.getColumn()], data[CsvField.MONTH.getColumn()], data[CsvField.DAY.getColumn()])); // Convierte y establece la fecha
                noiseDataEntry.setNoiseLevel(Integer.parseInt(data[CsvField.LEVEL.getColumn()])); // Establece el nivel de ruido
                noiseDataEntry.setHour(Integer.parseInt(data[CsvField.HOUR.getColumn()])); // Establece la hora
                noiseDataEntry.setDBs(Double.parseDouble(data[CsvField.DBS.getColumn()])); // Establece los decibelios
                String name = data[CsvField.NAME.getColumn()]; // Obtiene el nombre de la ubicación
                // Busca la ubicación correspondiente en la lista de ubicaciones
                UbicationModel ubication = ubications.stream().filter(u -> u.getName().equalsIgnoreCase(name)).findFirst().orElse(null);
                noiseDataEntry.setUbication(ubication); // Establece la ubicación en los datos de ruido
                noiseData.add(noiseDataEntry); // Agrega el objeto a la lista

                // Si la lista de datos de ruido tiene más de 500 elementos, se guardan en la base de datos
                if (noiseData.size() > 500){
                    noiseDataRepo.saveAll(noiseData); // Guarda en la base de datos
                    noiseData.clear(); // Limpia la lista
                }
            }
            noiseDataRepo.saveAll(noiseData); // Guarda cualquier dato restante en la base de datos
        } catch (CsvValidationException e) {
            throw new RuntimeException(e); // Lanza una excepción en caso de error
        }
    }

    public static Date convertToDate(String year, String month, String day) { // Método para convertir cadenas a objeto Date
        LocalDate localDate = LocalDate.of(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day)); // Crea un objeto LocalDate
        return Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant()); // Convierte LocalDate a Date
    }
}
