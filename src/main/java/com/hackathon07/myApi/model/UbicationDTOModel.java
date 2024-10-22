package com.hackathon07.myApi.model;

    // PARAMETROS
    public class UbicationDTOModel {
        private Double latitude;
        private Double longitude;
        private String name;

        // CONSTRUCTOR
        public UbicationDTOModel(Double latitude, Double longitude, String name) {
            this.latitude = latitude;
            this.longitude = longitude;
            this.name = name;
        }

        // GETTERS
        public Double getLatitude() {
            return latitude;
        }

        public Double getLongitude() {
            return longitude;
        }

        public String getName() {
            return name;
        }
    }


