package com.personTest.model;


import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Data
@Table(name = "personschule")
public class Personschule implements Serializable {
    @Id
    @GeneratedValue
    @Column(name="ID")
    private Integer id;
    private String name;
    private String leite;

    public Personschule(String name, String leite, Set<PersonStudent> student) {
        this.name = name;
        this.leite = leite;
        this.student = student;
    }

    public Personschule(String name, String leite) {
        this.name = name;
        this.leite = leite;
    }

    public Personschule() {
    }

    @OneToMany
    private Set<PersonStudent> student;
//    @OneToOne
//    private PersonStudent student;

}

