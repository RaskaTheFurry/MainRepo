
package game_school;

import javafx.scene.paint.Color;

import javafx.scene.shape.Ellipse;


public class Ball {
    private final Color color = Color.WHITE;
    private double Diameter = 2.;
    private double x = 0;
    private double y = 0;
    
    
    public Ball(double X , double Y, Double Diameter){
        setX(X);
        setY(Y);
        setDiameter(Diameter);
}
    public double getX(){
        return x;
    }
    public double getY(){
        return y;
    }
    public void setX(double newX){
        this.x = newX;
    }
    public void setY(double newY){
        this.y = newY;
    }
    public void setDiameter(double newDiameter){
        this.Diameter = newDiameter;
    }
    public double getDiameter(){
        return this.Diameter;
    }
}
