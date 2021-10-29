/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  jwmoreno
 * Created: 27/10/2021
 */

/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  jwmoreno
 * Created: 26/09/2021
 */

CREATE TABLE IF NOT EXISTS TBL_ESTADOS(
id  bigint auto_increment  ,
estado char (1) PRIMARY KEY,
descripcion varchar (50) NOT NULL 

);

CREATE TABLE IF NOT EXISTS TBL_USUARIOS(
id bigint auto_increment  ,
	nombre_completo varchar (50) NOT NULL ,
nombre_usuario varchar ( 50 ) NOT NULL,

clave varchar ( 50 ) NOT NULL,
fecha_creacion     DATE NOT NULL,
fecha_ultimo_ingreso     DATE NOT NULL,
nivel_acceso varchar (10) NOT NULL,
id_estado varchar (1) NOT NULL	,
CONSTRAINT UC_nombre_usuario UNIQUE (nombre_usuario),
FOREIGN KEY (id_estado) REFERENCES TBL_ESTADOS(id_estado)
);


CREATE TABLE IF NOT EXISTS TBL_CATEGORIA(
id_categoria bigint auto_increment   PRIMARY KEY,
	nombre varchar (50) NOT NULL ,
estado varchar (1) NOT NULL,
fecha_creacion     DATE NOT NULL,
fecha_actualizacion     DATE NOT NULL

	
);






CREATE TABLE IF NOT EXISTS  TBL_PRODUCTOS (
          id bigint  auto_increment pRIMARY KEY,
	nombre   varchar (50) NOT NULL,
	id_categoria bigint NOT NULL,
	costo	bigint  NOT NULL,
        precio bigint NOT NULL,
listaTag   varchar (50) NOT NULL,
fecha_creacion     DATE NOT NULL,
fecha_actualizacion     DATE NOT NULL,
id_estado char (1) NOT NULL,
FOREIGN KEY (id_categoria) REFERENCES TBL_CATEGORIA(id_categoria),
FOREIGN KEY (id_estado) REFERENCES TBL_ESTADOS(id_estado)

);


--insert into TBL_CATEGORIA (id_categoria,nombre,estado,fecha_creacion,fecha_actualizacion)  values (1,'ELECTRONICO','A','2021-10-27','2021-10-27');
insert into TBL_ESTADOS  values ('A','Estado Activo');
insert into TBL_ESTADOS  values ('I','Estado in Activo');
insert into TBL_ESTADOS  values ('E','Estado Eliminado');
insert into TBL_USUARIOS (id,nombre_completo,nombre_usuario,clave,fecha_creacion,fecha_ultimo_ingreso,nivel_acceso,id_estado) values (1,'jhon','jhon','1234','2021-10-27','2021-10-27','ADMIN','A');
insert into TBL_USUARIOS (id,nombre_completo,nombre_usuario,clave,fecha_creacion,fecha_ultimo_ingreso,nivel_acceso,id_estado) values (2,'edinson','edinson','12345','2021-10-27','2021-10-27','USER','A');


--insert into TBL_PRODUCTOS (id,nombre,id_categoria,costo,precio,listaTag,fecha_creacion,fecha_actualizacion,id_estado)  values (1,'TELEVISOR',1,33,33,'DDD','2021-10-27','2021-10-27','A');


