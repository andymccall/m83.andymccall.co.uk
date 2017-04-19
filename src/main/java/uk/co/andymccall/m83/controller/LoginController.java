package uk.co.andymccall.m83.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;

import javafx.animation.FadeTransition;
import javafx.animation.SequentialTransition;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.util.Duration;

import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {

    @FXML
    private JFXTextField usernameTextField;

    @FXML
    private JFXPasswordField passwordPasswordField;

    @FXML
    private JFXButton loginButton;

    @FXML
    private JFXButton cancelButton;

    @FXML
    private Label messageLabel;

    private int loginAttempts;

    @FXML
    public void initiateLogin(ActionEvent event) {

        String username = usernameTextField.getText();
        String password = passwordPasswordField.getText();

        setLoginAttempts(getLoginAttempts() + 1);

        if (username.contentEquals("username") & (password.contentEquals("password"))) {
            System.out.println("Username: " + username + " Password: " + password);
            System.out.println("Login correct!");
        } else {

            if (getLoginAttempts() >= 3) {
                System.out.println("Account locked out");
            }

            getMessageLabel().setText("Incorrect username or password");
            getMessageLabel().setVisible(true);

            FadeTransition fade = new FadeTransition(Duration.seconds(3), getMessageLabel());
            fade.setFromValue(1);
            fade.setToValue(0);
            SequentialTransition fadeMessage = new SequentialTransition(fade);
            fadeMessage.play();
            fade.setOnFinished(fadeEvent -> getMessageLabel().setVisible(false));

        }

    }

    @FXML
    public void cancelLogin(ActionEvent event) {

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

    public Label getMessageLabel() {
        return messageLabel;
    }

    public void setMessageLabel(Label messageLabel) {
        this.messageLabel = messageLabel;
    }

    public int getLoginAttempts() {
        return loginAttempts;
    }

    public void setLoginAttempts(int loginAttempts) {
        this.loginAttempts = loginAttempts;
    }

    public void initialize(URL url, ResourceBundle rb) {

        getMessageLabel().setVisible(false);
        getLoginButton().setDefaultButton(true);
        setLoginAttempts(0);

    }


}
