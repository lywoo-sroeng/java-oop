/*
Algebra: quadratic equations
Description

Design a class named QuadraticEquation fora quadratic equationimage.png. The class contains:

- Private data fields a, b, and c that represent three coefficients.

- A constructor for the arguments for a, b, and c.

- Three getter methods for a, b, and c.

- A method named getDiscriminant() that returns the discriminant, which Math.pow(b,2) - 4 * a * c.

- The methods named getRoot1() and getRoot2() for returning two roots ofthe equation,

r1 = -b + Math.sqrt(getDiscriminant())) / 2 * a

r2 = -b - Math.sqrt(getDiscriminant())) / 2 * a

These methods are useful only if the discriminant is nonnegative. Let these methods return 0 if the discriminant is negative.

Write aprogram that accepts values a, b, and c and displays the result based on the discriminant. If the discriminant is positive, display the two roots. If the discriminant is 0, display the one root. Otherwise, display “The equation hasno roots.”


Input
A line contains a,b and c(double type) splited by a space.


Output
If the equation is a quadratic equation,displays the discriminant first. And thenaccording to the discriminant, if the discriminant is positive, display the two roots(two decimal places). If the discriminant is 0, display the one root(two decimal places). Otherwise, display "The equation has no roots."

If the euqation is a linear equation,display the root(two decimal places)directly.

If the equation is an identity, display "The equation has infinite roots."


Sample Input 1 
1 2 1
Sample Output 1
0.00
-1.00

Sample Input 2 
1 1 1
Sample Output 2
-3.00
The equation has no roots.

Sample Input 3 
1 3 1
Sample Output 3
5.00
-0.38
-2.62

*/
package app;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class QuadraticEquationMain {

  public static void main(String[] args) {
    try {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      String[] strs = br.readLine().split(" ");
      double a = Double.parseDouble(strs[0]);
      double b = Double.parseDouble(strs[1]);
      double c = Double.parseDouble(strs[2]);
      QuadraticEquation quadraticEquation = new QuadraticEquation(a, b, c);
      // The equation is a quadratic equation
      if (a != 0) {
        System.out.println(String.format("%.2f", quadraticEquation.getDiscriminant()));
        if (quadraticEquation.getDiscriminant() > 0) {
          System.out.println(String.format("%.2f", quadraticEquation.getRoot1()));
          System.out.println(String.format("%.2f", quadraticEquation.getRoot2()));
        } else if (quadraticEquation.getDiscriminant() == 0) {
          System.out.println(String.format("%.2f", -b / 2 * a));
        } else {
          System.out.println("The equation has no roots.");
        }
      } 
      // The equation is a linear equation
      else if (a == 0 && b != 0) {
        System.out.println(String.format("%.2f", -c / b));
      } 
      // The equation is an identity
      else if (a == 0 && b == 0 && c == 0) {
        System.out.println("The equation has infinite roots.");
      } else {
        System.out.println("The equation has no roots.");
      }
    } catch (IOException e) {
    }
  }

  public static class QuadraticEquation {
    private double a;
    private double b;
    private double c;

    public QuadraticEquation(double a, double b, double c) {
      this.a = a;
      this.b = b;
      this.c = c;
    }

    public double getA() {
      return a;
    }

    public double getB() {
      return b;
    }

    public double getC() {
      return c;
    }

    public double getDiscriminant() {
      return Math.pow(b, 2) - 4 * a * c;
    }

    public double getRoot1() {
      return getDiscriminant() > 0 ? ((-b + Math.sqrt(getDiscriminant())) / 2 * a) : 0;
    }

    public double getRoot2() {
      return getDiscriminant() > 0 ? ((-b - Math.sqrt(getDiscriminant())) / 2 * a) : 0;
    }
  }

}
