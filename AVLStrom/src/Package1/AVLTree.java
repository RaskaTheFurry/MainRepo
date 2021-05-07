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
public class AVLTree {
    
    private Node root;
    
    public AVLTree(){
        
    }
    
    public void AddNumber(int number){
        root = AddNumberRecursive(number,this.root);
    }
    
    private Node AddNumberRecursive(int number, Node current){
        if(current == null){
            //System.out.println("New Node");
            return new Node(number);
        }
        if(current.number > number){
            //System.out.println("Left");
            current.left = AddNumberRecursive(number,current.left);
        }else{
            if(current.number <= number){
                current.right = AddNumberRecursive(number,current.right);
            }
        }
        //System.out.println("Right");
        
        return rebalance(current);
    }
    
    private void updateHeight(Node root){
        root.height = 1 + Math.max(height(root.left), height(root.right));
    }
    
    private int height(Node root){
        return root == null ? -1 : root.height;
    }
    
    int getBalance(Node root) {
        return (root == null) ? 0 : height(root.right) - height(root.left);
    }
    
    private Node rotateRight(Node y) {
        
            Node x = y.left;
            Node z = x.right;
            x.right = y;
            y.left = z;
            updateHeight(y);
            updateHeight(x);
            return x;
    }
    private Node rotateLeft(Node y) {
        
        Node x = y.right;
        Node z = x.left;
        x.left = y;
        y.right = z;
        updateHeight(y);
        updateHeight(x);
        return x;
    }
    private Node rebalance(Node z) {
        
        updateHeight(z);
        int balance = getBalance(z);
        if (balance > 1) {
            if (height(z.right.right) > height(z.right.left)) {
                z = rotateLeft(z);
            } else {
                z.right = rotateRight(z.right);
                z = rotateLeft(z);
            }
        } else if (balance < -1) {
            if (height(z.left.left) > height(z.left.right)){
                z = rotateRight(z);
            }else {
                z.left = rotateLeft(z.left);
                z = rotateRight(z);
            }
        }
        return z;
    }
    
    
    
    
    public void printNode(int n){
        // 0 InOrder ; 1 PreOrder ; 2 PostOrder
        switch(n){
            case 0:
                System.out.println("INORDER");
                printNodeInOrder(root);
                break;
            case 1:
                System.out.println("PREORDER");
                printNodePreOrder(root);
                break;
            case 2:
                System.out.println("POSTORDER");
                printNodePostOrder(root);
                break;
        }
        
    }
    
    private void printNodeInOrder(Node root){
        if(root.left != null){
            printNodeInOrder(root.left);
        }
        System.out.print(root.number+",");
        if(root.right != null){
            printNodeInOrder(root.right);
        }
    }
    
    private void printNodePostOrder(Node root){
        if (root != null) {
            printNodePostOrder(root.left);
            printNodePostOrder(root.right);
            System.out.print(root.number+",");
        }
    }
    
    private void printNodePreOrder(Node root){
        if (root != null) {
            System.out.print(root.number+",");
            printNodePreOrder(root.left);
            printNodePreOrder(root.right);
        }
    }
    
    
    
}
