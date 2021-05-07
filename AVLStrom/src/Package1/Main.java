/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Package1;

import java.util.Scanner;

/**
 *
 * @author Uzivatel
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        AVLTree tree = new AVLTree();
        // 2 8 2 8 6 -1
        // 0 InOrder ; 1 PreOrder ; 2 PostOrder
        boolean stop = false;
        Scanner sc = new Scanner(System.in);
        int num;
        while(!stop){
            num = sc.nextInt();
            if(num == -1){
                stop = true;
            }else{
            
            tree.AddNumber(num);
            }
        }
        tree.printNode(1);
        System.out.println("");
        tree.printNode(0);
        System.out.println("");
        tree.printNode(2);
        System.out.println("");
    }
    
}
