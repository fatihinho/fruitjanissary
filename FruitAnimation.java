package sample;

import javafx.animation.Timeline;
import javafx.scene.shape.Circle;

public class FruitAnimation {

    private Circle circle;
    private double x = 500, y = -500;
    private double dx = 1, dy = 1;
    private Timeline animation;

    FruitAnimation(Circle circle, double x, double y) {
        this.circle = circle;
        this.x = x;
        this.y = y;
    }

    public void moveBallY() {
        y += dy;
        circle.setCenterY(y);
        if (circle.getCenterY() == 750) {
            y = -100;
        }
    }
}
