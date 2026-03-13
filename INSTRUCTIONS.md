# INSTRUCTIONS

Guia rapida para correr el backend con MySQL y consumir los endpoints.

## 1. Requisitos

- Java 21
- MySQL Server 8+
- MySQL Workbench (opcional, recomendado)
- Windows PowerShell (o terminal equivalente)

## 2. Configurar base de datos MySQL

1. Crea la base y tablas ejecutando el script [kinConnect.sql](./kinConnect.sql).
2. Asegurate de que el nombre del schema en MySQL coincide con `spring.datasource.url`.
3. Verifica credenciales en [application.properties](./src/main/resources/application.properties).

Notas importantes:
- El archivo `kinConnect.sql` usa por defecto el schema `kin_conecta`.
- Si en `application.properties` usas `kinConecta`, debes:
1. Cambiar la URL a `kin_conecta`, o
2. Crear ese schema alterno y ajustar el script.

## 3. Configuracion recomendada de application.properties

Ejemplo compatible con el script SQL:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/kin_conecta?useSSL=false&allowPublicKeyRetrieval=true
spring.datasource.username=root
spring.datasource.password=TU_PASSWORD
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.jpa.hibernate.ddl-auto=none
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
```

## 4. Levantar el backend

Desde la carpeta `socialNetwork`:

```powershell
.\gradlew.bat bootRun
```

Si inicia correctamente, la API quedara disponible en:

```text
http://localhost:8080
```

## 5. Ejecutar pruebas

```powershell
.\gradlew.bat test --no-daemon --console=plain
```

## 6. Catalogo completo de endpoints

Consulta [ENDPOINTS.md](./ENDPOINTS.md) para ver todos los endpoints (195 rutas CRUD en 39 controladores).

## 7. Ejemplos de uso (curl)

Base URL:

```text
http://localhost:8080
```

### 7.1 Crear idioma

```bash
curl -X POST "http://localhost:8080/api/languages" \
  -H "Content-Type: application/json" \
  -d "{\"languageCode\":\"es\",\"name\":\"Espanol\"}"
```

### 7.2 Crear usuario

```bash
curl -X POST "http://localhost:8080/api/users" \
  -H "Content-Type: application/json" \
  -d "{\"role\":\"TOURIST\",\"fullName\":\"Ana Perez\",\"dateOfBirth\":\"1998-04-17\",\"email\":\"ana@example.com\",\"passwordHash\":\"hash_demo\",\"countryCode\":\"MX\",\"phoneNumber\":\"5512345678\",\"phoneE164\":\"+525512345678\",\"preferredLanguageCode\":\"es\",\"accountStatus\":\"ACTIVE\"}"
```

### 7.3 Obtener todos los usuarios

```bash
curl -X GET "http://localhost:8080/api/users"
```

### 7.4 Crear categoria FAQ

```bash
curl -X POST "http://localhost:8080/api/faq_categories" \
  -H "Content-Type: application/json" \
  -d "{\"name\":\"Pagos\",\"roleScope\":\"BOTH\",\"sortOrder\":1}"
```

### 7.5 Crear item FAQ

```bash
curl -X POST "http://localhost:8080/api/faq_items" \
  -H "Content-Type: application/json" \
  -d "{\"faqCategoryId\":1,\"question\":\"Como pago un tour?\",\"answer\":\"Puedes pagar con tarjeta.\",\"isActive\":true,\"sortOrder\":1}"
```

### 7.6 Obtener FAQ por id

```bash
curl -X GET "http://localhost:8080/api/faq_items/1"
```

### 7.7 Actualizar FAQ por id

```bash
curl -X PUT "http://localhost:8080/api/faq_items/1" \
  -H "Content-Type: application/json" \
  -d "{\"faqCategoryId\":1,\"question\":\"Como pago un tour?\",\"answer\":\"Tarjeta, transferencia o efectivo.\",\"isActive\":true,\"sortOrder\":1}"
```

### 7.8 Eliminar FAQ por id

```bash
curl -X DELETE "http://localhost:8080/api/faq_items/1"
```

### 7.9 Ejemplo con llave compuesta

```bash
curl -X GET "http://localhost:8080/api/tourist_profile_languages/1/es"
```

## 8. Solucion de problemas comunes

- Error `Unknown database`:
1. Revisa que el schema en MySQL exista.
2. Revisa que coincida el nombre en `spring.datasource.url`.

- Error de credenciales MySQL:
1. Verifica `spring.datasource.username` y `spring.datasource.password`.
2. Intenta conectarte primero en Workbench con esos mismos datos.

- Error de puerto ocupado:
1. Cierra el proceso que use `8080`, o
2. Configura `server.port` en `application.properties`.
