/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment4;



//import required classes and packages
import java.lang.*;

//creating MinimumSpanningTreeCalculation class to implement Prim's algorithm in Java
class minimumSpanningTreeCalculation {
    // Define the count of vertices available in the graph
    private static final int count = 8;

    // create minKVertex() method for finding the vertex v that has minimum key-value
    int minKVertex(int keys[], Boolean[] arrayOfMST)
    {
        // Initialize min value and its index
        int minimum_index = -1;
        int minimum_value = Integer.MAX_VALUE;

        //iterate over all vertices to find minimum key-value vertex
        for (int vertex = 0; vertex < count; vertex++)
            if (arrayOfMST[vertex] == false && keys[vertex] < minimum_value) {
                minimum_value = keys[vertex];
                minimum_index = vertex;
            }

        return minimum_index;
    }

    // create a printing minimumSpanningTree
    void minimumSpanningTree(int mstArray[], int graphArray[][])
    {
        int total_cost = 0;

        System.out.println("Edge             Weight");
        for (int j = 1; j < count; j++) {
            System.out.println(mstArray[j]+1 + " --------- " + (j+1) + "       "  + graphArray[j][mstArray[j]]);
            total_cost += graphArray[j][mstArray[j]];
        }

        System.out.println("\r\nThe total cost is: " + total_cost);
    }

    // create printMinimumSapnningTree() method for constructing and printing the Tree.
    void printMinimumSapnningTree(int[][] gArray)
    {
        // create array of size total number of vertices
        int mstArray[] = new int[count];

        // create keys[]
        int keys[] = new int[count];

        // create setOfMST array
        Boolean setOfMST[] = new Boolean[count];

        // set the value of the keys to infinite
        for (int j = 0; j < count; j++) {
            keys[j] = Integer.MAX_VALUE;
            setOfMST[j] = false;
        }

        // set value 0 to the 1st vertex because first vertes always include in MST.
        keys[0] = 0; // it select as first vertex
        mstArray[0] = -1; // set first value of mstArray to -1 to make it root of MST

        // The vertices in the MST will be equal to the count
        for (int i = 0; i < count - 1; i++) {
            // select the vertex having minimum key and that is not added in the MST yet from the set of vertices
            int edge = minKVertex(keys, setOfMST);

            // Add the selected minimum key vertex to the setOfMST
            setOfMST[edge] = true;

            // change the key value and the parent index of all the adjacent vertices of the selected vertex. The vertices that are not yet included in Minimum Spanning Tree are only considered.
            for (int vertex = 0; vertex < count; vertex++)


                // when the value of the gArray[edge][vertex] is smaller than keys[vertex], we update it
                if (gArray[edge][vertex] != 0 && setOfMST[vertex] == false && gArray[edge][vertex] < keys[vertex]) {
                    mstArray[vertex] = edge;
                    keys[vertex] = gArray[edge][vertex];
                }
        }

        // printing
        minimumSpanningTree(mstArray, gArray);
    }


}


public class MinimumSpanningTree {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {

        assignment4.minimumSpanningTreeCalculation dummy = new assignment4.minimumSpanningTreeCalculation();
        int graphArray[][] = new int[][]{
                { 0, 5, 4, 0, 0, 0, 0, 0 },     //1
                { 5, 0, 2, 3, 0, 0, 0, 0 },     //2
                { 4, 2, 0, 0, 4, 0, 0, 0 },     //3
                { 0, 3, 0, 0, 2, 0, 6, 0 },     //4
                { 0, 0, 4, 2, 0, 1, 0, 0 },     //5
                { 0, 0, 0, 0, 1, 0, 8, 0 },     //6
                { 0, 0, 0, 6, 0, 8, 0, 2 },     //7
                { 0, 0, 0, 0, 0, 0, 2, 0 }};    //8

        // I print the Minimum Spanning Tree solution
        dummy.printMinimumSapnningTree(graphArray);
    }

}
