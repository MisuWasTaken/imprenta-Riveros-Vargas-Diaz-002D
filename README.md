Para probar el postman lo primero que hice fue: "GET" http://localhost:8081/profesores y me mostro un [] Indicando que todo esta bien.
Luego en "POST", body, raw use este codigo para agregar un dato: 

{
  "nombre": "Francisco",
  "apellido": "Riveros",
  "correo": "franciscoriveros@duocuc.cl",
  "telefono": "953809086"
}
Luego se usa "GET" http://localhost:8081/profesores/1 para verificar que funciono correctamente

Mat
lenguaje
historia
fisica
quimica
ciencias
artes
formacion ciudadana
ed fisica
mecanica
electricidad
enfermeria


Este proyecto es para manejar las impresiones de forma automática. En vez de tener un solo programa gigante que haga todo, lo dividimos en tareas chiquitas llamadas microservicios, que se van avisando entre ellos para completar el trabajo.
El Recepcionista (API Gateway Puerto 8080): Es el jefe. TU se lo pides todo al Gateway. El se encarga de buscar la info en los demás servicios y te entrega la respuesta lista y completa.
Las Informaciones: Aquí guardamos todos los datos de los Profesores, las Asignaturas y los Cursos. Cada uno tiene su propia "carpeta" (Base de Datos MySQL) para que todo esté bien ordenado y no se mezcle nada y sea una manera mas sencilla.
Las Impresiones (Puerto 8085): Cuando alguien pide una impresión, este servicio junta los nombres de los profes y los cursos para armar el pedido especial que necesita el cliente.
El Historial (Puerto 8084): Este es como el que anota todo. Apenas se crea una impresión o cambia de estado, el sistema le avisa al Historial automáticamente. Él anota qué pasó y a qué hora, para que siempre tengamos el registro de lo que se ha hecho.

Este proyecto tiene como objetivo facilitar y hacer mucho mas llevadero el tener una constancia de las impresiones y poder manejarlas de mucha mejor manera.

Integrantes:
Damian Diaz
Francisco Riveros
Georgina Vargas