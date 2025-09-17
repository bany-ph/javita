# SOLID Principles

## Introduction

SOLID is an acronym for five design principles that make software designs more understandable, flexible, and maintainable. These principles were introduced by Robert C. Martin (Uncle Bob) and form the foundation of clean, object-oriented design.

**S** - Single Responsibility Principle  
**O** - Open/Closed Principle  
**L** - Liskov Substitution Principle  
**I** - Interface Segregation Principle  
**D** - Dependency Inversion Principle

## Single Responsibility Principle (SRP)

### Definition
*"A class should have one, and only one, reason to change."*

A class should have only one responsibility and only one reason to be modified. Each class should focus on a single task or functionality.

### Why It Matters
- **Easier to maintain**: Changes affect only one aspect of functionality
- **Reduced coupling**: Classes don't depend on multiple concerns
- **Better testability**: Single responsibility means focused, simple tests
- **Improved readability**: Clear, focused classes are easier to understand

### Violation Example
```java
// BAD: Multiple responsibilities in one class
public class User {
    private String name;
    private String email;
    
    // User data management
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    
    // Email validation (different responsibility)
    public boolean isValidEmail() {
        return email.contains("@") && email.contains(".");
    }
    
    // Database operations (another responsibility)
    public void saveToDatabase() {
        // Database connection and save logic
        System.out.println("Saving user to database...");
    }
    
    // Email sending (yet another responsibility)
    public void sendWelcomeEmail() {
        // Email sending logic
        System.out.println("Sending welcome email to " + email);
    }
}
```

### Correct Implementation
```java
// GOOD: Separated responsibilities

// 1. User entity - only data management
public class User {
    private String name;
    private String email;
    
    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }
    
    // Only getters and setters
    public String getName() { return name; }
    public String getEmail() { return email; }
}

// 2. Email validator - only validation logic
public class EmailValidator {
    public boolean isValid(String email) {
        return email != null && email.contains("@") && email.contains(".");
    }
}

// 3. User repository - only database operations
public class UserRepository {
    public void save(User user) {
        // Database saving logic
        System.out.println("Saving user: " + user.getName());
    }
}

// 4. Email service - only email operations
public class EmailService {
    public void sendWelcomeEmail(User user) {
        // Email sending logic
        System.out.println("Sending welcome email to: " + user.getEmail());
    }
}

// 5. User service - coordinates operations
public class UserService {
    private UserRepository userRepository;
    private EmailService emailService;
    private EmailValidator emailValidator;
    
    public void createUser(String name, String email) {
        if (!emailValidator.isValid(email)) {
            throw new IllegalArgumentException("Invalid email");
        }
        
        User user = new User(name, email);
        userRepository.save(user);
        emailService.sendWelcomeEmail(user);
    }
}
```

## Open/Closed Principle (OCP)

### Definition
*"Software entities should be open for extension but closed for modification."*

You should be able to extend a class's behavior without modifying its existing code.

### Why It Matters
- **Reduces risk**: No need to modify tested, working code
- **Supports growth**: Easy to add new features
- **Maintains stability**: Existing functionality remains unchanged
- **Follows DRY principle**: Avoid duplicating code

### Violation Example
```java
// BAD: Must modify class to add new discount types
public class DiscountCalculator {
    public double calculateDiscount(String customerType, double amount) {
        if (customerType.equals("REGULAR")) {
            return amount * 0.05;
        } else if (customerType.equals("PREMIUM")) {
            return amount * 0.10;
        } else if (customerType.equals("VIP")) {
            return amount * 0.15;
        }
        // To add new customer type, we must modify this method
        return 0;
    }
}
```

### Correct Implementation
```java
// GOOD: Open for extension, closed for modification

// Abstract base class
public abstract class DiscountCalculator {
    public abstract double calculateDiscount(double amount);
}

// Concrete implementations
public class RegularCustomerDiscount extends DiscountCalculator {
    @Override
    public double calculateDiscount(double amount) {
        return amount * 0.05;
    }
}

public class PremiumCustomerDiscount extends DiscountCalculator {
    @Override
    public double calculateDiscount(double amount) {
        return amount * 0.10;
    }
}

public class VipCustomerDiscount extends DiscountCalculator {
    @Override
    public double calculateDiscount(double amount) {
        return amount * 0.15;
    }
}

// Adding new discount type without modifying existing code
public class StudentDiscount extends DiscountCalculator {
    @Override
    public double calculateDiscount(double amount) {
        return amount * 0.20;
    }
}

// Usage with Strategy pattern
public class PriceCalculator {
    public double calculateFinalPrice(double basePrice, DiscountCalculator calculator) {
        double discount = calculator.calculateDiscount(basePrice);
        return basePrice - discount;
    }
}
```

## Liskov Substitution Principle (LSP)

### Definition
*"Objects of a superclass should be replaceable with objects of its subclasses without breaking the application."*

Subclasses should be substitutable for their parent classes without altering program correctness.

### Why It Matters
- **Ensures polymorphism works correctly**: Substitution should be seamless
- **Maintains contracts**: Subclasses must honor parent class contracts
- **Prevents unexpected behavior**: No surprises when using inheritance
- **Supports reliable inheritance hierarchies**

### Violation Example
```java
// BAD: Rectangle-Square problem
public class Rectangle {
    protected int width;
    protected int height;
    
    public void setWidth(int width) {
        this.width = width;
    }
    
    public void setHeight(int height) {
        this.height = height;
    }
    
    public int getArea() {
        return width * height;
    }
}

public class Square extends Rectangle {
    @Override
    public void setWidth(int width) {
        this.width = width;
        this.height = width; // Violates LSP - changes both dimensions
    }
    
    @Override
    public void setHeight(int height) {
        this.width = height; // Violates LSP - changes both dimensions
        this.height = height;
    }
}

// This breaks when using Square as Rectangle
public void testRectangle(Rectangle rect) {
    rect.setWidth(5);
    rect.setHeight(4);
    // Expects area = 20, but Square gives 16
    assert rect.getArea() == 20; // FAILS for Square!
}
```

### Correct Implementation
```java
// GOOD: Proper abstraction and inheritance

public abstract class Shape {
    public abstract int getArea();
}

public class Rectangle extends Shape {
    protected int width;
    protected int height;
    
    public Rectangle(int width, int height) {
        this.width = width;
        this.height = height;
    }
    
    public void setWidth(int width) {
        this.width = width;
    }
    
    public void setHeight(int height) {
        this.height = height;
    }
    
    @Override
    public int getArea() {
        return width * height;
    }
}

public class Square extends Shape {
    private int side;
    
    public Square(int side) {
        this.side = side;
    }
    
    public void setSide(int side) {
        this.side = side;
    }
    
    @Override
    public int getArea() {
        return side * side;
    }
}

// Usage - both can be used as Shape without issues
public int calculateTotalArea(List<Shape> shapes) {
    return shapes.stream()
                .mapToInt(Shape::getArea)
                .sum();
}
```

## Interface Segregation Principle (ISP)

### Definition
*"A client should not be forced to implement an interface that it doesn't use."*

Prefer many specific interfaces over one general-purpose interface. Classes should not depend on methods they don't use.

### Why It Matters
- **Reduces coupling**: Classes depend only on what they need
- **Increases flexibility**: Easier to implement and maintain
- **Prevents interface pollution**: Keeps interfaces focused and clean
- **Improves testability**: Smaller interfaces are easier to mock

### Violation Example
```java
// BAD: Fat interface forces unnecessary implementations
public interface Worker {
    void work();
    void eat();
    void sleep();
    void attendMeeting();
    void writeReport();
    void operateMachine();
}

// Robot doesn't eat or sleep, but must implement these methods
public class Robot implements Worker {
    @Override
    public void work() { System.out.println("Robot working"); }
    
    @Override
    public void eat() { 
        throw new UnsupportedOperationException("Robot doesn't eat"); 
    }
    
    @Override
    public void sleep() { 
        throw new UnsupportedOperationException("Robot doesn't sleep"); 
    }
    
    @Override
    public void attendMeeting() { 
        throw new UnsupportedOperationException("Robot doesn't attend meetings"); 
    }
    
    @Override
    public void writeReport() { System.out.println("Generating report"); }
    
    @Override
    public void operateMachine() { System.out.println("Operating machine"); }
}
```

### Correct Implementation
```java
// GOOD: Segregated interfaces

public interface Workable {
    void work();
}

public interface Eatable {
    void eat();
}

public interface Sleepable {
    void sleep();
}

public interface Attendable {
    void attendMeeting();
}

public interface Reportable {
    void writeReport();
}

public interface MachineOperable {
    void operateMachine();
}

// Human worker implements relevant interfaces
public class HumanWorker implements Workable, Eatable, Sleepable, Attendable {
    @Override
    public void work() { System.out.println("Human working"); }
    
    @Override
    public void eat() { System.out.println("Human eating"); }
    
    @Override
    public void sleep() { System.out.println("Human sleeping"); }
    
    @Override
    public void attendMeeting() { System.out.println("Attending meeting"); }
}

// Robot implements only what it can do
public class Robot implements Workable, Reportable, MachineOperable {
    @Override
    public void work() { System.out.println("Robot working"); }
    
    @Override
    public void writeReport() { System.out.println("Generating report"); }
    
    @Override
    public void operateMachine() { System.out.println("Operating machine"); }
}

// Manager implements management-specific interfaces
public class Manager implements Workable, Eatable, Sleepable, Attendable, Reportable {
    @Override
    public void work() { System.out.println("Managing team"); }
    
    @Override
    public void eat() { System.out.println("Manager eating"); }
    
    @Override
    public void sleep() { System.out.println("Manager sleeping"); }
    
    @Override
    public void attendMeeting() { System.out.println("Leading meeting"); }
    
    @Override
    public void writeReport() { System.out.println("Writing management report"); }
}
```

## Dependency Inversion Principle (DIP)

### Definition
*"Depend on abstractions, not on concretions."*

High-level modules should not depend on low-level modules. Both should depend on abstractions. Abstractions should not depend on details; details should depend on abstractions.

### Why It Matters
- **Reduces coupling**: High-level code doesn't depend on implementation details
- **Increases flexibility**: Easy to swap implementations
- **Improves testability**: Easy to mock dependencies
- **Supports inversion of control**: Dependencies are injected, not created

### Violation Example
```java
// BAD: High-level class depends on low-level concrete class
public class EmailService {
    public void sendEmail(String message) {
        System.out.println("Sending email: " + message);
    }
}

public class NotificationService {
    private EmailService emailService; // Direct dependency on concrete class
    
    public NotificationService() {
        this.emailService = new EmailService(); // Creates dependency
    }
    
    public void sendNotification(String message) {
        // Tightly coupled to EmailService
        emailService.sendEmail(message);
    }
}
```

### Correct Implementation
```java
// GOOD: Depend on abstractions

// Abstraction
public interface NotificationSender {
    void send(String message);
}

// Low-level implementations
public class EmailService implements NotificationSender {
    @Override
    public void send(String message) {
        System.out.println("Sending email: " + message);
    }
}

public class SMSService implements NotificationSender {
    @Override
    public void send(String message) {
        System.out.println("Sending SMS: " + message);
    }
}

public class SlackService implements NotificationSender {
    @Override
    public void send(String message) {
        System.out.println("Sending Slack message: " + message);
    }
}

// High-level class depends on abstraction
public class NotificationService {
    private List<NotificationSender> notificationSenders;
    
    // Dependency injection through constructor
    public NotificationService(List<NotificationSender> senders) {
        this.notificationSenders = senders;
    }
    
    public void sendNotification(String message) {
        for (NotificationSender sender : notificationSenders) {
            sender.send(message);
        }
    }
}

// Usage with dependency injection
public class Application {
    public static void main(String[] args) {
        List<NotificationSender> senders = Arrays.asList(
            new EmailService(),
            new SMSService(),
            new SlackService()
        );
        
        NotificationService service = new NotificationService(senders);
        service.sendNotification("Hello, SOLID principles!");
    }
}
```

## Real-World Application

### E-commerce System Example

```java
// Following all SOLID principles

// SRP: Single responsibility interfaces
public interface ProductRepository {
    List<Product> findAll();
    Product findById(Long id);
    void save(Product product);
}

public interface PaymentProcessor {
    PaymentResult process(Payment payment);
}

public interface InventoryManager {
    boolean isInStock(Product product, int quantity);
    void reserveItems(Product product, int quantity);
}

public interface NotificationSender {
    void send(String recipient, String message);
}

// OCP: Open for extension
public abstract class DiscountStrategy {
    public abstract double calculateDiscount(Order order);
}

public class SeasonalDiscountStrategy extends DiscountStrategy {
    @Override
    public double calculateDiscount(Order order) {
        return order.getTotal() * 0.15;
    }
}

// LSP: Proper inheritance
public abstract class PaymentMethod {
    public abstract PaymentResult processPayment(double amount);
}

public class CreditCardPayment extends PaymentMethod {
    @Override
    public PaymentResult processPayment(double amount) {
        // Credit card processing logic
        return new PaymentResult(true, "Payment successful");
    }
}

// ISP: Segregated interfaces (shown above)

// DIP: Dependency injection
public class OrderService {
    private final ProductRepository productRepository;
    private final PaymentProcessor paymentProcessor;
    private final InventoryManager inventoryManager;
    private final NotificationSender notificationSender;
    
    public OrderService(ProductRepository productRepository,
                       PaymentProcessor paymentProcessor,
                       InventoryManager inventoryManager,
                       NotificationSender notificationSender) {
        this.productRepository = productRepository;
        this.paymentProcessor = paymentProcessor;
        this.inventoryManager = inventoryManager;
        this.notificationSender = notificationSender;
    }
    
    public void processOrder(Order order) {
        // Validate inventory
        if (!inventoryManager.isInStock(order.getProduct(), order.getQuantity())) {
            throw new InsufficientInventoryException();
        }
        
        // Process payment
        PaymentResult result = paymentProcessor.process(order.getPayment());
        if (!result.isSuccessful()) {
            throw new PaymentFailedException();
        }
        
        // Reserve inventory
        inventoryManager.reserveItems(order.getProduct(), order.getQuantity());
        
        // Send confirmation
        notificationSender.send(order.getCustomerEmail(), 
                              "Order confirmed: " + order.getId());
    }
}
```

## Common Violations and Solutions

### 1. **God Classes** (SRP Violation)
```java
// Problem: One class doing everything
public class UserManager {
    // Database operations
    public void saveUser(User user) { }
    // Email operations  
    public void sendEmail(String email) { }
    // Validation logic
    public boolean validateUser(User user) { }
    // Reporting logic
    public void generateReport() { }
}

// Solution: Separate responsibilities
public class UserRepository { /* database operations */ }
public class EmailService { /* email operations */ }
public class UserValidator { /* validation logic */ }
public class ReportGenerator { /* reporting logic */ }
```

### 2. **Rigid Hierarchies** (OCP/LSP Violations)
```java
// Problem: Hard to extend, violates substitution
public class Shape {
    public void draw(String type) {
        if (type.equals("circle")) {
            // draw circle
        } else if (type.equals("square")) {
            // draw square
        }
    }
}

// Solution: Polymorphic design
public abstract class Shape {
    public abstract void draw();
}
public class Circle extends Shape { /* implementation */ }
public class Square extends Shape { /* implementation */ }
```

### 3. **Fat Interfaces** (ISP Violation)
```java
// Problem: Forces unnecessary implementations
public interface DatabaseOperations {
    void create(); void read(); void update(); void delete();
    void backup(); void restore(); void migrate(); void optimize();
}

// Solution: Specific interfaces
public interface CrudOperations { void create(); void read(); void update(); void delete(); }
public interface BackupOperations { void backup(); void restore(); }
public interface MaintenanceOperations { void migrate(); void optimize(); }
```

### 4. **Tight Coupling** (DIP Violation)
```java
// Problem: Direct dependencies
public class OrderService {
    private MySQLDatabase database = new MySQLDatabase();
    private EmailSender emailSender = new EmailSender();
}

// Solution: Dependency injection
public class OrderService {
    private final Database database;
    private final NotificationSender notificationSender;
    
    public OrderService(Database database, NotificationSender notificationSender) {
        this.database = database;
        this.notificationSender = notificationSender;
    }
}
```
