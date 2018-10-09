package com.personTest.control;

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

public class PersonTestController {
    @FXML
    private TextField txtName,txtVorname,txtStrasse,txtHnummer,txtPLZ,txtSchule,txtLeite,txtKlassse;
    @FXML
    private Button btnPrev,btnClear,btnSave,btnUpdate,btnDelete,btnNext;
    @FXML
    private ComboBox cboxSchule;
    @FXML
    private Label lblStudentID;
    @FXML
    private TableView tblvSchule;
    @FXML
    private GridPane gridStudentList;

    private _PersonDAO persTDAO;
@FXML
    private void initialize(){

    persTDAO=new _PersonDAO();
    PersonTest prs=new PersonTest();
    Personadress personadress=new Personadress();
    PersonStudent personStudent =new PersonStudent();
    Personschule personschule=new Personschule();
    btnSave.setOnAction(new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent event) {
            try {
                String name=txtName.getText();
                personStudent.setName(name);
                String vorname=txtVorname.getText();
                personStudent.setVorname(vorname);


            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    });

}

}
