-- 1. Borrar y Crear la base de datos (Ejecutar esto primero)
DROP DATABASE IF EXISTS smartchef;
CREATE DATABASE smartchef;

-- NOTA: Una vez creada, asegúrate de que tu herramienta (DBeaver/IntelliJ) 
-- esté apuntando a la nueva base de datos 'smartchef' para ejecutar lo siguiente:

-- 2. Crear el esquema
CREATE SCHEMA IF NOT EXISTS smartchef;
SET search_path TO smartchef;

-- 3. Crear Tipos ENUM (Tipos de datos personalizados)
DO $$ 
BEGIN
    IF NOT EXISTS (SELECT 1 FROM pg_type WHERE typname = 'tipo_preferencias') THEN
        CREATE TYPE tipo_preferencias AS ENUM ('economica','vegetariana','sinGluten', 'rapido');
    END IF;
    IF NOT EXISTS (SELECT 1 FROM pg_type WHERE typname = 'tipo_dificultad') THEN
        CREATE TYPE tipo_dificultad AS ENUM ('FACIL', 'MEDIA', 'DIFICIL');
    END IF;
    IF NOT EXISTS (SELECT 1 FROM pg_type WHERE typname = 'tipo_comprado') THEN
        CREATE TYPE tipo_comprado AS ENUM ('Si', 'No');
    END IF;
END $$;

-- 4. Creación de Tablas (Usando SERIAL para auto_increment)
CREATE TABLE usuarios (
    id_usuario SERIAL PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    fecha_nacimiento DATE,
    email VARCHAR(150) UNIQUE NOT NULL,
    contrasena VARCHAR(255) NOT NULL,
    direccion VARCHAR(100) NOT NULL,
    preferencias tipo_preferencias,
    url_imagen VARCHAR(255) NOT NULL,
    fecha_registro DATE DEFAULT CURRENT_DATE
);

CREATE TABLE recetas (
    id_receta SERIAL PRIMARY KEY,
    nombre VARCHAR(150) NOT NULL,
    descripcion VARCHAR(150),
    tiempo_preparacion INT,
    url_imagen VARCHAR(255) NOT NULL,
    dificultad tipo_dificultad NOT NULL,
    economica BOOLEAN DEFAULT FALSE,
    vegetariana BOOLEAN DEFAULT FALSE,
    sin_gluten BOOLEAN DEFAULT FALSE,
    rapido BOOLEAN DEFAULT FALSE
);

CREATE TABLE ingredientes (
    id_ingrediente SERIAL PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL
);

CREATE TABLE receta_ingredientes (
    id_receta_ingredientes SERIAL PRIMARY KEY,
    id_receta INT NOT NULL REFERENCES recetas(id_receta) ON DELETE CASCADE,
    id_ingrediente INT NOT NULL REFERENCES ingredientes(id_ingrediente) ON DELETE CASCADE,
    cantidad FLOAT
);

CREATE TABLE instrucciones_receta (
    id_instruccion SERIAL PRIMARY KEY,
    id_receta INT NOT NULL REFERENCES recetas(id_receta) ON DELETE CASCADE,
    paso_numero INT NOT NULL,
    descripcion TEXT NOT NULL
);

CREATE TABLE listas_compras (
    id_lista SERIAL PRIMARY KEY,
    id_usuario INT NOT NULL REFERENCES usuarios(id_usuario) ON DELETE CASCADE,
    fecha_creacion DATE DEFAULT CURRENT_DATE
);

CREATE TABLE lista_ingredientes (
    id_lista_ingredientes SERIAL PRIMARY KEY,
    id_lista INT NOT NULL REFERENCES listas_compras(id_lista) ON DELETE CASCADE,
    id_ingrediente INT NOT NULL REFERENCES ingredientes(id_ingrediente) ON DELETE CASCADE,
    cantidad FLOAT NOT NULL,
    comprado tipo_comprado NOT NULL DEFAULT 'No'
);

CREATE TABLE recetas_favoritas (
    id_recetas_favoritas SERIAL PRIMARY KEY,
    id_usuario INT NOT NULL REFERENCES usuarios(id_usuario) ON DELETE CASCADE,
    id_receta INT NOT NULL REFERENCES recetas(id_receta) ON DELETE CASCADE
);

CREATE TABLE historial_cocina (
    id_historial SERIAL PRIMARY KEY,
    id_usuario INT NOT NULL REFERENCES usuarios(id_usuario) ON DELETE CASCADE,
    id_receta INT NOT NULL REFERENCES recetas(id_receta) ON DELETE CASCADE,
    fecha_visitado DATE NOT NULL DEFAULT CURRENT_DATE,
    fecha_cocinado DATE NOT NULL DEFAULT CURRENT_DATE
);

CREATE TABLE colecciones (
    id_coleccion SERIAL PRIMARY KEY,
    id_usuario INT NOT NULL REFERENCES usuarios(id_usuario) ON DELETE CASCADE,
    nombre VARCHAR(100) NOT NULL
);

CREATE TABLE coleccion_recetas (
    id_coleccion_recetas SERIAL PRIMARY KEY,
    id_coleccion INT NOT NULL REFERENCES colecciones(id_coleccion) ON DELETE CASCADE,
    id_receta INT NOT NULL REFERENCES recetas(id_receta) ON DELETE CASCADE
);

CREATE TABLE etiquetas (
    id_etiqueta SERIAL PRIMARY KEY,
    nombre VARCHAR(50) UNIQUE NOT NULL
);

CREATE TABLE receta_etiquetas (
    id_receta_etiquetas SERIAL PRIMARY KEY,
    id_receta INT NOT NULL REFERENCES recetas(id_receta) ON DELETE CASCADE,
    id_etiqueta INT NOT NULL REFERENCES etiquetas(id_etiqueta) ON DELETE CASCADE
);