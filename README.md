# foroHubAlura

# Aplicacion de ALURA foroHub

API de topicos de respuestas y busqueas creado con Spring Boot con autenticacion con JWT y BCRYPT.


## Utilizaremos [SPRING INITALITZER](https://start.spring.io/)

utilizaremos para nuestro proyecto las siguientes dependencias de SpringBoot.

 - [Spring Boot DevTools](https://mvnrepository.com/artifact/mysql/mysql-connector-java)
 - [Lombok ](https://projectlombok.org/setup/maven)
  - [Spring Web](https://mvnrepository.com/artifact/org.springframework/spring-web)
 - [Validation  ](https://mvnrepository.com/artifact/javax.validation/validation-api)
  - [Spring Data JPA](https://mvnrepository.com/artifact/org.springframework.data/spring-data-jpa)
 - [MySQL Driver ](https://mvnrepository.com/artifact/mysql/mysql-connector-java) 
  - [Spring Security](https://mvnrepository.com/artifact/org.springframework.security/spring-security-core) 

## Referencias de API

#### Traer todos los topicos

```http
  GET /topico/mostrar
```

| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `token api` | `string` | **Required**. apiToken |

#### Traer solo un topico por id

```http
  GET /topico/unidad/{id}
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `token api` | `string` | **Required**. apiToken |
| `id`      | `string` | **Required**. id de libro y apiToken|


#### Crear un topico

```http
  POST /topico/crear
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `token api` | `string` | **Required**. apiToken |
| `titulo`      | `string` | **Required**  |
| `idioma`      | `string` | **Required**  |
| `autor`      | `json` | **Required**  |
| `nombre`      | `string` | **Required**  |
| `nacionalidad`      | `string` | **Required**  |

#### Actualizar un topico


```http
  PUT /topico/actualizar/{id}
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `token api` | `string` | **Required**. apiToken |
| `titulo`      | `string` | **NotRequired**  |
| `idioma`      | `string` | **NotRequired**  |
| `autor`      | `json` | **NotRequired**  |
| `nombre`      | `string` | **NotRequired**  |
| `nacionalidad`      | `string` | **NotRequired**  |

#### Eliminar un topico

```http
  DELETE /topico/borrar/{id}
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `token api` | `string` | **Required**. apiToken |
| `id`      | `Long` | **Required**  |


#### cada uno de los end point nesecitan las autenticacion que se realiza por medio del Login con un usuario previamente guardado y encriptado el password con BCRYPT  de una pagina en linea 

```http
  POST /login
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `login` | `string` | **Required** |
| `clave`      | `string` | **Required**  |

## Seguridad
Para la creacion del Login salvamos antes en la base de datos de MYSQL los datos del usuario login y clave encriptada antes - [BCRYPT](https://bcrypt-generator.com/) y la guardamos en nuestra base de datos para que nuestro proyecto la desencripte y vrifique el usuario con su rol.

Tambien usaremos en JSON Web Token usaremos la version 4.2.4 - [JWT](https://jwt.io/) para enviar un token en nuestra cabecera de autenticacion a todos nuestos endPoint y asi verificar que tipo de usuario se a logueado por ejemplo ADMIN, USER, CLIENT.



## Documentation

[JWT token](https://jwt.io/introduction) Para generar el token de autenticacion en todos nuestro endPoint,

[Bcrypt](https://www.npmjs.com/package/bcrypt) Para encriptar nuestras contrase;as en nuestra base de datos

[SpringInizialitzer](https://github.com/spring-io/initializr/) Donde encontraremos todas las dependencias necesarias para nuestro proyecto

[Maven properties](https://books.sonatype.com/mvnref-book/reference/resource-filtering-sect-properties.html) Aca podremos ayar mas informacion de las propiedades de maven



## 🔗 Links
[![Alura](https://img.shields.io/badge/alura-000?style=for-the-badge&logo=ko-fi&logoColor=r)](https://www.aluracursos.com/)
[![oracle](https://img.shields.io/badge/oracle-0A66C2?style=for-the-badge&logo=&logoColor=white)](https://www.oracle.com/ar/education/oracle-next-education/)


