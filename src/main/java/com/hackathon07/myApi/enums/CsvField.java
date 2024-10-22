package com.hackathon07.myApi.enums;

// Importación de la anotación Getter de Lombok para generar métodos getter automáticamente
import lombok.Getter;

// Definición de la enumeración CsvField que representa los campos de un archivo CSV
@Getter
public enum CsvField {
    // Declaración de los campos del CSV con su respectivo número de columna
    NAME(6),          // Campo que representa el nombre en la columna 6
    LONGITUDE(8),     // Campo que representa la longitud en la columna 8
    LATITUDE(7),      // Campo que representa la latitud en la columna 7
    HOUR(5),          // Campo que representa la hora en la columna 5
    DAY(3),           // Campo que representa el día en la columna 3
    MONTH(2),         // Campo que representa el mes en la columna 2
    YEAR(1),          // Campo que representa el año en la columna 1
    DBS(11),          // Campo que representa los decibelios (DBS) en la columna 11
    LEVEL(12);        // Campo que representa el nivel en la columna 12

    private final int column; // Variable de instancia para almacenar el número de columna asociado al campo

    // Constructor de la enumeración que asigna el número de columna
    CsvField(int column) {
        this.column = column; // Inicializa la variable de instancia con el valor pasado
    }

}
