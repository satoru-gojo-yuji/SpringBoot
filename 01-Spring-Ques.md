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


