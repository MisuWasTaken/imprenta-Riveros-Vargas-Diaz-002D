# Sistema de gestión de imprenta

Proyecto desarrollado con arquitectura de microservicios para gestionar solicitudes de impresión en un entorno escolar.
El sistema permite administrar profesores, asignaturas, cursos, impresiones, historial, inventario, cola de impresión, control de calidad y retiros. Todas las rutas pueden ser usadas desde el API GATEWAY desde el puerto: 8080

## Integrantes

- Francisco Riveros
- Damián Díaz

## Tecnologías utilizadas

- Java 21
- Spring Boot 3.5.14
- Spring Web
- Spring Data JPA
- MySQL
- XAMPP / phpMyAdmin
- Lombok
- Maven
- Swagger / OpenAPI
- Spring Cloud Gateway
- JUnit
- Mockito
- Postman
- GitHub
-Spring Security
-JWT

## Arquitectura del proyecto

El sistema está dividido en microservicios. Cada servicio tiene una responsabilidad específica y cuenta con su propia estructura por capas.

Estructura general de cada microservicio:

- Controller
- Service
- Repository
- Model

El API-GATEWAY funciona como punto de entrada principal y redirige las solicitudes hacia el microservicio correspondiente, sin necesidad de cambiar el purto a cada rato.

## Microservicios

| api-gateway | 8080 | Api Gateway |
| service-profesores | 8081 | Gestión de profesores |
| service-asignaturas | 8082 | Gestión de asignaturas |
| service-cursos | 8083 | Gestión de cursos |
| service-historial | 8084 | Historial de acciones |
| service-impresiones | 8085 | Solicitudes de impresión |
| service-inventario | 8086 | Lista de materiales disponibles |
| service-cola | 8087 | Cola y prioridad de impresión |
| service-calidad | 8088 | Anotaciones de copias defectuosas o problemas de calidad |
| service-retiros | 8089 | Estado de retiro de impresiones |
| service-auth | 8090 | Autenticación por token |

## Requisitos

Para ejecutar el proyecto se necesita:

- Java 21
- Maven
- XAMPP
- MySQL
- Visual Studio
- Postman

## Ejecucion

1. Abrir XAMPP.
2. Iniciar Apache y MySQL.
3. Abrir el proyecto en Visual Studio
4. Ejecutar cada microservicio.
5. Ejecutar API-GATEWAY.
6. Probar las rutas desde Postman usando: http://localhost:8080  (http://localhost:8080/retiros)
7. Revisar Swagger desde: http://localhost:8080/swagger-ui.html

## API Gateway

Ruta principal del gateway:

http://localhost:8080

Ejemplos de rutas:

| GET | /profesores
| GET | /asignaturas
| GET | /cursos
| GET | /historial
| GET | /impresiones
| GET | /inventario
| GET | /cola
| GET | /calidad
| GET | /retiros

## Endpoints principales

### Profesores:

- GET /profesores
- POST /profesores
- GET /profesores/{id}
- PUT /profesores/{id}
- DELETE /profesores/{id}

### Asignaturas:

- GET /asignaturas
- POST /asignaturas
- GET /asignaturas/{id}
- GET /asignaturas/sigla/{sigla}
- PUT /asignaturas/{id}
- DELETE /asignaturas/{id}

### Cursos:

- GET /cursos
- POST /cursos
- GET /cursos/{id}
- PUT /cursos/{id}
- DELETE /cursos/{id}

### Historial:

- GET /historial
- POST /historial
- GET /historial/{id}
- PUT /historial/{id}
- DELETE /historial/{id}

### Impresiones:

- GET /impresiones
- POST /impresiones
- GET /impresiones/{id}
- PUT /impresiones/{id}/listo
- DELETE /impresiones/{id}

### Inventario:

- GET /inventario
- POST /inventario
- GET /inventario/nombre/{nombre}
- PUT /inventario/{id}
- PUT /inventario/{id}/agregar?cantidad=10
- PUT /inventario/{id}/quitar?cantidad=5
- DELETE /inventario/{id}

### Cola de impresión:

- GET /cola
- POST /cola
- PUT /cola/{id}
- PUT /cola/{id}/lista
- GET /cola/urgentes
- DELETE /cola/{id}

### Calidad:

- GET /calidad
- POST /calidad
- GET /calidad/{id}
- PUT /calidad/{id}
- DELETE /calidad/{id}

### Retiros:

- GET /retiros
- POST /retiros
- PUT /retiros/{id}
- DELETE /retiros/{id}

### Auth:

- POST /auth/register
- POST /auth/login

# Ejemplos de JSON:

### Crear profesor:
{
  "nombre": "Francisco",
  "apellido": "Riveros",
  "correo": "f.riveros@duocuc.cl",
  "telefono": "4858345"
}


### Crear asignatura:
{
  "sigla": "MAT",
  "nombre": "Matemáticas"
}

### Crear curso:
{
  "nombre": "1 Básico A",
  "nivel": "Básico",
  "jornada": "Diurno"
}

### Crear impresion:
{
  "profesorId": 1,
  "cursoId": 1,
  "asignaturaId": 1,
  "cantidadCopias": 50,
  "notasAdicionales": "Test numero 1"
}

### Crear material de inventario:
{
  "nombre": "Resma carta",
  "cantidad": 20,
  "descripcion": "Papel blanco tamaño carta"
}

### Crear registro en cola:
{
  "impresionId": 3,
  "prioridad": "urgente",
  "estadoCola": "encola"
}

### Crear revisión de calidad:
{
  "impresionId": 2,
  "cantidadDefectuosas": 5,
  "notasExtras": "Salieron manchadas con tinta"
}

### Crear retiro:

{
  "impresionId": 3,
  "estadoRetiro": "pendiente"
}

### Registrar usuario:
{
  "nombreUsuario": "admin",
  "contraseña": "1234",
  "correo": "admin@imprenta.cl",
  "roles": []
}

### Logearse:
{
  "nombreUsuario": "admin",
  "contraseña": "1234"
}

## Swagger

Swagger centralizado:
# http://localhost:8080/swagger-ui.html

Swagger individual:

# | Profesores | http://localhost:8081/swagger-ui.html 
# | Asignaturas | http://localhost:8082/swagger-ui.html
# | Cursos | http://localhost:8083/swagger-ui.html
# | Historial | http://localhost:8084/swagger-ui.html
# | Impresiones | http://localhost:8085/swagger-ui.html
# | Inventario | http://localhost:8086/swagger-ui.html
# | Cola | http://localhost:8087/swagger-ui.html
# | Calidad | http://localhost:8088/swagger-ui.html
# | Retiros | http://localhost:8089/swagger-ui.html

## Base de datos

El proyecto utiliza MySQL mediante XAMPP y phpMyAdmin.
Cada microservicio trabaja con su propia base de datos.

## Testing

El proyecto contiene pruebas unitarias con JUnit y Mockito en 6 de ellos los cuales son:
- service-profesores
- service-cursos
- service-asignaturas
- service-historial
- service-impresiones
- service-inventario

## Funcionamiento general

1. Se registran `profesores, cursos y asignaturas`.
2. Se `crea una solicitud de impresión`.
3. `service-impresiones` reune los datos relacionados.
4. `service-historial` registra automaticamente una fecha de solicitud de impresion.
5. `service-cola` permite ver la cola de impresiones, destacando el /cola/urgentes.
6. `service-inventario` Permite ver el inventario y actualizarlo a comodidad del usuario.
7. `service-calidad` Sirve para anotar y registrar detalles en impresiones.
8. `service-retiros` indica si una impresión ya fue retirada o aun no.
9. El `api-gateway` permite acceder a todo desde un solo puerto.

## Estado del proyecto

El sistema cuenta con microservicios funcionales, API Gateway, Swagger centralizado, pruebas unitarias y comunicacion entre servicios. Tambien incluye JWT y auth.