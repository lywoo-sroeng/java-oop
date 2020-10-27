/*
The Account class
Description

Design a class named Account that contains:

- A private int data field named<id>for the account (default 0).
- A private double data field named<balance>for the account (default 0).
- A private double data field named<annualInterestRate>that stores the current interest rate (default 0). Assume all accounts have the same interest rate.
- A private Date data field named<dateCreated>that stores the datewhen the account was created.
- A no-arg constructor that creates a default account.
- A constructor that creates an account with the specified id and initial balance.
- The accessor and mutator methods for id , balance , and annualInterestRate .
- The accessor method for dateCreated .
- A method named<getMonthlyInterestRate()>that returns themonthly interest rate.
- A method named<getMonthlyInterest()>that returns the monthly interest.
- A method named<withdraw>that withdraws a specified amount from the account.
- A method named<deposit>that deposits a specified amount to the account.
Write code to simulate the process of deposit and withdrawal of the account.

MonthlyInterestRate=annualInterestRate/12

MonthlyInterest =balance *MonthlyInterestRate    (Round down)


Input
The first line of input contains id(positive integer), initial balance(positive integer) and annualInterestRate(double type), split by a space.

The next line contains a positive integer n giving the number of inputs to follow.

The next n lines describe thedeposit orwithdrawal operation.

eg.

1 100000 0.045
2
6 + 1000
1 - 9900
"1 100000 0.045" means create a account with id=1, initial balance=100000 and annualInterestRate=0.045.

"2" means there are 2 lines below.

"6 + 1000" means some persondeposit $1000 into this account after 6 days since the date of account creation.

"1 - 9900" means some personwithdraw $9900 from this account after 1 day since the day of last operation happens.


Output
In the first line, you should print the time for the account's dateCreated in format like "year-month".

In the next every line, you should print the account's balance after thedeposit orwithdrawaloperation immediately.



Spectially,

The account settles interest at the monthly interest rate every 30 days, and the settlement time is after all the operations performed on that day.
If there is not enough money in the account, the withdrawal operation will fail. At this time, the account balance will not be printed, and “Insufficient Balance.” will beprintedinstead.

Sample Input 1 
1 100000 0.045
3
6 + 1000
1 - 9900
7 + 12700

Sample Output 1
2020-10
101000
91100
103800

Sample Input 2 
5 0 0.5
5
30 - 100
0 + 100
1 - 100
0 + 1000
30 - 1000

Sample Output 2
2020-10
Insufficient Balance.
100
4
1004
45

*/
package app;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AccountMain {

  public static void main(String[] args) {
    try {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM");
      String[] strs = br.readLine().split(" ");
      Account account = new Account(Integer.parseInt(strs[0]), Long.parseLong(strs[1]));
      account.setAnnualInterestRate(Double.parseDouble(strs[2]));
      System.out.println(ft.format(account.getDateCreated()));
      int n = Integer.parseInt(br.readLine());
      int days = 0;
      for (int i = 0; i < n; i++) {
        String[] strs1 = br.readLine().split(" ");
        int day = Integer.parseInt(strs1[0]);
        String operation = strs1[1];
        long amount = Long.parseLong(strs1[2]);
        days += day;
        if (operation.equals("+")) {
          account.deposit(amount);
          if (days > 30) {
            int num = days / 30;
            days = days % 30;
            if (days == 0) {
              num = num == 1 ? 1 : num - 1;
            }
            for (int j = 0; j < num; j++) {
              account.deposit(account.getMonthlyInterest());
            }
          }
          System.out.println(account.getBalance());
        } else {
          if (account.getBalance() >= amount) {
            if (days > 30) {
              int num = days / 30;
              days = days % 30;
              if (days == 0) {
                num = num == 1 ? 1 : num - 1;
              }
              for (int j = 0; j < num; j++) {
                account.deposit(account.getMonthlyInterest());
              }
            }
            account.withdraw(amount);
            System.out.println(account.getBalance());
          } else {
            System.out.println("Insufficient Balance.");
          }
        }
      }
    } catch (IOException e) {
    }
  }

  public static class Account {
    private int id;
    private long balance;
    private static double annualInterestRate;
    private Date dateCreated;

    public Account() {
      dateCreated = new Date();
    }

    public Account(int id, long balance) {
      this.id = id;
      this.balance = balance;
      this.dateCreated = new Date();
    }

    public int getId() {
      return id;
    }

    public void setId(int id) {
      this.id = id;
    }

    public long getBalance() {
      return balance;
    }

    public void setBalance(long balance) {
      this.balance = balance;
    }

    public double getAnnualInterestRate() {
      return Account.annualInterestRate;
    }

    public void setAnnualInterestRate(double annualInterestRate) {
      Account.annualInterestRate = annualInterestRate;
    }

    public Date getDateCreated() {
      return dateCreated;
    }

    public double getMonthlyInterestRate() {
      return getAnnualInterestRate() / 12;
    }

    public long getMonthlyInterest() {
      return Math.round(Math.floor(balance * getMonthlyInterestRate()));
    }

    public void withdraw(long amount) {
      balance -= amount;
    }

    public void deposit(long amount) {
      balance += amount;
    }
  }

}