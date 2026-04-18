# Actividad: DAO a ficheros - Travelbooker (RA5.c,d,e)

**ID actividad:** 7.3

**Agrupamiento de la actividad**: Individual

---

### **Descripción:**

La actividad consiste en sustituir el actual sistema de almacenamiento en memoria del proyecto Travelbooker por una solución basada en ficheros utilizando el patrón DAO (Data Access Object), implementado los CRUD.

Cada alumno deberá reimplementar los Repository correspondientes a las entidades del sistema: ¿?, conectando la lógica de aplicación con el sistema de archivos.

#### **Objetivo**

- Aplicar el patrón DAO para almacenar la información en archivos desde Kotlin.
- Reforzar el trabajo colaborativo con control de versiones y ramas.
- Manejar archivos: Lectura y escritura.

# Preguntas para la Evaluación

#### **[CE 7.c] ¿Que librería/clases has utilizado para realizar la práctica.? Comenta los métodos mas interesantes**

La clase principal que he utilizado es java.io.File, que me ha servido para manipular archivos, un ejemplo puede ser crear una carpeta con dos archivos para el guardado de los datos de hoteles y vuelos

Metodos mas interesantes:
- file.appendText(linea) -> Añade texto al final del fichero sin borrar el contenido. Lo he utilizado para añadir nuevas reservas
- file.writeText("") -> Sobreescribe completamente el fichero.
- file.readLines() -> Lee todas las líneas del fichero.

### **[CE 7.d] 2.a ¿Que formato le has dado a la información del fichero para guardar y recuperar la información?**

He utilizado un formato .txt y dentro de los archivos he utilizado un ; como separador.

### **2.b ¿Que estrategia has usado para trabajar con los ficheros? (Carpeta en donde se guardan los ficheros, cuando crear los archivos, ....)**

La carpeta que he creado es Guardado y dentro de este están hoteles.txt y vuelos.txt.

Los archivos se crean si no existen gracias al init el cual comprueba si el archivo existe y en caso de que no exista crea la carpeta y los archivos.

### **2.c ¿Cómo se gestionan los errores? Pon ejemplos de código (enlace permanente al código en GitHub).**

Los errores se gestionan con try catch donde si hay error se rompe la línea y sigue la ejecución.

Permalinks:
- https://github.com/IES-Rafael-Alberti/2526-u7-7-3-travelbookerdao-ftellol/blob/5fa807a56be2136a5651e9a984492ca2826f645f/src/main/kotlin/es/iesra/datos/ReservaHotelDao.kt#L27-L36
- https://github.com/IES-Rafael-Alberti/2526-u7-7-3-travelbookerdao-ftellol/blob/5fa807a56be2136a5651e9a984492ca2826f645f/src/main/kotlin/es/iesra/datos/ReservaVueloDao.kt#L27-L37

### **[CE 7.e] 3.a Describe la forma de acceso para leer información**

Se hace mediante el comando file.readLines(), el cual primero leera las líneas, las separara con split y por último se transforman en objetos.

### **3.b Describe la forma de acceso para escribir información**

Se escribe con file.appendText(línea) que añade las nuevas líneas al final del fichero.

### **3.c Describe la forma de acceso para actualizar información. Pon ejemplos de código (enlace permanente al código en GitHub).**

La forma de actualizar la información es una reescritura completa del fichero. Se leen todas las reservas que hay, se modifican y se sobreescriben en el mismo archivo

Permalinks:
