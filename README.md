# <img src="https://media0.giphy.com/media/v1.Y2lkPTc5MGI3NjExbG1nNTRmYTNyazIzanJuMG54bHZsanExY2E0anZ1YnhxZHJ3aTNuaSZlcD12MV9pbnRlcm5hbF9naWZfYnlfaWQmY3Q9Zw/jivGITd768psP80B2i/giphy.gif" alt="Descripción" alt="Descripción" style="width: 150px; margin-right: 10px;"> 🐾 VetConnect 
VetConnect es una aplicación web fullstack desarrollada para conectar a veterinarios con dueños de mascotas, permitiendo agendar citas, registrar fichas clínicas y gestionar la relación médico-mascota de manera eficiente y moderna.

## 🚀 Características principales

- 🐶 Registro y gestión de mascotas
- 🧑‍⚕️ Registro de veterinarios y clientes
- 📅 Gestión de citas médicas
- 📄 Historial clínico digital
- 🔐 Autenticación y autorización por roles (en desarrollo)
- 📊 Panel de control para veterinarios y usuarios
- 📡 API RESTful desarrollada con Spring Boot

---

## 🧰 Tecnologías utilizadas

### 🔙 Backend
- **Java 17**
- **Spring Boot** (creado con [Spring Initializr](https://start.spring.io/))
  - Spring Web
  - Spring Data JPA
  - MySQL Driver
  - Lombok
- **Base de datos:** MySQL 8 (usando [Laragon 6.0.0](https://laragon.org/))
- **Testing de endpoints:** [Postman](https://www.postman.com/)

### 🔝 Frontend
- **React.js**
- **Tailwind CSS**
- **React Router**
- **Vite** (para desarrollo rápido)

---

## ⚙️ Requisitos previos

- Java 17+
- Node.js y npm
- MySQL (con Laragon o instalación manual)
- IDE como Visual Studio Code con extensiones para:
  - Java Extension Pack
  - Spring Boot Extension Pack
  - Lombok

---

## 📦 Instalación del backend

1. Clona el repositorio:
   ```bash
   git clone https://github.com/SangsterPrime/VetConnect.git
   cd VetConnect/backend
   ```

---
   
## 🪤Configura el archivo application.properties:
```java
spring.datasource.url=jdbc:mysql://localhost:3306/vetconnect
spring.datasource.username=root
spring.datasource.password=
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect
```
---
## 🐘Crea la base de datos desde Laragon o con MySQL CLI:
```sql
CREATE DATABASE vetconnect;
```
---

## 💻Corre la aplicación desde tu IDE o terminal:
```bash
./mvnw spring-boot:run
```
---

🧪 Testeo de la API con Postman
Importa la colección de endpoints en Postman desde: docs/VetConnect.postman_collection.json (si la tienes).

Prueba rutas como:

- GET /api/mascotas

- POST /api/usuarios

- PUT /api/citas/{id}

- DELETE /api/historias/{id}

---

## 📁 Estructura del backend:
```css
C:.
¦   definitivisimo.zip
¦   estructura.txt
¦   LICENSE
¦   
+---.qodo
+---VetConnect-vm
    ¦   .gitattributes
    ¦   .gitignore
    ¦   HELP.md
    ¦   mvnw
    ¦   mvnw.cmd
    ¦   pom.xml
    ¦   
    +---.mvn
    ¦   +---wrapper
    ¦           maven-wrapper.properties
    ¦           
    +---.qodo
    +---.vscode
    ¦       settings.json
    ¦       
    +---src
    ¦   +---main
    ¦   ¦   +---java
    ¦   ¦   ¦   +---com
    ¦   ¦   ¦       +---VetConnect_vm
    ¦   ¦   ¦           +---cl
    ¦   ¦   ¦               +---VetConnect_vm
    ¦   ¦   ¦                   ¦   VetConnectVmApplication.java
    ¦   ¦   ¦                   ¦   
    ¦   ¦   ¦                   +---controller
    ¦   ¦   ¦                   ¦       CitaController.java
    ¦   ¦   ¦                   ¦       HistorialController.java
    ¦   ¦   ¦                   ¦       MascotaController.java
    ¦   ¦   ¦                   ¦       UsuarioController.java
    ¦   ¦   ¦                   ¦       VeterinarioController.java
    ¦   ¦   ¦                   ¦       
    ¦   ¦   ¦                   +---model
    ¦   ¦   ¦                   ¦       Cita.java
    ¦   ¦   ¦                   ¦       Historial.java
    ¦   ¦   ¦                   ¦       Mascota.java
    ¦   ¦   ¦                   ¦       Usuario.java
    ¦   ¦   ¦                   ¦       Veterinario.java
    ¦   ¦   ¦                   ¦       
    ¦   ¦   ¦                   +---repository
    ¦   ¦   ¦                   ¦       CitaRepository.java
    ¦   ¦   ¦                   ¦       HistorialRepository.java
    ¦   ¦   ¦                   ¦       MascotaRepository.java
    ¦   ¦   ¦                   ¦       UsuarioRepository.java
    ¦   ¦   ¦                   ¦       VeterinarioRepository.java
    ¦   ¦   ¦                   ¦       
    ¦   ¦   ¦                   +---service
    ¦   ¦   ¦                           CitaService.java
    ¦   ¦   ¦                           HistorialService.java
    ¦   ¦   ¦                           MascotaService.java
    ¦   ¦   ¦                           UsuarioService.java
    ¦   ¦   ¦                           VeterinarioService.java
    ¦   ¦   ¦                           
    ¦   ¦   +---resources
    ¦   ¦       ¦   application.properties
    ¦   ¦       ¦   
    ¦   ¦       +---static
    ¦   ¦       +---templates
    ¦   +---test
    ¦       +---java
    ¦           +---com
    ¦               +---VetConnect_vm
    ¦                   +---cl
    ¦                       +---VetConnect_vm
    ¦                               VetConnectVmApplicationTests.java
    ¦                               
    +---target
        ¦   VetConnect-vm-0.0.1-SNAPSHOT.jar
        ¦   VetConnect-vm-0.0.1-SNAPSHOT.jar.original
        ¦   
        +---classes
        ¦   ¦   application.properties
        ¦   ¦   
        ¦   +---com
        ¦       +---VetConnect_vm
        ¦           +---cl
        ¦               +---VetConnect_vm
        ¦                   ¦   VetConnectVmApplication.class
        ¦                   ¦   
        ¦                   +---controller
        ¦                   ¦       CitaController.class
        ¦                   ¦       HistorialController.class
        ¦                   ¦       MascotaController.class
        ¦                   ¦       UsuarioController.class
        ¦                   ¦       VeterinarioController.class
        ¦                   ¦       
        ¦                   +---model
        ¦                   ¦       Cita.class
        ¦                   ¦       Historial.class
        ¦                   ¦       Mascota.class
        ¦                   ¦       Usuario.class
        ¦                   ¦       Veterinario.class
        ¦                   ¦       
        ¦                   +---repository
        ¦                   ¦       CitaRepository.class
        ¦                   ¦       HistorialRepository.class
        ¦                   ¦       MascotaRepository.class
        ¦                   ¦       UsuarioRepository.class
        ¦                   ¦       VeterinarioRepository.class
        ¦                   ¦       
        ¦                   +---service
        ¦                           CitaService.class
        ¦                           HistorialService.class
        ¦                           MascotaService.class
        ¦                           UsuarioService.class
        ¦                           VeterinarioService.class
        ¦                           
        +---generated-sources
        ¦   +---annotations
        +---generated-test-sources
        ¦   +---test-annotations
        +---maven-archiver
        ¦       pom.properties
        ¦       
        +---maven-status
        ¦   +---maven-compiler-plugin
        ¦       +---compile
        ¦       ¦   +---default-compile
        ¦       ¦           createdFiles.lst
        ¦       ¦           inputFiles.lst
        ¦       ¦           
        ¦       +---testCompile
        ¦           +---default-testCompile
        ¦                   createdFiles.lst
        ¦                   inputFiles.lst
        ¦                   
        +---test-classes
            +---com
                +---VetConnect_vm
                    +---cl
                        +---VetConnect_vm
                                VetConnectVmApplicationTests.class
                                
```

---

✨ Contribuciones
¿Tienes ideas o mejoras? ¡Eres bienvenido a contribuir! Puedes:

- Hacer un fork

- Crear una rama (git checkout -b feature/nueva-funcionalidad)

- Hacer un commit (git commit -m 'Agrega nueva funcionalidad')

- Hacer push a la rama (git push origin feature/nueva-funcionalidad)

- Abrir un pull request

---

👨‍💻 Desarrollador
Joel Sangster
📎 [GitHub](https://github.com/SangsterPrime)

---

📜 Licencia
Este proyecto está licenciado bajo la MIT License.
