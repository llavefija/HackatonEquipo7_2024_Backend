# DATASET para APP de Información Turística en Barcelona

## Descripción del Proyecto
Este proyecto es una **Dataset** desarrollado para una aplicación que proporciona a turistas y residentes de **Barcelona** información sobre los **puntos turísticos** más visitados en un día y realiza **previsiones** sobre la afluencia esperada en las próximas horas. 

## Origen
El origen de los datos son varios .csv de Barcelona Open Data con los registros y otro .csv maestro con la información de los puntos de medición utilizados. 
No existe punto API para dicho dataset. 

## Metodologia
### EDA
1. Usamos Python para compilar un dataframe uniendo varios archivos .csv con la intención de calcular una media de las observaciones de varios años o hacer una predicción con machine learning.
2. Realizamos limpieza de datos; comprobación de nulos y duplicados
3. Buscamos en el maestro puntos de medición cercanos a destinos turísticos
4. Filtramos el dataframe con dichos puntos de medición
5. Comprobamos que dichos puntos no son fijos y desaparecen periódicamente por lo que no podemos realizar una predicción o media.
6. Utilizamos Power Bi para visualizar con claridad que puntos disponen de los datos de todo el 2023 y seleccionamos 9 puntos

### Transformación de Datos
1. Para evaluar el augmento de ruido e inferir de ello la afluéncia de gente, usamos Power Bi para crear una columna con categorias ponderadas por cada
   punto de medición, en base a sus mínimas y máximas mediciones.
2. Depuramos el datframe para obtener un .csv ligero con la mínima información necesària para pasarla a BackEnd.

