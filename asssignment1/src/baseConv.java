//ECSE 202 Assignment 1 
//Saghar Sahebi
//student ID: 260908343



import acm.program.ConsoleProgram;

public class baseConv extends ConsoleProgram {
	public void run() {
			
		println("Base conversion Program");
		int inBase;
		int numBase10;
		int targetBase;
		String input;
		String output;
		
		
		while(true) {
			input = readLine("Enter a number(base 2-16): ");
		    if (input.equals("."))  
		    break;
			inBase = readInt("Enter the corresponding base as an integer: ");   
            numBase10 = String2Int(input,inBase); 
			println("The decimal equivalent of your input is "+numBase10); 
			targetBase = readInt("Enter the target base for conversion (2-16): "); // Read target base 
			output = Dec2Base(numBase10,targetBase);  
            println(input+" Base-"+inBase+" ---> "+ output +" Base-"+targetBase);  
			println();  
		  }
		    println("Program terminated");
	}
 

	private int String2Int(String input, int inBase) {
    	int power = 1;
    	int sum = 0 ;
    	int current;
    	for(int i = input.length() - 1; i >=0;i--) {
    		current = Char2Int(input.charAt(i));
    		sum += current * power;
    		power = power * inBase;
    		
    	}
    	
		return sum;
		
    }
	        	
		
	
    private int Char2Int(char chr) {
		if((chr == 'a') ||(chr == 'A')) {
			
			return 10;
		}
	    else if((chr == 'b') ||(chr =='B')){
	    	return 11;
	    }
	    else if ((chr == 'c')||(chr == 'C')){
	    	return 12;
	    }
	    else if ((chr == 'd') ||(chr =='D')) {
	    	return 13;
	    }
	    else if ((chr == 'e')||(chr=='E')) {
	    	return 14;
	    }
	    else if ((chr == 'f' )||(chr =='F')){
	    	return 15;
	    }
    	
    	else if ((chr >='0') && (chr<='9')) {
    			return (int)chr-'0';
    	}
    	else return 0;
    }
			
   
	        
	        
	private String Dec2Base(int numBase10, int targetBase) {
		int n=numBase10;
		int b =targetBase;
		int current;
		String output = "";
		
		while(n > 0) {
			current = n % b;
			n = n / b;
			
		output += Int2Char(current);
		}
		
		String finaloutput= revOutput(output);
		
		return finaloutput;

	}
	public String revOutput (String output) {
		
		String reversed= "";
		for (int i = output.length(); i > 0; i--) 
			 reversed += output.charAt(i-1);
		return reversed;
	}
	
	 private char Int2Char(int current) {
			if( current == 0 || current ==1 || current==2 || current==3 || current==4 ||current ==5 || current==6 || current==7 || current ==8|| current==9){
			return (char)(current+'0');
			
		}

	else if (current == 10){
	return 'a';
	}
	else if (current == 11) {
	return 'b';
	}
	else if (current == 12) {
	return 'c';
	}
	else if (current == 13) {
	return 'd';
	}
	else if (current ==14) {
	return'e';
	}
	else if (current == 15) {
	return 'f';
	
	}
			return (char) current;
}
	
	
	
				
				}
