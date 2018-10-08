package com.edutilos.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;


//@Entity
//@Data
//    @Table(name = "persontest")
@Getter
@Setter
@MappedSuperclass
//@Inheritance(strategy=InheritanceType.JOINED)
public class PersonTest implements Serializable {


    @Id
    @Column(name="ID")
    private Integer id;
    private String name;
    private String vorname;


    @OneToOne(cascade=CascadeType.ALL)
    private Personadress adress;




    public PersonTest() {

    }

    public PersonTest(Integer id, String name, String vorname) {
        this.id = id;
        this.name = name;
        this.vorname = vorname;

    }


    public String toString()  {
        final String separator = ",";
        StringBuilder sb = new StringBuilder();
        sb.append("PersonTest(").append(id).append(separator)
                .append(name).append(separator)
                .append(vorname).append(separator)
                .append(adress.toString()).append(")");
        return sb.toString();
    }



}