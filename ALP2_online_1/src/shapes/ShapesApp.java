/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shapes;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
/**
 *
 * @author Uzivatel
 */
public class ShapesApp {
    public static Scanner sc = new Scanner(System.in);
    public static ArrayList<Shape> shapes = new ArrayList<>();
    
    public static void main(String[] args) {
        int choice;

        do {
            displayMenu();
            choice = readChoice();
            switch (choice) {
                case 0:
                    break;
                case 1:
                    clearObjects();
                    break;
                case 2:
                    addSquare();
                    break;
                case 3:
                    addRectangle();
                    break;
                case 4:
                    addCircle();
                    break;
                case 5:
                    printObjects();
                    break;
                case 6:
                    computeArea();
                    break;
                case 7:
                    findWithMaxArea();
                    break;
                case 8:
                    getObjectInfo();
                    break;
                case 9:
                    sortByArea();
                    break;
                default:
                    System.out.println("Chybna volba");
            }
        } while (choice != 0);

    }

    private static void displayMenu() {
        System.out.println("");
        System.out.println("1. Nova sada");
        System.out.println("2. Pridej ctverec");
        System.out.println("3. Pridej obdelnik");
        System.out.println("4. Pridej kruh");
        System.out.println("5. Vypis geometricke utvary");
        System.out.println("6. Vypocti celkovou plochu");
        System.out.println("7. Vypis utvar s najvetsi plochou");
        System.out.println("8. Vypis plochu vybraneho utvaru");
        System.out.println("9. sort podle plochy");
        System.out.println("0. Konec programu");
    }
    
    //TODO
    private static int readChoice() {
        return sc.nextInt();
    }
    
    //TODO umozni zadat novou sadu utvaru
    private static void clearObjects() {
        shapes.clear();
    }
    
    //TODO Square IS A Rectangle
    private static void addSquare() {
        System.out.println("Type in size of square");
        double a = sc.nextDouble();
        shapes.add(new Rectangle(a,a));
    }
    
    //TODO
    private static void addRectangle() {
        System.out.println("Type in size of a and b");
        shapes.add(new Rectangle(sc.nextDouble(),sc.nextDouble()));
    }
    
    //TODO
    private static void addCircle() {
        System.out.println("1: I want to type in R");
        System.out.println("2: I want to type in D");
        switch(sc.nextInt()){
            case 1:
                shapes.add(Circle.getInstanceR(sc.nextDouble()));
                break;
            case 2:
                shapes.add(Circle.getInstanceD(sc.nextDouble()));
                break;
            default:
                System.out.println("Error, bad value");
        }
    }
    
    //TODO typ, rozmery, obsah o vsech
    private static void printObjects() {
        for (Shape shape : shapes) {
            System.out.println(shape.toString());
        }
    }
    
    //TODO vsech dohromady
    private static void computeArea() {
        double area = 0;
        for (Shape shape : shapes) {
            area += shape.computeArea();
        }
        System.out.println("Area of all shapes is: " + area);
    }
    
    //TODO info o objekte s max area
    private static void findWithMaxArea() {
        double maxArea = Integer.MIN_VALUE;
        int currentIndex = 0;
        int maxIndex = 0;
        for (Shape shape : shapes) {
            
            if(shape.computeArea() > maxArea){
                maxArea = shape.computeArea();
                maxIndex = currentIndex;
            }
            currentIndex++;
        }
        shapes.get(maxIndex).toString();
        
    }
    
    //TODO zobrazit vsechny, nechat vybrat a o vybranem zobrazit info
    private static void getObjectInfo() {
        int i = 0;
        for (Shape shape : shapes) {
            System.out.println(i+". "+shape.getShapeName());
            i++;
        }
        System.out.println("Choose which's info you want to know");
        shapes.get(sc.nextInt()).toString();
    }
    
    private static void sortByArea(){
        Collections.sort(shapes);
    }
}
