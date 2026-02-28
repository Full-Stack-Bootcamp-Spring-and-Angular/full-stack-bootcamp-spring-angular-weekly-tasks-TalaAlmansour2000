package com.myApp.entitiy;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GeneratorType;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDate;
import java.time.Period;

@Getter
@Setter
@Entity
@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(nullable = false)
    private String name;
    @Email
    private String email;

    @Column(name = "birth_date", nullable = false)
    private LocalDate birthDate;

    @Column(name = "registration_date")
    private LocalDate registrationDate;

    @Min(0)
    private double fees;

    @OneToOne(mappedBy = "student")
    private Transcript transcript;

    public Student() {}

    public Student(String name, String email, LocalDate birthDate, double fees) {
        this.name = name;
        this.email = email;
        this.birthDate = birthDate;
        this.registrationDate = LocalDate.now();
        this.fees = fees;
    }

    @Transient
    public int getAge() {
        return Period.between(birthDate, LocalDate.now()).getYears();
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", birthDate=" + birthDate +
                ", registrationDate=" + registrationDate +
                ", fees=" + fees +
                '}';
    }
}