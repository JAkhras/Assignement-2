
package assignement.pkg2;


public class Node {
        //Constructor
        //Here we create nodes based on their numerical data value
        // every node has (5) parameters
        // (1)leftchild/(2)rightchild has a value of 1 or 0
        //if leftchild=1 so this node has a leftchild
        //if leftchild=0 it does not have a leftchild
        //similar for rightchild
        //(3)Node.L and (4) Node.R are pointers to previous and next node
        //(5)data is the actual value of the node
	int data;

	Node L;
	Node R;

	int LeftChild;
	int RightChild;

	Node(int data) {

		this.data = data;

	}

}