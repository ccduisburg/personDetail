package com.edutilos.model;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@Table(name = "personstudent")
public class PersonStudent extends PersonTest {
    @Column
    private String scholl;
    @Column
    private Integer klasse;

    @ManyToOne
    private Personschule schule;

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
