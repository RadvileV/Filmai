package com.example.filmai.controller;

import com.example.filmai.MainApplication;
import com.example.filmai.utils.Validation;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.event.ActionEvent;

import java.io.IOException;
import java.util.EventObject;

public class RegisterController {
    @FXML
    private Label registrationStatus;
    @FXML
    private TextField regUsername;
    @FXML
    private PasswordField regPassword;
    @FXML
    private TextField regEmail;
    @FXML
    private Button regRegister;
    private Stage stage;
    private Parent root;
    private Scene scene;

    @FXML
    public void onRegisterButtonForRegistration(ActionEvent event) throws IOException {
        String regUsername2 = regUsername.getText();
        String regPassword2 = regPassword.getText();
        String regEmail2 = regEmail.getText();
        if (Validation.isValidUsername(regUsername2) && (Validation.isValidPassword(regPassword2) && (Validation.isValidEmail(regEmail2)))) {
            Parent root = FXMLLoader.load(MainApplication.class.getResource("login-view.fxml"));
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } else if (Validation.isValidUsername(regUsername2) && (Validation.isValidPassword(regPassword2))) {
            registrationStatus.setText("Klaida vedant el. paštą.");
        } else if (Validation.isValidPassword(regPassword2) && Validation.isValidEmail(regEmail2)) {
            registrationStatus.setText("Klaida vedant prisijungimo vardą, jį sudaryti gali tik didžiosios/mažosios raidės ir skaičiai, ilgis 5-13 simbolių.");
        } else if (Validation.isValidUsername(regUsername2) && Validation.isValidEmail(regEmail2)){
            registrationStatus.setText("Klaida vedant slaptažodį, jį sudaryti gali tik didžiosios/mažosios raidės, skaičiai ir ženklai !@#$%, ilgis 5-13 simbolių.");
        } else if (Validation.isValidUsername(regUsername2)) {
            registrationStatus.setText("Klaida vedant slaptažodį ir el. paštą. Slaptažodį sudaryti gali tik didžiosios/mažosios raidės, skaičiai ir ženklai !@#$%, ilgis 5-13 simbolių.");
        } else if (Validation.isValidPassword(regPassword2)) {
            registrationStatus.setText("Klaida vedant prisijungimo vardą ir el. paštą. Prisijungimo vardą sudaryti gali tik didžiosios/mažosios raidės ir skaičiai, ilgis 5-13 simbolių.");
        } else if (Validation.isValidEmail(regEmail2)) {
            registrationStatus.setText("Klaida vedant prisijungimo vardą ir slaptažodį. Vardui naudojama tik didžiosios/mažosios raidės ir skaičiai, ilgis 5-13 simbolių. Slaptažodžiui " +
                    "naudojama tik didžiosios/mažosios raidės, skaičiai ir ženklai !@#$%, ilgis 5-13 simbolių.");
        } else {
            registrationStatus.setText("Blogai įvesti visi duomenys.");
        }
    }
}
