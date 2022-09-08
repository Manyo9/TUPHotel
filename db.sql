// BASE DE DATOS MOTOR MYSQL

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