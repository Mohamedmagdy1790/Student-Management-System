INSERT INTO student (first_name, last_name, email, date_of_birth)
VALUES ('John', 'Doe', 'johndoe@example.com', '1990-01-01');

INSERT INTO student (first_name, last_name, email, date_of_birth)
VALUES ('Jane', 'Smith', 'janesmith@example.com', '1992-05-15');



INSERT INTO course (course_name, teacher_id)
VALUES ('Mathematics', 1);

INSERT INTO course (course_name, teacher_id)
VALUES ('Physics', 2);


INSERT INTO teacher (code, first_name, last_name, email, date_of_birth)
VALUES ('T001', 'John', 'Doe', 'johndoe@example.com', '1975-03-10');

INSERT INTO teacher (code, first_name, last_name, email, date_of_birth)
VALUES ('T002', 'Jane', 'Smith', 'janesmith@example.com', '1982-09-22');


INSERT INTO quiz (quiz_name, course_id)
VALUES ('Quiz 1', 1);

INSERT INTO quiz (quiz_name, course_id)
VALUES ('Quiz 1', 2);

INSERT INTO quiz (quiz_name, course_id)
VALUES ('Quiz 2', 2);


select * from student;

select * from student_course;
insert into student_course(student_id, course_id) values(2,1);
insert into student_course(student_id, course_id) values(1,2);


