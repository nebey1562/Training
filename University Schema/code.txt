CREATE TABLE Advisors (
    advisor_id INT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    specialization VARCHAR(100) NOT NULL
);

CREATE TABLE Students (
    student_id INT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    date_of_birth DATE NOT NULL,
    advisor_id INT,
    FOREIGN KEY (advisor_id) REFERENCES Advisors(advisor_id) ON DELETE SET NULL
);

CREATE TABLE Courses (
    course_code VARCHAR(10) PRIMARY KEY,
    title VARCHAR(100) NOT NULL,
    description TEXT,
    instructor VARCHAR(100) NOT NULL
);

CREATE TABLE Enrollments (
    student_id INT,
    course_code VARCHAR(10),
    PRIMARY KEY (student_id, course_code),
    FOREIGN KEY (student_id) REFERENCES Students(student_id) ON DELETE CASCADE,
    FOREIGN KEY (course_code) REFERENCES Courses(course_code) ON DELETE CASCADE
);
