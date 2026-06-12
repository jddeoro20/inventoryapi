# Parcial Práctico – Arquitectura de Software

## Universidad de Antioquia

### Integrantes

* **Andrés Cortés García** – CC. 1017217563
* **Jesús De Oro** – CC. 1002390199

---

# Descripción del Proyecto

Este proyecto corresponde al desarrollo de una API RESTful para la gestión de inventario de productos de un almacén, realizada como parte del Parcial Práctico de la asignatura Arquitectura de Software de la Universidad de Antioquia.

La solución fue desarrollada utilizando Spring Boot, MySQL, Maven, Git, GitHub y Docker, implementando una arquitectura por capas basada en buenas prácticas de desarrollo de software.

---

# Objetivo

Desarrollar un servicio web RESTful capaz de gestionar información de inventario mediante operaciones de consulta y registro de productos, utilizando una base de datos relacional y tecnologías modernas del ecosistema Java.

---

# Tecnologías Utilizadas

* Java 21
* Spring Boot 3.5.15
* Spring Data JPA
* Hibernate
* MySQL
* Maven
* Git
* GitHub
* Docker
* REST API

---

# Arquitectura de la Solución

La aplicación fue desarrollada siguiendo una arquitectura por capas que separa las responsabilidades del sistema.

```text
Cliente
   │
   ▼
REST Controller
   │
   ▼
Service Layer
   │
   ▼
Repository Layer
   │
   ▼
MySQL Database
```

---

# Estructura del Proyecto

```text
src
 └─ main
     └─ java
         └─ com.udea.inventoryapi
             ├─ controller
             │   └─ ProductController
             ├─ model
             │   ├─ Product
             │   └─ Warehouse
             ├─ repository
             │   └─ ProductRepository
             ├─ service
             │   └─ ProductService
             └─ InventoryapiApplication
```

---

# Modelo de Datos

## Product

Entidad principal encargada de representar los productos almacenados en el sistema.

| Campo  | Tipo    |
| ------ | ------- |
| id     | Long    |
| nombre | String  |
| precio | Double  |
| stock  | Integer |

## Warehouse

Entidad creada como aproximación para la gestión de almacenes dentro del sistema.

| Campo     | Tipo   |
| --------- | ------ |
| id        | Long   |
| nombre    | String |
| direccion | String |

---

# Endpoints Implementados

## Obtener todos los productos

```http
GET /products
```

Respuesta:

```json
[
  {
    "id": 1,
    "nombre": "Laptop",
    "precio": 2500.0,
    "stock": 10
  }
]
```

---

## Obtener producto por ID

```http
GET /products/{id}
```

---

## Registrar producto

```http
POST /products
```

Ejemplo de solicitud:

```json
{
  "nombre": "Laptop",
  "precio": 2500,
  "stock": 10
}
```

---

## Eliminar producto

```http
DELETE /products/{id}
```

---

# Persistencia de Datos

Se utilizó MySQL como motor de base de datos relacional para almacenar la información del inventario.

Configuración principal:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/inventorydb
spring.datasource.username=root
spring.datasource.password=********

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

Hibernate fue configurado para generar automáticamente las tablas necesarias durante la ejecución de la aplicación.

---

# Construcción del Proyecto

## Compilar el proyecto

```bash
mvn clean package
```

## Ejecutar la aplicación

```bash
mvn spring-boot:run
```

La aplicación se ejecuta por defecto en:

```text
http://localhost:8080
```

---

# Docker

Como parte del proyecto se realizó el proceso de contenerización de la aplicación mediante Docker.

Se creó el archivo `Dockerfile` y se construyó exitosamente una imagen Docker utilizando:

```bash
docker build -t inventoryapi .
```

Durante las pruebas se logró generar correctamente la imagen Docker de la aplicación. Sin embargo, la ejecución completa del contenedor presentó inconvenientes relacionados con la conectividad entre la aplicación y la base de datos MySQL ubicada fuera del contenedor.

A pesar de ello, se verificó satisfactoriamente el proceso de construcción de la imagen y la configuración inicial del despliegue mediante Docker.

---

# Control de Versiones

Se utilizó Git para el control de versiones del proyecto y GitHub para la publicación del código fuente.

Repositorio:

https://github.com/jddeoro20/inventoryapi

---

# Evidencias de Funcionamiento

Durante el desarrollo se verificó:

* Conexión exitosa a MySQL.
* Creación automática de tablas mediante Hibernate.
* Registro de productos mediante peticiones POST.
* Consulta de productos mediante peticiones GET.
* Eliminación de productos mediante peticiones DELETE.
* Generación exitosa del archivo JAR mediante Maven.
* Construcción exitosa de imagen Docker.
* Publicación exitosa del código fuente en GitHub.

---

# Resultados Obtenidos

La solución implementada permitió:

* Exponer una API REST funcional.
* Gestionar productos mediante operaciones CRUD básicas.
* Persistir información en una base de datos relacional.
* Aplicar arquitectura por capas.
* Utilizar herramientas modernas del ecosistema Java.
* Integrar control de versiones mediante Git y GitHub.
* Realizar pruebas de contenerización mediante Docker.

---

# Conclusiones

El proyecto permitió aplicar conceptos fundamentales de Arquitectura de Software mediante el desarrollo de una API REST basada en Spring Boot.

Durante la implementación se utilizaron mecanismos de persistencia con JPA e Hibernate, acceso a bases de datos relacionales mediante MySQL, control de dependencias con Maven y gestión de versiones utilizando Git y GitHub.

Adicionalmente, se realizaron pruebas de despliegue mediante Docker y se estructuró la aplicación siguiendo una arquitectura por capas que facilita el mantenimiento, escalabilidad y evolución futura del sistema.

La solución constituye una base sólida para futuras extensiones relacionadas con gestión avanzada de inventarios, administración de almacenes, documentación de APIs y despliegues completamente contenerizados.

