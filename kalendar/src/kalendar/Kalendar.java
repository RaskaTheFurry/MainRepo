/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kalendar;

import java.util.Scanner;


public class Kalendar {
    private static Scanner sc = new Scanner(System.in);
    
    public static void main(String[] args) {
        KalendarArray calendar = new KalendarArray(16,4,2020);
        System.out.format("%02d.%02d.%d \n", calendar.getDay(),calendar.getMonth(),calendar.getYear());
        printArray(calendar.getCalendar());
        boolean stop = false;
        while(!stop){
            int nextAction = sc.nextInt();
            if(nextAction == 0){
                stop = true;
            }
            if(nextAction<0){
                calendar.lowerMonth();
                System.out.format("%02d.%02d.%d \n", calendar.getDay(),calendar.getMonth(),calendar.getYear());
                printArray(calendar.getCalendar());
            }
            if(nextAction>0){
                calendar.raiseMonth();
                System.out.format("%02d.%02d.%d \n", calendar.getDay(),calendar.getMonth(),calendar.getYear());
                printArray(calendar.getCalendar());
            }
        }
    }
    
    private static void printArray(int[][] numberArray) {
        for (int[] pole : numberArray) {
            for (int number : pole) {
                System.out.print(number + " ");
            }
            System.out.println();
        }
    }
    
    
    
}
