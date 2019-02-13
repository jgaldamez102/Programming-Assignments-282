/*
 * Created by; Joses Galdamez, for CMPSCI 282, for Professor Ferguson.
 * Project 2 allows (1)the user to input an order number they want for their 
 * specific B-Tree, in which they are allowed to input values into. Then it 
 * gives the option of either finding a value or displaying the tree.(2) Phase 3 
 * allows the user to use a data text file to import the records into a B-Tree.
 * 11/8/2017
 */
package project2_282;

public class BTree extends Tree234 {

    Node root = new Node();

    @Override
    protected void split(Node thisNode) {

        boolean orderEvenorOdd = root.isEvenOrOdd();
        int order = root.getOrder();
        Node parent;
        int BLoc = order / 2;
        DataItem itemB;
        int size = 0;

        if (orderEvenorOdd == true) {
            size = (order - 1) - BLoc;
        } else {
            BLoc = BLoc + 1;
            size = (order - 1) - (BLoc);
        }

        DataItem[] items = new DataItem[size];
        for (int x = 0; x < size; x++) {
            items[x] = thisNode.removeItem();
        }

        itemB = thisNode.removeItem();

        Node[] childs = new Node[size + 1];

        int xx = root.getOrder() - 1;
        for (int x = 0; x < (size + 1); x++) {
            childs[x] = thisNode.disconnectChild(xx);
            xx--;
        }

        int itemIndex;
        Node newRight = new Node();
        if (thisNode == getRoot()) {
            root = getRoot();
            root = new Node();
            parent = root;
            root.connectChild(0, thisNode);
            setRoot(root);

        } else {
            parent = thisNode.getParent();
        }

        itemIndex = parent.insertItem(itemB);
        int n = parent.getNumItems();
        for (int j = n - 1; j > itemIndex; j--) {
            Node temp = parent.disconnectChild(j);
            parent.connectChild(j + 1, temp);
        }
        parent.connectChild(itemIndex + 1, newRight);
        for (int l = 0; l < size; l++) {
            newRight.insertItem(items[l]);
        }

        int length = childs.length - 1;
        for (int y = 0; y < childs.length; y++) {
            newRight.connectChild(y, childs[length]);
            length--;
        }

    }

}
