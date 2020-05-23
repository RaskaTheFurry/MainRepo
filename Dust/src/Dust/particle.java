package Dust;

import java.util.Random;
import javafx.scene.paint.Color;


public class particle{
    private Double X;
    private Double Y;
    private Integer ranX;
    private Integer ranY;
    private boolean gotColor = false;
    private Color color;
    public particle(){
        Random rnd = new Random();
        this.X = rnd.nextDouble()+rnd.nextInt(Dust.WIDTH);
        this.Y = rnd.nextDouble()+rnd.nextInt(Dust.HEIGHT);
        this.color = Color.rgb(rnd.nextInt(255), rnd.nextInt(255), rnd.nextInt(255));
    }
    public Double getX(){
        return X;
    }
    public Double getY(){
        return Y;
    }
    public void setX(Double X){
        this.X = X;
    }
    public void setY(Double Y){
        this.Y = Y;
    }
    public Integer getranX(){
        return ranX;
    }
    public Integer getranY(){
        return ranY;
    }
    public void setranX(Integer X){
        this.ranX = X;
    }
    public void setranY(Integer Y){
        this.ranY = Y;
    }
    public void setColor(Color x){
        this.color = x;
    }
    public Color getColor(){
        return this.color;
    }
}
