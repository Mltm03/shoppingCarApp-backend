# Proyecto: API REST para Catálogo de Compras

## ***Introducción***
Este proyecto se basa en una arquitectura por capas diseñada para proveer un servicio de API REST que permita gestionar y enviar datos a un catálogo de compras.
La arquitectura facilita la separación de responsabilidades, lo que hace que el código sea más fácil de mantener y escalar.


## ***Arquitectura del Proyecto***
La aplicación sigue el modelo básico de capas, que incluye las siguientes:

*Models (Modelos)*

Contienen las clases que representan las entidades del dominio.
Estas clases están mapeadas a las tablas de la base de datos utilizando JPA/Hibernate.

*Repositories (Repositorios)*

Gestionan la interacción con la base de datos.
Utilizan las interfaces de Spring Data (JpaRepository) para realizar operaciones CRUD de manera sencilla.

*Services (Servicios)*

Implementan la lógica de negocio.
Son responsables de coordinar la comunicación entre los repositorios y los controladores.

*Controllers (Controladores)*

Gestionan las solicitudes HTTP entrantes (GET, POST, PUT, DELETE, etc.).
Llaman a los servicios para procesar las solicitudes y devuelven las respuestas al cliente.

Cliente
   |
   v
Controladores (Controllers)
   |
   v
Servicios (Services)
   |
   v
Repositorios (Repositories)
   |
   v
Base de Datos


## **Tecnologías utilizadas**🚀
Este proyecto utiliza las siguientes tecnologías y herramientas:

Spring Boot: Framework principal para desarrollar la API REST.
Spring Data JPA: Para la interacción con la base de datos.
H2 Database/MySQL: Base de datos (puede cambiarse según necesidad).
Maven/Gradle: Gestión de dependencias.
Java 17.





## Estructura por capas
Dentro del presente proyeto se divide utilizando una arquitectura por capas de tal manera que es la mas comun en el desarrollo con springboot

Models -> Repositories -> Services -> Controllers


### Models

Primeramente se tiene el modelo de producto en la clase **Product.java** -> En esta clase se utiliza Jakarta y el objetivo es que se mapee a la base de datos
**Explicación del código**
Anotaciones principales:

@Entity: Marca esta clase como una entidad JPA que se mapeará a una tabla en la base de datos.
@Table(name="products"): Define el nombre de la tabla en la base de datos que corresponde a esta entidad. Si no se usa, JPA toma el nombre de la clase (Product).
@Id: Indica que el atributo id es la clave primaria.
@GeneratedValue(strategy=GenerationType.IDENTITY): Define cómo se generará el valor del campo id. En este caso, será autoincremental.
Campos de la clase:

id: Clave primaria de tipo Long.
name, description y price: Atributos básicos para un producto, todos de tipo String.
Getters y Setters: Proveen encapsulamiento, lo que permite acceder a los atributos de la clase de forma controlada.


### Repository

Para la capa de repository se utilizó la interface de  **ProductRepository**, donde se heredó de la clase  **CrudRepository** de springframework (un dato importante es que al heredar de crudRepository ya no es neesario realizar la anotación de @Repository para el bean)

Interfaz CrudRepository:

Es una interfaz genérica que te permite realizar operaciones básicas como:
Guardar (save)
Buscar por ID (findById)
Buscar todos los registros (findAll)
Eliminar (deleteById o delete)
En este caso, se trabaja con la entidad Product y su clave primaria de tipo Long.
Definición básica:

CrudRepository<Product, Long> significa que esta interfaz maneja objetos de tipo Product y que el tipo de la clave primaria de Product es Long.
Métodos disponibles (sin necesidad de implementarlos):

save(S entity)
findById(ID id)
existsById(ID id)
findAll()
deleteById(ID id)
deleteAll()

## Services

En la capa services del proyeto de momento se manejan 2 archivos, uno es una interface y el segundo es la implementación de dicha interface
ProductService (interfaz)
La interfaz define los métodos que el servicio debe implementar. Esto asegura que cualquier clase que implemente esta interfaz tendrá los métodos necesarios.

ProductServiceImpl
Esta clase implementa la lógica de los métodos definidos en la interfaz ProductService. Generalmente, interactúa con el repositorio para acceder a los datos.

    Explicación de los métodos en ProductServiceImpl:

    *findAll(): Obtiene todos los productos utilizando findAll() del repositorio.
    *findById(Long id): Busca un producto por su ID. Devuelve un Optional que puede estar vacío si el producto no existe.
    *save(Product product): Guarda o actualiza un producto. Spring Data automáticamente distingue si es una nueva entidad o una existente.
    *deleteById(Long id): Elimina un producto por su ID.
    *findByName(String name): Devuelve una lista de productos cuyo nombre coincida con el valor dado.
    *findByPriceBetween(BigDecimal minPrice, BigDecimal maxPrice): Busca productos cuyo precio esté dentro de un rango.


