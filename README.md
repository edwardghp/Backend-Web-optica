## Backend Web Optica

Este documento proporciona instrucciones paso a paso sobre cómo probar la API de la óptica utilizando IntelliJ IDEA y Postman.

### Requisitos previos

- **IntelliJ IDEA** instalado
- **Postman** instalado
- MySQL
- API en funcionamiento en `http://localhost:8080`

---

## Instrucciones para probar la API

### 1. Generar un Token de Autenticación

1. Abre **Postman**.
2. Crea una nueva petición **POST**:
   - **URL**: `http://localhost:8080/generate-token`
   - **Body**: Selecciona `raw` y `JSON` e introduce el siguiente contenido:

     ```json
     {
         "username": "edward@gmail.com",
         "password": "12345"
     }
     ```
3. Haz clic en **Send**.  
4. Obtendrás un token similar a:

    ```json
    {
        "token": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9..."
    }
    ```

---

### 2. Obtener Datos del Empleado Actual

1. Configura una nueva petición **GET**:
   - **URL**: `http://localhost:8080/actual-usuario`
   - **Authorization**: Selecciona `Bearer Token` y pega el token obtenido anteriormente.

2. Respuesta esperada (ejemplo de un empleado):

    ```json
    {
        "id": 1,
        "username": "edward@gmail.com",
        "password": "...",
        "nombres": "Edward",
        "apellidos": "Ortega",
        "telefono": "987654321",
        "enabled": true,
        "perfil": "foto.png",
        "credentialsNonExpired": true,
        "accountNonExpired": true,
        "authorities": [
            {
                "authority": "ADMINISTRADOR"
            }
        ],
        "accountNonLocked": true
    }
    ```

---

### 3. Obtener Información de un Empleado por Username

1. Nueva petición **GET**:
   - **URL**: `http://localhost:8080/usuarios/{username}`
   - Ejemplo: `http://localhost:8080/usuarios/edward@gmail.com`
   - **Authorization**: `Bearer Token`

2. Respuesta:

    ```json
    {
        "id": 1,
        "username": "edward@gmail.com",
        "nombres": "Edward",
        "apellidos": "Ortega",
        "telefono": "987654321",
        "enabled": true,
        "perfil": "foto.png",
        ...
    }
    ```

---

## Endpoints disponibles

### ClienteController (`/clientes`)

- **POST `/clientes/`**: Crear un nuevo cliente.
- **POST `/clientes/guardar-cita/{clienteId}`**: Guardar una cita asociada a un cliente.
- **GET `/clientes/es-cliente/{username}`**: Verificar si un usuario es cliente.

### EmpleadoController (`/usuarios`)

- **POST `/usuarios/{nombreRol}`**: Crear un nuevo empleado con rol.
- **GET `/usuarios/{username}`**: Obtener datos de un empleado por su `username`.
- **DELETE `/usuarios/{empleadoId}`**: Eliminar empleado por ID.
- **GET `/usuarios/get-employees`**: Obtener todos los empleados excepto el administrador.
- **GET `/usuarios/lista-solicitudes`**: Obtener solicitudes de citas.
- **GET `/usuarios/check-email?username={email}`**: Verificar disponibilidad de email.
- **GET `/usuarios/solicitud/{idSolicitud}`**: Obtener detalles de una cita específica.
- **GET `/usuarios/get/{idCliente}`**: Obtener información de un cliente por ID.
- **GET `/usuarios/doctores`**: Listar todos los empleados con rol de doctor.
- **PUT `/usuarios/asignar-cita/{idCita}?idEmployee={idEmployee}`**: Asignar una cita a un doctor.
- **GET `/usuarios/citas-asignadas`**: Ver todas las citas asignadas a doctores.

---

## Notas importantes

- **Autenticación**: La mayoría de los endpoints protegidos requieren autenticación mediante token JWT (`Bearer Token`).
- **Password Encoding**: Las contraseñas son encriptadas usando `BCryptPasswordEncoder`.
- **Roles**: El sistema maneja roles como `ADMINISTRADOR`, `DOCTOR`, entre otros.
- **Errores comunes**:
  - `401 Unauthorized`: Token inválido o no enviado.
  - `404 Not Found`: Usuario, cliente o cita no encontrados.


