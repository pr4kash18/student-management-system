# 🎓 Student Management System (Java + JDBC)

A console-based Student Management System built using Java, JDBC, MySQL, and DAO pattern.
This project demonstrates backend fundamentals like database connectivity, CRUD operations, and a menu-driven interface.

---

## 🚀 Features

* Add Student (Insert)
* View All Students (Read)
* Update Student Details
* Delete Student
* Menu-driven console system (runs continuously until user exits)

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
│   ├── model/
│   │   └── Student.java
│   │
│   ├── DAO/
│   │   └── StudentDAO.java
│   │
│   ├── db/
│   │   └── DBConnection.java
│   │
│   ├── config/
│   │   └── config.properties (ignored using .gitignore)
│   │
│   └── main/
│       └── Main.java
│
├── .gitignore
└── README.md
```

---

## 🧠 Key Concepts Used

* Separation of Concerns (Model, DAO, Main)
* PreparedStatement (prevents SQL injection)
* ResultSet handling
* List collection for managing multiple records
* Loop + switch-case for menu-driven system
* Clean and modular code structure

---

## 🎮 How It Works

When the program runs, it shows:

1. Add Student
2. View Students
3. Update Student
4. Delete Student
5. Exit

* The program runs in a loop
* User selects an option
* Corresponding operation is executed
* Program exits only when user selects Exit

---

## 🏁 Current Status

* CRUD operations implemented
* Menu-driven system completed
* Further improvements and features in progress

---

## 🔮 Future Improvements

* Search and filter students
* Advanced update (skip fields)
* Course and Enrollment module (many-to-many)
* Reports generation
* GUI or Web-based version (Spring Boot)

---


