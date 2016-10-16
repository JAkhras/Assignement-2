
package assignment.pkg2;

//Threaded Binary Tree

public class Assignment2 {

	static Node root;
	static Node current;
	static boolean NewChildtoRight = false;
	static boolean NewChildtoLeft = false;

	public static void main(String[] args) {

		
                //initialize Root
		root = new Node(10000);
		root.lBit = 0;
		root.rBit = 0;
		root.left = root.right = root;
            
		
                //First we generate the tree
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
		              
		

		System.out.println("Output for inOrder");
		inOrder();
		System.out.println();

	}

	public static void inOrder() {
                //We start at Root
                current = root;
                //Move all the way on the left leaf
		while (current.lBit == 1) {

			current = current.left;

		}
		//then move to next based on inOrder
		while(current != root){
			
			System.out.print(" -> " + current.data);
			current = nextInOrder(current);
			
		}

	}

	public static Node nextInOrder(Node next) {
                //this basically outputs either right or left
		//if no right child move up to next right
		if(next.rBit == 0){
			
			return next.right;	
		}
		
		next = next.right;
		
		while(next.lBit == 1){
			
			next = next.left;
			
		}
		
		return next;
		
	}


	public static void createNode(int data) {

		Node node = new Node(data);

		

			current = root;

			while (true) {
                                //if value of data is smaller than value of Root
				if (node.data < current.data) {

					if (current.lBit == 0) {
                                            //if there is nothing on the left, create a new left node

						NewChildtoLeft = true;
						NewChildtoRight = false;
						break;

					} else {

						current = current.left;
                                                //if there is something on the left go down to left

					}

				} else {
                                        //if node data > current data
					if (current.rBit == 0) {
                                            //if there is nothing to the right create a right

						NewChildtoLeft = false;
						NewChildtoRight = true;
						break;

					} else {

						current = current.right;
                                                //if there is something on the right go down to right

					}

				}

			}

			if (NewChildtoLeft) {
                            //creating a new child node to a virgin parent
                            //here creating a new left node so parent lbit=1 and parent rbit=0

				node.lBit = current.lBit;
				node.left = current.left;
				current.left = node;
				current.lBit = 1;
				node.rBit = 0;
				node.right = current;

			} else if (NewChildtoRight) {
                            //creating a new child node to a virgin parent
                            //here creating a new left node so parent lbit=0 and parent rbit=1
				node.rBit = current.rBit;
				node.right = current.right;
				current.right = node;
				current.rBit = 1;
				node.lBit = 0;
				node.left = current;

			} else {

				System.out.println("Problem");

			}
		
	}

}

class Node {
        //node constructor
	int data;

	Node left;
	Node right;

	int lBit;
	int rBit;

	Node(int data) {

		this.data = data;

	}

}