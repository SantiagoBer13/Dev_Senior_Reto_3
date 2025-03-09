# Proyecto Sistema de Gestión de Biblioteca con Pruebas Unitarias en Java

Este proyecto implementa un servicio de biblioteca (`LibraryService`) que maneja libros, usuarios y préstamos. El servicio interactúa con repositorios para almacenar y recuperar libros, usuarios y préstamos, y contiene varias funcionalidades como agregar libros, crear préstamos y obtener préstamos de un usuario.

## Estructura del Proyecto

El proyecto tiene una estructura que sigue el patrón de repositorios, servicios y pruebas unitarias. Aquí está el desglose de los componentes principales:

- **`LibraryService`**: Clase que gestiona la lógica del servicio de biblioteca.
- **`Book`, `User`, `Loan`**: Clases modelo que representan un libro, un usuario y un préstamo.
- **`IBookRepository`, `IUserRepository`, `ILoanRepository`**: Interfaces que definen los métodos para interactuar con los repositorios de datos.
- **Pruebas Unitarias**: Pruebas que aseguran el funcionamiento adecuado del servicio.

## Funcionalidades

### 1. **Agregar un libro**
La función `addBook` permite agregar un nuevo libro a la biblioteca.

### 2. Consultar un Libro: 
Se obtiene información detallada de un libro a partir de su ID.
2.

### 3. Registrar un Usuario: 
Se añade un nuevo usuario al sistema con su información.

### 4. Realizar un Préstamo: 
Un usuario solicita un libro, registrándose la fecha de préstamo.

### 5. Consultar Préstamos por Usuario: 
Se obtiene el historial de préstamos realizados por un usuario

## Pruebas Unitarias

### 1. **`addBook` (Agregar un libro)**
- **Objetivo**: Verificar que un libro se agrega correctamente al repositorio.
- **Pruebas**:
  - Caso válido: Guarda un libro con título y autor válidos.
  - Caso inválido: Lanza `IllegalArgumentException` si el título o el autor están vacíos.

### 2. **`getBookById` (Obtener un libro por ID)**
- **Objetivo**: Verificar que se obtiene el libro correcto por su `idBook`.
- **Prueba**: Retorna el libro esperado cuando se pasa un `idBook` válido.

### 3. **`addUser` (Agregar un usuario)**
- **Objetivo**: Verificar que un usuario se agrega correctamente al repositorio.
- **Pruebas**:
  - Caso válido: Guarda un usuario con un nombre válido.
  - Caso inválido: Lanza `IllegalArgumentException` si el nombre está vacío.

### 4. **`createLoan` (Crear un préstamo)**
- **Objetivo**: Verificar que un préstamo se guarda correctamente.
- **Pruebas**:
  - Caso válido: Guarda un préstamo con un usuario y un libro válidos.
  - Caso inválido: Lanza `IllegalArgumentException` si el usuario o el libro son `null`.

### 5. **`getLoansByUserId` (Obtener préstamos por ID de usuario)**
- **Objetivo**: Verificar que se obtienen correctamente los préstamos de un usuario.
- **Prueba**: Retorna una lista de préstamos asociados a un `idUser` válido.