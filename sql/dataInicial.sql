CREATE DATABASE PRUEBAS;

USE PRUEBAS;

CREATE TABLE  TBL_ROLES(
id  int identity PRIMARY KEY  ,
ROL varchar (50) 
);


CREATE TABLE  TBL_ESTADOS(
id_estado  int identity PRIMARY KEY  ,
estado char (1) ,
descripcion varchar (50) NOT NULL 

)
;

CREATE TABLE  TBL_USUARIOS(
id int identity PRIMARY KEY  ,
nombre_completo varchar (50) NOT NULL ,
nombre_usuario varchar ( 50 ) NOT NULL,
clave varchar ( 100 ) NOT NULL,
fecha_creacion     DATE NOT NULL,
fecha_ultimo_ingreso     DATE NOT NULL,
nivel_acceso int  NOT NULL,
id_estado int NOT NULL	,
CONSTRAINT UC_nombre_usuario UNIQUE (nombre_usuario),
FOREIGN KEY (id_estado) REFERENCES TBL_ESTADOS(id_estado),
FOREIGN KEY (nivel_acceso) REFERENCES TBL_ROLES (id)
)
;

CREATE TABLE  TBL_CATERIAS(
id_cateria int identity PRIMARY KEY  ,
nombre varchar (50) NOT NULL ,
id_estado int NOT NULL,
fecha_creacion     DATE NOT NULL,
fecha_actualizacion     DATE NOT NULL,
FOREIGN KEY (id_estado) REFERENCES TBL_ESTADOS(id_estado)
)
;

CREATE TABLE   TBL_PRODUCTOS (
  id int identity PRIMARY KEY  ,
nombre   varchar (50) NOT NULL,
id_cateria int NOT NULL,
costo	bigint  NOT NULL,
precio bigint NOT NULL,
Tag   varchar (50) NOT NULL,
fecha_creacion     DATE NOT NULL,
fecha_actualizacion     DATE NOT NULL,
id_estado int NOT NULL,
FOREIGN KEY (id_cateria) REFERENCES TBL_CATERIAS(id_cateria),
FOREIGN KEY (id_estado) REFERENCES TBL_ESTADOS(id_estado)

)
;



insert into TBL_ESTADOS (estado,descripcion) values ('A','Estado Activo');
insert into TBL_ESTADOS  (estado,descripcion) values ('I','Estado in Activo');
insert into TBL_ESTADOS  (estado,descripcion) values ('E','Estado Eliminado');
insert into TBL_CATERIAS (nombre,id_estado,fecha_creacion,fecha_actualizacion)  values ('ELECTRONICO',1,'2021-10-27','2021-10-27');
insert into TBL_ROLES(rol) values ('ADMIN');
insert into TBL_ROLES(rol) values ('USER');
insert into TBL_USUARIOS (nombre_completo,nombre_usuario,clave,fecha_creacion,fecha_ultimo_ingreso,nivel_acceso,id_estado) values ('jhon','jhon','$2a$10$v36hDX0BJpmuTXKWnBkEZO8322DJRLaUNI0miejgIIStZxODKVopK','2021-10-27','2021-10-27',1,1);

