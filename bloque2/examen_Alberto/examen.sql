-- ============================================================
-- EXAMEN SQL: GIMNASIO  ·  Script INICIAL
-- Ejecutar ENTERO en Workbench antes de empezar (rayo).
-- Crea la base de datos 'gimnasio' y las tablas monitor y socio.
-- Las tablas actividad e inscripcion las tienes que crear tu.
-- ============================================================

DROP DATABASE IF EXISTS gimnasio;
CREATE DATABASE gimnasio;
USE gimnasio;

-- 1.Estructura

CREATE TABLE monitor (
    id_monitor INT PRIMARY KEY AUTO_INCREMENT,
    nombre     VARCHAR(50) NOT NULL,
    telefono   VARCHAR(9)
);

CREATE TABLE socio (
    id_socio   INT AUTO_INCREMENT PRIMARY KEY,
    nombre     VARCHAR(50) NOT NULL,
    ciudad     VARCHAR(40),
    email      VARCHAR(80),
    fecha_alta DATE NOT NULL
);

-- 1.1 crear la tabla actividad

CREATE TABLE actividad(
    id_actividad INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(40) NOT NULL,
    precio DECIMAL(6, 2),
    plazas INT,
    dia VARCHAR(10),
    id_monitor INT NOT NULL,
    FOREIGN KEY(id_monitor) REFERENCES monitor(id_monitor)
);

-- 1.2 crear la tabla inscripcion

CREATE TABLE inscripcion(
    id_inscripcion INT PRIMARY KEY AUTO_INCREMENT,
    id_socio INT NOT NULL,
    id_actividad INT NOT NULL,
    fecha DATE NOT NULL,
    FOREIGN KEY(id_socio) REFERENCES socio(id_socio),
    FOREIGN KEY(id_actividad) REFERENCES actividad(id_actividad)
);

-- 1.3 alterar la tabla socio añadiendo una nueva columna
ALTER TABLE socio ADD COLUMN telefono VARCHAR(9);

-- 1.3 alterar la tabla socio modificando la columna creada
ALTER TABLE socio MODIFY COLUMN telefono VARCHAR(15);

-- 2.Insertar datos

INSERT INTO socio(nombre, ciudad, email, fecha_alta) 
VALUES("Alberto Algaba", "Jaen", "alberto.algaba@davante.org", "2026-11-04");

SELECT * FROM socio WHERE nombre = "Alberto Algaba";

INSERT INTO inscripcion(id_socio, id_actividad, fecha) 
VALUES(7, 2, "2026-11-04");

SELECT * FROM inscripcion WHERE id_socio = 7;

-- 3.Consultas simples

SELECT nombre FROM socio WHERE fecha_alta BETWEEN "2026-01-01" AND "2026-06-30";

SELECT DISTINCT dia FROM actividad;

SELECT nombre, dia, precio FROM actividad WHERE dia IN("Lunes", "Martes") AND precio < 20;

SELECT nombre FROM socio WHERE nombre LIKE "%er%";

-- 4.Actualizar datos

UPDATE actividad SET precio = precio * 1.10 WHERE id_actividad = 2;

SELECT * FROM actividad WHERE id_actividad = 2;

UPDATE socio SET ciudad = "Malaga" WHERE id_socio = 6;

SELECT * FROM socio WHERE id_socio = 6;

-- 5.Consultas con join

SELECT s.nombre as "nombre del socio", a.nombre as "nombre de la actividad", i.fecha as "fecha de inscripcion" 
FROM socio s 
JOIN inscripcion i ON (s.id_socio = i.id_socio)
JOIN actividad a ON (i.id_actividad = a.id_actividad);

SELECT a.nombre as "nombre actividad", a.dia, m.nombre as "nombre del monitor"
FROM actividad a JOIN monitor m ON (a.id_monitor = m.id_monitor);

SELECT a.nombre, COUNT(s.id_socio), SUM(a.precio) 
FROM actividad a JOIN inscripcion i ON (a.id_actividad = i.id_actividad)
JOIN socio s ON (i.id_socio = s.id_socio) GROUP BY a.nombre;

-- 6.Borrar datos

DELETE FROM inscripcion WHERE id_inscripcion = 8;
SELECT * FROM inscripcion WHERE id_inscripcion = 8;

-- DELETE FROM socio WHERE id_socio = 1;
/*Este ultimo borrado da error, porque hay otros datos o filas 
de otras tablas que apuntan a esa fila con una clave foranea
entonces al tener una o varias claves foraneas asociadas a la fila para borrar, da error 
porque rompe integridad en los datos y asi se evita que los datos queden huerfanos
se puede arreglar haciendo que los datos que apunten a la clave foranea se borren en cascada 
y se actualizen en cascada quedandose en NULL*/