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
│   ├── Main.java                # Entry point
│   ├── Student.java             # Student model
│   ├── ReportService.java       # Business logic
│   └── DatabaseHandler.java     # DB operations
│
├── lib/                        # External libraries
│
├── sql/
│   ├── setup.sql               # Database creation
│   └── data.sql                # Sample data
│
└── README.md                   # Project documentation


# MySQL Database Setup for Student Report Card System

## Database Tables

### 1. Students Table
sql
CREATE TABLE students (
    student_id INT AUTO_INCREMENT PRIMARY KEY,
    roll_number VARCHAR(20) UNIQUE NOT NULL,
    full_name VARCHAR(100) NOT NULL,
    class VARCHAR(20),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);


### 2. Subjects Table
sql
CREATE TABLE subjects (
    subject_id INT AUTO_INCREMENT PRIMARY KEY,
    subject_name VARCHAR(50) NOT NULL,
    subject_code VARCHAR(10) UNIQUE
);


### 3. Marks Table
sql
CREATE TABLE marks (
    mark_id INT AUTO_INCREMENT PRIMARY KEY,
    student_id INT NOT NULL,
    subject_id INT NOT NULL,
    marks_obtained DECIMAL(5,2) NOT NULL,
    exam_term VARCHAR(20) NOT NULL,
    academic_year VARCHAR(9) NOT NULL,
    FOREIGN KEY (student_id) REFERENCES students(student_id),
    FOREIGN KEY (subject_id) REFERENCES subjects(subject_id)
);


## Sample Data Insertion

### Insert Sample Subjects
sql
INSERT INTO subjects (subject_name, subject_code) VALUES
('Mathematics', 'MATH101'),
('Physics', 'PHY101'),
('Chemistry', 'CHEM101'),
('English', 'ENG101'),
('Computer Science', 'CS101');


### Insert Sample Students
sql
INSERT INTO students (roll_number, full_name, class) VALUES
('STU001', 'Krrish Verma', '12A'),
('STU002', 'Deepak Kumar', '12B'),
('STU003', 'Wahid Wasim', '12A');


### Insert Sample Marks
sql
INSERT INTO marks (student_id, subject_id, marks_obtained, exam_term, academic_year) VALUES
(1, 1, 85.5, 'Mid-Term', '2024-2025'),
(1, 2, 92.0, 'Mid-Term', '2024-2025'),
(2, 1, 78.0, 'Mid-Term', '2024-2025'),
(3, 5, 95.5, 'Mid-Term', '2024-2025');


## Useful Queries

### Get Student Report Card
sql
SELECT s.full_name, s.roll_number, sub.subject_name, m.marks_obtained
FROM marks m
JOIN students s ON m.student_id = s.student_id
JOIN subjects sub ON m.subject_id = sub.subject_id
WHERE s.roll_number = 'STU001' 
AND m.exam_term = 'Mid-Term' 
AND m.academic_year = '2023-2024';


### Calculate Total Marks and Average
sql
SELECT 
    s.full_name,
    SUM(m.marks_obtained) AS total_marks,
    AVG(m.marks_obtained) AS average_marks,
    COUNT(*) AS subjects_count
FROM marks m
JOIN students s ON m.student_id = s.student_id
WHERE s.roll_number = 'STU001'
AND m.exam_term = 'Mid-Term'
AND m.academic_year = '2023-2024';

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
