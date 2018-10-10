package com.personTest.control;

import com.edutilos.javaFX.model.Person;
import com.personTest.dao._PersonDAO;
import com.personTest.model.PersonStudent;
import com.personTest.model.PersonTest;
import com.personTest.model.Personadress;
import com.personTest.model.Personschule;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PersonTestController {
    @FXML
    private TextField txtName,txtVorname,txtStrasse,txtHnummer,txtPLZ,txtSchule,txtLeite,txtKlasse;
    @FXML
    private Button btnPrev,btnClear,btnSave,btnUpdate,btnDelete,btnNext,btnSearchByName;
    @FXML
    private ComboBox cboxSchule;
    @FXML
    private Label lblStudentID;
    @FXML
    private TableView tblvSchule;
    @FXML
    private GridPane gridStudentList;

    private _PersonDAO persTDAO;

    private List<PersonStudent> allStudent = new ArrayList<>();

    public void loadPersonStudents(List<PersonStudent> students) {
        tblvSchule.getItems().clear();
        tblvSchule.getItems().addAll(students);
    }


    private void clearField() {
        txtName.setText("");
        txtVorname.setText("");
        txtStrasse.setText("");
        txtHnummer.setText("");
        txtPLZ.setText("");
        txtSchule.setText("");
        txtLeite.setText("");
        txtKlasse.setText("");
        lblStudentID.setText("...");

    }

    private void refreshStudentList() {
        allStudent.clear();
        allStudent.addAll(persTDAO.findAll());
        tblvSchule.getItems().clear();
        tblvSchule.getItems().addAll(allStudent);
    }


    @FXML
    private void initialize() {

        persTDAO = new _PersonDAO();
        PersonTest prs = new PersonTest();
        Personadress personadress = new Personadress();
        PersonStudent personStudent = new PersonStudent();
        Personschule personschule = new Personschule();
        refreshStudentList();
        final int[] index = {0};

        btnSave.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    String name = txtName.getText();
                    personStudent.setName(name);
                    String vorname = txtVorname.getText();
                    personStudent.setVorname(vorname);
                    String strasse = txtStrasse.getText();
                    Integer klasse= Integer.parseInt(txtKlasse.getText());
                    personStudent.setKlasse(klasse);
                    personadress.setStrasse(strasse);
                    String PLZ = txtPLZ.getText();
                    personadress.setPLZ(PLZ);
                    String hnummer = txtHnummer.getText();
                    personadress.setHnummer(Integer.parseInt(hnummer));
                    personStudent.setAdress(personadress);
                    String schule = txtSchule.getText();
                    personschule.setName(schule);
                    String leiter = txtLeite.getText();
                    personschule.setLeite(leiter);
                    personStudent.setScholl(schule);
                    personStudent.setSchule(personschule);
                    personschule.setStudent(Stream.of(personStudent).collect(Collectors.toSet()));
                    persTDAO.create(personStudent);
                    allStudent.add(personStudent);
                    clearField();
                    refreshStudentList();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });



        btnPrev.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                int i = index[0];
                i--;
                if (i < 0)
                    i = allStudent.size() - 1;
                PersonStudent p = allStudent.get(i);
                lblStudentID.setText(p.getId().toString());
                txtName.setText(p.getName());
                txtVorname.setText(p.getVorname());
                txtStrasse.setText(p.getAdress().getStrasse());
                txtHnummer.setText(p.getAdress().getHnummer().toString());
                txtPLZ.setText(p.getAdress().getPLZ());
                txtSchule.setText(p.getSchule().getName());
                txtKlasse.setText(p.getKlasse().toString());
                txtLeite.setText(p.getSchule().getLeite());
                index[0] = i;

            }
        });
        btnNext.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                int i = index[0];
                i++;
                if (i >=allStudent.size())
                    i = 0;
                PersonStudent p = allStudent.get(i);
                lblStudentID.setText(p.getId().toString());
                txtName.setText(p.getName());
                txtVorname.setText(p.getVorname());
                txtStrasse.setText(p.getAdress().getStrasse());
                txtHnummer.setText(p.getAdress().getHnummer().toString());
                txtPLZ.setText(p.getAdress().getPLZ());
                txtSchule.setText(p.getSchule().getName());
                txtKlasse.setText(p.getKlasse().toString());
                txtLeite.setText(p.getSchule().getLeite());
                index[0] = i;

            }
        });

        btnClear.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                clearField();
            }
        });
        btnDelete.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                persTDAO.delete(Integer.parseInt(lblStudentID.getText()));
//                allStudent.removeIf(personStudent1 -> lblStudentID.getText().equals(personStudent1.getId()));
                allStudent.clear();
                allStudent.addAll(persTDAO.findAll());
                clearField();
                refreshStudentList();
            }
        });

        btnSearchByName.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                String name = txtName.getText();

                PersonStudent p = (PersonStudent) persTDAO.findByName(name);

                lblStudentID.setText(p.getId().toString());
                txtName.setText(p.getName());
                txtVorname.setText(p.getVorname());
                txtStrasse.setText(p.getAdress().getStrasse());
                txtHnummer.setText(p.getAdress().getHnummer().toString());
                txtPLZ.setText(p.getAdress().getPLZ());
                txtSchule.setText(p.getSchule().getName());
                txtKlasse.setText(p.getKlasse().toString());
                txtLeite.setText(p.getSchule().getLeite());

            }
        });

        btnUpdate.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                Integer ID = Integer.parseInt(lblStudentID.getText());

                try {
                    PersonStudent personStudent = new PersonStudent();
                    String name = txtName.getText();
                    personStudent.setName(name);
                    String vorname = txtVorname.getText();
                    personStudent.setVorname(vorname);
                    String strasse = txtStrasse.getText();
                    personadress.setStrasse(strasse);
                    String PLZ = txtPLZ.getText();
                    personadress.setPLZ(PLZ);
                    String hnummer = txtHnummer.getText();
                    personadress.setHnummer(Integer.parseInt(hnummer));
                    personStudent.setAdress(personadress);
                    String schule = txtSchule.getText();
                    personschule.setName(schule);
                    String leiter = txtLeite.getText();
                    personschule.setLeite(leiter);
                    personStudent.setScholl(schule);
                    personStudent.setSchule(personschule);
                    persTDAO.update(ID, personStudent);
//                    allStudent.set(ID,personStudent);
                    clearField();
                    refreshStudentList();
                } catch (Exception e) {
                    e.printStackTrace();
                }


            }
        });

    }
}
