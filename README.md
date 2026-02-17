# IncidentsHotelBackend – Backend Hospitality

API RESTful para la gestión operativa de hoteles, construida con **Spring Boot 3.5** siguiendo principios de **DDD (Domain-Driven Design)** ligero y buenas prácticas modernas.

Hotel es el **Aggregate Root**. Rooms e Incidents existen solo en el contexto de un Hotel → diseño coherente de bounded context.

## Características principales

- Diseño jerárquico de endpoints: `/hotels/{hotelId}/rooms`, `/hotels/{hotelId}/incidents`
- Aggregate Root bien definido: `Hotel` → `Room` y `Incident` dependen de él
- Validaciones de negocio estrictas:
  - No se permiten rooms duplicados por número en el mismo hotel
  - Incidents con transiciones de estado controladas (no se puede modificar un CLOSED)
  - Existencia obligatoria del hotel en todas las operaciones hijas
- DTOs de entrada/salida separados de las entidades → no se exponen modelos de dominio
- Documentación automática con **OpenAPI 3** + **Swagger UI**
- Uso correcto de repositories con consultas específicas (`findByHotel_IdAnd...`, `existsBy...`)
- Lógica de negocio en capa de **Service**, no en controllers
- Manejo de excepciones global + respuestas HTTP consistentes

## Tecnologías

- **Java 21** (o 17+)
- **Spring Boot 3.5.10**
- **Spring Web** + **Spring Data JPA**
- **Hibernate** (como proveedor JPA)
- **H2** (para desarrollo/tests) / **PostgreSQL** (recomendado en producción)
- **Springdoc OpenAPI** (`springdoc-openapi-starter-webmvc-ui:2.8.15`) → Swagger UI
- **Lombok**
- **Maven** (o Gradle si prefieres migrarlo)
- **Validation** (Bean Validation / Jakarta Validation)

## Endpoints principales (ejemplos)

| Método | Endpoint                              | Descripción                              |
|--------|---------------------------------------|------------------------------------------|
| GET    | `/hotels`                             | Listar todos los hoteles                 |
| POST   | `/hotels`                             | Crear hotel                              |
| GET    | `/hotels/{hotelId}`                   | Obtener hotel por ID                     |
| POST   | `/hotels/{hotelId}/rooms`             | Crear habitación en hotel                |
| GET    | `/hotels/{hotelId}/rooms`             | Listar habitaciones de un hotel          |
| GET    | `/hotels/{hotelId}/rooms/{roomId}`    | Obtener habitación específica            |
| POST   | `/hotels/{hotelId}/incidents`         | Reportar incidente en hotel              |
| GET    | `/hotels/{hotelId}/incidents`         | Listar incidentes (puede filtrar por estado) |
| PATCH  | `/hotels/{hotelId}/incidents/{id}`    | Cambiar estado de incidente (OPEN → IN_PROGRESS → RESOLVED → CLOSED) |

Documentación interactiva:  
→ http://localhost:8080/swagger-ui.html  
→ http://localhost:8080/v3/api-docs

## Cómo ejecutar el proyecto

### Prerrequisitos

- Java 21 (o al menos 17)
- Maven 3.8

### Pasos

## Clonar el repositorio

```bash
git clone https:github.com/David24977/IncidentsHotel_Backend.git
cd IncidentsHotel_Backend
