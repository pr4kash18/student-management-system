# 🎓 Student Management System (Java + MySQL)

A console-based Student Management System built using Java, JDBC, MySQL, and DAO pattern.
This project demonstrates backend fundamentals like database connectivity, CRUD operations, and a menu-driven interface.

---

## 🚀 Features
### 1. Student management

* Add Student (Insert)
* View All Students (Read)
* Update Student Details
* Delete Student

### 2. Course Management
* Add Course
* View All Courses
* Update Course
* Delete Course

### 3. Enrollment System (Many-to-Many)
* Enroll Student into Course
* View All Enrollments (using JOIN)
* Unenroll Student

### Menu-driven console system
* Main menu with submenus (Students, Courses, Enrollments)
* Runs continuously until user exits

---

## 🛠️ Tech Stack

* Java (OOP Concepts)
* JDBC
* MySQL
* DAO Pattern

---

## 📂 Project Structure

```
student-management-system/
│
├── src/
│ ├── model/
│ │ ├── Student.java
│ │ ├── Course.java
│ │ └── Enrollment.java
│ │
│ ├── DAO/
│ │ ├── StudentDAO.java
│ │ ├── CourseDAO.java
│ │ └── EnrollmentDAO.java
│ │
│ ├── db/
│ │ └── DBConnection.java
│ │
│ ├── config/
│ │ └── config.properties (ignored using .gitignore)
│ │
│ └── main/
│ └── Main.java
│
├── .gitignore
└── README.md
```

---


---

## 🧠 Key Concepts Used

* Separation of Concerns (Model, DAO, Main)
* PreparedStatement (prevents SQL injection)
* ResultSet handling
* List collection for managing multiple records
* Loop + switch-case for menu-driven system
* Clean and modular code structure
* Many-to-Many relationship handling (Students ↔ Courses)
* SQL JOIN queries

---

## 🎮 How It Works

When the program runs, it shows:

### Main Menu
1. Manage Students
2. Manage Courses
3. Manage Enrollments
4. Exit

---

### Student Menu
1. Add Student
2. View Students
3. Update Student
4. Delete Student
5. Back

---

### Course Menu
1. Add Course
2. View Courses
3. Update Course
4. Delete Course
5. Back

---

### Enrollment Menu
1. Enroll Student
2. View Enrollments
3. Unenroll Student
4. Back

---

* The program runs in a loop
* User selects an option
* Corresponding operation is executed
* Program exits only when user selects Exit

---

## 🏁 Current Status

* Student CRUD operations implemented
* Course CRUD operations implemented
* Enrollment system (many-to-many) implemented
* Menu-driven system with submenus completed

---

## 🔮 Future Improvements

* Search and filter students
* Advanced update (skip fields)
* Filter:
    - Courses by Student
    - Students by Course
* Reports generation
* GUI or Web-based version (Spring Boot)

---


---
## ⚙️ Setup Instructions

### 1️⃣ Clone the Repository
``` bash 
git clone https://github.com/pr4kash18/student-management-system.git
cd student-management-system
```
---

### 2️⃣ Setup MySQL Database
``` SQL
CREATE DATABASE student_management_system;
USE student_management_system;
```
---

### 3️⃣ Create Tables
### 1️. Student Table
``` SQL
CREATE TABLE students (
student_id INT AUTO_INCREMENT PRIMARY KEY,
student_Name VARCHAR(50),
Email_ID VARCHAR(50),
contact_no VARCHAR(20),
branch VARCHAR(20),
semester INT,
cgpa DOUBLE
);
```

### 2. Course Table
``` SQL
CREATE TABLE courses (
course_id INT AUTO_INCREMENT PRIMARY KEY,
course_name VARCHAR(50),
course_semester INT
);
```
### 3. Enrollment Table
```SQL
CREATE TABLE enrollments (
enroll_id INT AUTO_INCREMENT PRIMARY KEY,
student_id INT,
course_id INT,
FOREIGN KEY (student_id) REFERENCES students(student_id) ON DELETE CASCADE,
FOREIGN KEY (course_id) REFERENCES courses(course_id) ON DELETE CASCADE,
UNIQUE (student_id, course_id)
);
```
---

### 4️⃣ Configure Database Connection

Create file:
```
src/config/config.properties
```

### Write Url, Username and Password
```
db.url=jdbc:mysql://localhost:3306/student_management_system
db.username=root
db.password=your_password
```
---

### 5️⃣ Run the Application
```
Run Main.java
```
---

### ✅ You're Ready!

- Use menu to perform CRUD operations
- Program runs until Exit is selected

---
