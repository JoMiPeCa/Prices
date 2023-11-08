# API-LECTURA-PRECIOS
Microservicio que utiliza H2 como base de datos para funcionar... Respuestas en formato JSON.

## Contenidos
1. [Versiones usadas](README.md#versiones-usadas)
2. [Que se incluye](README.md#que-se-incluye)
3. [¿Como echar a andar y que esperar?](README.md#como-echar-a-andar-y-que-esperar)
4. [Dentro del código](README.md#dentro-del-código)
5. [Comentarios](README.md#comentarios)

---

### Versiones usadas

Debo clarificar que el endpoint en Postman no esta funcionando debido a que faltan clases de seguridad en el proyecto. Favor dirigirse a PricesServiceSpec para ver los casos de prueba utilizados. 

- H2 como base de datos
- Maven para construir el proyecto
- Spring Framework/Boot 3.1.5
- Tomcat embebido
- Java 17 (Amazon)
- Github
- Spock
- JDBC

---

### Que se incluye?

En el proyecto podrá encontrar un archivo sql, en el cual se encuentran los scripts para la base de datos, una coleccion de postman en donde estan las entradas del controlador usadas en este servicio. Y un documento con el ejercicio de este programa. 

---

### ¿Como echar a andar y que esperar?

Primero, descargue el proyecto. Descomprímalo en su ubicación deseada y utilizando maven, corralo(O bien con su IDE favorito, seleccione PricesApplication y corra el archivo). 
Después, podrá revisar la base de datos en: 

- URL: http://localhost:8080/h2-ui
- User:  user
- PW: password

Recomiendo ir a la clase de prueba PricesServiceSpec, donde encontrará el test a ejecutar con sus 5 variantes. La etiqueta @Unroll provoca que cada linea del "where" se ejecute como un test aparte. 

---

### Dentro del código

Se utiliza de base a JDK 17, pero como se puede observar en la mayoría del código, se utiliza Java 8 y Java 11. Todas las variables se pueden cambiar por su declaración original. 

Se utiliza Spock en vez de JUnit... Esto es porque es un framework potente y que tiene compatibilidad en varias versiones, incluidas Java 8 e inclusive Java 21... Sí quedo algún test sin hacer. Pido disculpas.

Nota: No utilizar los archivos autogenerados de jacoco. Si desea ver el coverage, puede generarlos en cada clase con su IDE favorito.

---

### Comentarios

Gracias por este desafío, me gusta poder poner en práctica mis conocimientos, pero me di cuenta de que el ejercicio tiene algunos errores, inclusive me confundió en algunos momentos... PricesResponseDTO.tarifaAaplicar quedo sin mapear porque no se entendía bien contra que campo debía mapearse, creo que falto un método o una especificación allí. Utilice una mezcla de variables español/ingles porque el ejercicio tenia la BD en ingles, pero venia en español, con varios campos en español. Entonces preferí dejarlo lo mas amigable para el usuario. 
Es una muy mala práctica utilizar dos idiomas para programar, pero hice una excepción dada la escritura del examen. 