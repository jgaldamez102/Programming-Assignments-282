/*
 * Created by; Joses Galdamez, for CMPSCI 282, for Professor Ferguson.
 * Project 2 allows (1)the user to input an order number they want for their 
 * specific B-Tree, in which they are allowed to input values into. Then it 
 * gives the option of either finding a value or displaying the tree.(2) Phase 3 
 * allows the user to use a data text file to import the records into a B-Tree.
 * 11/8/2017
 */
package project2_282;

import java.io.*;
import java.util.Scanner;

public class Tree234App {

    public static void main(String[] args) throws IOException {

        long value;

        Tree234 tree1 = new Tree234();
        System.out.print("Enter the Order of the Tree: ");
        int order1 = getInt();
        if (order1 > 4) {
            tree1.getRoot().setOrder(order1);
            tree1 = new BTree();
            System.out.println("A B-Tree Is Created With an Order of " + tree1.getRoot().getOrder());
        } else {
            System.out.println("A 234-Tree is Created With An Order of 4");
        }

        // From the example
        /*theTree.insert(50);
 
      theTree.insert(40);
 
      theTree.insert(60);
 
      theTree.insert(30);
 
      theTree.insert(70);
 
         */
        while (true) {

            System.out.print("Enter first letter of ");

            System.out.print("show, insert, change, read, find, or 'q' to exit: ");

            char choice = getChar();

            switch (choice) {

                //Change the order
                case 'c':
                    System.out.println("Enter the new order of the tree.");
                    int order2 = getInt();
                    System.out.println("New Empty Tree is Created, Current One Will Be Deleted");
                    if (order2 > 4) {
                        tree1.getRoot().setOrder(order2);
                        tree1 = new BTree();
                        System.out.println("A B-Tree with an order of " + tree1.getRoot().getOrder()
                                + " has been created");
                    } else {
                        System.out.println("A 234-Tree is Created With An Order of 4");
                        tree1 = new Tree234();
                    }
                    break;

                //Read the data file
                case 'r':
                    readData(tree1.getRoot().getOrder(), tree1);
                    break;

                //Exit the program
                case 'q':
                    System.exit(0);
                    break;

                //Display the tree.
                case 's':
                    tree1.displayTree();
                    break;

                //Insert a value.
                case 'i':
                    System.out.print("Enter value to insert: ");
                    value = getInt();
                    tree1.insert(value);
                    tree1.displayTree();
                    break;

                //Find a value for the tree.
                case 'f':
                    System.out.print("Enter numerical value to find: ");
                    value = getInt();
                    int found = tree1.find(value);
                    if (found != -1) {
                        System.out.println("Found " + value);
                    } else {
                        System.out.println("Tree does not have the number " + value);
                    }
                    break;

                default:

                    System.out.print("Invalid entry, try again!\n");

            }

        }

    }

//--------------------------------------------------------------
    public static String getString() throws IOException {

        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String s = br.readLine();
        return s;
    }

//--------------------------------------------------------------
    public static char getChar() throws IOException {
        String s = getString();
        return s.charAt(0);
    }

//-------------------------------------------------------------
    public static int getInt() throws IOException {
        String s = getString();
        return Integer.parseInt(s);
    }

//-------------------------------------------------------------   
    //For Phase 3
    public static void readData(int order, Tree234 theTree) throws IOException {
        System.out.println("Name of the text file to import? Include"
                + " the .txt at the end");
        String file = getString();
        System.out.println("The current order of the tree is " + order);
        System.out.println("Do you want the order to change? (Y/N) ");
        char yesOrNo = getChar();
        if (yesOrNo == 'Y' || yesOrNo == 'y') {
            System.out.println("Enter the new order you want for the tree.");
            int newOrder = getInt();
        }

        FileInputStream fstream = new FileInputStream(file);
        BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
        String line;
        while ((line = br.readLine()) != null) {
            String[] parts = line.split(",");
            long number = Long.parseLong(parts[0]);
            theTree.insert2(number, line);
        }
        br.close();

    }

}
