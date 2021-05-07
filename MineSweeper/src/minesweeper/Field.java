/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minesweeper;

/**
 *
 * @author Uzivatel
 */
public class Field {
    private boolean turned = false;
    private int neighbors = -1;
    private boolean bomb = false;
    
    
    public Field(){
        
    }

    public boolean isTurned() {
        return turned;
    }

    public int getNeighbors() {
        return neighbors;
    }

    public boolean isBomb() {
        return bomb;
    }

    public void setTurned(boolean turned) {
        this.turned = turned;
    }

    public void setNeighbors(int neighbors) {
        this.neighbors = neighbors;
    }

    public void setBomb(boolean bomb) {
        this.bomb = bomb;
    }
    
    
}
