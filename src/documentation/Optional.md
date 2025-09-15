# Optionals in java

The `Optional<T>` class was introduced in Java 8 as part of the `java.util` package.
It represents a container object that may or may not contain a non-null value. 
Optional is designed to help eliminate `NullPointerException` and 
make code more readable and maintainable by explicitly handling the absence of values.


### Key Benefits:
- **Null Safety**: Reduces NullPointerExceptions
- **Explicit Intent**: Makes nullable returns obvious in the API
- **Functional Style**: Enables functional programming patterns
- **Better Documentation**: Self-documenting code about possible absence of values


## Creating Optionals

### 1. `Optional.empty()`
Creates an empty Optional instance.

```java
Optional<String> empty = Optional.empty();
System.out.println(empty.isPresent()); // false
```

### 2. `Optional.of(value)`
Creates an Optional with a non-null value. Throws `NullPointerException` if value is null.

```java
Optional<String> optional = Optional.of("Hello World");
// Optional<String> nullOptional = Optional.of(null); // Throws NPE
```

### 3. `Optional.ofNullable(value)`
Creates an Optional that may contain null. Returns empty Optional if value is null.

```java
String nullableString = getValue(); // might return null
Optional<String> optional = Optional.ofNullable(nullableString);
```

## Checking for Values

### `isPresent()`
Returns true if Optional contains a value.

```java
Optional<String> optional = Optional.of("Hello");
if (optional.isPresent()) {
    System.out.println("Value exists: " + optional.get());
}
```

### `isEmpty()` (Java 11+)
Returns true if Optional is empty.

```java
Optional<String> empty = Optional.empty();
if (empty.isEmpty()) {
    System.out.println("Optional is empty");
}
```
# Getting values

### `get()`
Returns the value if present, otherwise throws `NoSuchElementException`. Use with caution!

```java
Optional<String> optional = Optional.of("Hello");
String value = optional.get(); // "Hello"

Optional<String> empty = Optional.empty();
// String value2 = empty.get(); // Throws NoSuchElementException
```

### `orElse(defaultValue)`
Returns the value if present, otherwise returns the default value.

```java
Optional<String> optional = Optional.empty();
String result = optional.orElse("Default Value"); // "Default Value"
```

--- 

## Best Practices

### 1. Never Use Optional.get() Without Checking
```java
// BAD
String value = optional.get();

// GOOD
String value = optional.orElse("default");
// or
if (optional.isPresent()) {
    String value = optional.get();
}
```

### 2. Prefer orElse() for Simple Defaults
```java
// For simple, pre-computed values
String value = optional.orElse("default");

// For expensive computations, use orElseGet()
String value = optional.orElseGet(() -> computeExpensiveDefault());
```

### 3. Use Optional as Return Types, Not Parameters
```java
// GOOD - Return type
public Optional<User> findUserById(Long id) {
    return Optional.ofNullable(userRepository.find(id));
}

// AVOID - Parameter type
public void processUser(Optional<User> user) { // Not recommended
    // ...
}
```

### 4. Don't Use Optional for Collections
```java
// BAD
public Optional<List<String>> getItems() {
    return Optional.ofNullable(items);
}

// GOOD
public List<String> getItems() {
    return items != null ? items : Collections.emptyList();
}
```

### 5. Chain Operations Functionally
```java
// Instead of multiple if-checks
Optional<String> result = findUser(id)
    .filter(user -> user.isActive())
    .map(User::getEmail)
    .filter(email -> email.contains("@"))
    .map(String::toLowerCase);
```


### Example 1:
```java
public class UserService {
    private UserRepository userRepository;
    
    public Optional<User> findUserByEmail(String email) {
        return Optional.ofNullable(userRepository.findByEmail(email));
    }
    
    public String getUserDisplayName(String email) {
        return findUserByEmail(email)
            .map(User::getProfile)
            .map(Profile::getDisplayName)
            .filter(name -> !name.trim().isEmpty())
            .orElse("Anonymous User");
    }
    
    public boolean isUserActive(String email) {
        return findUserByEmail(email)
            .map(User::getStatus)
            .filter(status -> status == UserStatus.ACTIVE)
            .isPresent();
    }
}
```

