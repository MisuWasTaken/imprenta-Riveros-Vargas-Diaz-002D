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