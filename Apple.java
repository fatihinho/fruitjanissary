package sample;

import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Arc;
import javafx.scene.shape.Circle;

import java.io.InputStream;
import java.util.Random;

public class Apple extends Fruit {

    private int value;
    private double x, y;
    private Group group;
    private Pane pane;
    private Arc leftArc,rightArc;
    private Circle circle, nextCircle;

    Apple(Pane pane) {
        this.pane = pane;
    }

    public void generate() {
        this.x = (200 + (Math.random() * 880));
        this.y = (-50 - (Math.random() * 100));
    }

    public void update() {
        Game.score.setText(Game.addScore(10));

        InputStream inStream = getClass().getResourceAsStream("img/apple.jpeg");
        Image imageObject = new Image(inStream);

        circle = nextCircle;
        circle.setVisible(false);

        generate();
        nextCircle = new Circle(x, y, 30);
        nextCircle.setFill(new ImagePattern(imageObject));
        pane.getChildren().add(nextCircle);
        Utils.translateTransitionNextCircleA(nextCircle);

        nextCircle.setOnMouseDragEntered(event -> update());

        System.out.println("Ax : " + x + "\nAy : " + y);
    }

    @Override
    public void drawAndSlice() {
        InputStream inStream = getClass().getResourceAsStream("img/apple.jpeg");
        Image imageObject = new Image(inStream);

        generate();
        circle = new Circle(x, y, 30);
        circle.setFill(new ImagePattern(imageObject));
        pane.getChildren().add(circle);
        Utils.translateTransitionCircleA(circle);

        Random random = new Random();

        circle.setOnMouseDragEntered(event -> {
            Game.score.setText(Game.addScore(10));

            circle.setVisible(false);
            generate();
            nextCircle = new Circle(x, y, 30);
            nextCircle.setFill(new ImagePattern(imageObject));
            pane.getChildren().add(nextCircle);
            Utils.translateTransitionNextCircleA(nextCircle);
            value = random.nextInt(2);
            if (value == 0) {
                leftArc = new Arc(circle.getCenterX() - 5 ,circle.getCenterY(),circle.getRadius(),circle.getRadius(),45,180);
                rightArc = new Arc(circle.getCenterX() + 5,circle.getCenterY(),circle.getRadius(),circle.getRadius(),225,180);
            }
            else {
                leftArc = new Arc(circle.getCenterX() - 5 ,circle.getCenterY(),circle.getRadius(),circle.getRadius(),90,180);
                rightArc = new Arc(circle.getCenterX() + 5,circle.getCenterY(),circle.getRadius(),circle.getRadius(),270,180);
            }
            group = new Group(leftArc, rightArc);
            circle.setClip(group);
            nextCircle.setOnMouseDragEntered(event1 -> update());
        });
    }
}
