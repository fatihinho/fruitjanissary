package sample;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.InputStream;

public class MainMenu extends Application {

    private Text username = new Text();
    private Leaderboard lb = new Leaderboard();
    private User user = new User();
    private Game game = new Game();
    private Register register = new Register();
    private Login login = new Login();

    public void usernameTitle() {
        username.setText("Welcome, " + user.getUsername());
        username.setFill(Color.BLUE);
        username.setFont(new Font(14));
        username.setX(450);
        username.setY(25);
    }

    @Override
    public void start(Stage stage) {
        Pane root = new Pane();

        InputStream inStream = getClass().getResourceAsStream("img/janissary.png");
        Image imageObject = new Image(inStream);
        ImageView image = new ImageView(imageObject);

        Button newGameButton = new Button("New Game");
        Button leaderboard = new Button("Leaderboard");
        Button quitButton = new Button("Quit");
        newGameButton.setFocusTraversable(false);
        leaderboard.setFocusTraversable(false);
        quitButton.setFocusTraversable(false);

        final Text actionText = new Text();
        actionText.setFill(Color.DARKRED);
        actionText.setX(80);
        actionText.setY(20);

        newGameButton.setOnAction(event -> {
            if (!(user.getUsername() == null))
                game.start(stage);
            else
                actionText.setText("You must login or register");
        });
        leaderboard.setOnAction(event -> lb.start(stage));
        quitButton.setOnAction(event -> Platform.exit());

        final Hyperlink sign_up = new Hyperlink("Sign Up");
        sign_up.setTextFill(Color.WHITE);
        sign_up.setFocusTraversable(false);
        final Hyperlink sign_in = new Hyperlink("Sign In");
        sign_in.setTextFill(Color.WHITE);
        sign_in.setFocusTraversable(false);

        sign_up.setOnAction(event -> register.start(stage));
        sign_in.setOnAction(event -> login.start(stage));

        VBox menuButtons = new VBox();
        menuButtons.getChildren().addAll(newGameButton, leaderboard, quitButton, sign_up, sign_in);

        root.getChildren().addAll(image, menuButtons, username, actionText);

        stage.setTitle("Main Menu");
        stage.setScene(new Scene(root, 630, 350));
        stage.setResizable(false);
        stage.sizeToScene();
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}