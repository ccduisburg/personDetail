package com.personTest.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;



@Entity
@Data
@Table(name = "personadrestest")
public class Personadress implements Serializable {
    @Id
    @GeneratedValue
    @Column(name="ID")
    private Integer id;
    private String strasse;
    private String PLZ;
    private Integer hnummer;


    public Personadress() {

    }


    public Personadress(Integer id, String strasse, String PLZ, Integer hnummer) {
        this.id = id;
        this.strasse = strasse;
        this.PLZ = PLZ;
        this.hnummer = hnummer;
    }
}


