CREATE TABLE `proyecto_final_bd`.`notas` (
  `dni_alumno` VARCHAR(45) NOT NULL,
  `id_asignatura` INT NOT NULL,
  `temas` VARCHAR(45) NOT NULL,
  `nota` FLOAT NULL,
  PRIMARY KEY (`dni_alumno`, `id_asignatura`, `temas`));
  
ALTER TABLE `proyecto_final_bd`.`notas` 
ADD INDEX `id_asignatura_idx` (`id_asignatura` ASC) VISIBLE;
;
ALTER TABLE `proyecto_final_bd`.`notas` 
ADD CONSTRAINT `dni_alumno`
  FOREIGN KEY (`dni_alumno`)
  REFERENCES `proyecto_final_bd`.`alumnos` (`dni`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION,
ADD CONSTRAINT `id_asignatura`
  FOREIGN KEY (`id_asignatura`)
  REFERENCES `proyecto_final_bd`.`asignaturas` (`id_asignatura`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;
  
INSERT INTO `proyecto_final_bd`.`notas` (`dni_alumno`, `id_asignatura`, `temas`, `nota`) VALUES ('70925689Z', '1', '1-3', '8');
INSERT INTO `proyecto_final_bd`.`notas` (`dni_alumno`, `id_asignatura`, `temas`, `nota`) VALUES ('70925689Z', '1', '4-6', '7');
INSERT INTO `proyecto_final_bd`.`notas` (`dni_alumno`, `id_asignatura`, `temas`, `nota`) VALUES ('70925689Z', '1', '7-12', '9');
INSERT INTO `proyecto_final_bd`.`notas` (`dni_alumno`, `id_asignatura`, `temas`, `nota`) VALUES ('70925689Z', '1', '13-15', '8.5');
INSERT INTO `proyecto_final_bd`.`notas` (`dni_alumno`, `id_asignatura`, `temas`, `nota`) VALUES ('70925689Z', '2', '1-5', '6');
INSERT INTO `proyecto_final_bd`.`notas` (`dni_alumno`, `id_asignatura`, `temas`, `nota`) VALUES ('70925689Z', '2', '6-10', '9');
INSERT INTO `proyecto_final_bd`.`notas` (`dni_alumno`, `id_asignatura`, `temas`, `nota`) VALUES ('70925689Z', '2', '11-15', '9.5');
INSERT INTO `proyecto_final_bd`.`notas` (`dni_alumno`, `id_asignatura`, `temas`, `nota`) VALUES ('04823864Y', '4', '1-4', '6');
INSERT INTO `proyecto_final_bd`.`notas` (`dni_alumno`, `id_asignatura`, `temas`, `nota`) VALUES ('04823864Y', '4', '5-7', '7');
INSERT INTO `proyecto_final_bd`.`notas` (`dni_alumno`, `id_asignatura`, `temas`, `nota`) VALUES ('04823864Y', '4', '8-10', '5.5');
INSERT INTO `proyecto_final_bd`.`notas` (`dni_alumno`, `id_asignatura`, `temas`, `nota`) VALUES ('04823864Y', '4', '11-16', '7.5');
