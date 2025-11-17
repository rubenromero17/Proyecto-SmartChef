create database smartchef;
use smartchef;

create table usuarios (
    id_usuario int  primary key,
    nombre varchar(100) not null,
    email varchar(150) unique not null,
    contrasena varchar(255) not null,
    fecha_registro date default current_date
);
create table recetas (
    id_receta int  primary key,
    nombre varchar(150) not null,
    descripcion text,
    tiempo_preparacion int,
    dificultad varchar(20),
    economica boolean default false, 
    vegetariana boolean default false,
    sin_gluten boolean default false,
    rapido boolean default false,
    creador_id int references usuarios(id_usuario)
);

create table ingredientes (
    id_ingrediente int primary key,
    nombre varchar(100) unique not null,
    categoria varchar(50),
    unidad_medida varchar(20)
);

create table receta_ingredientes (
    id_receta int references recetas(id_receta) on delete cascade,
    id_ingrediente int references ingredientes(id_ingrediente) on delete cascade,
    cantidad decimal(10,2),
    primary key (id_receta, id_ingrediente)
);

create table instrucciones_receta (
    id_instruccion int primary key,
    id_receta int references recetas(id_receta) on delete cascade,
    paso_numero int not null,
    descripcion text not null,
    imagen_url varchar(255)
);

create table fotos_recetas (
    id_foto int primary key,
    id_receta int references recetas(id_receta) on delete cascade,
    url_imagen varchar(255) not null,
    descripcion varchar(255),
    es_principal boolean default false
);

create table fotos_perfil_usuario (
    id_foto int primary key,
    id_usuario int references usuarios(id_usuario) on delete cascade,
    url_imagen varchar(255) not null,
    activa boolean default true,
    fecha_subida timestamp default current_timestamp
);

create table listas_compras (
    id_lista int primary key,
    id_usuario int references usuarios(id_usuario),
    fecha_creacion date default current_date,
    nombre varchar(100) default 'mi lista'
);

create table lista_ingredientes (
    id_lista int references listas_compras(id_lista) on delete cascade,
    id_ingrediente int references ingredientes(id_ingrediente),
    cantidad decimal(10,2),
    comprado boolean default false,
    primary key (id_lista, id_ingrediente)
);

create table recetas_favoritas (
    id_usuario int references usuarios(id_usuario) on delete cascade,
    id_receta int references recetas(id_receta) on delete cascade,
    primary key (id_usuario, id_receta)
);

create table historial_cocina (
    id_historial int  primary key,
    id_usuario int references usuarios(id_usuario),
    id_receta int references recetas(id_receta),
    fecha_cocinado date not null
);

create table colecciones (
    id_coleccion int primary key,
    id_usuario int references usuarios(id_usuario),
    nombre varchar(100) not null
);

create table coleccion_recetas (
    id_coleccion int references colecciones(id_coleccion) on delete cascade,
    id_receta int references recetas(id_receta),
    primary key (id_coleccion, id_receta)
);

create table comentarios_recetas (
    id_comentario int  primary key,
    id_receta int references recetas(id_receta) on delete cascade,
    id_usuario int references usuarios(id_usuario),
    texto text not null,
    fecha timestamp default current_timestamp
);

create table valoraciones_recetas (
    id_valoracion int primary key,
    id_receta int references recetas(id_receta) on delete cascade,
    id_usuario int references usuarios(id_usuario),
    estrellas int check (estrellas between 1 and 5),
    comentario text,
    fecha timestamp default current_timestamp
);

create table etiquetas (
    id_etiqueta int primary key,
    nombre varchar(50) unique not null
);

create table receta_etiquetas (
    id_receta int references recetas(id_receta) on delete cascade,
    id_etiqueta int references etiquetas(id_etiqueta),
    primary key (id_receta, id_etiqueta)
);