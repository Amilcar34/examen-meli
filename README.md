# Examen Meli: traductor Morse

App para traducir de codigo binario a morse y de este ultimo a lenguaje humano.

## Setup

- JAVA 1.8
- MAVEN

##Instrucciones

Para compilar y ejecutar proyecto es necesario contar con la version 1.8 de la JDK y Maven para la gestion de las dependencias.
Una vez levantado la aplicacion se debe ingresar a http://localhost:8080/ 

Al ingresar a la aplicacion web, es necesario ingresar el nombre y el apellido del emisor del mensaje. 

Luego, se exigira que antes de enviar el primer mensaje se ingrese la palabra 'PARIS' en clave morse al menos dos veces, para utilizarlo posteriormente como parametro al momento de decodificar el mensaje. 
Para ingresar el mensaje, se debe presionar el boton "COMENZAR" y luego se habilitara el boton "PRESIONAME!" el cual permite enviar un PUNTO o TRAZO en morse. Despues, se presiona el boton enviar para detener el envio del mensaje.

Una vez ingresado la palabra 'PARIS' podemos ingresar el mensaje deseado en clave morse, ademas del receptor del mensaje.

Para visualizar el mensaje enviado, se puede ingresar nuevamente a la aplicacion con el nombre y el apellido del receptor.
En la opcion del menu 'Mensajes' se encontrara una lista de contactos con sus respectivos mensajes.

Tambien, se puede encontrar el proyecto deployado en [ML-EXAMEN](https://ml-examen.cfapps.io/).

## Tecnologias utilizadas
	
- H2 database
- Spring Web 
- Spring Data JPA
- Thymeleaf
- HTML, CSS y JS
- Bootstrap 4
- Swagger

## Api

Para obtener la documentacion de la API ingresar a [ML-DOCUMENTACION](https://ml-examen.cfapps.io/swagger-ui.html#/morse-rest-controller).

## Datos relevantes

Como premisa principal del proyecto al momento de decodificar un mensaje en bits a morse, se decidio seguir el estandar propuesto por morse: 
	
- Al inicio de cada comunicacion enviar la palabra PARIS repetidas veces para utilizarlo de 
	medida.

