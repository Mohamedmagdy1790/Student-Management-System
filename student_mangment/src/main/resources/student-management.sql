DROP SCHEMA IF EXISTS `student-management`;

CREATE SCHEMA `student-management`;

use `student-management`;

SET FOREIGN_KEY_CHECKS = 0;



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





