/**
 * Created by : Joses Galdamez, for Computer Science 282, for Professor Ferguson.
 * Project 3 has four classes, in which PathApp.java implements a menu that 
 * allows the user to choose a specific function for a graph (add, change, etc)
 * and executes that upon the graph pre-made. Vertex.java and Graph.java create
 * both the graph and vertexes, which overall impact the creation of a graph.
 *  
 */
package project3_282;

/**
 *
 * @author josesgaldamez
 */
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class PathApp {

    public static void main(String[] args) throws Exception {
        Graph theGraph = new Graph(); 
        //Information that started from the textbook code, we work from this 
        //information and add onto it
        theGraph.addVertex('A');     // 0  (start)
        theGraph.addVertex('B');     // 1
        theGraph.addVertex('C');     // 2
        theGraph.addVertex('D');     // 3
        theGraph.addVertex('E');     // 4

        theGraph.addEdge(0, 1, 50);  // AB 50
        theGraph.addEdge(0, 3, 80);  // AD 80
        theGraph.addEdge(1, 2, 60);  // BC 60
        theGraph.addEdge(1, 3, 90);  // BD 90
        theGraph.addEdge(2, 4, 40);  // CE 40
        theGraph.addEdge(3, 2, 20);  // DC 20
        theGraph.addEdge(3, 4, 70);  // DE 70
        theGraph.addEdge(4, 1, 50);  // EB 50

        System.out.println("Shortest paths");
        theGraph.path();             // shortest paths
        System.out.println();

        //Menu
        while (true) {
            System.out.println("\nPick the first letter for each option: ");
            System.out.println("C-Change the weight of an edge."
                    + "\nA-Add an edge. \nD-Delete an edge. "
                    + "\nF-Find path(s) from a vertex."
                    + "\nR-Read/W-Write a Graph. "
                    + "\nQ-Quit the program");
            char option = getChar();

            switch (Character.toUpperCase(option)) {
                //Change case
                case 'C':
                    System.out.println("\nWhich start vertex?");
                    String startVertex = getString();
                    System.out.println("Which end vertex?");
                    String endVertex = getString();
                    
                    int first = LettersToNumbers(startVertex.charAt(0));
                    int second = LettersToNumbers(endVertex.charAt(0));

                    if (theGraph.checkEdge(first, second) == true) {
                        System.out.println("Please enter the new weight between "
                                + "vertex " + startVertex + " and vertex " + endVertex);
                        int newWeight = getInt();
                        theGraph.addEdge(first, second, newWeight);
                        System.out.println("New weight between " + startVertex
                                + " and " + endVertex + " is now " + 
                                theGraph.getWeight(first, second));
                    } 
                    else {
                        System.out.println("Edge doesnt exist!!\n");
                    }
                    theGraph.path();
                    break;
                    //Add case
                case 'A':
                    System.out.println("\nStart vertex for the edge?");
                    char startVertexEdge = getChar();
                    System.out.println("End vertex for the edge?");
                    char endVertexEdge = getChar();
                    int startEdge = LettersToNumbers(startVertexEdge);
                    int endEdge = LettersToNumbers(endVertexEdge);

                    if ((theGraph.checkVertex(startEdge) && theGraph.checkVertex(endEdge)) == false) {
                        System.out.println("Enter a valid vertex");
                    }
                   
                    else if (theGraph.checkEdge(startEdge, endEdge) == false) {
                        System.out.println("What is the weight between " +
                                startVertexEdge + " and " + endVertexEdge + " ?");
                        int weight = getInt();
                        theGraph.addEdge(startEdge, endEdge, weight);
                    } 
                    else {
                        System.out.println("An edge already exists between " + startVertexEdge
                                + " and " + endVertexEdge); 
                    }
                    theGraph.path();
                    break;
                    //Delete
                case 'D':
                    System.out.println("Type in the start vertex you want deleted ?");
                    char from = getChar();
                    System.out.println("To what vertex ?");
                    char to = getChar();
                    int from1 = LettersToNumbers(from);
                    int to1 = LettersToNumbers(to);
                    
                    
                    if (theGraph.checkEdge(from1, to1) == true) {
                        theGraph.deleteEdge(from1, to1);
                        System.out.println("The edge Between " + from + " and " + to
                                + " is now deleted.");
                    } 
                    else {
                        System.out.println("Edge doesnt exist from" + from
                                + " to " + to);  //Tell the user an edge doesnt exits
                    }
                    theGraph.path();
                    break;
                    //Find case
                case 'F':
                    System.out.println("What vertex are you trying to find?");
                    char index = getChar();
                    theGraph.getPath(LettersToNumbers(index));
                    System.out.println("Path shows at the bottom of square "
                            + "objects that print out, if none are printed "
                            + "then no path is found.");
                    theGraph.path();
                    break;
                    //Write case
                case 'W':
                    System.out.println("What is the file name you wish to write "
                            + "to? Include the .txt (default file is Graph.txt ");
                    String file = getString();
                    ObjectOutputStream write = new ObjectOutputStream(new FileOutputStream(file));
                    write.writeObject(theGraph);
                    System.out.println("The File " + file + " Has Been Written!");
                    write.close();
                    theGraph.path();
                    break;
                    //Read case, build fails if file is read before any is written
                    //within the same build frame.
                case 'R':
                    System.out.println("What file do you want to read from?");
                    file = getString();
                    Graph newGraph = null;
                    ObjectInputStream read = new ObjectInputStream(new FileInputStream(file));
                    try {
                        newGraph = (Graph) read.readObject();
                        theGraph = newGraph;
                        System.out.println("Current Graph Has Been Replaced With"
                                + " The File  " + file + " We Read!");
                        theGraph.path();
                        read.close();
                    } 
                    catch (IOException ex) {
                        //Just in the case that the file is not found
                        System.out.println("the file " + ex.getLocalizedMessage().toString()
                        + " does not exist, try another file another time");
                        System.exit(-1);
                    }
                    break;
                    //Quit case, displays cheapest paths
                case 'Q':
                    theGraph.path();
                    System.exit(0);
            }
        }
    }
    
    

    public static String getString() throws IOException {

        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String s = br.readLine();
        return s;
    }
    public static char getChar() throws IOException {
        String s = getString();
        return s.charAt(0);
    }
    public static int getInt() throws IOException {
        String s = getString();
        return Integer.parseInt(s);
    }

    //Letter to number converter
    public static int LettersToNumbers(char letter) {
        int num = (int) (Character.toLowerCase(letter));
        if (num <= 122 & num >= 97) {
            return num - 97;
        }
        return 0;
    }
}