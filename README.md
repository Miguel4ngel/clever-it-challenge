# Desafio CleverIT

El componente entregado, expone una API Rest como interface para realizar operaciones sobre una entidad Tarea (Task).

## Configuración Local

Los siguientes puntos o elementos son necesarios para la construccion e implementacion de esta API.

    * Intellij IDEA Community (Recomendado).
    * Gradle
    * Java 1.8
    * Base de datos (Para ejemplo, se utilizo base de datos Postgres)

## Configuracion Inicial Base de Datos

### Creacion de Esquema

    CREATE SCHEMA "clever" AUTHORIZATION postgres;

### Creacion de Tabla

    Al tener implementado JPA/Hibernate, la tabla Task es creada automaticamente al iniciar la aplicacion.

### Configuracion Data Source
    
    En el Archivo application.yml, se deben reemplazar las siguientes propiedades: 
    
    spring:
        datasource:
            url: jdbc:postgresql://localhost:5432/postgres?currentSchema=clever&ssl=false
            driverClassName: org.postgresql.Driver
            username: <local_db_username>
            password: <local_db_password>

## Starting Application

Una vez  realizada la configuracion inicial de la base de datos,  ejecutar mediante consola:

    * gradlew clean build

Una vez finalizado y obtenido el mensaje BUILD SUCCESSFUL

    * gradlew bootRun

Una vez iniciada la aplicacion, se puede consumir el siguiente endpoint mediante curl o herramienta Postman.

## Especificaciones API v1

## Swagger: 
    
    http://localhost:8081/swagger-ui/index.html#/

### GET: /task/{task-id} : Retorna el Task para el id recibido.

    curl --location --request GET 'http://localhost:8081/task/2'


### GET: /task/ : Retorna todos los Task.

    curl --location --request GET 'http://localhost:8081/task/'

### POST: /task/ : Crea un nuevo Task.
    
    curl --location --request POST 'http://localhost:8081/task/' \
        --header 'Content-Type: application/json' \
        --data-raw '{
            "title":"Terminar Desafio",
            "description":"Debo terminar desafio de cleverIT",
            "expirationDate": "2023-09-28",
            "status":"PENDANT"
        }'

### PUT: /task/{task-id} : Actualiza el Task asociado al Id recibido.

    curl --location --request PUT 'http://localhost:8081/task/2' \
        --header 'Content-Type: application/json' \
        --data-raw '{
            "title":"Terminar Desafio (updated)",
            "description":"Debo terminar desafio de cleverIT",
            "expirationDate": "2023-09-28",
            "status":"PENDANT"
        }'


### DELETE: /task/{task-id} : Elimina el Task asociado al Id recibido.

    curl --location --request DELETE 'http://localhost:8081/task/1'


