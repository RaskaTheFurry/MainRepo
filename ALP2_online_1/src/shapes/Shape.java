/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shapes;

/**
 *
 * @author Uzivatel
 */
public abstract class Shape implements Comparable<Shape> {
    
    protected String name = "Generic Object";
    
    public abstract double computeArea();
    
    public String getShapeName(){
        return this.getClass().getSimpleName();
    }
    
    @Override
    public String toString(){
        return name+" : " + getShapeName();
    }
    
    @Override
    public int compareTo(Shape o) {
        double thisArea = this.computeArea();
        if(thisArea < o.computeArea()){
            return 1;
        }else{
            if(thisArea > o.computeArea()){
                return -1;
            }
        }
        return 0;
    }
    
}
