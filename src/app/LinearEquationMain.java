/*
Algebra: 2 * 2 linear equations
Description

Design a class named LinearEquation for a 2 * 2 system of linear equations:

ax + by = e
cx + dy = f

x = (ed - bf) / (ad - bc)
y = (af - ec) / (ad - bc)

The class contains:

- Private data fields a, b, c, d, e, and f.
- A constructor with the arguments for a, b, c, d, e, and f.
- Six getter methods for a, b, c, d, e, and f.
- A method named isSolvable() that returns true if ad - bc is not 0.
- Methods getX() and getY() that return the solution for the equation.

Input
A line contains a,b, c, d, e and f(double type) splited by a space.


Output
Calculate X and Y(two decimal places), and displays the result in format  "(X, Y)".

Sample Input 1 
1 2 3 4 5 6
Sample Output 1
(-4.00, 4.50)

Sample Input 2 
2 3 4 6 8 10
Sample Output 2
The equation has no solution.

*/
package app;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LinearEquationMain {

  public static void main(String[] args) {
    try {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      String[] strs = br.readLine().split(" ");
      double a = Double.parseDouble(strs[0]);
      double b = Double.parseDouble(strs[1]);
      double c = Double.parseDouble(strs[2]);
      double d = Double.parseDouble(strs[3]);
      double e = Double.parseDouble(strs[4]);
      double f = Double.parseDouble(strs[5]);
      LinearEquation le = new LinearEquation(a, b, c, d, e, f);
      if (le.isSolvable()) {
        System.out.println(String.format("(%.2f, %.2f)", le.getX(), le.getY()));
      } else {
        System.out.println("The equation has no solution.");
      }
    } catch (IOException e) {
    }
  }

  public static class LinearEquation {
    private double a;
    private double b;
    private double c;
    private double d;
    private double e;
    private double f;

    public LinearEquation(double a, double b, double c, double d, double e, double f) {
      this.a = a;
      this.b = b;
      this.c = c;
      this.d = d;
      this.e = e;
      this.f = f;
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

    public double getD() {
      return d;
    }

    public double getE() {
      return e;
    }

    public double getF() {
      return f;
    }

    public boolean isSolvable() {
      return (a * d - b * c) != 0 ? true : false;
    }

    public double getX() {
      return (e * d - b * f) / (a * d - b * c);
    }

    public double getY() {
      return (a * f - e * c) / (a * d - b * c);
    }
  }

}
