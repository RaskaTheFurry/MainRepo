/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pexasojavafx;

import java.util.Random;

/**
 *
 * @author Uzivatel
 * @version 0.1.0
 */
public class ArrayHandle {

    private int[][] pexArray;
    private boolean[][] revealed;
    private int x, y;
    private final Random rnd = new Random();

    public ArrayHandle(int x, int y) {
        pexArray = new int[x][y];
        this.revealed = new boolean[x][y];
        if((x*y)%2 == 1){
            throw new IllegalArgumentException("Values give odd numbers, even required");
        }
        this.x = x;
        this.y = y;
        genArray();
    }
    /** 
     * generates 2-way array, where are exactly 2 numbers of x*y/2 numbers
     */
    public void genArray() {
        resetReveal();
        int[] numbersUsed = new int[(x * y) / 2];
//        System.out.println(numbersUsed.length);
        int ranNum;
        for (int i = 0; i < pexArray.length; i++) {
            for (int j = 0; j < pexArray[i].length; j++) {

                ranNum = rnd.nextInt(numbersUsed.length);
//                System.out.println(ranNum);
                while (numbersUsed[ranNum] > 1) {
                    ranNum = rnd.nextInt(numbersUsed.length);
                }
                pexArray[i][j] = ranNum;
                numbersUsed[ranNum]++;
            }
        }

    }
    /** 
     * nulls generated array
     */
    public void nullArray() {

        pexArray = null;

    }
    /** 
     * resets reveal array of booleans, for possible replay, not implemented
     */
    public void resetReveal() {
        for (int i = 0; i < this.revealed.length; i++) {
            for (int j = 0; j < this.revealed[i].length; j++) {
                this.revealed[i][j] = false;
            }

        }

    }
    /** 
     * gets array of generated numbers
     * @return Integer 2-way Array[x][y]
     */
    public int[][] getPexArray() {
        return pexArray;
    }
    /** 
     * gets number of columns
     * @return returns X of arrays
     */
    public int getX() {
        return x;
    }
    /** 
     * gets number of rows
     * @return returns Y of arrays
     */
    public int getY() {
        return y;
    }
    /** 
     * 
     * @return gets two-way boolean array[x][y] of revealed cards
     */
    public boolean[][] getRevealed() {
        return revealed;
    }
    /** sets card on x,y to boolean
     * 
     * @param x position X in Boolean Array
     * @param y position Y in Boolean Array
     * @param j Boolean put into position of [x][y] in Revealed boolean Array
     */
    public void setRevealed(int x, int y, boolean j) {
        
        this.revealed[x][y] = j;
        
    }
}
