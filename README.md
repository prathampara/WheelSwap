Welcome to the Vehicle Exchange Platform! This project is a robust and secure web application designed to facilitate the exchange of vehicles between users. Built with Spring Boot, Hibernate, Spring Data JPA, MySQL, and secured with Spring Security, this platform provides a seamless experience for users to list, browse, and exchange vehicles.

Table of Contents
Features

Technologies Used

Prerequisites

Setup and Installation

API Documentation

Security

Database Schema

Contributing

License

Acknowledgements

Features
User Authentication and Authorization: Secure user registration, login, and role-based access control using Spring Security.

Vehicle Listing: Users can list their vehicles for exchange with details like make, model, year, mileage, and condition.

Browse Vehicles: Users can browse through a list of available vehicles for exchange.

Request Exchange: Users can send exchange requests to other users for their listed vehicles.

Manage Listings: Users can update or delete their vehicle listings.

Admin Dashboard: Admins can manage users, vehicles, and exchange requests.

Technologies Used
Spring Boot: For building the backend application.

Hibernate: For ORM (Object-Relational Mapping) and database interactions.

Spring Data JPA: For simplified data access and repository abstraction.

MySQL: As the relational database management system.

Spring Security: For authentication and authorization.

Postman: For API testing and documentation.

Maven: For project dependency management.

Prerequisites
Before you begin, ensure you have the following installed:

Java JDK 11 or higher

MySQL Server

Maven

Postman (for API testing)

Git (for version control)

Setup and Installation
Clone the Repository:

bash
Copy
git clone https://github.com/prathampara/WheelSwap.git
cd WheelSwap
Configure MySQL Database:

Create a new MySQL database named vehicle_exchange.

Update the application.properties file with your MySQL credentials:

properties

spring.datasource.url=jdbc:mysql://localhost:3306/vehicle_exchange
spring.datasource.username=your-username
spring.datasource.password=your-password
spring.jpa.hibernate.ddl-auto=update
Build the Project:

bash
Copy
mvn clean install
Run the Application:

bash
Copy
mvn spring-boot:run
Access the Application:

The application will be running on http://localhost:8080.

Use Postman to interact with the API endpoints.

API Documentation
Authentication
Register a New User:

POST /api/auth/register

Request Body:

json
Copy
{
  "username": "john_doe",
  "password": "password123",
  "email": "john.doe@example.com",
  "role": "USER"
}
Login:

POST /api/auth/login

Request Body:

json
Copy
{
  "username": "john_doe",
  "password": "password123"
}
Vehicle Management
List a Vehicle:

POST /api/vehicles

Request Body:

json
Copy
{
  "make": "Toyota",
  "model": "Corolla",
  "year": 2020,
  "mileage": 15000,
  "condition": "Excellent"
}
Browse Vehicles:

GET /api/vehicles

Update a Vehicle:

PUT /api/vehicles/{vehicleId}

Request Body:

json
Copy
{
  "make": "Toyota",
  "model": "Corolla",
  "year": 2021,
  "mileage": 20000,
  "condition": "Good"
}
Delete a Vehicle:

DELETE /api/vehicles/{vehicleId}

Exchange Requests
Send Exchange Request:

POST /api/exchange-requests

Request Body:

json
Copy
{
  "vehicleId": 1,
  "message": "I would like to exchange my Honda Civic for your Toyota Corolla."
}
View Exchange Requests:

GET /api/exchange-requests

Accept/Reject Exchange Request:

PUT /api/exchange-requests/{requestId}

Request Body:

json
Copy
{
  "status": "ACCEPTED" // or "REJECTED"
}
Security
Spring Security is used to handle user authentication and authorization.

JWT (JSON Web Tokens) are used for secure user sessions.

Role-based access control ensures that only authorized users can perform certain actions (e.g., only admins can delete users).

Database Schema
The database schema includes the following tables:

Users: Stores user information (username, password, email, role).

Vehicles: Stores vehicle details (make, model, year, mileage, condition, user_id).

Exchange_Requests: Stores exchange requests (vehicle_id, requester_id, status, message).

Contributing
We welcome contributions! If you'd like to contribute, please follow these steps:

Fork the repository.

Create a new branch (git checkout -b feature/YourFeatureName).

Commit your changes (git commit -m 'Add some feature').

Push to the branch (git push origin feature/YourFeatureName).

Open a pull request.

License
This project is licensed under the MIT License - see the LICENSE file for details.

Acknowledgements
Spring Boot: For making it easy to create stand-alone, production-grade Spring-based applications.

Hibernate: For simplifying database interactions.

Spring Security: For providing comprehensive security services.

Postman: For API testing and documentation.
