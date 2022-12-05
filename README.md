# Spring Boot "Weather API" 

This is an example of a REST weather API which retrieves specific weather data metrics from various weather stations.

## Project Build

* Clone this repository 
* Make sure you are using JDK 1.8 and Maven 3.x
* You can build the project and run the tests by running ```mvn clean install```
* Once successfully built, you can run the service by ```WeatherApplication -> Run As -> Java Application```

## Database Setup

### Create table
```
CREATE TABLE `weather` (
 `id` int(128) NOT NULL AUTO_INCREMENT,
 `station` varchar(128) COLLATE utf8_bin NOT NULL,
 `date` date NOT NULL,
 `temperature` varchar(128) COLLATE utf8_bin NOT NULL,
 `humidity` varchar(128) COLLATE utf8_bin NOT NULL,
 `wind_speed` varchar(128) COLLATE utf8_bin NOT NULL,
 `air_pressure` varchar(128) COLLATE utf8_bin NOT NULL,
 `dew_point` varchar(128) COLLATE utf8_bin NOT NULL,
 PRIMARY KEY (`id`)
 ) ENGINE=MyISAM AUTO_INCREMENT=11 DEFAULT CHARSET=utf8 COLLATE=utf8_bin
```
### Insert data
```
INSERT INTO `weather` (`id`, `station`, `date`, `temperature`, `humidity`, `wind_speed`, `air_pressure`, `dew_point`) VALUES ('1', 'NEW YORK', '2022-11-25', '5', '22', '8', '1023', '22'); 
INSERT INTO `weather` (`id`, `station`, `date`, `temperature`, `humidity`, `wind_speed`, `air_pressure`, `dew_point`) VALUES ('2', 'NEW YORK', '2022-11-26', '6', '41', '16', '963', '35'); 
INSERT INTO `weather` (`id`, `station`, `date`, `temperature`, `humidity`, `wind_speed`, `air_pressure`, `dew_point`) VALUES ('3', 'NEW YORK', '2022-11-27', '11', '36', '29', '458', '10'); 
INSERT INTO `weather` (`id`, `station`, `date`, `temperature`, `humidity`, `wind_speed`, `air_pressure`, `dew_point`) VALUES ('4', 'NEW YORK', '2022-11-28', '2', '55', '30', '745', '18'); 
INSERT INTO `weather` (`id`, `station`, `date`, `temperature`, `humidity`, `wind_speed`, `air_pressure`, `dew_point`) VALUES ('5', 'NEW YORK', '2022-11-29', '1', '21', '5', '1065', '26'); 
INSERT INTO `weather` (`id`, `station`, `date`, `temperature`, `humidity`, `wind_speed`, `air_pressure`, `dew_point`) VALUES ('6', 'NEW YORK', '2022-11-30', '9', '9', '17', '458', '39'); 
INSERT INTO `weather` (`id`, `station`, `date`, `temperature`, `humidity`, `wind_speed`, `air_pressure`, `dew_point`) VALUES ('7', 'NEW YORK', '2022-12-1', '7', '27', '45', '965', '28'); 
INSERT INTO `weather` (`id`, `station`, `date`, `temperature`, `humidity`, `wind_speed`, `air_pressure`, `dew_point`) VALUES ('8', 'NEW YORK', '2022-12-2', '2', '39', '37', '740', '37'); 
INSERT INTO `weather` (`id`, `station`, `date`, `temperature`, `humidity`, `wind_speed`, `air_pressure`, `dew_point`) VALUES ('9', 'NEW YORK', '2022-12-3', '3', '12', '15', '1098', '13'); 
INSERT INTO `weather` (`id`, `station`, `date`, `temperature`, `humidity`, `wind_speed`, `air_pressure`, `dew_point`) VALUES ('10', 'NEW YORK', '2022-12-4', '5', '43', '3', '485', '38'); 

INSERT INTO `weather` (`id`, `station`, `date`, `temperature`, `humidity`, `wind_speed`, `air_pressure`, `dew_point`) VALUES ('11', 'DUBLIN', '2022-11-25', '5', '22', '8', '1023', '22'); 
INSERT INTO `weather` (`id`, `station`, `date`, `temperature`, `humidity`, `wind_speed`, `air_pressure`, `dew_point`) VALUES ('12', 'DUBLIN', '2022-11-26', '6', '41', '16', '963', '35'); 
INSERT INTO `weather` (`id`, `station`, `date`, `temperature`, `humidity`, `wind_speed`, `air_pressure`, `dew_point`) VALUES ('13', 'DUBLIN', '2022-11-27', '11', '36', '29', '458', '10'); 
INSERT INTO `weather` (`id`, `station`, `date`, `temperature`, `humidity`, `wind_speed`, `air_pressure`, `dew_point`) VALUES ('14', 'DUBLIN', '2022-11-28', '2', '55', '30', '745', '18'); 
INSERT INTO `weather` (`id`, `station`, `date`, `temperature`, `humidity`, `wind_speed`, `air_pressure`, `dew_point`) VALUES ('15', 'DUBLIN', '2022-11-29', '1', '21', '5', '1065', '26'); 
INSERT INTO `weather` (`id`, `station`, `date`, `temperature`, `humidity`, `wind_speed`, `air_pressure`, `dew_point`) VALUES ('16', 'DUBLIN', '2022-11-30', '9', '9', '17', '458', '39'); 
INSERT INTO `weather` (`id`, `station`, `date`, `temperature`, `humidity`, `wind_speed`, `air_pressure`, `dew_point`) VALUES ('17', 'DUBLIN', '2022-12-1', '7', '27', '45', '965', '28'); 
INSERT INTO `weather` (`id`, `station`, `date`, `temperature`, `humidity`, `wind_speed`, `air_pressure`, `dew_point`) VALUES ('18', 'DUBLIN', '2022-12-2', '2', '39', '37', '740', '37'); 
INSERT INTO `weather` (`id`, `station`, `date`, `temperature`, `humidity`, `wind_speed`, `air_pressure`, `dew_point`) VALUES ('19', 'DUBLIN', '2022-12-3', '3', '12', '15', '1098', '13'); 
INSERT INTO `weather` (`id`, `station`, `date`, `temperature`, `humidity`, `wind_speed`, `air_pressure`, `dew_point`) VALUES ('20', 'DUBLIN', '2022-12-4', '5', '43', '3', '485', '38'); 

INSERT INTO `weather` (`id`, `station`, `date`, `temperature`, `humidity`, `wind_speed`, `air_pressure`, `dew_point`) VALUES ('21', 'LONDON', '2022-11-25', '5', '22', '8', '1023', '22'); 
INSERT INTO `weather` (`id`, `station`, `date`, `temperature`, `humidity`, `wind_speed`, `air_pressure`, `dew_point`) VALUES ('22', 'LONDON', '2022-11-26', '6', '41', '16', '963', '35'); 
INSERT INTO `weather` (`id`, `station`, `date`, `temperature`, `humidity`, `wind_speed`, `air_pressure`, `dew_point`) VALUES ('23', 'LONDON', '2022-11-27', '11', '36', '29', '458', '10'); 
INSERT INTO `weather` (`id`, `station`, `date`, `temperature`, `humidity`, `wind_speed`, `air_pressure`, `dew_point`) VALUES ('24', 'LONDON', '2022-11-28', '2', '55', '30', '745', '18'); 
INSERT INTO `weather` (`id`, `station`, `date`, `temperature`, `humidity`, `wind_speed`, `air_pressure`, `dew_point`) VALUES ('25', 'LONDON', '2022-11-29', '1', '21', '5', '1065', '26'); 
INSERT INTO `weather` (`id`, `station`, `date`, `temperature`, `humidity`, `wind_speed`, `air_pressure`, `dew_point`) VALUES ('26', 'LONDON', '2022-11-30', '9', '9', '17', '458', '39'); 
INSERT INTO `weather` (`id`, `station`, `date`, `temperature`, `humidity`, `wind_speed`, `air_pressure`, `dew_point`) VALUES ('27', 'LONDON', '2022-12-1', '7', '27', '45', '965', '28'); 
INSERT INTO `weather` (`id`, `station`, `date`, `temperature`, `humidity`, `wind_speed`, `air_pressure`, `dew_point`) VALUES ('28', 'LONDON', '2022-12-2', '2', '39', '37', '740', '37'); 
INSERT INTO `weather` (`id`, `station`, `date`, `temperature`, `humidity`, `wind_speed`, `air_pressure`, `dew_point`) VALUES ('29', 'LONDON', '2022-12-3', '3', '12', '15', '1098', '13'); 
INSERT INTO `weather` (`id`, `station`, `date`, `temperature`, `humidity`, `wind_speed`, `air_pressure`, `dew_point`) VALUES ('30', 'LONDON', '2022-12-4', '5', '43', '3', '485', '38'); 
```

## Endpoints
### GET All - http://localhost:8080/api/weather
```
{
        "id": 4,
        "station": "NEW YORK",
        "date": "2022-11-28",
        "temperature": 2.0,
        "humidity": 55.0,
        "windSpeed": 30.0,
        "airPressure": 745.0,
        "dewPoint": 18.0
}
```
### POST - http://localhost:8080/api/weather
```
{
"id": "31",
"station": "LONDON",
"date": "2022-12-05",
"temperature": "5",
"humidity": "41",
"windSpeed": "8",
"airPressure": "1023",
"dewPoint": "22"
}
```
### PUT - http://localhost:8080/api/weather/31
```
{
"id": "31",
"station": "LONDON",
"date": "2022-12-05",
"temperature": "12",
"humidity": "41",
"windSpeed": "8",
"airPressure": "1023",
"dewPoint": "22"
}
```
### DELETE - http://localhost:8080/api/weather/31

### GET ALL STATION + METRIC RANGE - http://localhost:8080/api/weather/DUBLIN/TEMPERATURE/2022-11-25/2022-11-29
```
{
    "TOTAL": 25.0,
    "MINIMUM": 1.0,
    "MAXIMUM": 11.0,
    "AVERAGE": 5.0,
    "TYPE": "TEMPERATURE"
}
```

### GET STATION + METRIC ALL - http://localhost:8080/api/weather/DUBLIN/TEMPERATURE

```
{
    "TOTAL": 51.0,
    "MINIMUM": 1.0,
    "MAXIMUM": 11.0,
    "AVERAGE": 5.1,
    "TYPE": "TEMPERATURE"
}
```

### GET ALL STATION - http://localhost:8080/api/weather/NEW YORK


## Questions and Comments: william@williamwall.ie
