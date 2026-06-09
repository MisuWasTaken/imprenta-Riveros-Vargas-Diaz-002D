Este proyecto es para manejar las impresiones de forma automática. En vez de tener un solo programa gigante que haga todo, lo dividimos en 
microservicios, que se van avisando entre ellos para completar el trabajo.

El Recepcionista (API Gateway Puerto 8080): Es el jefe. TU se lo pides todo al Gateway. El se encarga de buscar la info en los demás servicios y te entrega la respuesta lista y completa.
Las Informaciones: Aquí guardamos todos los datos de los Profesores (8081), las Asignaturas (8082) y los Cursos (8083). Cada uno tiene su propia "carpeta" (Base de Datos MySQL) para que todo esté bien ordenado y no se mezcle nada y sea una manera mas sencilla.
Las Impresiones (Puerto 8085): Cuando alguien pide una impresión, este servicio junta los nombres de los profes y los cursos para armar el pedido especial que necesita el cliente.
El Historial (Puerto 8084): Este es como el que anota todo. Apenas se crea una impresión o cambia de estado, el sistema le avisa al Historial automáticamente. Él anota qué pasó y a qué hora, para que siempre tengamos el registro de lo que se ha hecho.


Se utilizo Java con Spring Boot.
MySQL con Xampp
WebClient y RestTemplate para la comunicacion correcta entre servicios

Para ejecutar:

Se debe iniciar el Xampp con Apache y MySQL.
Iniciar los 5 microservicios y el gateway (8080)
Y realizar las pruebas mandando JSON desde postman al puerto 8080.



Integrantes:
Damian Diaz
Francisco Riveros
Georgina Vargas





Para ver Profesores:
http://localhost:8081/swagger-ui.html

Para ver las Asginaturas:
http://localhost:8082/swagger-ui.html

Para ver los Cursos:
http://localhost:8083/swagger-ui.html

Para ver el Historial:
http://localhost:8084/swagger-ui.html

Para ver las impresiones:
http://localhost:8085/swagger-ui.html