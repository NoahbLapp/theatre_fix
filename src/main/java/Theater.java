package main.java;
import java.util.ArrayList;

public class Theater {
    public Customer[][] seats;

    /*
    * * Creates a Theater seating chart with the given number of rows and columns
    * from the Customers in customerList. Empty seats are represented by null.
    *
    * @param rows the number of rows of seats in the theater
    * 
    * @param cols the number of columns of seats in the theater
    * 
    * @param customerList The customers to be given seats in the theater
    * 
    * @param rand indicator if customers should be given random seats
    * 
    * Precondition: rows > 0; cols > 0;
    * rows * cols >= customerList.size()
    * Postcondition:
    * - Customers appear in the seats in the same order as they appear in
    * customerList, starting at seats[0][0], and seats is filled row by row from
    * customerList, followed by any empty seats (represented by null).
    * OR
    * Customers are placed in the seats in random order, with empty seats null
    * - customerList is unchanged.
    */

   public Theater(int rows, int cols, ArrayList<Customer> customerList) {
    // Construct the seats 2D array
    seats = new Customer[rows][cols];

    int index = 0;
    for (int r = 0; r < rows; r++) {
       for (int c = 0; c < cols; c++) {
          if (index < customerList.size()) {
             seats[r][c] = customerList.get(index);
             index++;
          }
       }
    }
 }


 /*
  * This method should return true if the seat is occupied, false otherwise.
  */
 public boolean isSeatOccupied(int row, int col) {
 

    // placeholder
    return false;

 }

 /*
  * This method should return the row number with the greatest number of occupied
  * seats
  */
 public int findMostOccupiedRow() {
    return -1;// placeholder
 }

 /*
  * This method should return the tallest customer in the theater
  */
 public Customer getTallestCustomer() {
    return null;
 }

 /*
  * This method should return a list of Customers who need to have their seats
  * moved
  * because there is someone more than 3 inches taller than them sitting directly
  * in front of them (one row closer, but in the same seat).
  *
  * This method does not actually change any seats, but constructs and returns a
  * NEW
  * arrayList filled with customers who have someone sitting in front of them
  * that
  * is more than 3 inches taller than they are.
  */
 public ArrayList<Customer> getCustomersToBeMoved() {
    return null;
 }

 /*
  * This method returns a String that can be used to print out the contents
  * of the seats in the theater
  */
 public String toString() {
    String output = "";

    for (int r = 0; r < seats.length; r++) {
       output = output + "[" + r + "] ";
       for (int c = 0; c < seats[r].length; c++) {
          if (seats[r][c] == null)
             output = output + "<empty>        ";
          else
             output = output + seats[r][c];
       }
       output = output + "\n";
    }
    return output;
 }
}
