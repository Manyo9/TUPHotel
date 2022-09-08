# TUPHotel
Hotel Test App

En un hotel los pasajeros pueden contratar servicios adicionales a su estadı́a los cuales son abonados al finalizar la estadı́a. Para administrar 
los datos de esos servicios el hotel posee una base de datos con la siguiente estructura:

Servicios
IdServicio (PK) int
Concepto varchar
IdHabitacion (FK) int
Importe float

Habitaciones
IdHabitacion (PK) int
Denominacion varchar

El usuario nos solicita un programa que permita almacenar los datos de los servicios en la base de datos existente. El programa deberá poseer la siguiente funcionalidad:
• Alta de servicios: Una pantalla debe permitir almacenar los datos un servicio contratado. La pantalla deberá mostrar con un control adecuado 
la lista de habitaciones para que pueda seleccionar.
• Reportes: Deberán presentarse en una o más ventanas los siguientes reportes:
– Suma de todos los servicios contratados
– Id y denominación de habitación y suma de servicios contratados por todas aquellas habitaciones que registren más de 3 servicios.
- Concepto e importe de todos aquellos servicios contratados por una habitación en particular seleccionada por el usuario

BASE DE DATOS MOTOR MYSQL

use hotel;
CREATE TABLE `hotel`.`habitaciones`(
    IdHabitacion int NOT NULL,
    Denominacion varchar(100) NOT NULL,
    PRIMARY KEY (`IdHabitacion`)
);


CREATE TABLE `hotel`.`Servicios`(
    IdServicio int AUTO_INCREMENT NOT NULL,
    Concepto varchar(100) NOT NULL,
    IdHabitacion int NOT NULL,
    Importe float NOT NULL,
    PRIMARY KEY (`IdServicio`),
    CONSTRAINT FK_Servicios_Habitacion FOREIGN KEY(IdHabitacion)
REFERENCES Habitaciones (IdHabitacion)
);


INSERT INTO Habitaciones VALUES (101, 'Primer piso hab. 1');
INSERT INTO Habitaciones VALUES (102, 'Primer piso hab. 2');
INSERT INTO Habitaciones VALUES (103, 'Primer piso hab. 3');
INSERT INTO Habitaciones VALUES (104, 'Primer piso hab. 4');
INSERT INTO Habitaciones VALUES (201, 'Segundo piso hab. 1');
INSERT INTO Habitaciones VALUES (202, 'Segundo piso hab. 2');
INSERT INTO Habitaciones VALUES (301, 'Tercer piso hab. 1');
INSERT INTO Habitaciones VALUES (302, 'Tercer piso hab. 2');
INSERT INTO Habitaciones VALUES (401, 'Suite');