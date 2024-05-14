<h1 align="center">Alura Latam. Challenge Libros </h1>
<p align="left">
   <img src="https://img.shields.io/badge/STATUS-EN%20DESAROLLO-green">
</p>

<p align="left">
   <img src="https://github.com/githubJHEB/challengeLibrosBaseDatos/assets/35204102/ec9fa03c-3817-4844-852f-8cafbe3147b3")
">
  
</p>


### Tópicos

- [Descripción del proyecto](#descripción-del-proyecto)

- [Funcionalidades](#funcionalidades)

- [Tecnologías utilizadas](#tecnologías-utilizadas)

- [Api utilizada](#api-utilizada)

- [Como abrir](#como-abrir)

- [Personas Contribuyentes](#personas-contribuyentes)

- [Licencia](#licencia)


## Descripción del proyecto
<p align="justify">
Este reto busca poner en práctica por medio de Spring Boot, la solicitud de información a la API de https://gutendex.com/books/, la cual ofrece el servicio de lista de libros con algunos datos característicos, entre ellos autor, link de descarga y otros. Tambien busca poner en práctica el mapeo de los resultados obtenidos JSON, con la libreria Hibernate JPA, para posteriormente crear un CRUDE con base de datos Postgresql.

![Descripción del proyecto. La figura muestra un niño leyendo un libor](https://github.com/githubJHEB/challengeLibrosBaseDatos/assets/35204102/7ca96678-ec78-4fae-a3e3-1d52d50fa8d5)

</p>

## Funcionalidades

<p align="justify">
Se debe digitar un número que represente la función deseada entre 1 y 7 
</p>

:heavy_check_mark: `Funcionalidad 1:` Carga de datos a la base de datos local desde la API Gutendex, por titulo.

:heavy_check_mark: `Funcionalidad 2:` Buscar libro por titulo.

:heavy_check_mark: `Funcionalidad 3:` Listar libros registrados en la base de datos Postgresql.

:heavy_check_mark: `Funcionalidad 4:` Listar los autores registrados en la base de datos.

:heavy_check_mark: `Funcionalidad 5:` Listar de autores regisrados desde una año en particular .

:heavy_check_mark: `Funcionalidad 6:` Listar lo libros resgistrado por idioma.

:heavy_check_mark: `Funcionalidad 7:` La opción de salir de la aplicación.

## Tecnologías utilizadas
<p align="justify">
Java v 17
</p>
<p align="justify">
Affinity Designer.
</p>

## Api utilizada
<p align="justify">
Necesaria para obtener los datos en formato JSON de libros.
</p>
<p align="justify">
https://gutendex.com/books/
</p>

## Como abrir
<p align="justify">
Ejecutar "ChallengeLibrosBaseDatosApplication.java" con IDEA CE Indellij
</p>
<p align="justify">
La API de Gutendex, no requiere de credenciales.
</p>
<p align="justify">
Debe configurar en archivo application.properties la contraseña dela base de datos, asi como su ruta.
</p>
<p align="justify">
Debe crear un tabla en la base de datos Postgrsql llmada "libros"
</p>
<p align="justify">
Una vez se ejecute la aplicación debe selecionar la opción uno, para cargar los datos de los libros desde la API Gutendex, por titulo y alamacenar cada nuevo resgistro en la base de datos. Los libros no pueden ser repetidos.
</p>


## Personas Contribuyentes
<p align="justify">
Jaime Eraso
</p>

## Licencia

<p align="justify">
Derechos reservados
</p>



