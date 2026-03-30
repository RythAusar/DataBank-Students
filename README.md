# DataBank Students (JSF + JPA + MySQL)

Description
This is a Java web application built using JavaServer Faces (JSF), Java Persistence API (JPA), and MySQL.

The application allows users to manage student records with full CRUD functionality.

Tecnhologies used:
- Java
- JSF (Jakarta Faces)
- JPA (Hibernate / EclipseLink)
- MySQL
- Maven
- Payara

Features:
- Add new students
- View student list
- Update student information
- Delete students
- Input validation (email, phone)

Setup Instructions:

1. Clone the repository:

2. Create MySQL database:
- Create a database (e.g. `databank`)
- Import schema

3. Configure database:
- Open `payara-resources.xml`
- Replace: 
property name="user" value="placeHolderName"
property name="password" value="placeHolderPassword"

with your username and password


4. Run the project:
- Deploy Payara server


Author:
Nikita Sakunov