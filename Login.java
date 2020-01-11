package sample;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Login extends Application {

    private MainMenu mainMenu;

    private static String textUsername, textPassword;

    public static String getTextUsername() {
        return textUsername;
    }

    public static String getTextPassword() {
        return textPassword;
    }

    @Override
    public void start(Stage stage) {
        GridPane root = new GridPane();
        root.setAlignment(Pos.CENTER);
        root.setVgap(10);
        root.setHgap(10);
        root.setPadding(new Insets(25, 25, 25, 25));
        root.setStyle("-fx-background-color: #002233;");

        Text sceneTitle = new Text("LOGIN");
        sceneTitle.setFont(Font.font("Verdana", 20));
        sceneTitle.setFill(Color.rgb(0, 153, 122));
        root.add(sceneTitle, 0, 0, 2, 1);

        Label lblUsername = new Label("Username :");
        lblUsername.setFont(Font.font("Verdana", 14));
        lblUsername.setTextFill(Color.rgb(153, 223, 255));
        root.add(lblUsername, 0, 1);

        TextField usernameField = new TextField();
        root.add(usernameField, 1, 1);

        Label lblPassword = new Label("Password :");
        lblPassword.setFont(Font.font("Verdana", 14));
        lblPassword.setTextFill(Color.rgb(153, 223, 255));
        root.add(lblPassword, 0, 2);

        PasswordField passwordField = new PasswordField();
        root.add(passwordField, 1, 2);

        final Text actionText = new Text();
        root.add(actionText, 1, 6);

        final Hyperlink goToRegister = new Hyperlink("Click to Register");
        root.add(goToRegister, 0, 7);

        goToRegister.setOnAction(event -> {
            Register register = new Register();
            register.start(stage);
        });

        Button btn = new Button("Sign In");
        HBox hBoxBtn = new HBox(10);
        hBoxBtn.setAlignment(Pos.BOTTOM_CENTER);
        hBoxBtn.getChildren().add(btn);
        root.add(hBoxBtn, 1, 4);

        btn.setOnAction(event -> {
            textUsername = usernameField.getText();
            textPassword = passwordField.getText();
            actionText.setFill(Color.WHITE);
            if (usernameField.getText().isEmpty() || passwordField.getText().isEmpty()) {
                actionText.setFill(Color.RED);
                actionText.setText("Please Enter Username and Password !");
            }
            else if (DBController.isValid()) {
                actionText.setText("Login is Successful");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                mainMenu = new MainMenu();
                mainMenu.usernameTitle();
                mainMenu.start(stage);
            }
            else {
                actionText.setFill(Color.RED);
                actionText.setText("Invalid Username or Password !");
            }
        });

        stage.setTitle("Login");
        stage.setScene(new Scene(root, 450, 500));
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
        System.out.println(Login.getTextUsername() + " " + Login.getTextPassword());
        System.out.println(DBController.isValid());
    }
}