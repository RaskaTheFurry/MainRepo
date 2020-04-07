/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alp2_online_1;
import java.util.Scanner;
/**
 *
 * @author Uzivatel
 */
public class NewMain {

    static Scanner sc = new Scanner(System.in);
    
    
    public static void main(String[] args) {
        nShape shape = new nShape();
        boolean stop = false;
        while (!stop) {
            System.out.println("1. Add Bod\n2. count area and perimeter\n3. konec");
            switch(sc.nextInt()){
                case 1:
                    shape.add(sc.nextDouble(), sc.nextDouble());
                    break;
                case 2:
                    System.out.println("Objem: " + shape.perimeter() + " ; Obsah: " + shape.area());
                    break;
                case 3:
                    stop = true;
                    break;
            }
        }
    }
    
}
