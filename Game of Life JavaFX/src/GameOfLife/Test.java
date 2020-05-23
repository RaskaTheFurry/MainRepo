package GameOfLife;

import java.util.Random;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Test extends Application {

    public final static int WIDTH = 800;
    public final static int HEIGHT = 600;

    public Rectangle[][] r = new Rectangle[81][61];
    public Random rnd = new Random();
    public Grid grid = new Grid(81, 61, 0.5);
    Cell[][] cells = grid.getCell();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws InterruptedException {

        BorderPane root = new BorderPane();

        for (int x = 0; x < 81; x++) {
            for (int y = 0; y < 61; y++) {
                //System.out.println(x + "|" + y);
                r[x][y] = new Rectangle(x * 10, y * 10, 10, 10);

                r[x][y].setFill(Color.BLACK);
                r[x][y].setStroke(Color.WHITE);

                root.getChildren().add(r[x][y]);
            }
        }

        Scene scene = new Scene(root, WIDTH, HEIGHT);

        primaryStage.setTitle("Conway's Game of Life");
        primaryStage.setScene(scene);
        primaryStage.show();

        Thread thread = new Thread(() -> {
            while (!Thread.currentThread().isInterrupted()) {
                Platform.runLater(() -> LOOP());
                try {

                    Thread.sleep(33);

                } catch (InterruptedException exc) {
                    break;
                }
            }

        });
        thread.setDaemon(true);
        thread.start();

    }

    private void LOOP() {

        for (int x = 0; x < cells.length; x++) {
            for (int y = 0; y < cells[x].length; y++) {
                if (cells[x][y].isAlive()) {
                    r[x][y].setFill(Color.BLACK);
                    r[x][y].setStroke(Color.WHITE);
                    //System.out.print(cells[x][y].isAlive() + "|");
                } else {
                    r[x][y].setFill(Color.TRANSPARENT);
                    r[x][y].setStroke(Color.BLACK);
                    //System.out.print(cells[x][y].isAlive() + "|");
                }
            }
            //System.out.print("\n");
        }
        grid.updateAll();
    }

    //}
}
