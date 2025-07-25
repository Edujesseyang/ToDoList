package com.Launch;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) {
        // title
        primaryStage.setTitle("Say Hello");

        // mainScene
        Label label = new Label("Enter your name: ");
        TextField nameField = new TextField();
        Button enterButton = new Button("Enter");
        Label outputLabel = new Label();

        // layout (mainScene)
        VBox layout = new VBox(20);
        layout.getChildren().addAll(label, nameField, enterButton);

        Scene mainScene = new Scene(layout, 550, 300);
        primaryStage.setScene(mainScene);

        // outPut scene
        Button backButton = new Button("Back");
        VBox outputLayout = new VBox(20);
        outputLayout.getChildren().addAll(outputLabel, backButton);
        Scene outputScene = new Scene(outputLayout, 550, 300);


        // button actions
        enterButton.setOnAction(e -> {
            String name = nameField.getText();
            if (name.isBlank()) {
                outputLabel.setText("Who are you again?");
                primaryStage.setScene(outputScene);
            } else {
                outputLabel.setText("Hello, " + name + "!");
                primaryStage.setScene(outputScene);
            }
        });

        backButton.setOnAction(e -> {
            primaryStage.setScene(mainScene);
        });


        // show stage
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
