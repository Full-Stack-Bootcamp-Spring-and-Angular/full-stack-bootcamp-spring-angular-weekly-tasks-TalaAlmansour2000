package com.myApp.entitiy;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "transcript")
@Getter@Setter
public class Transcript {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double gpa;

    private String year;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "student_id", unique = true)
    private Student student;

    public Transcript() {}

    public Transcript(Student student, double gpa, String year) {
        this.student = student;
        this.gpa = gpa;
        this.year = year;
    }

    @Override
    public String toString() {
        return "Transcript{" +
                "id=" + id +
                ", gpa=" + gpa +
                ", year='" + year + '\'' +
                '}';
    }
}