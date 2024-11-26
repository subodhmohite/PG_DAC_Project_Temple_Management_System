# PG_DAC_Project_Temple_Management_System

The Temple Management System is a comprehensive web-based platform designed to automate and streamline the
operations of the Shree Mahalaxmi Temple in Kolhapur. This online portal allows devotees to book darshan slots,
schedule worship, rituals and make donations to the temple. The platform enables devotees to check the availability
of slots for their chosen date, ensuring a seamless booking experience. Additionally, the system provides temple
administrators with tools to manage darshan bookings, track donations, and maintain detailed records of devotees.


# 🌟 Features

 **For Devotees**
- **Darshan Booking:** Reserve slots for darshan with real-time availability.
- **Pooja and Ritual Scheduling:** Book specific rituals or worship services online.
- **Booking History:** View past bookings and donations.

 **For Administrators**
- **User Management:** Manage devotees' accounts and access.
- **Booking Management:** View and approve darshan, pooja, and ritual bookings.
- **Slot Availability Management:** Configure availability for darshan and other services.

---

# 🖥️ Technology Stack

 **Frontend**
- **React.js** for dynamic UI
- **Axios** for API requests
- **React Router** for navigation

 **Backend**
- **Spring Boot** for RESTful APIs
- **Spring Security** for authentication and authorization
- **JWT** for secure session management
- **MySQL** for database

 **Other Tools**
- **Spring Tool Suite (STS)** for backend development
- **Postman** for API testing
- **Docker** (optional) for containerization

---

# ⚙️ System Architecture

1. **Frontend:** React-based interface for users and administrators.
2. **Backend:** Spring Boot APIs for business logic and database interaction.
3. **Database:** Centralized relational database for storing all bookings, user data, and donation records.

---

# 🛠️ Installation and Setup

**Prerequisites**
- **Node.js** and **npm** installed
- **Java JDK 11+** installed
- **MySQL** server running
- **Spring Tool Suite (STS)** for backend development

**Steps**
1. **Clone the Repository**
   ```bash
   git clone https://github.com/subodhmohite/PG_DAC_Project_Temple_Management_System
   cd PG_DAC_Project_Temple_Management_System

**2.Backend Setup**
- Navigate to the backend directory:
  ```bash
  cd ShreeMahalaxmiDarshan
- Configure the application.properties file with your database credentials.
- Run the Spring Boot application from STS.

**3.Frontend Setup**
- Navigate to the frontend directory:
  ```bash
  cd FrontEnd
  cd React

- Install dependencies:
  ```bash
  npm install

- Start the React development server:
   ```bash
   npm start

**4.Access the Application**
- Open a web browser and navigate to:http://localhost:3000

## 🔐 Security
**Password Hashing:** User passwords are stored securely using BCrypt.
**JWT Authentication:** Provides secure token-based user sessions.
**Role-Based Access Control (RBAC):** Ensures only authorized users can access specific features.

## 📖 Project Structure
# Backend
- src/main/java/com.app/ - Contains controllers, services, and repository classes.
- src/main/resources/ - Configuration files and SQL scripts.

# Frontend
- FrontEnd/React/src/components/ - React components for the UI.

# 📧 Contact
- For any queries, feel free to reach out at subodhmohite3424@gmail.com.

# 🏅 Acknowledgments
- This project is part of the PG-DAC Program and aims to provide a practical solution to real-world challenges faced by temples in managing their operations efficiently.



