package sample;

import javafx.animation.TranslateTransition;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

import java.sql.SQLException;

public class Utils {

    private static GameOver gameOver = new GameOver();
    static TranslateTransition ttL, ttP, ttA, ttW;

    public static void translateTransitionCircleL(Circle circle) {
        ttL = new TranslateTransition();
        ttL.setNode(circle);
        ttL.setDuration(Duration.seconds(4));
        ttL.setCycleCount(1);
        ttL.setFromY(-100);
        ttL.setToY(880);
        ttL.setAutoReverse(false);
        ttL.play();
        ttL.setOnFinished(event -> {
            translateTransitionCircleL(circle);
            if (circle.isVisible()) {
                Game.dropped++;
                System.out.println(circle.getTranslateY());
                System.out.println(Game.dropped);
                if (Game.dropped == 1)
                    Game.life1.setFill(Color.RED);
                if (Game.dropped == 2)
                    Game.life2.setFill(Color.RED);
                if (Game.dropped == 3) {
                    Game.life3.setFill(Color.RED);
                    try {
                        gameOver.start(Game.getWindow());
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }

    public static void translateTransitionNextCircleL(Circle nextCircle) {
        ttL = new TranslateTransition();
        ttL.setNode(nextCircle);
        ttL.setDuration(Duration.seconds(3));
        ttL.setCycleCount(1);
        ttL.setFromY(-100);
        ttL.setToY(880);
        ttL.setAutoReverse(false);
        ttL.play();
        ttL.setOnFinished(event -> {
            translateTransitionNextCircleL(nextCircle);
            if (nextCircle.isVisible()) {
                Game.dropped++;
                System.out.println(nextCircle.getTranslateY());
                System.out.println(Game.dropped);
                if (Game.dropped == 1)
                    Game.life1.setFill(Color.RED);
                if (Game.dropped == 2)
                    Game.life2.setFill(Color.RED);
                if (Game.dropped == 3) {
                    Game.life3.setFill(Color.RED);
                    try {
                        gameOver.start(Game.getWindow());
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }

    public static void translateTransitionCircleP(Circle circle) {
        ttP = new TranslateTransition();
        ttP.setNode(circle);
        ttP.setDuration(Duration.seconds(4));
        ttP.setCycleCount(1);
        ttP.setFromY(-100);
        ttP.setToY(880);
        ttP.setAutoReverse(false);
        ttP.play();
        ttP.setOnFinished(event -> {
            translateTransitionCircleP(circle);
            if (circle.isVisible()) {
                Game.dropped++;
                System.out.println(circle.getTranslateY());
                System.out.println(Game.dropped);
                if (Game.dropped == 1)
                    Game.life1.setFill(Color.RED);
                if (Game.dropped == 2)
                    Game.life2.setFill(Color.RED);
                if (Game.dropped == 3) {
                    Game.life3.setFill(Color.RED);
                    try {
                        gameOver.start(Game.getWindow());
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }

    public static void translateTransitionNextCircleP(Circle nextCircle) {
        ttP = new TranslateTransition();
        ttP.setNode(nextCircle);
        ttP.setDuration(Duration.seconds(3));
        ttP.setCycleCount(1);
        ttP.setFromY(-100);
        ttP.setToY(880);
        ttP.setAutoReverse(false);
        ttP.play();
        ttP.setOnFinished(event -> {
            translateTransitionNextCircleP(nextCircle);
            if (nextCircle.isVisible()) {
                Game.dropped++;
                System.out.println(nextCircle.getTranslateY());
                System.out.println(Game.dropped);
                if (Game.dropped == 1)
                    Game.life1.setFill(Color.RED);
                if (Game.dropped == 2)
                    Game.life2.setFill(Color.RED);
                if (Game.dropped == 3) {
                    Game.life3.setFill(Color.RED);
                    try {
                        gameOver.start(Game.getWindow());
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }

    public static void translateTransitionCircleA(Circle circle) {
        ttA = new TranslateTransition();
        ttA.setNode(circle);
        ttA.setDuration(Duration.seconds(4));
        ttA.setCycleCount(1);
        ttA.setFromY(-100);
        ttA.setToY(880);
        ttA.setAutoReverse(false);
        ttA.play();
        ttA.setOnFinished(event -> {
            translateTransitionCircleA(circle);
            if (circle.isVisible()) {
                Game.dropped++;
                System.out.println(circle.getTranslateY());
                System.out.println(Game.dropped);
                if (Game.dropped == 1)
                    Game.life1.setFill(Color.RED);
                if (Game.dropped == 2)
                    Game.life2.setFill(Color.RED);
                if (Game.dropped == 3) {
                    Game.life3.setFill(Color.RED);
                    try {
                        gameOver.start(Game.getWindow());
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }

    public static void translateTransitionNextCircleA(Circle nextCircle) {
        ttA = new TranslateTransition();
        ttA.setNode(nextCircle);
        ttA.setDuration(Duration.seconds(3));
        ttA.setCycleCount(1);
        ttA.setFromY(-100);
        ttA.setToY(880);
        ttA.setAutoReverse(false);
        ttA.play();
        ttA.setOnFinished(event -> {
            translateTransitionNextCircleA(nextCircle);
            if (nextCircle.isVisible()) {
                Game.dropped++;
                System.out.println(nextCircle.getTranslateY());
                System.out.println(Game.dropped);
                if (Game.dropped == 1)
                    Game.life1.setFill(Color.RED);
                if (Game.dropped == 2)
                    Game.life2.setFill(Color.RED);
                if (Game.dropped == 3) {
                    Game.life3.setFill(Color.RED);
                    try {
                        gameOver.start(Game.getWindow());
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }

    public static void translateTransitionCircleW(Circle circle) {
        ttW = new TranslateTransition();
        ttW.setNode(circle);
        ttW.setDuration(Duration.seconds(4));
        ttW.setCycleCount(1);
        ttW.setFromY(-100);
        ttW.setToY(880);
        ttW.setAutoReverse(false);
        ttW.play();
        ttW.setOnFinished(event -> {
            translateTransitionCircleW(circle);
            if (circle.isVisible()) {
                Game.dropped++;
                System.out.println(circle.getTranslateY());
                System.out.println(Game.dropped);
                if (Game.dropped == 1)
                    Game.life1.setFill(Color.RED);
                if (Game.dropped == 2)
                    Game.life2.setFill(Color.RED);
                if (Game.dropped == 3) {
                    Game.life3.setFill(Color.RED);
                    try {
                        gameOver.start(Game.getWindow());
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }

    public static void translateTransitionNextCircleW(Circle nextCircle) {
        ttW = new TranslateTransition();
        ttW.setNode(nextCircle);
        ttW.setDuration(Duration.seconds(3));
        ttW.setCycleCount(1);
        ttW.setFromY(-100);
        ttW.setToY(880);
        ttW.setAutoReverse(false);
        ttW.play();
        ttW.setOnFinished(event -> {
            translateTransitionNextCircleW(nextCircle);
            if (nextCircle.isVisible()) {
                Game.dropped++;
                System.out.println(nextCircle.getTranslateY());
                System.out.println(Game.dropped);
                if (Game.dropped == 1)
                    Game.life1.setFill(Color.RED);
                if (Game.dropped == 2)
                    Game.life2.setFill(Color.RED);
                if (Game.dropped == 3) {
                    Game.life3.setFill(Color.RED);
                    try {
                        gameOver.start(Game.getWindow());
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }
}
