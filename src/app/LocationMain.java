/*
The Location class
Description

Design a class named Location for locating a maximalvalue and its location in a two-dimensional array. The class contains public datafields row, column, and maxValue that store the maximal value and its indicesin a two-dimensional array with row and column as int types and maxValue asa double type.

Write the following method that returns the location of the largest element in a two-dimensional array:

public static Location locateLargest(double[][] a)



Override theLocation class's toString() method.

The return value is an instance of Location. Write a program that accepts a two-dimensional array input and displays the location of the largest element in the array.


Input
The first line of input contains two positive integers m and n, where m means thetwo-dimensional array has m rows, and n meansthetwo-dimensional array has n columns.

The next m lines are array values.Each line contains n floating point numbers.


Output
Display max value and its position in format "The location of the largest element is maxValue at (row, column)."

Sample Input 1 
2 3
1 3 4
2 8 6

Sample Output 1
The location of the largest element is 8.0 at (1, 1).

Sample Input 2 
1 1
10
Sample Output 2
The location of the largest element is 10.0 at (0, 0).

 */

package app;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LocationMain {

  public static void main(String[] args) {
    try {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      String[] strs = br.readLine().split(" ");
      int m = Integer.parseInt(strs[0]);
      int n = Integer.parseInt(strs[1]);
      double[][] a = new double[m][n];
      for (int i = 0; i < m; i++) {
        strs = br.readLine().split(" ");
        for (int j = 0; j < n; j++) {
          a[i][j] = Double.parseDouble(strs[j]);
        }
      }
      Location location = locateLargest(a);
      System.out.println(location.toString());
    } catch (IOException e) {
    }
  }

  public static Location locateLargest(double[][] a) {
    int row = 0;
    int column = 0;
    double maxValue = a[row][column];
    for (int i = 0; i < a.length; i++) {
      for (int j = 0; j < a[i].length; j++) {
        if (maxValue < a[i][j]) {
          maxValue = a[i][j];
          row = i;
          column = j;
        }
      }
    }
    Location location = new Location();
    location.update(row, column, maxValue);
    return location;
  }

  public static class Location {
    public int row;
    public int column;
    public double maxValue;

    public Location() {
    }

    public void update(int row, int column, double maxValue) {
      this.row = row;
      this.column = column;
      this.maxValue = maxValue;
    }

    public String toString() {
      return "The location of the largest element is " + maxValue + " at (" + row + ", " + column + ").";
    }

  }

}
