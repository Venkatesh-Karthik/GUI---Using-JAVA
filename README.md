# GUI---Using-JAVA

# Complaint Management System (Java Swing)

## 📌 Project Overview
The **Complaint Management System** is a Java-based desktop application developed using **Java Swing**.  
It allows users to register complaints, view existing complaints, and resolve them.  
All complaint data is stored locally using **file handling**, making the system lightweight and offline-friendly.

This project demonstrates **Core Java**, **Object-Oriented Programming**, **GUI development**,  
**Exception Handling**, and **File I/O operations**.

---

## 🎯 Objectives
- To provide a simple and user-friendly system for managing complaints
- To apply core Java and OOP concepts in a real-world use case
- To implement file-based data persistence
- To design an interactive GUI using Java Swing

---

## 🛠 Technologies Used
- Java
- Java Swing (GUI)
- File I/O (FileReader, FileWriter, BufferedReader)
- OOP Concepts
- Exception Handling
- Git & GitHub

---

## 📂 Project Structure
```
ComplaintManagement/
│
├── model/
│   └── Complaint.java
│
├── util/
│   └── FileUtil.java
│
├── ui/
│   └── ComplaintApp.java
│
├── complaints.txt
└── README.md
```

---

## ⚙️ Features
- Register a new complaint
- Auto-generate complaint ID
- View all complaints
- Resolve complaints
- File-based storage (no database required)
- Simple and scalable GUI

---

## 🧩 OOP Concepts Used
- **Encapsulation** – Private variables with getters/setters
- **Classes & Objects** – Complaint modeled as a class
- **Inheritance** – JFrame inheritance for GUI
- **Polymorphism** – Method overriding (`toString()`)

---

## 🖥️ How to Run the Project

### Step 1: Clone the Repository
```
git clone https://github.com/<your-username>/GUI---Using-JAVA.git
```

### Step 2: Open the Project
Open the project folder in any Java IDE  
(VS Code / IntelliJ IDEA / Eclipse).

### Step 3: Compile the Program
```
javac ui/ComplaintApp.java
```

### Step 4: Run the Application
```
java ui.ComplaintApp
```

---

## 🧪 Sample Output
- Complaint submitted successfully
- Complaint list displayed with ID, name, issue, and status
- Complaint status updated to "Resolved"

---

## 🚀 Future Enhancements
- Add user authentication (Admin/User)
- Replace file storage with a database
- Add complaint categories and priority
- Use JTable for better data visualization
- Add search and filter options

---

## 👨‍💻 Author
**Venkatesh Karthik**

---

## 📜 License
This project is developed for **educational purposes** as part of a Java academic curriculum.
