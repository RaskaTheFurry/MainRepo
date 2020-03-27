/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alp2_online_1;

/**
 *
 * @author Uzivatel
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    private static Vector2[] a = new Vector2[4];

    public static void main(String[] args) {
//        Vector2 b1 = new Vector2(4,3);
//        Vector2 b2 = new Vector2();
//        Vector2 b3 = new Vector2(6,3);
//        System.out.println(b1.toString() + " ; " + b2.toString());
//        System.out.println(Vector2.distanceBetween(b1, b2));
//        System.out.println(Vector2.distanceBetween(b1, b3));

        for (int i = 0; i < a.length; i++) {
            a[i] = new Vector2();

        }
        a[0] = new Vector2(3, 4);
        a[1] = new Vector2(6,4);
        a[2] = new Vector2(6,0);
        a[3] = new Vector2(3,0);
        
        System.out.println(perimeter());
    }

    public static double perimeter() {
        double[] distances = new double[a.length];
        for (int i = 0; i < a.length; i++) {
            if (i < a.length - 1) {
                distances[i] = Vector2.distanceBetween(a[i], a[i + 1]);
            } else {
                distances[i] = Vector2.distanceBetween(a[i], a[0]);
            }
        }
        return sum(distances);
    }

    public static double sum(double[] a) {
        double sum = 0;
        for (int i = 0; i < a.length; i++) {
            sum += a[i];
        }
        return sum;
    }

}
