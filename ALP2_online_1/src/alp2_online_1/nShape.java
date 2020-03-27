/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alp2_online_1;

import java.util.ArrayList;

/**
 *
 * @author Uzivatel
 */
public class nShape {

    private static ArrayList<Vector2> x = new ArrayList<>();

    public nShape() {

    }

    public nShape(ArrayList<Vector2> x) {
        this.x = x;
    }

    public nShape(Vector2[] x) {
        for (int i = 0; i < x.length; i++) {
            this.x.add(x[i]);
        }
    }

    public void add(Vector2 x) {
        this.x.add(x);
    }

    public void add(Vector2[] x) {
        for (int i = 0; i < x.length; i++) {
            this.x.add(x[i]);

        }
    }

    public void add(ArrayList<Vector2> x) {
        this.x.addAll(x);
    }

    public void add(double x, double y) {
        this.x.add(new Vector2(x, y));
    }

    public static double perimeter() {
        double[] distances = new double[x.size()];
        for (int i = 0; i < x.size(); i++) {
            if (i < x.size() - 1) {
                distances[i] = Vector2.distanceBetween(x.get(i), x.get(i + 1));
            } else {
                distances[i] = Vector2.distanceBetween(x.get(i), x.get(0));
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

    public Vector2 nearest() {
        double minDistance = Integer.MAX_VALUE;
        Vector2 nearest = null;
        for (Vector2 vector : x) {
            if (vector.distanceFromZero() < minDistance) {
                minDistance = vector.distanceFromZero();
                nearest = vector;
            }
        }
        return nearest;
    }

    public Vector2 furthest() {
        double maxDistance = Integer.MIN_VALUE;
        Vector2 furthest = null;
        for (Vector2 vector : x) {
            if (vector.distanceFromZero() > maxDistance) {
                maxDistance = vector.distanceFromZero();
                furthest = vector;
            }
        }
        return furthest;
    }

    public double shortestBetween() {
        double minDistance = Integer.MAX_VALUE;
        double distance;
        for (int i = 0; i < x.size(); i++) {
            if (i < x.size() - 1) {
                distance = x.get(i).distance(x.get(i + 1));
            } else {
                distance = x.get(i).distance(x.get(0));
            }
            if (minDistance < distance) {
                minDistance = distance;
            }

        }
        return minDistance;
    }
    
    public double longestBetween() {
        double maxDistance = Integer.MIN_VALUE;
        double distance;
        for (int i = 0; i < x.size(); i++) {
            if (i < x.size() - 1) {
                distance = x.get(i).distance(x.get(i + 1));
            } else {
                distance = x.get(i).distance(x.get(0));
            }
            if (maxDistance > distance) {
                maxDistance = distance;
            }

        }
        return maxDistance;
    }
}
