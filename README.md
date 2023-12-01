# Rest API Spring Boot Gestion de una escuela

Este proyecto se trata de una Rest API desarrollada en Spring Boot y ha sido creada como proyecto final del ***Master Viewnext en desarrollo en Java***.

## Descripcion del proyecto

Este proyecto es una API REST que proporciona servicios para gestionar los alumnos de un colegio. 

Este proyecto cuenta con 3 microservicios que interactuan entre si, para proporcionar las distintas funcionalidades. Estos 3 microservicios son:

- Alumno
- Asignatura
- Nota

### Microservicio Alumno

El microservicio Alumno cuenta con una entidad principal llamada Alumno con los siguientes campos:

- DNI
- Nombre
- Primer apellido
- Segundo apellido
- Direccion
- Fecha de nacimiento

Tambien cuenta con una entidad secuandaria llamada AlumnoAsignatura que permite relacionar los alumnos matriculados en cada una de las asignaturas. Cuenta con los siguientes campos:

- DNI del alumnp
- Id de la asignatura

### Microservicio Asignatura

El microservicio Asignatura cuenta con una entidad principal llamada Asignatura con los siguientes campos:

- Id de la asignatura
- Nombre
- Numero de temas
- Numero de alumnos matriculados

### Microservicio Nota

El microservicio Nota cuenta con una entidad principal llamada Nota con los siguientes campos:

- DNI del alumno
- Id de la asignatura
- Temas de la nota
- Nota

## Tecnologías utilizadas

- Spring Boot
- Java
- RESTful API
- Maven

## Configuracion del proyecto

Asegurate de tener Java y Maven en tu sistema antes de ejecutar el proyecto.

1. Clona este repositorio en tu maquina local:

  ```git clone https://github.com/tuusuario/rest-api-spring-boot.git```

2. Navega al direcotrio del proyecto:

  ```cd rest-api-spring-boot```

3. Ejecuta la aplicacion Spring Boot:

  ```mvn spring-boot:run```

## Uso de la API

Se puede hacer uso de herramientas como Postman para interactuar con la API. A continuacion se describiran los disintos recursos y su utilización.

### Microservicio Alumno

Se ejecuta en el puerto 8080. Los recursos de este microservicio son los siguientes:

- **Añadir alumno**: Se añade el alumno cuyos datos se pasan en el cuerpo de la petición.

POST -> http://localhost:8080/alumnos

{
	"dni": "123456789M",
	"nombre": "Pepe",
	"apellido1": "Dominguez",
	"apellido2": "Sanchez",
	"direccion": "Calle falsa",
	"fechaNacimiento": "2001-07-18"
}

- **Modificar alumno**: Se modifica el nombre y apellidos del alumno con el DNI pasado como parámetro. El nombre y los apellidos se pasan también como parámetros.

 PUT -> http://localhost:8080/alumnos/<dni del alumno a modificar\>?nombre=x&apellido1=x&apellido2=x

- **Dar de baja a alumno**: Se elimina al alumno cuyo DNI coincida con el pasado como parámetro en la petición.

DELETE -> http://localhost:8080/alumnos/<dni del alumno a eliminar\>

- **Ver listado de alumnos**: Obtiene una lista de todos los alumnos.

GET -> http://localhost:8080/alumnos

- **Obtener asignaturas de un alumno**: Se recupera un listado con los nombres de las asignaturas en las que se encuentra matriculado un alumno cuyo DNI se pasará como parámetro.

GET -> http://localhost:8080/alumnos/<dni del alumno\>/asignaturas

- **Obtener la lista de notas de un alumno**: Se obtiene el listado de notas (nombre de la asignatura, temas y valor numérico de la nota) de un alumno determinado cuyo DNI se pasará como parámetro.

GET -> http://localhost:8080/alumnos/<dni del alumno\>/alumnos

- **Obtener la nota media de un alumno en una asignatura**: Se obttiene la calificación media de un alumno en una asignatura pasado el DNI del alumno y el nombre de la asignatura. También se obtiene un listado con todas las notas del alumno en la asignatura concreta.

GET -> http://localhost:8080/alumnos/<dni del alumno\>/<nombre de la asignatura\>

- **Matricular alumno en una asignatura**: Se matricula al alumno cuyo dni se pasa como parámetro en la asignatura cuyo nombre se pasa como parámetro.

POST -> http://localhost:8080/alumnos/<dni del alumno\>/<nombre de la asignatura\>

- **Desmatricular alumno en una asignatura**: Se desmatricula al alumno cuyo dni se pasa como parámetro en la asignatura cuyo nombre se pasa como parámetro.

DELETE -> http://localhost:8080/alumnos/<dni del alumno\>/<nombre de la asignatura\>

### Microservicio Asignatura

Se ejecuta en el puerto 7070. Los recursos de este microservicio son los siguientes:

- **Añadir asignatura**: Se añade la asignatura cuyos datos se pasan en el cuerpo de la petición.

POST -> http://localhost:7070/asignaturas

{
    "idAsignatura": 11,
    "nombre": "Aplaudir",
    "numTemas": "6",
    "numAlumnosMatriculados": 12
}

- **Eliminar asignatura**: Se elimina la asignatura con el id de la asignatura pasado como parámetro.

DELETE -> http://localhost:7070/asignaturas/<id de la asignatura a eliminar\>

- **Obtener numero de alumnos matriculados en una asignatura:** Se obtiene el número de alumnos matriculados en una asignatura, donde se recibe como parámetro el id de la asignatura.

GET -> http://localhost:7070/asignaturas/<id de la asignatura\>

- **Ver listado de asignaturas**: Se obtiene una lista de todas las asignaturas.

GET -> http://localhost:7070/asignaturas

- **Modificar alumnos matriculados en una asignatura**: Se actualiza el número de alumnos matriculados en una determinada asignatura. Como parámetro se recibe el id de la asignatura y el tipo de operación (incremento (+) o decremento (-)).

PUT -> http://localhost:7070/asignaturas/<id de la asignatura\>/<tipo de operacion\>

- **Obtener nombre de asignatura**: Se obtiene únicamente el nombre de la asignatura cuyo id se pasará como parámetro.

GET -> http://localhost:7070/asignaturas/<id de la asignatura\>

- **Obtener id  de asignatura**: Se obtiene únicamente el id de la asignatura cuyo nombre se pasará como parámetro.

GET -> http://localhost:7070/asignaturas/<nombre de la asignatura\>/id

- **Obtener número de temas de una asignatura**: Se obtiene únicamente el número de temas de la asignatura cuyo nombre se pasará como parámetro.

GET -> http://localhost:7070/asignaturas/<nombre de la asignatura\>/temas
