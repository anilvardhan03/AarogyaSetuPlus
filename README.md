# ArogyaSetuPlus - Insurance Applying Application

## Overview
ArogyaSetuPlus is a web-based insurance application designed to facilitate the insurance application process. The application is built using **Spring Boot**, **Oracle Database**, and **OpenPDF** for document generation.

## Features
- **User Registration & Authentication**
- **Health Insurance Application Submission**
- **Email Notification System**
- **PDF Report Generation**
- **RESTful APIs with OpenAPI Documentation**
- **Integration with Oracle Database**

## Tech Stack
- **Java 17**
- **Spring Boot 3.4.2**
- **Spring Data JPA** (for ORM)
- **Spring Web & WebFlux** (for APIs)
- **Spring Mail** (for email notifications)
- **OpenPDF** (for generating PDFs)
- **Oracle Database (OJDBC 11)**
- **Lombok** (for reducing boilerplate code)
- **Spring Boot DevTools** (for live reload during development)
- **SpringDoc OpenAPI** (for API documentation)

## Setup & Installation
### Prerequisites
- **Java 17** installed
- **Maven** installed
- **Oracle Database** configured

### Steps to Run Locally
1. **Clone the repository**
   ```bash
   git clone <repository_url>
   cd ArogyaSetuPlus-Insurance_Applying_Application
   ```

2. **Configure Database Connection**
   - Update `application.properties` or `application.yml` with your Oracle DB credentials.

3. **Build and Run the Project**
   ```bash
   mvn clean install
   mvn spring-boot:run
   ```

4. **Access API Documentation**
   - Open [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html) in your browser.
   - 


## Contribution
1. **Fork the repo**
2. **Create a feature branch** (`git checkout -b feature-xyz`)
3. **Commit your changes** (`git commit -m "Add feature XYZ"`)
4. **Push to the branch** (`git push origin feature-xyz`)
5. **Create a Pull Request**



## Author
Developed by Naga Mouli Anil Gubbala

