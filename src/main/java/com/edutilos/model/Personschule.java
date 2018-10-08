package com.edutilos.model;


import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Data
@Table(name = "personschule")
public class Personschule implements Serializable {
    @Id
    @Column(name="ID")
    private Integer id;
    private String name;
    private String leite;

    @OneToMany(cascade = CascadeType.ALL)
    private Set<PersonStudent> student;
//    @OneToOne
//    private PersonStudent student;

}

