package com.hackathon07.myApi.enums;

import lombok.Getter;

@Getter
public enum CsvField {
    NAME(6),
    LONGITUDE(5),
    LATITUDE(8),
    HOUR(13),
    DAY(2),
    MONTH(10),
    YEAR(0),
    DBS(12),
    LEVEL(1);

    private final int column;

    CsvField(int column){
        this.column = column;
    }

}
