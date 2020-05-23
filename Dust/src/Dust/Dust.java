package Dust;

import java.util.Random;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.PointerInfo;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;
public class Dust extends Application {
    
    public final static int WIDTH = 800;
    public final static int HEIGHT = 600;
    private int amountOfParticles = 2500;
    public particle[] particles = new particle[amountOfParticles];
    public Random rnd = new Random();
    private boolean GotColor = false;
    private Integer ranX;
    private Integer ranY;
    
    @Override
    public void start(Stage primaryStage) {
        Canvas canvas = new Canvas(WIDTH, HEIGHT);
        
        GraphicsContext gc = canvas.getGraphicsContext2D();
        
        Timeline tl = new Timeline(new KeyFrame(Duration.millis(10), e -> frame(gc)));
        tl.setCycleCount(Timeline.INDEFINITE);
        StackPane root = new StackPane();
        Scene scene = new Scene(root, WIDTH, HEIGHT);
        canvas.setOnMouseDragged(new EventHandler<MouseEvent>() {
    @Override public void handle(MouseEvent mouseEvent) {
        
        if (mouseEvent.isPrimaryButtonDown()) {
                
        for(int z = 0;z<particles.length ;z++){
            Point p = MouseInfo.getPointerInfo().getLocation();
            if(((p.x-253)-particles[z].getX())<50 && ((p.x-253)-particles[z].getX())>-50 && ((p.y-75)-particles[z].getY())>-50 && ((p.y-75)-particles[z].getY())<50 ){
                
//                System.out.println(particles[z].getX() + "||" + (p.getX()-253+50));
                particles[z].setX(particles[z].getX()+(((p.x-253)-particles[z].getX())/2));
                particles[z].setY(particles[z].getY()+(((p.y-75)-particles[z].getY())/2));
                gc.fillRect(particles[z].getX(), particles[z].getY(), 1, 1);
                
            }
        }
        }
        if (mouseEvent.isSecondaryButtonDown()) {
            for(int z = 0;z<particles.length ;z++){
            Point p = MouseInfo.getPointerInfo().getLocation();
            if(((p.x-253)-particles[z].getX())<50 && ((p.x-253)-particles[z].getX())>-50 && ((p.y-75)-particles[z].getY())>-50 && ((p.y-75)-particles[z].getY())<50 ){
                
                
                particles[z].setX(particles[z].getX()-(((p.x-253)-particles[z].getX())/2));
                particles[z].setY(particles[z].getY()-(((p.y-75)-particles[z].getY())/2));
                gc.fillRect(particles[z].getX(), particles[z].getY(), 1, 1);
                
                
                
            }
        }
        }
        
    }
    
    });
        
        
        primaryStage.setTitle("Prach");
        for(int i = 0;i<amountOfParticles ; i++){
            particles[i] = new particle();
        }
        primaryStage.setScene(new Scene(new StackPane(canvas)));
        primaryStage.show();
        tl.play();
    }
    private void frame(GraphicsContext gc){
        gc.setFill(Color.BLACK);
	gc.fillRect(0, 0, WIDTH, HEIGHT);
        for(int x = 0;x<particles.length ; x++){
            
            
            gc.fillRect(particles[x].getX(), particles[x].getY(), 1, 1);
            
            gc.setFill(particles[x].getColor());
            
            
            if((particles[x].getranX() == null && particles[x].getranY() == null) || (particles[x].getX().intValue() == (particles[x].getranX()) && particles[x].getY().intValue() == (particles[x].getranY()))){
            particles[x].setranX((int)Math.floor(particles[x].getX())+rnd.nextInt(101)-(50));
            particles[x].setranY((int)Math.floor(particles[x].getY())+rnd.nextInt(101)-(50));
            }
//            System.out.println(particles[x].getX().intValue() +"||"+ (particles[x].getranX()));
            
            particles[x].setX(particles[x].getX()+(particles[x].getranX()-particles[x].getX())/1000+rnd.nextInt(3)-(1));
            particles[x].setY(particles[x].getY()+(particles[x].getranY()-particles[x].getY())/1000+rnd.nextInt(3)-(1));
            if(particles[x].getX() < 0 || particles[x].getX() > WIDTH || particles[x].getY() > HEIGHT || particles[x].getY()<0){
                particles[x].setX(particles[x].getX()*(-1));
                particles[x].setY(particles[x].getY()*(-1));
            }
        }
        
	
    }
    public static void main(String[] args) {
        launch(args);
    }
    
}
