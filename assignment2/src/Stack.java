//Saghar Sahebi student ID:260908343    ECSE202 assignment 2

public class Stack {
	void push(String arg) {
		listNode node = new listNode();
		node.line = arg;
		node.next = top;
		top = node;
	}
    String pop() {
    	if(top == null)
    		return null;
    	String line = top.line;
    	top = top.next;
    	return line;
    }
    private class listNode{
    	String line;
    	listNode next;
    }
    listNode top = null;
}
//This class was given by professor Ferri in lecture 7 -the Stack 
