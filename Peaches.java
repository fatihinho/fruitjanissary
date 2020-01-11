package sample;

import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Arc;
import javafx.scene.shape.Circle;

import java.io.InputStream;
import java.util.Random;

public class Peaches extends Fruit {

    private int value;
    private double x, y;
    private Group group;
    private Pane pane;
    private Arc leftArc,rightArc;
    private Circle circle, nextCircle;

    Peaches(Pane pane) {
        this.pane = pane;
    }

    public void generate() {
        this.x = (200 + (Math.random() * 880));
        this.y = (-50 - (Math.random() * 100));
    }

    public void update() {
        Game.score.setText(Game.addScore(15));

        InputStream inStream = getClass().getResourceAsStream("img/peaches.jpg");
        Image imageObject = new Image(inStream);

        circle = nextCircle;
        circle.setVisible(false);

        generate();
        nextCircle = new Circle(x, y, 25);
        nextCircle.setFill(new ImagePattern(imageObject));
        pane.getChildren().add(nextCircle);
        Utils.translateTransitionNextCircleP(nextCircle);

        nextCircle.setOnMouseDragEntered(event -> update());

        System.out.println("Px : " + x + "\nPy : " + y);
    }

    @Override
    public void drawAndSlice() {
        InputStream inStream = getClass().getResourceAsStream("img/peaches.jpg");
        Image imageObject = new Image(inStream);

        generate();
        circle = new Circle(x, y, 25);
        circle.setFill(new ImagePattern(imageObject));
        pane.getChildren().add(circle);
        Utils.translateTransitionCircleP(circle);

        Random random = new Random();

        circle.setOnMouseDragEntered(event -> {
            Game.score.setText(Game.addScore(15));

            circle.setVisible(false);
            generate();
            nextCircle = new Circle(x, y, 25);
            nextCircle.setFill(new ImagePattern(imageObject));
            pane.getChildren().add(nextCircle);
            Utils.translateTransitionNextCircleP(nextCircle);
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
