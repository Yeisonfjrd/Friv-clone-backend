# Friv Clone Backend

Este es el backend del proyecto Friv Clone, una recreación moderna del clásico portal de juegos Friv. Construido con Spring Boot, proporciona una API RESTful para gestionar los juegos y sus categorías.

## 🚀 Características

- API RESTful completa
- Base de datos H2 en memoria
- CORS configurado para desarrollo local
- Gestión de juegos y categorías
- Documentación Swagger/OpenAPI

## 🛠️ Tecnologías Utilizadas

- Java 17
- Spring Boot 3.2.0
- Spring Data JPA
- H2 Database
- Maven

## 📋 Prerrequisitos

- Java JDK 17 o superior
- Maven 3.6 o superior
- IDE compatible con Spring Boot (recomendado: IntelliJ IDEA o Eclipse)

## 🔧 Instalación

1. Clonar el repositorio:
```bash
git clone https://github.com/tu-usuario/friv-clone-backend.git
cd friv-clone-backend
```

2. Compilar el proyecto:
```bash
./mvnw clean install
```

3. Ejecutar la aplicación:
```bash
./mvnw spring-boot:run
```

La aplicación estará disponible en `http://localhost:8080`

## 📚 Documentación API

### Endpoints

- `GET /api/games` - Obtener todos los juegos
- `GET /api/games/{id}` - Obtener un juego por ID
- `POST /api/games` - Crear un nuevo juego
- `PUT /api/games/{id}` - Actualizar un juego existente
- `DELETE /api/games/{id}` - Eliminar un juego

### Modelo de Datos

```json
{
  "id": 1,
  "title": "Nombre del Juego",
  "description": "Descripción del juego",
  "imageUrl": "URL de la imagen",
  "gameUrl": "URL del juego",
  "category": "Categoría del juego"
}
```

## 🔍 Base de Datos

La aplicación utiliza H2, una base de datos en memoria. Puedes acceder a la consola H2 en:
- URL: `http://localhost:8080/h2-console`
- JDBC URL: `jdbc:h2:mem:frivdb`
- Usuario: `sa`
- Contraseña: `password`

## 🧪 Tests

Para ejecutar los tests:
```bash
./mvnw test
```

## 📦 Despliegue

La aplicación está configurada para ser desplegada en cualquier servidor que soporte Java. Para generar el archivo JAR:
```bash
./mvnw package
```

El archivo JAR se generará en la carpeta `target/`.

## 🤝 Contribuir

1. Fork el proyecto
2. Crear una rama para tu feature (`git checkout -b feature/AmazingFeature`)
3. Commit tus cambios (`git commit -m 'Add some AmazingFeature'`)
4. Push a la rama (`git push origin feature/AmazingFeature`)
5. Abrir un Pull Request

## 📝 Licencia

Este proyecto está bajo la Licencia MIT - ver el archivo [LICENSE.md](LICENSE.md) para más detalles.

## ✨ Autores

* **Yeison Fajardo** - *Trabajo Inicial* - [YeisonFjrd](https://github.com/Yeisonfjrd)

## 🎉 Agradecimientos

* Friv por la inspiración
* La comunidad de Spring Boot
* Todos los contribuidores 
