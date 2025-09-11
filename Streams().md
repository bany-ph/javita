# Java Streams 

## ¿Qué son los Streams?

Los **Streams** en Java (introducidos en Java 8) son una abstracción que permite procesar colecciones de datos de forma funcional, declarativa y eficiente. No modifican la fuente original y permiten operaciones en cadena (chaining).

### Características Principales

- **Funcional**: Basado en programación funcional
- **Declarativo**: Describes QUÉ quieres, no CÓMO hacerlo
- **Lazy**: Las operaciones intermedias no se ejecutan hasta una operación terminal
- **Inmutable**: No modifican la colección original
- **Parallelizable**: Soporte nativo para procesamiento paralelo

---

## Creación de Streams

```java
// Desde colecciones
List<String> lista = Arrays.asList("A", "B", "C");
Stream<String> stream1 = lista.stream();

// Desde arrays
String[] array = {"X", "Y", "Z"};
Stream<String> stream2 = Arrays.stream(array);

// Streams vacíos
Stream<String> stream3 = Stream.empty();

// Streams con elementos específicos
Stream<String> stream4 = Stream.of("uno", "dos", "tres");

// Streams infinitos
Stream<Integer> infinitos = Stream.generate(() -> 1);
Stream<Integer> secuencial = Stream.iterate(0, n -> n + 1);
```

---

## Operaciones Intermedias (Lazy)

### 🔍 **filter()** - Filtrar elementos
**Propósito**: Selecciona elementos que cumplen una condición

```java
List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

// Filtrar números pares
List<Integer> pares = numeros.stream()
    .filter(n -> n % 2 == 0)
    .collect(Collectors.toList());
// Resultado: [2, 4, 6, 8, 10]

// Filtrar strings que empiecen con 'A'
List<String> nombres = Arrays.asList("Ana", "Bruno", "Antonio", "Carlos");
List<String> conA = nombres.stream()
    .filter(nombre -> nombre.startsWith("A"))
    .collect(Collectors.toList());
// Resultado: ["Ana", "Antonio"]
```

### 🔄 **map()** - Transformar elementos
**Propósito**: Aplica una función a cada elemento, transformándolo

```java
List<String> palabras = Arrays.asList("hola", "mundo", "java");

// Convertir a mayúsculas
List<String> mayusculas = palabras.stream()
    .map(String::toUpperCase)
    .collect(Collectors.toList());
// Resultado: ["HOLA", "MUNDO", "JAVA"]

// Obtener longitudes
List<Integer> longitudes = palabras.stream()
    .map(String::length)
    .collect(Collectors.toList());
// Resultado: [4, 5, 4]

// Transformar objetos
List<Persona> personas = Arrays.asList(
    new Persona("Juan", 25),
    new Persona("Ana", 30)
);

List<String> nombresEdades = personas.stream()
    .map(p -> p.getNombre() + " (" + p.getEdad() + ")")
    .collect(Collectors.toList());
// Resultado: ["Juan (25)", "Ana (30)"]
```

### 🎭 **flatMap()** - Aplanar streams anidados
**Propósito**: Convierte cada elemento en un stream y los aplana en uno solo

```java
List<List<String>> listaDeListas = Arrays.asList(
    Arrays.asList("a", "b"),
    Arrays.asList("c", "d", "e"),
    Arrays.asList("f")
);

List<String> aplanado = listaDeListas.stream()
    .flatMap(List::stream)
    .collect(Collectors.toList());
// Resultado: ["a", "b", "c", "d", "e", "f"]

// Ejemplo con strings
List<String> frases = Arrays.asList("Hola mundo", "Java streams");
List<String> palabras = frases.stream()
    .flatMap(frase -> Arrays.stream(frase.split(" ")))
    .collect(Collectors.toList());
// Resultado: ["Hola", "mundo", "Java", "streams"]
```

### 🎯 **distinct()** - Eliminar duplicados
**Propósito**: Elimina elementos duplicados

```java
List<Integer> conDuplicados = Arrays.asList(1, 2, 2, 3, 3, 3, 4);
List<Integer> sinDuplicados = conDuplicados.stream()
    .distinct()
    .collect(Collectors.toList());
// Resultado: [1, 2, 3, 4]
```

### 📏 **limit()** y **skip()** - Controlar cantidad
**Propósito**: Limitar o saltar elementos

```java
List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

// Tomar solo los primeros 5
List<Integer> primeros5 = numeros.stream()
    .limit(5)
    .collect(Collectors.toList());
// Resultado: [1, 2, 3, 4, 5]

// Saltar los primeros 3 y tomar los siguientes 3
List<Integer> medios = numeros.stream()
    .skip(3)
    .limit(3)
    .collect(Collectors.toList());
// Resultado: [4, 5, 6]
```

### 🔤 **sorted()** - Ordenar elementos
**Propósito**: Ordena los elementos

```java
List<String> nombres = Arrays.asList("Carlos", "Ana", "Bruno");

// Orden natural
List<String> ordenados = nombres.stream()
    .sorted()
    .collect(Collectors.toList());
// Resultado: ["Ana", "Bruno", "Carlos"]

// Orden personalizado
List<String> porLongitud = nombres.stream()
    .sorted(Comparator.comparing(String::length))
    .collect(Collectors.toList());
// Resultado: ["Ana", "Bruno", "Carlos"]

// Orden inverso
List<String> inverso = nombres.stream()
    .sorted(Comparator.reverseOrder())
    .collect(Collectors.toList());
// Resultado: ["Carlos", "Bruno", "Ana"]
```

### 👁️ **peek()** - Debug y efectos secundarios
**Propósito**: Permite "espiar" el stream sin modificarlo (útil para debugging)

```java
List<String> resultado = Arrays.asList("a", "b", "c").stream()
    .peek(s -> System.out.println("Original: " + s))
    .map(String::toUpperCase)
    .peek(s -> System.out.println("Mayúscula: " + s))
    .collect(Collectors.toList());
```

---

## Operaciones Terminales (Eager)

### 📦 **collect()** - Recolectar resultados
**Propósito**: Convierte el stream en otra estructura de datos

```java
List<String> nombres = Arrays.asList("Ana", "Bruno", "Carlos");

// A Lista
List<String> lista = nombres.stream().collect(Collectors.toList());

// A Set
Set<String> set = nombres.stream().collect(Collectors.toSet());

// A String con separador
String concatenado = nombres.stream()
    .collect(Collectors.joining(", "));
// Resultado: "Ana, Bruno, Carlos"

// Agrupando por longitud
Map<Integer, List<String>> porLongitud = nombres.stream()
    .collect(Collectors.groupingBy(String::length));
// Resultado: {3=[Ana], 5=[Bruno], 6=[Carlos]}

// Particionando (dividiendo en dos grupos)
Map<Boolean, List<String>> particion = nombres.stream()
    .collect(Collectors.partitioningBy(s -> s.length() > 4));
// Resultado: {false=[Ana], true=[Bruno, Carlos]}
```

### 🔍 **find** - Buscar elementos
**Propósito**: Encontrar elementos específicos

```java
List<String> nombres = Arrays.asList("Ana", "Bruno", "Carlos");

// Encontrar cualquiera que empiece con 'B'
Optional<String> conB = nombres.stream()
    .filter(s -> s.startsWith("B"))
    .findAny();

// Encontrar el primero que empiece con 'C'
Optional<String> primeroConC = nombres.stream()
    .filter(s -> s.startsWith("C"))
    .findFirst();

// Uso seguro del Optional
conB.ifPresent(System.out::println);
String resultado = conB.orElse("No encontrado");
```

### ✅ **match** - Verificar condiciones
**Propósito**: Verificar si elementos cumplen condiciones

```java
List<Integer> numeros = Arrays.asList(2, 4, 6, 8);

// ¿Todos son pares?
boolean todosPares = numeros.stream()
    .allMatch(n -> n % 2 == 0);  // true

// ¿Alguno es mayor a 5?
boolean algunoMayor5 = numeros.stream()
    .anyMatch(n -> n > 5);  // true

// ¿Ninguno es impar?
boolean ningunoImpar = numeros.stream()
    .noneMatch(n -> n % 2 == 1);  // true
```

### 🔢 **count()** - Contar elementos
**Propósito**: Cuenta los elementos del stream

```java
List<String> palabras = Arrays.asList("Java", "Python", "JavaScript", "C++");

long cantidadConJ = palabras.stream()
    .filter(s -> s.startsWith("J"))
    .count();  // 2

long totalPalabras = palabras.stream().count();  // 4
```

### 📊 **reduce()** - Operaciones de reducción
**Propósito**: Combina todos los elementos en un solo resultado

```java
List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5);

// Suma
int suma = numeros.stream()
    .reduce(0, Integer::sum);  // 15

// Producto
int producto = numeros.stream()
    .reduce(1, (a, b) -> a * b);  // 120

// Máximo
Optional<Integer> maximo = numeros.stream()
    .reduce(Integer::max);

// Concatenar strings
List<String> palabras = Arrays.asList("Hola", " ", "mundo");
String frase = palabras.stream()
    .reduce("", String::concat);  // "Hola mundo"
```

### 🔄 **forEach()** - Iterar elementos
**Propósito**: Ejecuta una acción sobre cada elemento

```java
List<String> nombres = Arrays.asList("Ana", "Bruno", "Carlos");

// Imprimir cada nombre
nombres.stream().forEach(System.out::println);

// Con operaciones previas
nombres.stream()
    .filter(s -> s.length() > 4)
    .map(String::toUpperCase)
    .forEach(System.out::println);
```

---

## Streams Numéricos Especializados

### IntStream, LongStream, DoubleStream

```java
// Crear rangos
IntStream.range(1, 6)  // [1, 2, 3, 4, 5]
    .forEach(System.out::println);

IntStream.rangeClosed(1, 5)  // [1, 2, 3, 4, 5]
    .forEach(System.out::println);

// Estadísticas
IntSummaryStatistics stats = IntStream.range(1, 101)
    .summaryStatistics();

System.out.println("Suma: " + stats.getSum());      // 5050
System.out.println("Promedio: " + stats.getAverage()); // 50.5
System.out.println("Máximo: " + stats.getMax());    // 100
System.out.println("Mínimo: " + stats.getMin());    // 1
System.out.println("Cantidad: " + stats.getCount()); // 100

// Conversión
List<Integer> cuadrados = IntStream.range(1, 6)
    .map(n -> n * n)
    .boxed()  // int -> Integer
    .collect(Collectors.toList());
// [1, 4, 9, 16, 25]
```

---

## Ejemplos Prácticos Completos

### Ejemplo 1: Procesamiento de Empleados

```java
class Empleado {
    private String nombre;
    private String departamento;
    private double salario;
    private int edad;
    
    // constructor, getters...
}

List<Empleado> empleados = Arrays.asList(
    new Empleado("Juan", "IT", 50000, 28),
    new Empleado("Ana", "HR", 45000, 32),
    new Empleado("Carlos", "IT", 60000, 35),
    new Empleado("María", "Finance", 55000, 29)
);

// Salario promedio del departamento IT
double promedioIT = empleados.stream()
    .filter(e -> e.getDepartamento().equals("IT"))
    .mapToDouble(Empleado::getSalario)
    .average()
    .orElse(0.0);

// Empleados mayores de 30, ordenados por salario
List<String> mayoresDe30 = empleados.stream()
    .filter(e -> e.getEdad() > 30)
    .sorted(Comparator.comparing(Empleado::getSalario).reversed())
    .map(Empleado::getNombre)
    .collect(Collectors.toList());

// Agrupar por departamento y contar
Map<String, Long> empleadosPorDpto = empleados.stream()
    .collect(Collectors.groupingBy(
        Empleado::getDepartamento,
        Collectors.counting()
    ));
```

### Ejemplo 2: Análisis de Texto

```java
String texto = "Java es genial. Streams en Java son poderosos. " +
               "Java facilita la programación funcional.";

// Palabras más frecuentes
Map<String, Long> frecuenciaPalabras = Arrays.stream(texto.split("\\W+"))
    .map(String::toLowerCase)
    .filter(s -> s.length() > 2)
    .collect(Collectors.groupingBy(
        Function.identity(),
        Collectors.counting()
    ));

// Top 3 palabras más frecuentes
List<String> top3 = frecuenciaPalabras.entrySet().stream()
    .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
    .limit(3)
    .map(Map.Entry::getKey)
    .collect(Collectors.toList());
```

---

## Streams Paralelos

```java
List<Integer> numeros = IntStream.range(1, 1000000)
    .boxed()
    .collect(Collectors.toList());

// Stream secuencial
long inicio = System.currentTimeMillis();
long suma1 = numeros.stream()
    .filter(n -> n % 2 == 0)
    .mapToLong(n -> n * n)
    .sum();
long tiempoSecuencial = System.currentTimeMillis() - inicio;

// Stream paralelo
inicio = System.currentTimeMillis();
long suma2 = numeros.parallelStream()
    .filter(n -> n % 2 == 0)
    .mapToLong(n -> n * n)
    .sum();
long tiempoParalelo = System.currentTimeMillis() - inicio;

System.out.println("Secuencial: " + tiempoSecuencial + "ms");
System.out.println("Paralelo: " + tiempoParalelo + "ms");
```

---

## Buenas Prácticas

### ✅ DO (Hacer)

1. **Usar nombres descriptivos en lambdas**
   ```java
   // ✅ Bien
   empleados.stream()
       .filter(empleado -> empleado.getSalario() > 50000)
   
   // ❌ Mal
   empleados.stream()
       .filter(e -> e.getSalario() > 50000)
   ```

2. **Preferir method references cuando sea posible**
   ```java
   // ✅ Bien
   nombres.stream().map(String::toUpperCase)
   
   // ❌ Menos preferible
   nombres.stream().map(s -> s.toUpperCase())
   ```

3. **Usar Optional correctamente**
   ```java
   // ✅ Bien
   empleados.stream()
       .filter(e -> e.getNombre().equals("Juan"))
       .findFirst()
       .ifPresent(this::procesarEmpleado);
   
   // ❌ Mal
   Empleado empleado = empleados.stream()
       .filter(e -> e.getNombre().equals("Juan"))
       .findFirst()
       .get(); // Puede lanzar NoSuchElementException
   ```

### ❌ DON'T (No hacer)

1. **No usar streams para operaciones simples**
   ```java
   // ❌ Overkill para algo simple
   list.stream().forEach(System.out::println);
   
   // ✅ Mejor
   list.forEach(System.out::println);
   ```

2. **No crear efectos secundarios en operaciones intermedias**
   ```java
   // ❌ Mal
   list.stream()
       .filter(item -> {
           System.out.println(item); // Efecto secundario
           return item.isValid();
       })
   
   // ✅ Bien
   list.stream()
       .peek(System.out::println)
       .filter(Item::isValid)
   ```

3. **No usar parallelStream sin considerar el contexto**
   ```java
   // ❌ Innecesario para colecciones pequeñas
   smallList.parallelStream().map(String::toUpperCase)
   
   // ✅ Mejor para colecciones pequeñas
   smallList.stream().map(String::toUpperCase)
   ```

---

### Tipos de Operaciones

* **Operaciones Intermedias**: 🚦 Son métodos que **transforman un `Stream` en otro `Stream`**. No ejecutan ninguna operación hasta que se invoca un método terminal. Piensa en ellos como pasos en una cadena de montaje: cada paso toma una entrada (un `Stream`) y produce una salida (un `Stream` modificado) para el siguiente paso. Puedes encadenar tantas operaciones intermedias como necesites.
    * **Ejemplo**: `stream.filter(...).map(...)`
* **Operaciones Terminales**: 🏁 Son métodos que **inician la ejecución** de la cadena de `Streams` y **producen un resultado final**. Después de llamar a una operación terminal, el `Stream` se "consume" y no se puede reutilizar. Un `Stream` solo puede tener una única operación terminal.
    * **Ejemplo**: `stream.count()`, `stream.collect(...)`, `stream.forEach(...)`

La distinción entre ambos es fundamental para entender cómo funciona la API de Streams, ya que un `Stream` no hace nada por sí solo hasta que una operación terminal "dispara" toda la cadena de operaciones intermedias que la preceden.

---

## Referencia Rápida de Métodos

| Método | Tipo | Descripción | Retorna |
|--------|------|-------------|---------|
| `filter()` | Intermedia | Filtra elementos | `Stream<T>` |
| `map()` | Intermedia | Transforma elementos | `Stream<R>` |
| `flatMap()` | Intermedia | Aplana streams | `Stream<R>` |
| `distinct()` | Intermedia | Elimina duplicados | `Stream<T>` |
| `sorted()` | Intermedia | Ordena elementos | `Stream<T>` |
| `peek()` | Intermedia | Espía elementos | `Stream<T>` |
| `limit()` | Intermedia | Limita cantidad | `Stream<T>` |
| `skip()` | Intermedia | Salta elementos | `Stream<T>` |
| `collect()` | Terminal | Recolecta resultados | `R` |
| `forEach()` | Terminal | Itera elementos | `void` |
| `reduce()` | Terminal | Reduce a un valor | `Optional<T>` o `T` |
| `count()` | Terminal | Cuenta elementos | `long` |
| `anyMatch()` | Terminal | ¿Alguno cumple? | `boolean` |
| `allMatch()` | Terminal | ¿Todos cumplen? | `boolean` |
| `noneMatch()` | Terminal | ¿Ninguno cumple? | `boolean` |
| `findFirst()` | Terminal | Primer elemento | `Optional<T>` |
| `findAny()` | Terminal | Cualquier elemento | `Optional<T>` |

