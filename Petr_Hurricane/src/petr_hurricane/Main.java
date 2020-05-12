/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package petr_hurricane;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Uzivatel
 */
public class Main {
    static Scanner sc;
    static ArrayList<Hurricane> hurricanes = new ArrayList<>();
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        
        try {
            sc = new Scanner(new File("hurricanedata.txt"));
            while(sc.hasNextLine()){
                String temp1 = sc.nextLine();
//                System.out.println(temp1);
                String[] temp = temp1.split("\t");
                
//                System.out.println(temp[0]);
                hurricanes.add(Hurricane.initialize(Integer.parseInt(temp[0]), temp[1], Double.parseDouble(temp[2]), Double.parseDouble(temp[3]), temp[4]));
                
            
            }
            
            
            
            sc = new Scanner(System.in);
            System.out.println("Zadejte rozemzí 2 roků");
            writeHurricanesInYears(sc.nextInt(), sc.nextInt());
            
            
            boolean stop = false;
            
            while(!stop){
                System.out.println("0 = stop\njakékoliv číslo = zadej jméno hurikánu");
                switch(sc.nextInt()){
                    case 0:
                        stop = true;
                        break;
                    default:
                        System.out.println("Zadej jméno hurtikánu");
                        String getHurricane = sc.next();
                        Hurricane hur = getHurricaneByName(getHurricane);
                        System.out.format("Hurikán jménem %s měl rychlost %.2f km a je kategorie %s \n", hur.getName(),hur.getSpeedInKm(), hur.getSeverity());
                        break;
                }
            }
            
            Collections.sort(hurricanes);
            for (int i = 0; i < hurricanes.size(); i++) {
                System.out.println(hurricanes.get(i).toString());
                
            }
            
            
            
        } catch (FileNotFoundException ex) {
            System.out.println("Chyba: Soubor neexistuje");
        }
    }
    
    
    private static Hurricane getHurricaneByName(String str) {
        for (int i = 0; i < hurricanes.size(); i++) {
            if (hurricanes.get(i).getName().equals(str)) {
                return hurricanes.get(i);
            }

        }
        return null;
    }
    
    private static void writeHurricanesInYears(int a, int b){
        for (int i = 0; i < hurricanes.size(); i++) {
            if(hurricanes.get(i).getYear()>=a && hurricanes.get(i).getYear()<=b){
                System.out.println(hurricanes.get(i).toString());
            }
            
        }
    }
    
}
