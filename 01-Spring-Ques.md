http://localhost:8080/actuator/health


management.endpoints.web.exposure.include=health,info
management.info.env.enabled=true


info.app.name=My super app
info.app.description= A crazy  fun app
info.app.version=1.0.0  

**@Configuration**
indicates that the class contains bean definitions.
Methods annotated with @Bean inside the configuration class define individual beans.
The Spring IoC container will manage these beans and handle their lifecycle.

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public MyService myService() {
        return new MyServiceImpl();
    }

    @Bean
    public MyRepository myRepository() {
        return new MyRepositoryImpl();
    }
}

1. @Componentmarks a class as a Spring component.
2. Classes annotated with @Component are automatically detected and registered as beans.
3. @ComponentScan is used to specify the packages to scan for annotated components.
4. @Autowired is used to inject the component into other beans

The client sends an HTTP POST request to the /api/items endpoint with a JSON body.
The @PostMapping("/items") annotation maps this request to the addItem method.
The @RequestBody annotation tells Spring to deserialize the JSON body of the request into an Item object.
The addItem method receives the Item object populated with the data from the request body, ready for further processing.
Using @RequestBody with @PostMapping simplifies handling and processing of incoming data, ensuring a clean and efficient way to bind request data to Java objects.

@RequestBody 
This is particularly useful when you're dealing with JSON or XML data in the request body that needs to be converted into a Java object. 

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @PostMapping("/users")
    public String createUser(@RequestBody UserDto user) {
        // Process the user data
        return "User " + user.getUsername() + " with email " + user.getEmail() + " created successfully.";
    }
}

@ResponseBody: This annotation tells Spring to convert the return value of the method to JSON and write it directly to the HTTP response body, using message converters.




@RequiredArgsConstructor in Spring Boot is a Lombok annotation that helps reduce boilerplate code by automatically generating constructors for required fields. It promotes constructor injection, which is a good practice in Spring applications for ensuring immutability and thread-safety. This leads to cleaner, more maintainable, and less error-prone code.

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MyService {

    @NonNull
    private MyRepository myRepository;
    private final AnotherDependency anotherDependency;

    // Other methods
}

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MyService {

    private final MyRepository myRepository;
    private final AnotherDependency anotherDependency;

    // Other methods
}


Purpose: @PostConstruct
 is used for initialization logic that should run once after the bean is created and dependencies are injected.
Lifecycle: The method annotated with @PostConstruct will be executed once after the dependency injection is done.
Use Cases: Commonly used for setting up resources, initializing data, or any other setup tasks required after the bean is fully initialized.
By using @PostConstruct, you can ensure that your initialization logic runs at the right time in the bean's lifecycle, making your Spring application more robust and easier to maintain.

The @PostConstruct annotation in Spring is used to annotate a method that should be executed after the dependency injection is done to perform any initialization. This method will be invoked only once, after the bean's properties have been set.

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.annotation.PostConstruct;
import java.util.Arrays;

@Service
public class DataInitializer {

    @Autowired
    private UserRepository userRepository;

    @PostConstruct
    public void init() {
        // Check if the database is empty
        if (userRepository.count() == 0) {
            // Load initial data
            userRepository.saveAll(Arrays.asList(
                new User("john.doe@example.com", "John", "Doe"),
                new User("jane.doe@example.com", "Jane", "Doe")
            ));
        }
    }
}

  @Configuration 
  annotation is used to indicate that a class declares one or more @Bean methods and may be processed by the Spring container to generate bean definitions and service requests at runtime.

Key Points about @Configuration
Bean Definitions: A class annotated with @Configuration is a source of bean definitions. It can define beans using methods annotated with @Bean.
Singleton Scope: Beans defined in a @Configuration class are by default singletons, ensuring that only one instance of each bean is created and managed by the Spring container.
Class-Level Configuration: It is a way to define configurations at the class level, which can be processed by Spring's container.
ProxyEnhancements: By default, Spring will use CGLIB to create a subclass of the @Configuration class to intercept calls to @Bean methods and manage them within the Spring context.


@Param : 
In Spring Framework, @Param (org.springframework.data.repository.query.Param) is used to bind the method parameter to Query parameter.

Example:

@Query("select e from Employee e where e.deptId = :deptId")
List<Employee> findEmployeeByDeptId(@Param("deptId") Long departmentId);
Here, Employee is JPA Entity, and @Param is used to bind the method parameter departmentId to Query parameter deptId.

In your case, you are trying to fetch URL Parameter value. @RequestParam need to be used. @RequestParam is used to bind method parameter to web URL request parameter.


What is @RequestParam?
The @RequestParam annotation in Spring MVC is used to extract query parameters from the request URL. Query parameters are typically appended to the URL after a question mark (?) and separated by ampersands (&). For example, in the URL http://example.com/api/products?id=123&name=Laptop, id and name are query parameters.

Usage of @RequestParam:
@GetMapping("/products")
public ResponseEntity<Product> getProductById(
    @RequestParam Long id,
    @RequestParam(required = false) String name
) {
    // Method logic to retrieve product details
}
In the above example, id and name are extracted from the query parameters of the request URL. The required attribute of @RequestParam can be set to false to make a parameter optional.


What is @PathVariable?
On the other hand, the @PathVariable annotation is used to extract values from URI templates. URI templates are parts of the URL path enclosed in curly braces ({}). For instance, in the URL pattern /products/{id}, id is a path variable.

Usage of @PathVariable:
@GetMapping("/products/{id}")
public ResponseEntity<Product> getProductById(@PathVariable Long id) {
    // Method logic to retrieve product details based on ID
}
Here, id is extracted from the URL path and used to fetch the corresponding product information.


