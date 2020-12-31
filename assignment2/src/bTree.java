//Saghar Sahebi student ID:260908343   ECSE202 assignment 2

//I wrote the program with the help of the code in lecture 7 from professor Ferri
public class bTree {	
    bNode root = null;
    Stack myStack = new Stack();

public void addNode(String line) {
	bNode current;
	
	if (root==null) {
		root = makeNode(line);
	}
	else {
		current = root;
		while (true) {
			if(current.line.compareToIgnoreCase(line)>0) {                           //I got help from beginnersbook.com for this line
				if (current.left == null) {
					current.left = makeNode(line);
					break;	
			    }
			else {
					current = current.left;
				}
	    	}
			else {
				if(current.right == null) {
					current.right = makeNode(line);
					break;
				}
				else {
					current = current.right;
				}
			}
		}
   }
}


 bNode makeNode (String line) { 
	bNode node = new bNode();
	node.line = line;
	node.left = null;
	node.right = null;
	return node;	
}
private class bNode{
	String line;
	bNode left;
	bNode right;
	
}
private void traverse_inorder(bNode root) {                                     //printing the names in sorted order by traverse_inorder
	if (root.left !=null) traverse_inorder(root.left);
	System.out.println(root.line);
	myStack.push(root.line);
	if(root.right != null)
		traverse_inorder(root.right);
}

public void traverse_inorder() {
	System.out.println("names A - Z");
	traverse_inorder(root);
	System.out.println("");
	System.out.println("names Z- -A");
	 while (true) {
		 String x = myStack.pop();
		 
		 if(x == null)break;
		 System.out.println(x);
	 }
}
}


