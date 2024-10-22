# API Web para Información Turística en Barcelona

## Descripción del Proyecto
Este proyecto es una **API** desarrollada para una aplicación que proporciona a turistas y residentes de **Barcelona** información sobre los **puntos turísticos** más visitados en un día y realiza **previsiones** sobre la afluencia esperada en las próximas horas. La API está construida utilizando el framework de **Spring Boot** en **Java**.

## Requisitos Previos
- **Java 17** o superior.
- Base de datos **MySQL**, ejecutar el script 'createDb.sql' para crear una base de datos llamada `hackaton07`. (Esto puede ser modificado en el archivo `application.properties` del proyecto).
- Usuario con permisos **root** y contraseña `M@s7erKey`. (También se puede cambiar en `application.properties`).

## Instalación y Ejecución del Proyecto

1. **Clonar el Repositorio** a tu máquina local:
   ```bash
   git clone https://github.com/llavefija/HackatonEquipo7_2024_Backend.git

   ## Instalación y Ejecución del Proyecto

2. **Navegar al Directorio** del Proyecto: `cd HackatonEquipo7_2024_Backend`
  
3. **Iniciar** el Proyecto:

Desde un IDE compatible con Java, localiza y ejecuta la clase `Hackaton07Application`.
O bien, desde la terminal, ejecuta el siguiente comando:

  ```bash
  mvn spring-boot:run
  ```
Una vez iniciado, la API estará disponible en: http://localhost:8080.

## Endpoints

### Ubicaciones y Noise

- **Recoger ubicaciones**: 
  - **Método**: `GET`
  - **URL**: `http://localhost:8080/ubications`
  - **Descripción**: Obtiene una lista de las ubicaciones y cordenadas.

- **Recoger ruidos**: 
  - **Método**: `GET`
  - **URL**: `http://localhost:8080/noises`
  - **Descripción**: Obtiene una lista de ruidos y fechas.
 
- **Recoger datos combinados por hora y fecha**: 
  - **Método**: `GET`
  - **URL**: `http://localhost:8080/ubicationsAllInfo/dbcolors/{fecha}/{hora}`
  - **Descripción**: Obtiene una lista de ruidos y fechas seleccionados por la fecha.
 
- **Recoger datos combinados por fecha e id de ubicacion**: 
  - **Método**: `GET`
  - **URL**: `http://localhost:8080/ubicationsAllInfo/dbcolorsByUbication/{fecha}/{idUbicacion}`
  - **Descripción**: Obtiene una lista de ruidos y fechas seleccionados por la fecha y por el id de la ubicacion.
  
