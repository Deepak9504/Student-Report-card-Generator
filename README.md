# Student Report Card Generator
## Project Overview
The *Student Report Card Generator* is a Java application designed to automate the process of creating student report cards. It takes student details and marks as input, calculates the total, average, and assigns grades based on performance. This project demonstrates basic Java concepts like classes, arrays, and conditional logic.

## Features
- *Input Student Details*: Enter the student's name and roll number.
- *Marks Entry*: Input marks for 5 subjects (out of 100).
- *Calculations*: Automatically calculates total marks, average, and assigns a grade.
- *Report Card Display*: Generates a formatted report card with all details.

## Class Design
- *Class: Student*
  - *Fields*: name, rollNo, marks[]
  - *Methods*: 
    - calculateTotal(): Calculates the total marks.
    - calculateAverage(): Computes the average of the marks.
    - calculateGrade(): Assigns a grade based on the average.
    - displayReport(): Displays the report card.
 # Project Structure
report-card-generator/
│
├── src/
│   ├── Main.java                
│   ├── Student.java           
│   ├── ReportService.java      
│   └── DatabaseHandler.java   
│
├── lib/                       
│
├── sql/
│   ├── setup.sql              
│   └── data.sql                
│
└── README.md            
# MySQL Setup for Report Card System

sql
-- Create students table
CREATE TABLE students (
    id INT AUTO_INCREMENT PRIMARY KEY,
    roll_no VARCHAR(20) UNIQUE NOT NULL,
    name VARCHAR(100) NOT NULL
);

-- Create subjects table
CREATE TABLE subjects (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50) NOT NULL
);

-- Create marks table
CREATE TABLE marks (
    id INT AUTO_INCREMENT PRIMARY KEY,
    student_id INT NOT NULL,
    subject_id INT NOT NULL,
    score DECIMAL(5,2) CHECK (score BETWEEN 0 AND 100),
    FOREIGN KEY (student_id) REFERENCES students(id),
    FOREIGN KEY (subject_id) REFERENCES subjects(id)
);


## Software Requirements
- *Java Development Kit (JDK)*
- *Java Runtime Environment (JRE)*
- *Code Editor* (e.g., IntelliJ IDEA, Eclipse, VS Code)
- *Operating System*: Windows, macOS, or Linux

## How to Run
1. Ensure you have JDK installed on your system.
2. Clone this repository or download the source code.
3. Compile the Java file:
   bash
   javac ReportCard.java
   
4. Run the compiled program:
   bash
   java ReportCard
   

## Contributors
- *Krrish Verma* (Group Leader) - Admission Number: 24SCSE1010880
- *Deepak Kumar* - Admission Number: 24SCSE1011037
- *Wahid Wasim* - Admission Number: 24SCSE1011320
- *Kartikey Bharadwaj* - Admission Number: 24SCSE1010805

## Conclusion
This project efficiently demonstrates the use of object-oriented programming in Java to create a functional student report card generator. It highlights key concepts like classes, methods, arrays, and conditional logic.
