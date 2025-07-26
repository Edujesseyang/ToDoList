package com.Launch;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class LoginStage extends Stage {
    public static void show(Stage stage) {
        // define elements
        Label text = new Label("Enter your user name and password:");

        TextField username = new TextField();
        username.setPromptText("Enter username");

        PasswordField password = new PasswordField();
        password.setPromptText("Enter password");


        Button loginBtn = new Button("login");
        Button signUpBtn = new Button("sign up");

        // layouts
        HBox buttonsLayout = new HBox(loginBtn, signUpBtn);
        buttonsLayout.setSpacing(10);
        buttonsLayout.setAlignment(Pos.CENTER);

        VBox sceneLayout = new VBox(text, username, password, buttonsLayout);
        sceneLayout.setSpacing(10);
        sceneLayout.setPadding(new Insets(30, 50, 30, 50));
        sceneLayout.setAlignment(Pos.CENTER);

        // create scene
        Scene scene = new Scene(sceneLayout, 350, 200);
        stage.setScene(scene);
        stage.setTitle("Login");
        stage.show();

        // button actions
        signUpBtn.setOnAction(e -> {
            Stage signupStage = new Stage();
            SignUpStage.show(signupStage);
        });


    }
}
