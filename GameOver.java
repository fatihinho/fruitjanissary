package sample;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.sql.SQLException;

public class GameOver extends Application {

    private final double screenX = 1270, screenY = 690;
    private User user = new User();

    @Override
    public void start(Stage stage) throws SQLException {
        Pane root = new Pane();
        root.setStyle("-fx-background-color: #e68a00;");

        Text game_over = new Text("GAME OVER");
        game_over.setX(500);
        game_over.setY(250);
        game_over.setFont(new Font(50));
        game_over.setFill(Color.RED);

        Text score_title = new Text("Your Score : ");
        score_title.setX(525);
        score_title.setY(300);
        score_title.setFont(new Font(24));
        score_title.setFill(Color.DARKBLUE);

        Text score = new Text(Game.getCurrScore());
        score.setX(675);
        score.setY(300);
        score.setFont(new Font(24));
        score.setFill(Color.DARKBLUE);

        user.setUserScore();
        user.setLeaderboard();

        Button quit = new Button("Quit");
        quit.setOnAction(event -> Platform.exit());

        root.getChildren().addAll(game_over, score_title, score, quit);

        stage.setScene(new Scene(root, screenX, screenY));
        stage.setResizable(false);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}