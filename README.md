# PMV


NOMBRE_PROYECTO: pruductominimoviable   -> codigo fuente en la carpeta <producto>

INSTALADOR BASE DATOS:

1) con docker, en caso de que lo tengan  instalado : arrancar docker correr los siguientes comandos

1.1 ->       docker pull jhonwimo/sqlserver:dbversion21.12

1.2 ->       docker run -d -p 1470:1433 --name databasecontainer c35f8e751abc


2) Para crear la base de datos sin docker, en la carpeta <sql> dejo el script para correr en la bd de sql server (crear una Base de datos llamada PRUEBA sobre esa se ejecuta el script)
En la ruta producto\src\main\resources\prod.properties  esta la config para 
conectarse a la base de datos 


CORRER MICROSERVICIO:

3)Para correr el proyecto entrar a la carpeta (arrancar) abren el cmd sobre esa ruta.
Ejecutan ese comando->  java -jar pruductominimoviable-0.0.1-SNAPSHOT.jar 
con esto arrancaria en el puerto 8002
NOTA si lo arrancan desde esa carpeta tambien dentro se genera la carpeta logs para las los registros

PRUEBAS:

4) En el archivo PRODUCTO.postman_collection  estan los ejemplos de las Llamadas a la API para cargar a postman

Para entrar a cada método api se necesita un token ya esta todo en el postman solo seria pedir el token a la api desde postam 
y ponerlo en cada llamada 
 
se creo solo un usuario llamado jhon este tiene el rol ADMIN en el postman este deberia generarles el token nombre ->  TOKEN ADMIN




Tecnologías java,maven,Spring Boot,jpa,docker


Nota: para conectarse al BD, esto si se creó con docker 
Usuario:         sa
Contraseña : Jour!Passw0rd
Puerto : 1470
Base datos:  PRUEBA





