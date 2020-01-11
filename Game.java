package sample;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.ImageCursor;
import javafx.scene.Scene;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.InputStream;

public class Game extends Application {

    private final double screenX = 1270, screenY = 690;
    private GameOver gameOver = new GameOver();
    static int currScore = 0, newScore;
    static Text score;
    private static Stage window;
    static Circle life1, life2, life3;

    static int dropped = 0;

    public static Stage getWindow() {
        return window;
    }

    public static String addScore(int newScore) {
        Game.newScore = newScore;
        Game.currScore += Game.newScore;
        return Integer.toString(Game.currScore);
    }

    public static String getCurrScore() {
        return Integer.toString(Game.currScore);
    }

    @Override
    public void start(Stage stage) {
        window = stage;

        Pane root = new Pane();
        root.setOnDragDetected(event -> root.startFullDrag());

        InputStream inStream = getClass().getResourceAsStream("img/wood.jpg");
        Image imageObject = new Image(inStream);
        ImageView image = new ImageView(imageObject);

        GridPane text = new GridPane();
        score = new Text("0");
        score.setFont(Font.font("Verdana", 30));
        score.setFill(Color.RED);
        score.setStroke(Color.WHITE);
        score.setStrokeWidth(0.5);
        text.setHgap(20);
        text.add(score, 1, 0);

        life1 = new Circle(1170, 25, 15, Color.WHITE);
        life2 = new Circle(1205, 25, 15, Color.WHITE);
        life3 = new Circle(1240, 25, 15, Color.WHITE);

        Group lifes = new Group(life1, life2, life3);

        Text lives_text = new Text("LIVES");
        lives_text.setFont(Font.font("Verdana", 30));
        lives_text.setFill(Color.RED);
        lives_text.setStroke(Color.WHITE);
        lives_text.setStrokeWidth(0.5);
        lives_text.setX(1160);
        lives_text.setY(70);

        root.setFocusTraversable(true);
        root.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.P) {
                Utils.ttL.pause();
                Utils.ttP.pause();
                Utils.ttA.pause();
                Utils.ttW.pause();
                Boom.ttB.pause();
                root.setEffect(new GaussianBlur());
            }
            if (e.getCode() == KeyCode.O) {
                Utils.ttL.play();
                Utils.ttP.play();
                Utils.ttA.play();
                Utils.ttW.play();
                Boom.ttB.play();
                root.setEffect(null);
            }
        });

        root.getChildren().addAll(image, text, lifes, lives_text);

        Fruit l = new Lemon(root);
        Fruit p = new Peaches(root);
        Fruit a = new Apple(root);
        Fruit w = new Watermelon(root);

        Bomb  b = new Boom(root);

        l.drawAndSlice();
        p.drawAndSlice();
        a.drawAndSlice();
        w.drawAndSlice();

        b.drawAndSlice();

        Image imgCursor = new Image("sample/img/blade.png");
        root.setCursor(new ImageCursor(
                imgCursor,
                imgCursor.getWidth() / 2,
                imgCursor.getHeight() / 2));

        window.setScene(new Scene(root, screenX, screenY));
        window.setResizable(false);
        window.show();

        root.requestFocus();
    }

    public static void main(String[] args) {
        launch(args);
    }
}