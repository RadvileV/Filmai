package com.example.filmai.controller;

import com.example.filmai.MainApplication;
import com.example.filmai.utils.Validation;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginController {
    @FXML
    private Label loginStatus;
    @FXML
    private TextField loginUsername;
    @FXML
    private PasswordField loginPassword;

    @FXML
    public void onLoginButtonClick() {
        String username2 = loginUsername.getText();
        String password2 = loginPassword.getText();
        if (Validation.isValidUsername(username2)&&(Validation.isValidPassword(password2))) {
            loginStatus.setText("Teisingai įvestas prisijungimo vardas ir slaptažodis");
        } else {
            loginStatus.setText("Klaidingai įvestas prisijungimo vardas arba slaptažodis");
        }
    }

    @FXML
    public void onRegisterButtonClick(ActionEvent event) throws IOException {
        //Vaizdo užkrovimas
        Parent root = FXMLLoader.load(MainApplication.class.getResource("register-view.fxml"));
        Stage registerStage = new Stage();
        //Stage (langas) bus vienas, scenų gali būti daug
        registerStage.setTitle("Registracijos langas");
        registerStage.setScene(new Scene(root, 600, 400));
        //Parodymas lango
        registerStage.show();
        //Kodas reikalingas paslėpti prieš tai buvusį langą
        ((Node) (event.getSource())).getScene().getWindow().hide();
    }
}