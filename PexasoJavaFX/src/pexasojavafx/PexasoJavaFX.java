/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pexasojavafx;

import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.input.MouseEvent;


/**
 *
 * @author Uzivatel
 */
public class PexasoJavaFX extends Application {
    /**
     * @param resolution_X Width of window and Canvas
     * @param resolution_Y Height of window and Canvas
     * @param version Version used in window title
     * @param lastX Used in Clicked method, used to see X of last clicked card
     * @param lastY Used in Clicked method, used to see Y of last clicked card
     * @param revealedCards How many cards have been revealed
     * @param playerPoints How many points did player score in a game
     */
    private int resolution_X = 800;
    private int resolution_Y = 600;
    private static final String version = "0.1.0";
    private int lastX = -1, lastY = -1;
    private int revealedCards = 1;
    private int playerPoints = 0;
    private GraphicsContext gc;

    /** 
    * Start, Includes TimeLine, infinite, 10ms refresh
    * Timeline possibly unnecessary, but ill leave it there
    * @version 0.1.0
    */
    @Override
    public void start(Stage primaryStage) {
        Canvas canvas = new Canvas(resolution_X, resolution_Y);

        this.gc = canvas.getGraphicsContext2D();
        ArrayHandle arrHandle;
        try {
            arrHandle = new ArrayHandle(4, 4);
            Timeline tl = new Timeline(new KeyFrame(Duration.millis(10), e -> draw(arrHandle)));
            tl.setCycleCount(Timeline.INDEFINITE);

            StackPane root = new StackPane();

//        printArray(arrHandle.getPexArray());
            canvas.setOnMouseClicked(e -> clicked(arrHandle, e));
            primaryStage.setTitle("Pexaso " + version);
            primaryStage.setScene(new Scene(new StackPane(canvas)));
            primaryStage.show();
            tl.play();
        } catch (IllegalArgumentException e) {
            System.out.println((char)27 + "[31m"+"ERROR: ODD ARRAY");
            Platform.exit();
        }
        
        
        
    }

    /** 
    * Draws rectangles and text
    * @param gc Graphics context used in Canvas
    * @param arr Handler of Arrays with few useful methods
    * @version 0.1.0
    * @since 13.3.2019
    */
    public void draw(ArrayHandle arr) {
//            System.out.println(arr.getY());
        gc.setFill(Color.WHITE);
        gc.fillRect(0, 0, resolution_X, resolution_X);
        double sirka = (resolution_X / arr.getX());
        double vyska = (resolution_Y / arr.getY());
        for (int i = 0; i < arr.getX(); i++) {
            for (int j = 0; j < arr.getY(); j++) {
                if (!arr.getRevealed()[i][j]) {
                    gc.setFill(Color.BLACK);
                    gc.setStroke(Color.WHITE);

                    gc.fillRect(sirka * i + 5, vyska * j, sirka - 5, vyska - 5);
                    gc.setFill(Color.BLACK);
                    gc.setStroke(Color.BLACK);
                    gc.fillText(Integer.toString(arr.getPexArray()[j][i]), sirka * i + (sirka) / 2, vyska * j + vyska / 2);
                } else {
                    gc.setFill(Color.TRANSPARENT);
                    gc.setStroke(Color.TRANSPARENT);
                    gc.fillRect(sirka * i + 5, vyska * j, sirka - 5, vyska - 5);
                    gc.setFill(Color.BLACK);
                    gc.setStroke(Color.BLACK);
                    gc.fillText(Integer.toString(arr.getPexArray()[j][i]), sirka * i + sirka / 2, vyska * j + (vyska / 2));
                }

            }

        }
    }

    /** 
    * Method used by MouseEvents, ArrayHandle arr, MouseEvent e
    * mouseEvent on click. On click tests, if exactly 2 cards have been revealed and if they are the same
    * @param arr Handler of Arrays with few useful methods
    * @param e Event used to get mouse position after clicked
    * @version 0.1.0
    * @since 13.3.2019
    */
    private void clicked(ArrayHandle arr, MouseEvent e) {
        
        double sirka = (resolution_X / arr.getX());
        double vyska = (resolution_Y / arr.getY());
        //arr.setRevealed((int)(resolution_X/e.getSceneX()), (int)(resolution_Y/e.getSceneY()));
        //System.out.println(e.getSceneX()+", "+e.getSceneY());
        for (int i = 0; i < arr.getX(); i++) {
            for (int j = 0; j < arr.getY(); j++) {
                if (e.getSceneX() > sirka * i + 5 && e.getSceneY() > vyska * j && e.getSceneX() < sirka * i + 5 + sirka - 5 && e.getSceneY() < vyska * j + vyska - 5) {
                    arr.setRevealed(i, j, true);
                    
                    //System.out.println(this.revealedCards);
                    boolean isTwoRevealed = this.revealedCards == 2;
                    
                    if (isTwoRevealed && arr.getPexArray()[this.lastY][this.lastX] != arr.getPexArray()[j][i]) {
                        
                        arr.setRevealed(this.lastX, this.lastY, false);
                        
                        arr.setRevealed(i, j, false);
                        
                        this.revealedCards = 1;
                    } else {
                        if (isTwoRevealed && arr.getPexArray()[this.lastY][this.lastX] == arr.getPexArray()[j][i]) {
                            arr.setRevealed(this.lastX, this.lastY, true);
                            arr.setRevealed(i, j, true);
                            this.revealedCards = 1;
                            this.lastX = -1;
                            this.lastY = -1;
                            this.playerPoints++;
                            System.out.println((char)27 + "[32m"+"Tvoje skore: " + this.playerPoints);

                        } else {
                            if (this.revealedCards < 2) {
                                this.lastX = i;
                                this.lastY = j;
                                this.revealedCards++;
                                //System.out.println("Lasted");
                            }

                        }
                    }

                    System.out.println(arr.getPexArray()[j][i]);
                    
                }
                
            }
        }
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    /*
    known bugs:
        >already revealed same cards still give score
    Future features:
        >Cards will wait revealed for few seconds before hiding again if wrong
        >End
        
        
     */
}
