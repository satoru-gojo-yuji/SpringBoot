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




