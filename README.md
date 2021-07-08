# Carros por consola
## _Reto de programación_

[![N|Solid](https://static.vecteezy.com/system/resources/thumbnails/000/623/239/small/auto_car-16.jpg)]

En este reto vamos a modelar un concurso de carros, donde vamos a tener ciertas reglas
del juego. Para este reto es necesario tener los conocimientos básicos de LENGUAJE DE
PROGRAMACIÓN usando el paradigma de programación orientada a objetos. Esto implica
conocer el modelamiento de objetos, además se deberá guardar en base de datos los
resultados del juego.

## Características

Dentro del reto se debe considerar lo siguiente:

- ✨Manejo de clases u objetos ✨
- ✨ Persistencia de datos✨
- ✨ Manejos de listas o colecciones✨
- ✨ Conocimiento de cualquier lenguaje de programación.✨
- ✨ Manejo de Git (versión de control)✨
 

> Solo aplicate al reto si te sientes capaz de hacerlo.
¡Buena suerte!


## Tecnología
Versiones utilizadas en la creacion del proyecto.

- [JDK 16].- software para los desarrolladores de Java
- [Apache NetBeans IDE 12.4] - entorno de desarrollo integrado libre, orientado principalmente al desarrollo de aplicaciones Java.
- [MySQL 8.0] - sistema de gestión de base de datos relacional (RDBMS) de código abierto


## Instalación

Instalar la dependencia en el pom.xml para la conexión con la base de datos.

```sh
<dependencies>
<dependency>
    <groupId>mysql</groupId>
    <artifactId>mysql-connector-java</artifactId>
    <version>8.0.25</version>
</dependency>
</dependencies>
```

## Problema

Lo que se busca en este juego es crear unos carros y posicionarlo en una pista (cada
carro tiene un conductor), puede existir tantos carros como carriles, cada pista deberá
tener el mismo límite de distancia (kilómetros) para el recorrido del carro, los carros
avanzan de forma aleatoria aumentado su distancia por medio de metros (los kilómetros
de debe convertir a metros para que el avance sea en metros)

## Funcionalidades
- Configurar Juego: Crear juego con jugadores, el juego debe tener los limites de
kilómetros por cada pista (un jugador puede ser un conductor y un conductor debe
tener un carro asociado y un carro debe estar asociado a un carril que a su vez debe
estar en una pista)
- Iniciar el juego: iniciar con un identificado del juego, se debe tener la lista de carros
en donde se pueda iterar y avanzar según la posición de la pista o carril, esto debe
ser de forma aleatoria (por medio del dado).
- Asignar podio (fin del juego): Se debe seleccionar primer, segundo y tercer lugar
en la medida que los carros llegan a la meta (asignar al podio).
- Guardar datos: Se debe persistir los resultados con los nombres de los conductores
en la posición del podio y agregar un contador de las veces que ha ganado


## Base de datos

Para la conexión con la base de datos es necesario crear la tabla y el esquema necesarios, esto se puede hacer con una importación sencilla.

lo primero sería crear el schema en workbench llamado ***sofkadata***.

![image](https://user-images.githubusercontent.com/83151174/124999004-f6d32d00-e012-11eb-849a-c73ad1dd12d2.png)

Luego se debe entrar a la opción data import.

![image](https://user-images.githubusercontent.com/83151174/124999124-22eeae00-e013-11eb-8b8a-5e686696e208.png)

Por último solo seria activar la opción self-contained file y se busca el archivo llamado sofkadata_ganadores que está dentro de la carpeta raíz y se selecciona el esquema en donde se va a importar que seria sofkadata.

![image](https://user-images.githubusercontent.com/83151174/124999326-7660fc00-e013-11eb-949a-1ae2e6c9f9d4.png)


esto en codigo seria de la siguiente manera:

```sh
CREATE SCHEMA `sofkadata` ;

CREATE TABLE `sofkadata`.`ganadores` (
  `nombre` LONGTEXT NULL,
  `vecesPrimero` INT NULL,
  `vecesSegundo` INT NULL,
  `vecesTercero` INT NULL);
```
Para realizar la conexión es necesario un esquema con el nombre ***sofkadata*** y una tabla  llamada ***ganadores***, en este caso esta configurado todo en localhost con un usuario root y una contraseña root, esto se puede cambiar para realizar la conexión en el código de la siguiente manera:

ir a el package juego y abrir juego.java

![image](https://user-images.githubusercontent.com/83151174/124997468-4532fc80-e010-11eb-86d6-4fab2547fb44.png)

Al final del código estarán los ***3 metodos*** necesarios para la conexión con la DB, ahí se podrá cambiar el puerto, el nombre del esquema, usuario, contraseña, y dos líneas más abajo el nombre de la tabla, esto se hace solo si es necesario.

![image](https://user-images.githubusercontent.com/83151174/124997993-36007e80-e011-11eb-95f2-3a3efea90a8a.png)

## Código

El código inicia solicitando la catidad de jugadores además de creando una nueva base de datos si la conexión fue realizada, sino no afectara el código pero la persistencia de los datos no será en una base de datos. 

![image](https://user-images.githubusercontent.com/83151174/125001130-90044280-e017-11eb-9fb2-1ff8de9f0dda.png)

Luego pide el nombre de los jugadores, el código contempla string vacios e inclusive repetidos.

![image](https://user-images.githubusercontent.com/83151174/125001307-eb363500-e017-11eb-9ab5-e393043fa7c1.png)

y pregunta si el jugador va a ser conductor o no esto admite yYnN.

![image](https://user-images.githubusercontent.com/83151174/125001275-db1e5580-e017-11eb-843e-1c6f85d66b8f.png)

una vez puesto todos los nombres se selecciona la pista, el juego contempla que si el valor ingresado no esta disponible tenga que ingresar de nuevo el valor.

![image](https://user-images.githubusercontent.com/83151174/125001591-9f37c000-e018-11eb-96a0-86e3bd27457e.png)

Por ultimo luego de realizar la carrera el codigo me entrega el podio y almacena en la DB.

![image](https://user-images.githubusercontent.com/83151174/125001645-c55d6000-e018-11eb-9fe9-0465f5563c78.png)

DB

![image](https://user-images.githubusercontent.com/83151174/125001664-cee6c800-e018-11eb-89f4-850d2a4189aa.png)


**Free Software, Hell Yeah!**

[//]: # (These are reference links used in the body of this note and get stripped out when the markdown processor does its job. There is no need to format nicely because it shouldn't be seen. Thanks SO - http://stackoverflow.com/questions/4823468/store-comments-in-markdown-syntax)

   [JDK 16]: <https://www.oracle.com/java/technologies/javase-jdk16-downloads.html>
   [Apache NetBeans IDE 12.4]: <https://netbeans.apache.org/download/nb124/nb124.html>
   [MySQL 8.0]: <https://dev.mysql.com/downloads/mysql/>
