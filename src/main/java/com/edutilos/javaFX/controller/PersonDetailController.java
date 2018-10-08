package com.edutilos.javaFX.controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class PersonDetailController {
    @FXML
    private TextField tfID, tfName, tfAge,tfWage;
    @FXML
    private Button btnPrint, btnClear;
    @FXML
    private void initialize() {

        btnPrint.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try{
                   Long ID= Long.parseLong(tfID.getText());
                    String name= tfName.getText();
                    Integer age=Integer.parseInt(tfAge.getText());
                    Double wage=Double.parseDouble(tfWage.getText());
                    System.out.println(ID +" "+name+" "+ age+" "+wage);
                }catch(Exception ex){
                    ex.printStackTrace();

                }

            }
        });

        btnClear.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                tfID.setText("");
                tfName.setText("");
                tfAge.setText("");
                tfWage.setText("");
            }
        });

    }

}
