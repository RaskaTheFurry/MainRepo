/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Package1;

/**
 *
 * @author Uzivatel
 */
public class Node {
    public int number;
    public Node left,right ;
    public int height;
    
    public Node(int number){
        this.number = number;
        left = null;
        right = null;
    }
    
}
