# 🎓 SIGED - Sistema Integrado de Gestión Educativa Digital

---

## 📌 **Elevator Pitch**

**SIGED** es un **Sistema Integrado de Gestión Educativa Digital** diseñado para modernizar la administración académica de instituciones educativas. Permite a docentes registrar y consultar notas, crear anotaciones en la hoja de vida de estudiantes, y facilita la comunicación bidireccional mediante un sistema de mensajería. Construido con tecnología **Enterprise-Grade** (Spring Boot 4.1.0, Java 24), SIGED es **escalable, seguro y listo para producción** en ambientes containerizados.

---

## 🛠️ **Stack Tecnológico**

| Componente | Versión/Tecnología | Propósito |
|-----------|-------------------|----------|
| **Lenguaje** | Java 24 | Backend moderno y performante |
| **Framework** | Spring Boot 4.1.0 | Desarrollo REST ágil |
| **ORM** | Spring Data JPA | Persistencia de datos |
| **Base de Datos** | MySQL 8.0 | Almacenamiento relacional |
| **Build Tool** | Maven 3.9+ | Gestión de dependencias |
| **Containerización** | Docker | Despliegue portátil |
| **Arquitectura** | Monolítica | Modelo escalable y mantenible |
| **Metodología** | SCRUM (Ágil) | Desarrollo iterativo |

---

## 🏃 **Metodología**

Trabajamos bajo **SCRUM** con:
- ✅ **Sprints de 2 semanas** para desarrollo incremental
- ✅ **Daily standups** para sincronización del equipo
- ✅ **Definition of Done**: Código testeado, documentado y en producción
- ✅ **Retrospectivas** para mejora continua

---

## 🏗️ **Diagrama de Despliegue**

```
┌────────────────────────────────────────────────────────────────┐
│                         HOST (Windows)                         │
│                                                                 │
│  ┌──────────────────────────┐      ┌─────────────────────┐    │
│  │  🐳 Docker Container     │      │  📊 Laragon MySQL   │    │
│  │  ┌────────────────────┐  │      │  ┌───────────────┐  │    │
│  │  │ Spring Boot 8080   │  │◄────►│  │ siged_db:3306 │  │    │
│  │  │ (libroClases.jar)  │  │      │  │ (root/sin pwd)│  │    │
│  │  │                    │  │      │  └───────────────┘  │    │
│  │  │ host.docker.       │  │      │                     │    │
│  │  │ internal:3306      │  │      └─────────────────────┘    │
│  │  └────────────────────┘  │                                  │
│  └──────────────────────────┘                                  │
│         │                                                      │
│         └──► REST API: http://localhost:8080/api/*             │
└────────────────────────────────────────────────────────────────┘
```

**Flujo de conexión:**
1. Aplicación corre **dentro de Docker** en puerto `8080`
2. Se conecta a MySQL **en el host** usando `host.docker.internal:3306`
3. Crea automáticamente la BD `siged_db` y tablas al iniciar

---

## 🎬 **Guion de Demostración (10 minutos)**

### **Paso 1️⃣ - Login Exitoso**
**Endpoint:** `POST /api/usuarios/login`

**Request:**
```json
{
  "correo": "docente@siged.edu",
  "password": "123456"
}
```

**Response (200 OK):**
```json
{
  "id": 1,
  "correo": "docente@siged.edu",
  "password": "123456",
  "rol": "DOCENTE"
}
```

✅ **Demostración:** Acceder como docente autenticado.

---

### **Paso 2️⃣ - Registro de una Nota**
**Endpoint:** `POST /api/notas`

**Request:**
```json
{
  "idEstudiante": 5,
  "idDocente": 1,
  "valorNota": 4.5,
  "idAsignatura": 3
}
```

**Response (201 Created):**
```json
{
  "id": 42,
  "idEstudiante": 5,
  "idDocente": 1,
  "valorNota": 4.5,
  "idAsignatura": 3
}
```

✅ **Demostración:** La nota se registra inmediatamente en la BD.

---

### **Paso 3️⃣ - Consulta de Hoja de Vida (Anotaciones)**
**Endpoint:** `GET /api/anotaciones/estudiante/5`

**Response (200 OK):**
```json
[
  {
    "id": 1,
    "idEstudiante": 5,
    "idDocente": 1,
    "tipo": "DISCIPLINARIA",
    "descripcion": "Excelente comportamiento en clase",
    "fecha": "2026-06-26T10:30:00"
  },
  {
    "id": 2,
    "idEstudiante": 5,
    "idDocente": 1,
    "tipo": "ACADEMICA",
    "descripcion": "Participa activamente en debates",
    "fecha": "2026-06-26T14:15:00"
  }
]
```

✅ **Demostración:** La hoja de vida es accesible y completa.

---

### **Paso 4️⃣ - Envío de Mensaje**
**Endpoint:** `POST /api/mensajes`

**Request:**
```json
{
  "idRemitente": 1,
  "idDestinatario": 5,
  "contenido": "¡Excelente desempeño en el examen, Juan!",
  "fecha": "2026-06-26T15:45:00"
}
```

**Response (201 Created):**
```json
{
  "id": 15,
  "idRemitente": 1,
  "idDestinatario": 5,
  "contenido": "¡Excelente desempeño en el examen, Juan!",
  "fecha": "2026-06-26T15:45:00"
}
```

✅ **Demostración:** Comunicación docente-estudiante funcional.

---

## 🚀 **Conclusiones y Futuras Mejoras**

### ✅ **Logros del MVP**
- ✔️ Arquitectura monolítica escalable y limpia
- ✔️ CRUD completo para 4 entidades clave
- ✔️ REST API con manejo de errores HTTP
- ✔️ Integración MySQL con Hibernate/JPA
- ✔️ Containerización Docker lista
- ✔️ CORS habilitado para futuro Front-End

### 🔮 **Futuras Mejoras**
- 🔐 **JWT Authentication** para seguridad avanzada
- 🛡️ **OAuth 2.0** para integración con proveedores
- 📊 **Auditoría y Logging** con ELK Stack
- ⚡ **Caché Redis** para optimizar consultas
- 🧪 **Test Coverage** 80%+ con JUnit 5 + Mockito
- 📱 **API Versionado** (v1, v2, v3...)
- 🔔 **WebSockets** para notificaciones en tiempo real
- 📈 **Métricas y Monitoring** con Prometheus/Grafana

---

## 📦 **Cómo Ejecutar**

### **Local (sin Docker):**
```bash
# 1. Asegurate que MySQL esté corriendo en Laragon
# 2. Actualiza application.properties si es necesario
# 3. Compila y ejecuta
mvn clean spring-boot:run
```

### **Con Docker:**
```bash
# 1. Compila el JAR
mvn clean package

# 2. Construye la imagen
docker build -t siged:latest .

# 3. Ejecuta el contenedor
docker run -p 8080:8080 siged:latest
```

---

## 📞 **Contacto y Soporte**

**Equipo de Desarrollo:** Proyecto Ingeniería de Software 2026  
**Última Actualización:** 26 de Junio, 2026  
**Licencia:** MIT

---

**🎯 SIGED está listo para producción. ¡Vamos al futuro de la educación digital!**
 
