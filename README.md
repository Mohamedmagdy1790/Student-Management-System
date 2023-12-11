
# Student Mangment System

## Introduction 
#### Problem
 Manually managing student, teacher, quiz, and course data for an entire semester is a tedious and error-prone process.

#### Solution
 This project develops a backend-only web application using Java Spring MVC to streamline  educational data management.

## Technologies 
1-java programming language

2-springboot framework

3- mysql for database


## Key Features
Comprehensive Management: Manage student, teacher, quiz, and course data with ease.

Powerful APIs: Create, read, update, and delete (CRUD) data through intuitive API 
endpoints.

Modular Design: Benefit from a clean architecture with separate service and controller layers.

Optional Swagger Integration: Enhance developer experience with interactive API documentation.



 ### database design 
 we have four tables 
 student ,teacher , course, quiz

 #### relationships between the tables:

Teacher and Course: One-to-Many (1:N) relationship

One teacher can teach multiple courses.
Each course is taught by only one teacher.
Student and Course: Many-to-Many (M:N) relationship

A student can enroll in multiple courses.
Each course can have multiple students.
Course and Quiz: One-to-Many (1:N) relationship

One course can have multiple quizzes.
Each quiz belongs to only one course.

database diagram:
<img src="https://github.com/Mohamedmagdy1790/Student-Management-System/blob/main/dbdiagram.png">

``` mysql script
create table student(
    student_id int primary key auto_increment,
    first_name varchar(50) not null ,
    last_name varchar(50) not null ,
    email varchar(255) unique ,
    date_of_birth DATETIME
);

-- associative entity between student and course table for many to many relationship
create table student_course(
    student_id int,
    course_id int ,
   constraint  fk_student foreign key (student_id) references student(student_id) ,
   constraint  fk_course foreign key (course_id) references course(course_id)    ,
   -- composite key
   CONSTRAINT pk_prodCat primary key (student_id,course_id)

);



create table course(
    course_id int primary key auto_increment,
    course_name varchar(50) not null ,
    teacher_id int ,
    constraint foreign key fk_teacher(teacher_id) references teacher(teacher_id)

);



create table teacher(
    teacher_id int primary key auto_increment,
    code varchar(10),
    first_name varchar(50) not null,
    last_name varchar(50) not null,
    email varchar(255) unique ,
    date_of_birth DATETIME
);


create table quiz(
    quiz_id int primary key auto_increment,
    quiz_name varchar(50),
    course_id int ,
    foreign key(course_id) REFERENCES course(course_id)
);

```

## setup
 
Clone the project

Run mysql db script

Run app with you favoraite IDE 

## API ENDPOINTS: 
 swagger: 
enter this url after you run th app 
```
http://localhost:8080/swagger-ui/index.html#/
```






