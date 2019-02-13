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
public class DistPar implements Serializable { // distance and parent
    // items stored in sPath array

    public int distance;   // distance from start to this vertex
    public int parentVert; // current parent of this vertex
// -------------------------------------------------------------

    public DistPar(int pv, int d) { // constructor

        distance = d;
        parentVert = pv;
    }

    public int getParent() {
        return parentVert;
    }
// -------------------------------------------------------------
}  // end class DistPar
///////////////////////////////////////////////////////////////
