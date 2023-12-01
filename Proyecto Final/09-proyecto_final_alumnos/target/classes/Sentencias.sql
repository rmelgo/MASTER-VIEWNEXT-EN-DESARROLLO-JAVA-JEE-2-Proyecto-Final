CREATE SCHEMA `proyecto_final_bd` ;

CREATE TABLE `proyecto_final_bd`.`alumnos` (
  `dni` VARCHAR(50) NOT NULL,
  `nombre` VARCHAR(45) NULL,
  `apellido1` VARCHAR(45) NULL,
  `apellido2` VARCHAR(45) NULL,
  `direccion` VARCHAR(200) NULL,
  `fecha_nacimiento` DATE NULL,
  PRIMARY KEY (`dni`));
  
INSERT INTO `proyecto_final_bd`.`alumnos` (`dni`, `nombre`, `apellido1`, `apellido2`, `direccion`, `fecha_nacimiento`) VALUES ('70925689Z', 'Raúl', 'Melgosa', 'Salvador', 'Calle Camino Estrecho de la Aldehuela', '2001-12-12');
INSERT INTO `proyecto_final_bd`.`alumnos` (`dni`, `nombre`, `apellido1`, `apellido2`, `direccion`, `fecha_nacimiento`) VALUES ('04823864Y', 'Antonio', 'Martín', 'Vicente', 'Calle Imperial', '2001-02-17');
INSERT INTO `proyecto_final_bd`.`alumnos` (`dni`, `nombre`, `apellido1`, `apellido2`, `direccion`, `fecha_nacimiento`) VALUES ('70995566K', 'Alberto', 'Lorenzo', 'Castro', 'Calle Ganges', '2001-06-17');




CREATE TABLE `proyecto_final_bd`.`alumnos_asignaturas` (
  `dni_alumno` VARCHAR(45) NOT NULL,
  `id_asignatura` INT NOT NULL,
  PRIMARY KEY (`id_alumno`, `id_asignatura`));
 
  
  
  
ALTER TABLE `proyecto_final_bd`.`alumnos_asignaturas` 
ADD INDEX `asignatura_idx` (`id_asignatura` ASC) VISIBLE;
;
ALTER TABLE `proyecto_final_bd`.`alumnos_asignaturas` 
ADD CONSTRAINT `asignatura`
  FOREIGN KEY (`id_asignatura`)
  REFERENCES `proyecto_final_bd`.`asignaturas` (`id_asignatura`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION,
ADD CONSTRAINT `alumno`
  FOREIGN KEY (`dni_alumno`)
  REFERENCES `proyecto_final_bd`.`alumnos` (`dni`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;
  
  
INSERT INTO `proyecto_final_bd`.`alumnos_asignaturas` (`dni_alumno`, `id_asignatura`) VALUES ('70925689Z', '1');
INSERT INTO `proyecto_final_bd`.`alumnos_asignaturas` (`dni_alumno`, `id_asignatura`) VALUES ('70925689Z', '2');
INSERT INTO `proyecto_final_bd`.`alumnos_asignaturas` (`dni_alumno`, `id_asignatura`) VALUES ('70925689Z', '3');
INSERT INTO `proyecto_final_bd`.`alumnos_asignaturas` (`dni_alumno`, `id_asignatura`) VALUES ('70925689Z', '4');
INSERT INTO `proyecto_final_bd`.`alumnos_asignaturas` (`dni_alumno`, `id_asignatura`) VALUES ('70925689Z', '5');
INSERT INTO `proyecto_final_bd`.`alumnos_asignaturas` (`dni_alumno`, `id_asignatura`) VALUES ('70925689Z', '6');
INSERT INTO `proyecto_final_bd`.`alumnos_asignaturas` (`dni_alumno`, `id_asignatura`) VALUES ('70925689Z', '7');
INSERT INTO `proyecto_final_bd`.`alumnos_asignaturas` (`dni_alumno`, `id_asignatura`) VALUES ('70925689Z', '8');
INSERT INTO `proyecto_final_bd`.`alumnos_asignaturas` (`dni_alumno`, `id_asignatura`) VALUES ('70925689Z', '10');