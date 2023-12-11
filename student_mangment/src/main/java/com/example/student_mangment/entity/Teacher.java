package com.example.student_mangment.entity;


import javax.persistence.*;
import lombok.*;

import java.sql.Timestamp;
import java.util.List;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString


@Entity
@Table(name = "teacher")
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer teacherId;

    @Column(name = "code", unique = true, nullable = false, length = 10)
    private String code;

    @Column(name = "first_name", nullable = false, length = 50)
    private String firstName;

    @Column(name = "last_name", nullable = false, length = 50)
    private String lastName;


    @Column(name = "email", unique = true)
    private String email;

    @Column(name = "date_of_birth")
    private Timestamp dateOfBirth;

    @OneToMany(mappedBy = "teacher", fetch = FetchType.LAZY)
    private List<Course> courses;

}
