//Saghar Sahebi  260908343   ECSE202 assignment 4 
public class Queue {
  
// Instance variables, local to each instance

  listNode front=null; // Pointer to front
  listNode rear=null;  // Pointer to rear

/**
 * enqueue method - adds data to a new node to the end of the queue
 */
 void enqueue (String arg) {
    listNode node = new listNode(); // Allocate a new node
    node.payload = arg;    // Store payload
    node.next = null;   // Node at end points to null
   if (rear != null)   // If rear points to a node
      rear.next = node;  // attach this one to it.
   else
      front = node;    // Front points here if first node
    rear = node;       // Rear now points to new node
  }

/**
 * dequeue method - removes data from node at front of queue
 */

  String dequeue() {
   if (front != null) {     // If queue is not empty
     if (front == rear) rear=null;  // On last element, set rear to null
      String payload = front.payload;  // Retrieve data at front node
      front = front.next;        // Move front pointer to next frame
     return payload;      // Return payload
    }
   else
     return null;      // Case of empty queue
  }


public class listNode {
  String payload;
  listNode next;
}
}