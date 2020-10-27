/*
The Rectangle class
Description

Design a class named<Rectangle>to represent a rectangle. The class contains:

- Two double data fields named width and height that specify the width andheight of the rectangle. The default values are<1>for both<width>and<height>.
- A no-arg constructor that creates a default rectangle.
- A constructor that creates a rectangle with the specified width and height.
- A method named<getArea()>that returns the area of this rectangle.

Input
The first line of input contains a positive integerngiving the number of inputs to follow.

The width and weight of a rectangle is given one row split by a space in the next n lines.


Output
The output contains n lines.


Sample Input 1 
1
4 40

Sample Output 1
160.0

Sample Input 2 
2
0.5 0.7
1 40

Sample Output 2
0.35
40.00

*/
package app;

import java.io.*;

public class RectangleMain {
  public static void main(String args[]) {
    try {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int n = Integer.parseInt(br.readLine());
      for (int i = 0; i < n; i++) {
        String[] strs = br.readLine().split(" ");
        Rectangle rectangle;
        if (strs.length != 2) {
          rectangle = new Rectangle();
        } else {
          rectangle = new Rectangle(Double.parseDouble(strs[0]), Double.parseDouble(strs[1]));
        }
        System.out.println(String.format("%.2f", rectangle.getArea()));
      }
    } catch (IOException e) {
    }
  }

  public static class Rectangle {
    double width = 1.00;
    double height = 1.00;

    public Rectangle() {
    }

    public Rectangle(double width, double height) {
      this.width = width;
      this.height = height;
    }

    public double getArea() {
      return this.width * this.height;
    }
  }
}