package uk.co.andymccall.m83.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.event.ActionEvent;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable{

    @FXML
    private JFXTextField usernameTextField;

    @FXML
    private JFXPasswordField passwordPasswordField;

    @FXML
    private JFXButton loginButton;

    @FXML
    private JFXButton cancelButton;

    @FXML
    public void initiateLogin(ActionEvent event) {
        String username = usernameTextField.getText();
        String password = passwordPasswordField.getText();

        System.out.println("Username: " + username + " Password: " + password);
    }

    @FXML
    public void calncelLogin(ActionEvent event) {

        System.out.println("Exiting M83");

        Platform.exit();

    }

    public JFXTextField getUsernameTextField() {
        return usernameTextField;
    }

    public void setUsernameTextField(JFXTextField usernameTextField) {
        this.usernameTextField = usernameTextField;
    }

    public JFXPasswordField getPasswordPasswordField() {
        return passwordPasswordField;
    }

    public void setPasswordPasswordField(JFXPasswordField passwordPasswordField) {
        this.passwordPasswordField = passwordPasswordField;
    }

    public JFXButton getLoginButton() {
        return loginButton;
    }

    public void setLoginButton(JFXButton loginButton) {
        this.loginButton = loginButton;
    }

    public JFXButton getCancelButton() {
        return cancelButton;
    }

    public void setCancelButton(JFXButton cancelButton) {
        this.cancelButton = cancelButton;
    }

    public void initialize(URL url, ResourceBundle rb) {

    }


}
