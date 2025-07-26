package com.Launch.Stages;

import com.Launch.Model.Tool;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class SignUpStage extends Stage {
    public static void show(Stage stage) {
        // account info subtitle
        Label promptAccountInfo = new Label("Account Information");
        promptAccountInfo.setAlignment(Pos.CENTER);
        Separator sepLine = new Separator(Orientation.HORIZONTAL);
        sepLine.setPrefWidth(400);

        // username/password
        Label promptUsername = new Label("Enter your username:");
        TextField username = new TextField();
        Label promptPassword = new Label("Enter your password:");
        PasswordField password = new PasswordField();
        Label promptPassword2 = new Label("Confirm your password:");
        PasswordField confirmPassword = new PasswordField();

        // user info title
        Label promptUserInfo = new Label("User Information");
        promptUserInfo.setAlignment(Pos.CENTER);
        Separator sepLine2 = new Separator(Orientation.HORIZONTAL);
        sepLine2.setPrefWidth(400);

        // name
        Label promptName = new Label("Enter your name:");
        TextField name = new TextField();

        // dayOfBirth
        Label promptBirthDay = new Label("Choose your date of birth:");
        ComboBox<Integer> yearOfBirth = new ComboBox<>();
        yearOfBirth.getItems().addAll(2025, 2024, 2023, 2022, 2021, 2020, 2019, 2018, 2017, 2016, 2015, 2014, 2013, 2012, 2011, 2010, 2009, 2008, 2007, 2006, 2005, 2004, 2003, 2002, 2001, 2000, 1999, 1998, 1997, 1996, 1995, 1994, 1993, 1992, 1991, 1990, 1989, 1988, 1987, 1986, 1985, 1984, 1983, 1982, 1981, 1980, 1979, 1978, 1977, 1976, 1975, 1974, 1973, 1972, 1971, 1970, 1969, 1968, 1967, 1966, 1965, 1964, 1963, 1962, 1961, 1960, 1959, 1958, 1957, 1956, 1955, 1954, 1953, 1952, 1951, 1950, 1949, 1948, 1947, 1946, 1945, 1944, 1943, 1942, 1941, 1940, 1939, 1938, 1937, 1936, 1935, 1934, 1933, 1932, 1931, 1930, 1929, 1928, 1927, 1926, 1925);
        ComboBox<Integer> monthOfBirth = new ComboBox<>();
        monthOfBirth.getItems().addAll(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12);
        ComboBox<Integer> dayOfBirth = new ComboBox<>();
        dayOfBirth.getItems().addAll(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31);

        yearOfBirth.setPromptText("Year");
        monthOfBirth.setPromptText("Month");
        dayOfBirth.setPromptText("Day");

        // email/home Address
        Label promptEmail = new Label("Enter your email:");
        TextField email = new TextField();

        Label promptHomeAddress = new Label("Enter home address:");
        TextField homeAddress = new TextField();

        // phone number
        Label promptPhone = new Label("Enter your phone number:");
        TextField phone1 = new TextField();
        TextField phone2 = new TextField();
        TextField phone3 = new TextField();
        phone1.setPromptText("---");
        phone2.setPromptText("---");
        phone3.setPromptText("----");
        phone1.setMaxWidth(35);
        phone2.setMaxWidth(35);
        phone3.setMaxWidth(45);

        // buttons
        Button confirm = new Button("Confirm");
        confirm.setPadding(new Insets(10));
        Button cancel = new Button("Cancel");
        cancel.setPadding(new Insets(10));

        // layouts
        HBox phoneLayout = new HBox(phone1, phone2, phone3);
        HBox birthDayDrop = new HBox(monthOfBirth, dayOfBirth, yearOfBirth);
        HBox btnLayout = new HBox(confirm, cancel);

        VBox accountInfoLayout = new VBox(promptAccountInfo, sepLine, promptUsername, username, promptPassword, password, promptPassword2, confirmPassword);
        VBox userInfoLayout = new VBox(promptUserInfo, sepLine2, promptName, name, promptBirthDay, birthDayDrop, promptEmail, email, promptHomeAddress, homeAddress, promptPhone, phoneLayout);

        // padding
        accountInfoLayout.setPadding(new Insets(10));
        userInfoLayout.setPadding(new Insets(10));
        btnLayout.setPadding(new Insets(10));
        btnLayout.setAlignment(Pos.CENTER);

        // main scene layout
        VBox sceneLayout = new VBox(accountInfoLayout, userInfoLayout, btnLayout);
        sceneLayout.setPadding(new Insets(20));

        // set spacing
        accountInfoLayout.setSpacing(10);
        userInfoLayout.setSpacing(10);
        phoneLayout.setSpacing(5);
        birthDayDrop.setSpacing(5);
        btnLayout.setSpacing(20);


        // show scene
        Scene scene = new Scene(sceneLayout, 600, 700);
        stage.setScene(scene);
        stage.setTitle("New User Sign up");
        stage.show();

        // btn action
        cancel.setOnAction(e -> stage.close());
        confirm.setOnAction(e -> {
            String passwordStr = password.getText();
            String confirmPasswordStr = confirmPassword.getText();
            if (!Tool.passwordValidCheck(passwordStr, confirmPasswordStr)) {
                popPasswordWarning();
            }
        });
    }

    public static void popPasswordWarning() {
        Alert passwordNotMatchAlert = new Alert(Alert.AlertType.WARNING);
        passwordNotMatchAlert.setTitle("Password Confirmation Error");
        passwordNotMatchAlert.setHeaderText("Invalid Password");
        passwordNotMatchAlert.setContentText("Password must contain at least 8 characters.\nIt must contains 2 uppercase, 2 lowercase, and 2 numbers. \nIt should not contains \", < . > ? / : ; \" ' | \\ ~ `\".");
        passwordNotMatchAlert.showAndWait();
    }
}
