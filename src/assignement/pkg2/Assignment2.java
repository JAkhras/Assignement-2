
package assignement.pkg2;

//Threaded Binary Tree

public class Assignment2 {

	static Node root;
	static Node Previous;
	static boolean NewChildtoRight = false;
	static boolean NewChildtoLeft = false;

	public static void main(String[] args) {
                
                //The main function consists of 3 steps
              
                //1) Initialize Root with a synthetic "Mother" Root of value=10000
		root = new Node(10000);
		root.LeftChild = 0;
		root.RightChild = 0;
		root.L = root.R = root;
            
		
                //2) Generate the tree
                //createNode is a function bellow that automatically generates an ordered BST
		createNode(45);
		createNode(78);
		createNode(89);
		createNode(32);
		createNode(60);             
		createNode(25);
		createNode(39);                
		createNode(91);
		createNode(12);
		createNode(34);
		createNode(65);
               
		
                //3) Print the tree in "inOrder" sequence
		System.out.println("Output for inOrder");
		inOrder();
		System.out.println();

	}

	public static void inOrder() {
                //We start at "Mother" Root of value=10000
                Previous = root;
                //Move all the way on the left leaf first
		while (Previous.LeftChild == 1) {

			Previous = Previous.L;

		}
		//Whilellop() runs until last node refers to "Mother" node
		while(Previous != root){
			//First print value retrived all the way on the left
			System.out.print(" -> " + Previous.data);
                        //Then go fetch the next data and repeat print
			Previous = nextInOrder(Previous);
			//That's it!!The end!
		}

	}

	public static Node nextInOrder(Node next) {
              
		//The order is crucial here
                //First look right
                //Then Look left
                //Gives priority to LeftChild over RightChild
                
                //We look right first
		if(next.RightChild == 0){
			//if node has no right child, go to next right node
			return next.R;	
		}
		//If node has a right child, temporarily assign a next destination as right node
		next = next.R;
		
                //if node also has a left node then go to next left node
		while(next.LeftChild == 1){	
			next = next.L;
		}
		//otherwise use the temporary destination
		return next;
		
	}


	public static void createNode(int data) {

		Node Actual = new Node(data);

		
                        //Always start with the "Mother" Root of value=10000
			Previous = root;

			while (true) {
                                //if value of data is smaller than value of Root
				if (Actual.data < Previous.data) {

					if (Previous.LeftChild == 0) {
                                            //if there is nothing on the left, create a new left extension

						NewChildtoLeft = true;
						NewChildtoRight = false;
						break;

					} else {

						Previous = Previous.L;
                                                //if there is something on the left move down one node to left

					}

				} else {
                                        //if Actual data > Previous data
					if (Previous.RightChild == 0) {
                                            //if there is nothing to the right create a new right extension

						NewChildtoLeft = false;
						NewChildtoRight = true;
						break;

					} else {

						Previous = Previous.R;
                                                //if there is something on the right move one node to right

					}

				}

			}

			if (NewChildtoLeft) {
                           //creating a new left child node to a virgin parent
                            
                                //The new child inherits next left from its parent
                                Actual.L = Previous.L;
                                //New child can refer to its parent
                                Actual.R = Previous;
                                //The parent node is then given its "parent" title/parameters
				Previous.L = Actual;
				Previous.LeftChild = 1;
                                //New Child gets initialized
                                Actual.LeftChild = 0;
				Actual.RightChild = 0;
				

			} else if (NewChildtoRight) {
                           //creating a new right child node to a virgin parent
                           
                                //The new child inherits next right from its parent
				Actual.R = Previous.R;
                                //New child can refer to its parent
                                Actual.L = Previous;
                                //The parent node is then given its "parent" title/parameters
				Previous.R = Actual;
				Previous.RightChild = 1;
                                //New Child gets initialized
                                Actual.RightChild = 0;
				Actual.LeftChild = 0;
				

			} else {

				System.out.println("Not Normal");

			}
		
	}

}

