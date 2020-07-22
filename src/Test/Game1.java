package Test;

import Models.EasyEquationGenerator;
import Models.Equation;
import Models.Game;
import javafx.animation.AnimationTimer;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.List;
public class Game1 extends Application {
   
    AnimationTimer timer;
    Pane root = new Pane();
    List drop = new ArrayList();
    double mouseX;
    Rectangle cont;
    double speed;
    double falling;
    Label lblMissed;
    int missed;
 
    public static void main(String[] args) {
        launch();
 
    }

 
    @Override
    public void start(Stage primaryStage) throws Exception {

        /*lblMissed = new Label("Missed: 0");
        lblMissed.setLayoutX(10);
        lblMissed.setLayoutY(10);
        missed = 0;
       
        speed = 1;
        falling = 500;
        drop.add(circle());
        root.getChildren().add(((Node)drop.get(drop.size() -1)));
        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(falling), event -> {
           
            speed += falling / 3000;
            
            
        }));
       
        timeline.setCycleCount(1000);
        timeline.play();
        EasyEquationGenerator eg = new EasyEquationGenerator(1000, 500);
        Equation eq = eg.generateEquation();
       
       
        timer = new AnimationTimer() {
 
            @Override
            public void handle(long arg0) {
                gameUpdate(eq, circle());
               
            }
           
        };
        
        timer.start(); 
       
        cont = rectangle();
   
        root.getChildren().addAll(cont, lblMissed);
       
        Scene scene = new Scene(root, 1000, 500);
       
        scene.setOnMouseMoved(e -> {
            mouseX = e.getX();
        });*/
    	
        /*Pane root = new Pane();
        Scene scene = new Scene(root, 1000, 500);
        Game game=Game.getInstance();
        game.start(root);
        primaryStage.setScene(scene);
        primaryStage.show();
       
    
   
    /*public Circle circle() {
        Circle circle = new Circle();
        circle.setLayoutX(0);
        circle.setLayoutY(0);
        circle.setRadius(20);
        circle.setFill(Color.BLUE);
        return circle;
    }
   
    public Rectangle rectangle() {
        Rectangle rectangle = new Rectangle();
        rectangle.setLayoutX(200);
        rectangle.setLayoutY(550);
        rectangle.setHeight(50);
        rectangle.setWidth(70);
        rectangle.setFill(Color.GREEN);
        return rectangle;
       
    }
   
    public int rand(int min, int max) {
        return (int)(Math.random() * max + min);
    }
    public void gameUpdate(Equation eq, Circle c){
       
        cont.setLayoutX(mouseX);
        
        	if(drop.size() > 0) {
                Circle f = (Circle) drop.get(0);
                //Point p = eq.updateCoordinates((int) c.getLayoutX(), (int)c.getLayoutY());
                //System.out.println(p.x);
                //System.out.println(p.y);
                //f.setLayoutX(p.x);
                //f.setLayoutY(p.y);
            }
        	
            //Point p = eq.updateCoordinates((int) c.getLayoutX(), (int)c.getLayoutY());
            //System.out.println(c.getLayoutY() + speed + c.getLayoutY() / 150);
            //System.out.println(p.x);
            //System.out.println(p.y);
            //System.out.println(p.y);
            //
        	//c.setLayoutY(p.y);
            //if get droped into square
            for(int i = 0; i < drop.size(); i++) {
            	
            if((((Circle) drop.get(i)).getLayoutX() > cont.getLayoutX() && ((Circle) drop.get(i)).getLayoutX() < cont.getLayoutX() + 70) &&
                    ((Circle) drop.get(i)).getLayoutY() >= 550  ) {
                root.getChildren().remove(((Circle) drop.get(i)));
                drop.remove(i);
            }
               
            //if missed remove
            else if(((Circle) drop.get(i)).getLayoutY() >= 590) {
                root.getChildren().remove(((Circle) drop.get(i)));
                drop.remove(i);
                missed += 1;
                lblMissed.setText("Missed: " + String.valueOf(missed));
            }
    }*/
    }
}
