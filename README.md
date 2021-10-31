# PMV


proyecto codificado sobre java 1.8  ,el codigo fuente esta en la carpeta <proyecto> ,Script bd esta en la carpeta <sql>

Tecnologías java,maven,Spring Boot,jpa
En la carpeta sql dejo el script para correr en la bd de sql server (crear una Base de datos llamada prueba sobre esa se ejecuta el script)
En el archivo PRODUCTO.postman_collection  estan los ejemplos de las Llamadas a la API para cargar a postman
Para correr el proyecto entrar a la carpeta (arrancar) abren el cmd sobre esa ruta.
Ejecutan ese comando:  java -jar pruductominimoviable-0.0.1-SNAPSHOT.jar con esto arrancaria en el puerto 8002
NOTA si lo arrancan desde esa carpeta tambien dentro se genera la carpeta logs para las los registros
 
 
Para entrar a cada método api se necesita un token ya esta todo en el postman solo seria pedir el token a la api desde postam 
y ponerlo en cada llamada
 
se creo solo un usuario llamado jhon este tiene el rol ADMIN en el postman este deberia generarles el token 
 
En la ruta producto\src\main\resources\prod.properties  esta la config para conectarse a la base de datos se tendrá que cambiar solo el puerto
 
 