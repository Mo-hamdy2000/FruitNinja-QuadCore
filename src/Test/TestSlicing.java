package Test;

import Models.*;
import javafx.animation.AnimationTimer;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class TestSlicing extends Application {

    AnimationTimer timer;
    Pane root = new Pane();

    Watermelon watermelon = new Watermelon();
    FruitDecorator f=new FruitDecorator(watermelon);
    List<Fruit> fruits = new ArrayList<Fruit>();

    double mouseX;
    double speed;
    double falling;

    public static void main(String[] args) {
        launch();

    }

    @Override
    public void start(Stage primaryStage) {

        EasyEquationGenerator eg = new EasyEquationGenerator(1000, 500);
        Equation eq = eg.generateEquation();
        watermelon.setEq(eq);
        fruits.add(watermelon);

        speed = 1;
        falling = 500;

        root.getChildren().add(fruits.get(0).getImageView());

        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(falling), event -> {

            speed += falling / 2000;

        }));

        timeline.setCycleCount(1000);
        timeline.play();


        timer = new AnimationTimer() {

            @Override
            public void handle(long arg0) {
                gameUpdate(eq);

            }

        };

        timer.start();

        Scene scene = new Scene(root, 1000, 500);

        scene.setOnMouseMoved(e -> {
            mouseX = e.getX();
        });

        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public int rand(int min, int max) {
        return (int) (Math.random() * max + min);
    }

    Point p;

    public void gameUpdate(Equation eq) {

        Fruit w = fruits.get(0);
        w.move(System.currentTimeMillis());

    }
}
