## Assignment -1
The system must support different user types (e.g., "Admin," "Customer,"
"Vendor"). This flexibility should allow adding new user types without
requiring significant refactoring or changes to the system.

## Table of Contents

- [Features](#features)
- [Technologies Used](#technologies-used)
- [Installation](#installation)

## Features

- The system should differentiate behavior based on user types. For
example:Registration Emails,Third-Party Integration
- Implemented synchronization between SQL and NoSQL
- Implemented dual database storage eg. PostgreSQL,MongoDB
- Created successful registration workflow
- Implemented logging mechanism
- Added JWT based authentication ,Role based(User type) access control and API rate limiting per user/client
- Implemented Data Consistency (ACID across SQL and NoSQL)
- Implemnted Asynchronous mechanisms for Scalability and Performance

## Technologies-used
- **Java**: 17
- **Spring Boot**: 3.3.5
- **Spring Data JPA**: 3.3.5
- **Hibernate**: 8.0.1
- **Maven**: 4.0.0
- **Spring security**
- **Redis**
- **MongoDB**
- **Spring scheduler**
- **Docker**
- 
## Installation
- Clone the repository:
https://github.com/VaishnaviBagal98/users-registration-assignment.git
- Install the dependencies using:  **mvn install** command
