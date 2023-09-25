create table  `nexos`.`departamentos`( id INT not null auto_increment primary key,
 departamento_codigo INT,
 departamento_nombre varchar(20),
fecha_hora_crea datetime,
fecha_hora_modifica datetime);

CREATE TABLE `nexos`.`empleados` ( id INT not null auto_increment primary key,
 documento_tipo varchar(5),
 documento_numero INT not null,
nombres varchar(20),
apellidos varchar(20),
departamentos_id int,
ciudad varchar(20),
dirección  varchar(20),
correo_electrónico varchar(20),
elefono long,
fecha_hora_crea datetime,
fecha_hora_modifica datetime,

);

ALTER TABLE `nexos`.`empleados` 
ADD CONSTRAINT `departamentos_id`
  FOREIGN KEY (`departamentos_id`)
  REFERENCES `nexos`.`departamentos` (`departamento_codigo`)
  ON DELETE CASCADE
  ON UPDATE CASCADE;