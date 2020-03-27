/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alp2_online_1;

/**
 *
 * @author Uzivatel
 */
public class Vector2 {
    private double x,y;
    
    public Vector2(){
        this.x = 0;
        this.y = 0;
    }
    public Vector2(double x, double y){
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }
    
    public double distance(Vector2 b){
        return Math.sqrt(Math.pow(this.x-b.getX(),2)+Math.pow(this.y-b.getY(),2));
    }
    
    public double distanceFromZero(){
        Vector2 b = new Vector2(0,0);
        return Math.sqrt(x*x+y*y);
    }
    
    public static double distanceBetween(Vector2 p1, Vector2 p2){
        return Math.sqrt(Math.pow(p1.getX()-p2.getX(),2)+Math.pow(p1.getY()-p2.getY(),2));
    }
    
    public void scale(double x){
        this.x = this.x*x;
        this.y = this.y*x;
    }
    public void scale(double x,double y){
        this.x = this.x*x;
        this.y = this.y*y;
    }

    @Override
    public String toString() {
        return "Vector2{" + "x=" + x + ", y=" + y + '}';
    }
    
    
    
}
