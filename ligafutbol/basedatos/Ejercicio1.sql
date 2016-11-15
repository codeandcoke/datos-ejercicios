CREATE DATABASE IF NOT EXISTS ejercicio1;
USE ejercicio1;

CREATE TABLE IF NOT EXISTS equipos
(
	id INT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
	nombre VARCHAR(50) UNIQUE NOT NULL,
	patrocinador VARCHAR(50),
	color1 VARCHAR(50) NOT NULL,
	color2 VARCHAR(50) NOT NULL,
	categoria ENUM ('Formación Profesional', 'Bachillerato')
);
-- Esto es un comentario
CREATE TABLE IF NOT EXISTS jugadores
(
	id INT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
	nombre VARCHAR(50) NOT NULL,
	apellidos VARCHAR(50),
	direccion VARCHAR(100),
	telefono VARCHAR(12) NOT NULL,
	fecha_nacimiento DATE NOT NULL,
	id_equipo INT UNSIGNED REFERENCES equipos
);

CREATE TABLE IF NOT EXISTS partidos
(
	id INT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
	campo VARCHAR(50) NOT NULL,
	arbitro VARCHAR(50) NOT NULL,
	incidencias VARCHAR(500)
);

CREATE TABLE IF NOT EXISTS equipo_partido
(
	id_equipo INT UNSIGNED REFERENCES equipos,
	id_partido INT UNSIGNED REFERENCES partidos,
	condicion ENUM ('local', 'visitante'),
	goles INT UNSIGNED DEFAULT 0,
	PRIMARY KEY (id_equipo, id_partido)
);
