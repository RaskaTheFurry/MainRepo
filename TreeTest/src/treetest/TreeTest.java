/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package treetest;

import java.util.Random;
import java.util.Scanner;
/**
 *
 * @author Uzivatel
 */
public class TreeTest {
    public static int counter = 1;
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        Tree tree = new Tree();
        boolean end = false;
        int number;
        while(sc.hasNextInt()){
            
            number = sc.nextInt();
            if(number >= 0){
                tree.add(number);
                
            }else{
                end = true;
            }
            
        }
        System.out.println("preorder");
        tree.PreOrder(tree.root);
        System.out.println("inorder");
        tree.InOrder(tree.root);
        System.out.println("postorder");
        tree.PostOrder(tree.root);
        
//        Node uzel = tree.find(number);
//        System.out.println(uzel);
        
    }

    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int value) {
            this.value = value;
        }

        public Node add(int value) {
            if (value > this.value) {
                if (this.right == null) {
                    this.right = new Node(value);
                    return this.right;
                } else {
                    return this.right.add(value);
                }
            } else {
                if (this.left == null) {
                    this.left = new Node(value);
                    return this.left;
                } else {
                    return this.left.add(value);
                }
            }
        }

        public Node find(int value) {
            System.out.format("Find: %d%n", counter++);

            if (value == this.value) {
                return this;
            }
            if (value > this.value) {
                return this.right == null
                    ? null
                    : this.right.find(value);
            } else {
                return this.left == null
                    ? null
                    : this.left.find(value);
            }
        }
        
        
    }

    public static class Tree {
        public Node root;

        public void add(int value) {
            if (root == null) {
                root = new Node(value);
            } else {
                root.add(value);
            }
        }

        public Node find(int value) {
            if(this.root == null) {
                return null;
            }
            
            return this.root.find(value);
        }
        public void PreOrder(Node value){
            System.out.println(value.value);
            if(value.left == null){
                if(value.right != null){
                    PreOrder(value.right);
                }
            }else{
                PreOrder(value.left);
                if(value.right == null){
                    
                }else{
                    PreOrder(value.right);
                }
            }
        }
        public void PostOrder(Node value){
            
            if(value.left == null){
                
                if(value.right != null){
                    PostOrder(value.right);
                    
                }
            }else{
                PostOrder(value.left);
                if(value.right == null){
                    
                }else{
                    PostOrder(value.right);
                    
                }
            }
            System.out.println(value.value);
        }
        
        public void InOrder(Node value){
            if(value.left != null){
                InOrder(value.left);
            }
            System.out.println(value.value);
            if(value.right != null){
                InOrder(value.right);
            }
            
        }
    }
}
    

