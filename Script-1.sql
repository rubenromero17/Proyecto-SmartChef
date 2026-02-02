-- ===============================
-- BASE DE DATOS
-- ===============================
CREATE DATABASE smartchef;
USE smartchef;


-- ===============================
-- TABLA USUARIOS
-- ===============================
CREATE TABLE usuarios (
    id_usuario INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    fecha_nacimiento DATE,
    email VARCHAR(150) UNIQUE NOT NULL,
    contrasena VARCHAR(255) NOT NULL,
    direccion VARCHAR(100) NOT NULL,
    preferencias ENUM('economica','vegetariana','sinGluten','rapido'),
    url_imagen VARCHAR(255) NOT NULL,
    fecha_registro DATE
);


-- ===============================
-- TABLA RECETAS
-- ===============================
CREATE TABLE recetas (
    id_receta INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(150) NOT NULL,
    descripcion VARCHAR(150),
    tiempo_preparacion INT,
    url_imagen VARCHAR(255) NOT NULL,
    dificultad ENUM('FACIL','MEDIA','DIFICIL') NOT NULL,
    economica BOOLEAN,
    vegetariana BOOLEAN,
    sin_gluten BOOLEAN,
    rapido BOOLEAN
);


-- ===============================
-- TABLA INGREDIENTES
-- ===============================
CREATE TABLE ingredientes (
    id_ingrediente INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL
);


-- ===============================
-- TABLA RECETA_INGREDIENTES
-- ===============================
CREATE TABLE receta_ingredientes (
    id_receta_ingredientes INT AUTO_INCREMENT PRIMARY KEY,
    id_receta INT NOT NULL,
    id_ingrediente INT NOT NULL,
    cantidad FLOAT,
    FOREIGN KEY (id_receta) REFERENCES recetas(id_receta) ON DELETE CASCADE,
    FOREIGN KEY (id_ingrediente) REFERENCES ingredientes(id_ingrediente) ON DELETE CASCADE
);


-- ===============================
-- TABLA INSTRUCCIONES_RECETA
-- ===============================
CREATE TABLE instrucciones_receta (
    id_instruccion INT AUTO_INCREMENT PRIMARY KEY,
    id_receta INT NOT NULL,
    paso_numero INT NOT NULL,
    descripcion TEXT NOT NULL,
    FOREIGN KEY (id_receta) REFERENCES recetas(id_receta) ON DELETE CASCADE
);


-- ===============================
-- TABLA LISTAS_COMPRAS
-- ===============================
CREATE TABLE listas_compras (
    id_lista INT AUTO_INCREMENT PRIMARY KEY,
    id_usuario INT NOT NULL,
    fecha_creacion DATE DEFAULT CURRENT_DATE,
    FOREIGN KEY (id_usuario) REFERENCES usuarios(id_usuario)
);


-- ===============================
-- TABLA LISTA_INGREDIENTES
-- ===============================
CREATE TABLE lista_ingredientes (
    id_lista_ingredientes INT AUTO_INCREMENT PRIMARY KEY,
    id_lista INT NOT NULL,
    id_ingrediente INT NOT NULL,
    cantidad FLOAT NOT NULL,
    comprado ENUM('Si','No') NOT NULL,
    FOREIGN KEY (id_lista) REFERENCES listas_compras(id_lista) ON DELETE CASCADE,
    FOREIGN KEY (id_ingrediente) REFERENCES ingredientes(id_ingrediente) ON DELETE CASCADE
);


-- ===============================
-- TABLA RECETAS_FAVORITAS
-- ===============================
CREATE TABLE recetas_favoritas (
    id_recetas_favoritas INT AUTO_INCREMENT PRIMARY KEY,
    id_usuario INT NOT NULL,
    id_receta INT NOT NULL,
    FOREIGN KEY (id_usuario) REFERENCES usuarios(id_usuario) ON DELETE CASCADE,
    FOREIGN KEY (id_receta) REFERENCES recetas(id_receta) ON DELETE CASCADE
);


-- ===============================
-- TABLA HISTORIAL_COCINA
-- ===============================
CREATE TABLE historial_cocina (
    id_historial INT AUTO_INCREMENT PRIMARY KEY,
    id_usuario INT NOT NULL,
    id_receta INT NOT NULL,
    fecha_visitado DATE NOT NULL,
    fecha_cocinado DATE NOT NULL,
    FOREIGN KEY (id_usuario) REFERENCES usuarios(id_usuario) ON DELETE CASCADE,
    FOREIGN KEY (id_receta) REFERENCES recetas(id_receta) ON DELETE CASCADE
);


-- ===============================
-- TABLA COLECCIONES
-- ===============================
CREATE TABLE colecciones (
    id_coleccion INT AUTO_INCREMENT PRIMARY KEY,
    id_usuario INT NOT NULL,
    nombre VARCHAR(100) NOT NULL,
    FOREIGN KEY (id_usuario) REFERENCES usuarios(id_usuario)
);


-- ===============================
-- TABLA COLECCION_RECETAS
-- ===============================
CREATE TABLE coleccion_recetas (
    id_coleccion_recetas INT AUTO_INCREMENT PRIMARY KEY,
    id_coleccion INT NOT NULL,
    id_receta INT NOT NULL,
    FOREIGN KEY (id_coleccion) REFERENCES colecciones(id_coleccion) ON DELETE CASCADE,
    FOREIGN KEY (id_receta) REFERENCES recetas(id_receta)
);


-- ===============================
-- TABLA ETIQUETAS
-- ===============================
CREATE TABLE etiquetas (
    id_etiqueta INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50) UNIQUE NOT NULL
);


-- ===============================
-- TABLA RECETA_ETIQUETAS
-- ===============================
CREATE TABLE receta_etiquetas (
    id_receta_etiquetas INT AUTO_INCREMENT PRIMARY KEY,
    id_receta INT NOT NULL,
    id_etiqueta INT NOT NULL,
    FOREIGN KEY (id_receta) REFERENCES recetas(id_receta) ON DELETE CASCADE,
    FOREIGN KEY (id_etiqueta) REFERENCES etiquetas(id_etiqueta) ON DELETE CASCADE
);
