create database smartchef;
use smartchef;

create table usuarios (
    id_usuario int auto_increment primary key,
    nombre varchar(100) not null,
    fecha_nacimiento date,
    email varchar(150) unique not null,
    contrasena varchar(255) not null,
    direccion varchar(100) not null,
    preferencias ENUM('economica','vegetariana','sin gluten', 'rapido'),
    url_imagen varchar(255) not null,
    fecha_registro date default current_date
);

create table recetas (
    id_receta int auto_increment primary key,
    nombre varchar(150) not null,
    descripcion varchar(150),
    tiempo_preparacion int,
    url_imagen varchar(255) not null,
    dificultad ENUM('FACIL', 'MEDIA', 'DIFICIL') NOT null,
    economica tinyint(1) default 0,
    vegetariana tinyint(1) default 0,
    sin_gluten tinyint(1) default 0,
    rapido tinyint(1) default 0
);

create table ingredientes (
    id_ingrediente int auto_increment primary key,
    nombre varchar(100) unique not null
);

create table receta_ingredientes (
	id_receta_ingredientes int auto_increment primary key,
    id_receta int not null,
    id_ingrediente int not null,
    cantidad int,
    foreign key (id_receta) references recetas(id_receta) on delete cascade,
    foreign key (id_ingrediente) references ingredientes(id_ingrediente) on delete cascade
);

create table instrucciones_receta (
    id_instruccion int auto_increment primary key,
    id_receta int not null,
    paso_numero int not null,
    descripcion text not null,
    foreign key (id_receta) references recetas(id_receta) on delete cascade
);


create table listas_compras (
    id_lista int auto_increment primary key,
    id_usuario int not null,
    fecha_creacion date default current_date,
    foreign key (id_usuario) references usuarios(id_usuario)
);

create table lista_ingredientes (
	id_lista_ingredientes int auto_increment primary key,
    id_lista int not null,
    id_ingrediente int not null,
    cantidad int not null,
    comprado  ENUM('Si', 'No') not null,
    foreign key (id_lista) references listas_compras(id_lista) on delete cascade,
    foreign key (id_ingrediente) references ingredientes(id_ingrediente) on delete cascade
);

create table recetas_favoritas (
	id_recetas_favoritas int auto_increment primary key,
    id_usuario int not null,
    id_receta int not null,
    foreign key (id_usuario) references usuarios(id_usuario) on delete cascade,
    foreign key (id_receta) references recetas(id_receta) on delete cascade
);

create table historial_cocina (
    id_historial int auto_increment primary key,
    id_usuario int not null,
    id_receta int not null,
    fecha_visitado date not null,
    fecha_cocinado date not null,
    foreign key (id_usuario) references usuarios(id_usuario) on delete cascade,
    foreign key (id_receta) references recetas(id_receta) on delete cascade
);

create table colecciones (
    id_coleccion int auto_increment primary key,
    id_usuario int not null,
    nombre varchar(100) not null,
    foreign key (id_usuario) references usuarios(id_usuario)
);

create table coleccion_recetas (
	id_coleccion_recetas int auto_increment primary key,
    id_coleccion int not null,
    id_receta int not null,
    foreign key (id_coleccion) references colecciones(id_coleccion) on delete cascade,
    foreign key (id_receta) references recetas(id_receta)
);

create table etiquetas (
    id_etiqueta int auto_increment primary key,
    nombre varchar(50) unique not null
);

create table receta_etiquetas (
	id_receta_etiquetas int auto_increment primary key,
    id_receta int not null,
    id_etiqueta int not null,
    foreign key (id_receta) references recetas(id_receta) on delete cascade,
    foreign key (id_etiqueta) references etiquetas(id_etiqueta) on delete cascade
);

alter table usuarios 
	add column url_imagen varchar(255) not null;

alter table recetas

drop table fotos_perfil_usuario;

drop table fotos_recetas;
