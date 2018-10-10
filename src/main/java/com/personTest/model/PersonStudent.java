package com.personTest.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "personstudent")
public class PersonStudent extends PersonTest {
    @Column
    private String scholl;
    @Column
    private Integer klasse;

    @ManyToOne (cascade = CascadeType.ALL)
    private Personschule schule;

    public PersonStudent(String name, String vorname, String scholl, Integer klasse, Personschule schule) {
        super(name, vorname);
        this.scholl = scholl;
        this.klasse = klasse;
        this.schule = schule;
    }

    public PersonStudent(String name, String vorname, String scholl, Integer klasse) {
        super(name, vorname);
        this.scholl = scholl;
        this.klasse = klasse;
    }

    public PersonStudent() {
    }

    @Override
    public String toString() {
        final String separator = ",";
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString()).append("    ");
        sb.append("PersonStudent(").append(scholl).append(separator)
                .append(klasse).append(separator)
                .append(schule.getName()).append(")");
        return sb.toString();
    }

}
