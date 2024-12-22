-- Database: EducationSystem
CREATE DATABASE EducationSystem;

-- Switch to the new database
\c EducationSystem;

-- Table: Users
CREATE TABLE Users (
    user_id SERIAL PRIMARY KEY,
    username VARCHAR(50) NOT NULL UNIQUE,
    password VARCHAR(50) NOT NULL,
    first_name VARCHAR(50),
    last_name VARCHAR(50),
    user_type VARCHAR(50) CHECK (user_type IN ('Admin', 'Manager', 'Dean', 'Teacher', 'Student', 'Researcher', 'TechSupportSpecialist')) NOT NULL,
    faculty VARCHAR(50) CHECK (faculty IN ('SITE', 'Business', 'Law', 'Science')),
    degree VARCHAR(50) CHECK (degree IN ('BACHELOR', 'MASTER', 'PHD')),
    gpa NUMERIC(3, 2),
    hire_date DATE,
    salary NUMERIC(10, 2),
    employee_post VARCHAR(50) CHECK (employee_post IN ('ADMIN', 'MANAGER', 'TEACHER', 'TECHSUPPORT')),
    manager_type VARCHAR(50) CHECK (manager_type IN ('DEPARTMENT', 'OR')),
    rank VARCHAR(50) CHECK (rank IN ('LECTURER', 'SENIOR_LECTURER', 'ASSISTANT_PROFESSOR', 'PROFESSOR')),
    age INT
);

-- Table: Courses
CREATE TABLE Courses (
    course_id SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    code VARCHAR(10) NOT NULL UNIQUE,
    credits INT NOT NULL,
    faculty VARCHAR(50) CHECK (faculty IN ('SITE', 'Business', 'Law', 'Science')) NOT NULL,
    course_type VARCHAR(50) CHECK (course_type IN ('BASIC', 'ELECTIVE', 'CORE')) NOT NULL
);

-- Table: Marks
CREATE TABLE Marks (
    mark_id SERIAL PRIMARY KEY,
    student_id INT NOT NULL REFERENCES Users(user_id),
    course_id INT NOT NULL REFERENCES Courses(course_id),
    attestation_type VARCHAR(50) CHECK (attestation_type IN ('FIRST', 'SECOND', 'EXAM')) NOT NULL,
    mark NUMERIC(5, 2) NOT NULL,
    gpa NUMERIC(3, 2),
    letter_grade CHAR(1)
);

-- Table: Requests
CREATE TABLE Requests (
    request_id SERIAL PRIMARY KEY,
    requester_id INT NOT NULL REFERENCES Users(user_id),
    order_type VARCHAR(50) CHECK (order_type IN ('COMPLAINT', 'FX_RETAKE')) NOT NULL,
    description TEXT,
    status VARCHAR(50) CHECK (status IN ('PENDING', 'APPROVED', 'REJECTED')) DEFAULT 'PENDING'
);

-- Table: ResearchPapers
CREATE TABLE ResearchPapers (
    paper_id SERIAL PRIMARY KEY,
    researcher_id INT NOT NULL REFERENCES Users(user_id),
    title VARCHAR(255) NOT NULL,
    published_date DATE NOT NULL,
    article_length INT NOT NULL,
    citations INT DEFAULT 0,
    publisher VARCHAR(100),
    project_title VARCHAR(255)
);

-- Table: Comments
CREATE TABLE Comments (
    comment_id SERIAL PRIMARY KEY,
    news_id INT NOT NULL REFERENCES News(news_id),
    commenter VARCHAR(50) NOT NULL,
    comment_date DATE NOT NULL,
    content TEXT NOT NULL
);

-- Table: News
CREATE TABLE News (
    news_id SERIAL PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    description TEXT NOT NULL,
    news_date DATE NOT NULL,
    news_type VARCHAR(50) CHECK (news_type IN ('PPONE', 'RES')) NOT NULL
);

-- Table: CourseRegistrations
CREATE TABLE CourseRegistrations (
    registration_id SERIAL PRIMARY KEY,
    student_id INT NOT NULL REFERENCES Users(user_id),
    course_id INT NOT NULL REFERENCES Courses(course_id),
    registration_date DATE DEFAULT CURRENT_DATE
);

-- Table: Projects
CREATE TABLE Projects (
    project_id SERIAL PRIMARY KEY,
    project_name VARCHAR(255) NOT NULL,
    participant_id INT NOT NULL REFERENCES Users(user_id)
);

-- Sample Data
INSERT INTO Users (username, password, first_name, last_name, user_type) VALUES
('admin', 'admin123', 'Admin', 'User', 'Admin'),
('manager', 'manager123', 'Manager', 'User', 'Manager'),
('student1', 'student123', 'John', 'Doe', 'Student'),
('teacher1', 'teacher123', 'Alice', 'Smith', 'Teacher');

INSERT INTO Courses (name, code, credits, faculty, course_type) VALUES
('Programming 101', 'CS101', 3, 'SITE', 'BASIC'),
('Database Systems', 'CS102', 3, 'SITE', 'CORE');

INSERT INTO News (title, description, news_date, news_type) VALUES
('LESSON POSTPONED', 'Tomorrow lessons will be postponed.', '2023-12-25', 'PPONE'),
('RESEARCH UPDATE', 'Check out the latest research updates.', '2023-12-23', 'RES');


select * from Courses