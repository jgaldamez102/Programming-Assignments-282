/*
 * Created by; Joses Galdamez, for CMPSCI 282, for Professor Ferguson.
 * Project 2 allows (1)the user to input an order number they want for their 
 * specific B-Tree, in which they are allowed to input values into. Then it 
 * gives the option of either finding a value or displaying the tree.(2) Phase 3 
 * allows the user to use a data text file to import the records into a B-Tree.
 * 11/8/2017
 */
package project2_282;

public class DataItem {

    public long dData;
    public String record;// one data item

//--------------------------------------------------------------
    public DataItem(long dd) {   // constructor
        dData = dd;
    }

//--------------------------------------------------------------
    public void displayItem() {
        System.out.print("/" + dData);
    }

    public void setRecord(String newRecord) {
        record = newRecord;
    }

    public String getRecord() {
        return record;
    }

//--------------------------------------------------------------
}  // end class DataItem
