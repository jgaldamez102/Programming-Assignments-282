/**
 * Created by : Joses Galdamez, for Computer Science 282, for Professor Ferguson.
 * Project 3 has four classes, in which PathApp.java implements a menu that 
 * allows the user to choose a specific function for the graph (add, change, etc)
 * and executes that upon the graph pre-made. Vertex.java and Graph.java create
 * both the graph and vertexes, which overall impact the creation of a graph.
 *  
 */
package project3_282;

import java.io.Serializable;
/**
 *
 * @author josesgaldamez
 */
public class Vertex implements Serializable{
   public char label; 
   public boolean isInTree;
// -------------------------------------------------------------
   public Vertex(char lab)   // constructor
      {
      label = lab;
      isInTree = false;
      }
// -------------------------------------------------------------
   }  // end class Vertex
////////////////////////////////////////////////////////////////