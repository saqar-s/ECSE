//Saghar Sahebi student ID:260908343    ECSE202  assignment 2

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 * this class was posted on MyCourses by Professor Ferry
 * our goal in this program is to arrange a list of names(.txt) and in alphabetic order
 */


public class A2 {
	@SuppressWarnings("resource")
	public static void main(String args[]) {
		
/* Prompt user for a file name.  If no name is entered, terminate
 the program, otherwise attempt to open the file. If file open
 is not successful, prompt again for a new name.  Keep doing this
 until successful open, or a blank line is entered.*/
		
		bTree myTree = new bTree();
		
		System.out.println("Simple File Listing Program");
		Scanner sc = new Scanner(System.in);
		BufferedReader rd = null;
		//the BufferedReader method is like Scanner,Reads text from a character-input stream 
		
		while(rd == null) {
			System.out.print("Enter name of file to list: ");
			String filename = sc.nextLine();
			if (filename.equals("")) {
				System.out.println("Program terminated");
				System.exit(0);
			}

			try {
				rd = new BufferedReader(new FileReader(filename));
			}
			catch (IOException ex) {
				System.out.println("Unable to open file, try again.");
			}
		}

		
		System.out.println("");
		try {
			while (true) {
				String line = rd.readLine();							
				if (line == null) break;								
			myTree.addNode(line);
			                                                         
			}														
		}
		catch (IOException ex) {
			System.out.println("I/O Error - program terminated");
			System.exit(-1);
		}
		
		myTree.traverse_inorder();			                      
		System.out.println("\n\nProgram terminated");

	}
}
