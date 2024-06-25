# Patient Medicine And Appointment System

## Introduction
This guide explains how to set up, configure, and operate the Hospital Management System. It includes details on the project structure, API endpoints, request and response formats, and data validation rules.

## Project Setup
1. **Clone the Repository**: Clone the project from GitHub.
2. **Navigate to the Project Directory**: Open your terminal and navigate to the project folder.
3. **Install Dependencies**: Run `mvn install` to install all necessary dependencies.
4. **Database Configuration**: Update the `application.properties` file with your database details.
5. **Run the Application**: Start the application using `mvn spring-boot:run` or an IDE like Eclipse or IntelliJ.

## Configuration
The main configuration files are in the `src/main/resources` directory.
1. **application.properties**: Contains database and environment-specific settings.
2. **SecurityConfig.java**: Configures security settings such as login and logout URLs and access permissions.
3. **ConfigWeb.java**: Configures web-specific settings like hidden HTTP method filters.

## API Endpoints

### Registration
- **URL**: `/registration`
- **Method**: `POST`
- **Request Body**:
    ```json
    {
      "firstName": "string",
      "lastName": "string",
      "email": "string",
      "password": "string"
    }
    ```
- **Response**: Redirects to `/registration?success`

### Login
- **URL**: `/login`
- **Method**: `GET`
- **Response**: Returns the login page

### Home
- **URL**: `/home`
- **Method**: `GET`
- **Response**: Returns the home page

### Add Medicine
- **URL**: `/addMedicine`
- **Method**: `GET`
- **Response**: Returns the add medicine form

- **URL**: `/save`
- **Method**: `POST`
- **Request Body**:
    ```json
    {
      "medicine": {
        "name": "string",
        "quantity": "integer",
        "patientUserId": "long"
      }
    }
    ```
- **Response**: Redirects to `/home`

### Display Medicine
- **URL**: `/displayMedicine`
- **Method**: `GET`
- **Response**: Returns the view medicine page

### Update Medicine
- **URL**: `/medicineUpdateById`
- **Method**: `GET`
- **Request Params**: `serialNo` (integer)
- **Response**: Returns the update medicine form

- **URL**: `/saveUpdate`
- **Method**: `PUT`
- **Request Body**:
    ```json
    {
      "medicine": {
        "serialNo": "integer",
        "quantity": "integer"
      }
    }
    ```
- **Response**: Returns the view medicine page

### Display Doctors
- **URL**: `/displayDoctors`
- **Method**: `GET`
- **Response**: Returns the view doctors page

### Book Appointment
- **URL**: `/bookAppointment/{doctorId}`
- **Method**: `GET`
- **Response**: Returns the appointment booking page

- **URL**: `/saveAppointment`
- **Method**: `POST`
- **Request Body**:
    ```json
    {
      "appointment": {
        "doctorId": "integer",
        "patientUserId": "long"
      }
    }
    ```
- **Response**: Redirects to `/home`

### Display Appointments
- **URL**: `/displayAppointments`
- **Method**: `GET`
- **Response**: Returns the view appointments page

## Data Validation Rules

### Patient Registration
- **firstName**: Required, String
- **lastName**: Required, String
- **email**: Required, String, must be a valid email format
- **password**: Required, String

### Medicine
- **name**: Required, String
- **quantity**: Required, Integer

### Appointment
- **doctorId**: Required, Integer
- **patientUserId**: Required, Long

This document outlines the basic structure and usage of the Hospital Management System to ensure smooth setup and operation.



Here is the example for sample database for doctors table:

INSERT INTO doctor_details (available_date, available_slot, available_time, consultation_fee, experience, doctor_name, qualification, specialization)
VALUES
('2024-06-10', 'Morning', '09:00 - 11:00', 100.0, 10, 'Dr. Amit Verma', 'MD', 'Cardiology'),
('2024-06-11', 'Afternoon', '13:00 - 15:00', 80.0, 8, 'Dr. Priya Singh', 'MBBS', 'Dermatology'),
('2024-06-12', 'Evening', '16:00 - 18:00', 90.0, 12, 'Dr. Rajesh Mehta', 'MS', 'Orthopedics'),
('2024-06-13', 'Morning', '08:00 - 10:00', 120.0, 15, 'Dr. Neha Sharma', 'MD', 'Pediatrics'),
('2024-06-14', 'Afternoon', '14:00 - 16:00', 110.0, 11, 'Dr. Rohan Patel', 'MBBS', 'Neurology'),
('2024-06-15', 'Evening', '17:00 - 19:00', 130.0, 20, 'Dr. Anjali Rao', 'MS', 'Gynecology'),
('2024-06-16', 'Morning', '10:00 - 12:00', 95.0, 7, 'Dr. Arjun Iyer', 'MD', 'Psychiatry'),
('2024-06-17', 'Afternoon', '12:00 - 14:00', 85.0, 9, 'Dr. Meera Gupta', 'MBBS', 'Oncology'),
('2024-06-18', 'Evening', '18:00 - 20:00', 105.0, 13, 'Dr. Vikram Reddy', 'MS', 'Urology'),
('2024-06-19', 'Morning', '07:00 - 09:00', 115.0, 14, 'Dr. Shalini Desai', 'MD', 'Ophthalmology');













