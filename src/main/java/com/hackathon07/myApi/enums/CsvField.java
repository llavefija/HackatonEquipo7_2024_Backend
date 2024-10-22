package com.hackathon07.myApi.enums;

import lombok.Getter;

@Getter
public enum CsvField {
    NAME(6),
    LONGITUDE(8),
    LATITUDE(7),
    HOUR(5),
    DAY(3),
    MONTH(2),
    YEAR(1),
    DBS(11),
    LEVEL(12);

    private final int column;

    CsvField(int column){
        this.column = column;
    }

}
