package Test;
 
import Models.*;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import java.awt.*;
 
public class TestSlicing1 extends Application {
 
    AnimationTimer timer;
    //Pane root = new Pane();
    //GameLogic gamelogic=GameLogic.getInstance();
    Game game=Game.getInstance();
 
 
   /* FruitFactory fruitFactory = new FruitFactory();
    Fruit watermelon = (Fruit) fruitFactory.createObject(GameObjects.Watermelon);
    Fruit pineapple = (Fruit) fruitFactory.createObject(GameObjects.Pineapple);
    Fruit apple = (Fruit) fruitFactory.createObject(GameObjects.Apple);
    Fruit banana = (Fruit) fruitFactory.createObject(GameObjects.Banana);
    Fruit orange = (Fruit) fruitFactory.createObject(GameObjects.Orange);
   
                                     
     Fruit w= new SliceAllDecorator(pineapple);*/
 
 
    double mouseX;
    double speed=1;
    double falling=500;
 
    public static void main(String[] args) {
        launch();
 
    }
 
    @Override
    public void start(Stage primaryStage) {
 
        //EasyEquationGenerator eg = new EasyEquationGenerator(1000, 600);
        //Equation eq = eg.generateEquation();
 
        /*pineapple.setEq(eq);
        apple.setEq(eq);
        orange.setEq(eq);
 
        game.getGameObjects().add(pineapple);
        game.getGameObjects().add(apple);
        game.getGameObjects().add(orange);
 
        speed = 1;
        falling = 500;
 
        root.getChildren().add(((Fruit)game.getGameObjects().get(0)).getImageView());*/
 
        AnchorPane root = new AnchorPane();
        game.start(root, true, 1);
        /*Timeline timeline = new Timeline(new KeyFrame(Duration.millis(500), event -> {
 
            speed += falling / 3000;
            
 
        }));
 
        timeline.setCycleCount(1000);
        timeline.play();
 */
 
        /*timer = new AnimationTimer() {
 
            @Override
            public void handle(long arg0) {
                game.gameUpdate(eq);
 
            }
 
        };
 
        timer.start();*/
 
        Scene scene = new Scene(root, 1200, 800);
 
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
 
   /* public void gameUpdate(Equation eq) {
 
        Fruit w = (Fruit) game.getGameObjects().get(0);
        w.move(System.currentTimeMillis());
 
    }*/
}