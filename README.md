# 📦 Clinica Dental

Proyecto universitario con el lenguaje Java orientado en la Web, se usan tecnologias de mapeo como JPA y el uso de JSP para controlar las vistas.

---

## 🚀 Tecnologías utilizadas

- Java 17
- Maven
- HTML5, CSS3, JavaScript
- MySQL / PostgreSQL (Maria DB)
- Lombok

---

## 📁 Estructura del proyecto

```bash
.
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── org/dentalclinic/
│   │   │       ├── logic/
│   │   │       ├── servlets/
│   │   │       └── persistence/
│   │   └── resources/
│   │   │       ├── META-INF/
│   │   └── webapp/
├── pom.xml
└── README.md
```

---

## ⚙️ Instalación y ejecución

### ✅ Requisitos previos

- Java JDK 17 o superior
- Maven instalado
- MySQL

### 🧩 Pasos para ejecutar localmente

1. Clona el repositorio:

```bash
git clone https://github.com/<tu-usuario>/<tu-repo>.git
cd <tu-repo>
```

2. Configura la base de datos en `src/main/resources/application.properties`:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/<nombre_bd>
spring.datasource.username=<usuario>
spring.datasource.password=<contraseña>
spring.jpa.hibernate.ddl-auto=update
```

3. Ejecuta la aplicación:

```bash
mvn spring-boot:run
```

4. Accede a la aplicación en tu navegador:

```
http://localhost:8080
```

---

## ✅ Funcionalidades principales

- Registro e inicio de sesión de usuarios
- Gestión de entidades (CRUD)
- Validaciones de formularios
- Conexión a base de datos
- Diseño con plantillas HTML + CSS
- Separación por capas (controlador, servicio, repositorio)

---

## 📌 Pendientes / To-do

- [ ] Agregar roles y permisos de usuario
- [ ] Mejorar diseño responsive
- [ ] Documentar API REST
- [ ] Utilizar frameworks modernos
---
