package com.example.student_mangment.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import javax.persistence.*;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString

@Entity
@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer studentId;

    @Column(name = "first_name", nullable = false, length = 50)
    private String firstName;
    @Column(name = "last_name", nullable = false, length = 50)
    private String lastName;

    @Column(name = "date_of_birth")
    private Timestamp dateOfBirth;


    @Column(name = "email", unique = true)
    private String email;

    @ManyToMany(mappedBy = "students", fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    @JsonIgnore
    private List<Course> courses = new ArrayList<>();


    // method for adding new course
    // also adding this new  student to this course
    public void addCourse(Course course) {
        if (!this.courses.contains(course)) {
            courses.add(course);
            course.getStudents().add(this);
        }
    }

    //  method for removing  course from list of courses that student enrolled in
    //  also remove all students associated with  this course
    public void removeCourse(Course course) {
        if (this.courses.contains(course)) {
            courses.remove(course);
            course.getStudents().add(null);
        }
    }

}





