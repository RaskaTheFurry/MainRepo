/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minesweeper;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Uzivatel
 */
public class MineSweeper {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        boolean end = false;
        int x,y,n;
        Scanner sc = new Scanner(System.in);
        while(!end){
            
            System.out.println("Zadejte šířku hracího pole");
            x = sc.nextInt();
            if(x < 0){
                end = true;
                continue;
            }
            System.out.println("Zadejte výšku hracího pole");
            y = sc.nextInt();
            if(y < 0){
                end = true;
                continue;
            }
            System.out.println("Zadejte počet bomb, max x*y/4");
            n = sc.nextInt();
            if(n < 0){
                end = true;
                continue;
            }
            while(n > (x*y)/4 || n<0){
                System.out.println("zadejte správnou hodnotu počtu min");
                n = sc.nextInt();
            }
            Field[][] fields = genMineSweeper(x,y,n);
            
            boolean end2 = false;
            while(!end2){
                printPole(fields);
                System.out.println("zadete vždy x a y ve formátu X Y");
                x = sc.nextInt();
                y = sc.nextInt();
                if(!(y >= fields.length || x >= fields[0].length || y < 0 || x < 0)){
                    
                
                if(fields[y][x].isBomb()){
                    System.out.println("Prohra");
                    break;
                }
                reveal(fields,x,y);
                }
            }
            
        }
        
        
        
        
//        Field[][] fields = new Field[5][5];
//        for (int i = 0; i < fields.length; i++) {
//            for (int j = 0; j < fields[i].length; j++) {
//                fields[i][j] = new Field();
//            }
//        }
//        fields[0][4].setBomb(true);
//        fields[4][0].setBomb(true);
//        fields[2][2].setBomb(true);
        
//        reveal(fields,0,0);
//        printPole(fields);
    }
    
    /*
    TODO : počítání bomb v okolí samostatná metoda
    */
    public static void reveal(Field[][] fields, int x, int y){
        if(fields[y][x].isBomb()){
            fields[y][x].setTurned(true);
            
        }else{
        if(!fields[y][x].isTurned() && !fields[y][x].isBomb()){
            fields[y][x].setTurned(true);
            
            int bombs = 0;
            for (int i = -1; i <= 1; i++) {
                for (int j = -1; j <= 1; j++) {
                    if(x+j>=0 && x+j<fields[0].length){
                        if(y+i>=0 && y+i<fields.length){
//                            if(y+i != y && x+j == x || y+i == y && x+j != x){
                                if(fields[y+i][x+j].isBomb()){
                                    bombs++;
//                                }
                            }
                        }
                    }
                }
            }
            fields[y][x].setNeighbors(bombs);
            
            if(fields[y][x].getNeighbors() == 0){
            for (int i = -1; i <= 1; i++) {
                for (int j = -1; j <= 1; j++) {
                    if(x+j>=0 && x+j<fields[0].length){
                        if(y+i>=0 && y+i<fields.length){
//                            if(y+i != y && x+j == x || y+i == y && x+j != x){
                                
                                reveal(fields,x+j,y+i);
                                    
                                
//                            }
                        }
                    }
                }
            }
            }
        }
        }
    }
    
    
    
    
    public static Field[][] genMineSweeper(int x, int y, int n){
        Field[][] fields = new Field[y][x];
        for (int i = 0; i < fields.length; i++) {
            for (int j = 0; j < fields[i].length; j++) {
                fields[i][j] = new Field();
            }
        }
        Random rnd = new Random();
        int rndx,rndy;
        for (int i = 0; i < n; i++) {
            rndx = rnd.nextInt(x);
            rndy = rnd.nextInt(y);
            if(fields[rndy][rndx].isBomb()){
                i--;
                continue;
            }
            fields[rndy][rndx].setBomb(true);
        }
        
        return fields;
    }
    
    
    public static void printPole(Field[][] fields){
        for (int i = 0; i < fields.length; i++) {
            for (int j = 0; j < fields.length; j++) {
                System.out.print(fields[i][j].isTurned()?fields[i][j].getNeighbors()+" ":"_ ");
            }
            System.out.println("");
        }
        System.out.println("\n\n");
    }
}
