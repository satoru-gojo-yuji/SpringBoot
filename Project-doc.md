

src
└── main
    ├── java
    │   └── com
    │       └── example
    │           └── yourproject
    │               ├── YourProjectApplication.java
    │               ├── controller
    │               │   └── AdminController.java
    │               ├── model
    │               │   ├── Admin.java
    │               │   ├── Role.java
    │               │   └── User.java
    │               ├── repository
    │               │   ├── AdminRepository.java
    │               │   ├── RoleRepository.java
    │               │   └── UserRepository.java
    │               └── service
    │                   ├── AdminService.java
    │                   ├── RoleService.java
    │                   └── UserService.java
    └── resources
        ├── application.properties
        ├── static
        └── templates


src/main/java/com/example/yourproject: This is the base package of your project.
YourProjectApplication.java: The main class of your Spring Boot application.
controller: Package to hold controller classes.
AdminController.java: Controller class for handling admin-related requests.
model: Package to hold entity classes (JPA entities).
Admin.java: Entity class representing the Admin table.
Role.java: Entity class representing the Role table.
User.java: Entity class representing the User table.
repository: Package to hold repository interfaces (Spring Data JPA repositories).
AdminRepository.java: Repository interface for the Admin entity.
RoleRepository.java: Repository interface for the Role entity.
UserRepository.java: Repository interface for the User entity.
service: Package to hold service classes.
AdminService.java: Service class for business logic related to admins.
RoleService.java: Service class for business logic related to roles.
UserService.java: Service class for business logic related to users.
src/main/resources: This directory contains application properties, static resources, and templates.
application.properties: Configuration file for Spring Boot application properties.
With this project structure, you have a clear separation of concerns where entities, repositories, services, and controllers are organized into their respective packages. This makes it easier to manage and maintain your Spring Boot application.