package sample;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

import java.io.InputStream;
import java.sql.SQLException;

public class Boom extends Bomb {

    private double x = 500, y = -500;
    private double dx = 1, dy = 1;
    private Pane pane;
    static Timeline ttB;
    private Circle circle;
    private GameOver gameOver = new GameOver();

    Boom(Pane pane) {
        this.pane = pane;
    }

    public void moveBallY() {
        y += dy;
        circle.setCenterY(y);
        if (circle.getCenterY() == 750) {
            this.x = (200 + (Math.random() * 880));
            circle.setCenterX(x);
            y = -250;
        }
    }

    @Override
    public void drawAndSlice() {
        InputStream inStream = getClass().getResourceAsStream("img/bomb.png");
        Image imageObject = new Image(inStream);

        circle = new Circle(x, y, 30);
        circle.setFill(new ImagePattern(imageObject));
        pane.getChildren().add(circle);
        ttB = new Timeline(new KeyFrame(Duration.millis(2), event -> moveBallY()));
        ttB.setCycleCount(Timeline.INDEFINITE);
        ttB.play();

        circle.setOnMouseDragEntered(event -> {
            try {
                gameOver.start(Game.getWindow());
            } catch (IllegalStateException e) {
                e.fillInStackTrace();
            } catch (NullPointerException e) {
                e.fillInStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        });
    }
}
