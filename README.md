Summary:
Create a REST API for a system that assigns students to classes. API will be used by both a UI and programmatically by other systems.

Language:
Java 8

Frameworks used:
Spring boot

Data Access Layer: 
JPA, postgresql

Architecture:
The system was implemented using the N-tier design pattern.

    TIERS:
    API Layer: (StudentController and CourseController)
    Service Layer: (StudentService and CourseService)
    Data Access Layer: (StudentRepository and CourseRepository)

For retrieving students and courses I used the GetMapping annotation
For creating a new Student or Course I used the PostMapping annotation
For updating an exiting object I used the PutMapping annotation
For deleting an object I used the DeleteMapping annotations.