//Saghar Sahebi  260908343   ECSE202 assignment 4 
public class Stack {

// Instance variables (particular to each instance)
  listNode top = null;

/**
 * push method - creates a new instance of a stack frame, and stores
 * the payload accordingly.
 */

 void push(String arg) {
    listNode node = new listNode();  // Create a new instance
    node.payload = arg;      // Store the data
   if (top != null)
      node.next = top;     // If stack not empty, link to top
   else
      node.next = null;   // Otherwise link to null
    top = node;          // Top now points to newly created node
  }

/**
 * pop method - returns the payload at the top of the stack, then
 * moves the pointer to the next frame in line.
 * @return the payload is a string.
 */
  String pop() {
   if (top == null) return null; // Check if stack empty, return null
    String payload = top.payload; // Otherwise grab payload from top
    top = top.next;        // Top now points to next frame in line
   return payload;     // Return payload
  }
  public class listNode {
	  String payload;
	  listNode next;
	
	}

}