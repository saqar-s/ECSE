//Saghar Sahebi 260908343 ECSE202 assignment4
//for this program i got help from a slides and lectures of professor Ferrie ,rosetcode.org,stackoverflow,githib and the solution to assignement 3 posted by professor Ferrie


import java.util.StringTokenizer;

import acm.program.ConsoleProgram;


	public class JCalc extends ConsoleProgram {
		static Character[] operators = new Character[] {'^','%','*','/','+','-'};
		 static int[] oPrecedence = new int[] {4,3,3,3,2,2};

		 Queue Qin = new Queue();  
		 	 
		postFix pf = new postFix(); 
		
		 
		public void run() { 
		println("Infix expression evaluator, enter expression of blank line to exit."); 
		while (true) { 
		String input = readLine("expr: "); 
		if (input.equals("")) break;  
		pf.parse(input, Qin);  
 
		double result = pf.doExpression(Qin);  
		println(input+" = "+result);  
		}  
		}
		
	public class postFix{
		public double doExpression(Queue Qin) {
		String s,o;
		Stack opStack = new Stack();
		Queue Qout = new Queue();
        while ((s=Qin.dequeue()) != null) {     
            if (isOperator(s)) {        
                while ((o=opStack.pop()) != null) {   
                 if (Precedence(o) >= Precedence(s)) { 
                  Qout.enqueue(o);      
                 }
                 else {
                  opStack.push(o);      

                  break;       
                 }
                }
                opStack.push(s);          

               }
  
             
               else if (s.charAt(0)=='(') {      
                opStack.push(s);
               }
             
               else if (s.charAt(0)==')') {      
                while ((o=opStack.pop()) != null) {         
 
                 if (o.charAt(0) != '(') {    
                  Qout.enqueue(o);
                 }
                 else {
                  break;
                 }
                }
               }

	           
	 
	           
	             else if (s.charAt(0) != ')') {
	               Qout.enqueue(s);       
	             }           
	           
		
		
        }
	
	           while ((o=opStack.pop()) != null)
	              Qout.enqueue(o);
        
		
        
		return FinalResult(Qout);
		}

		public void parse(String input, Queue Qin) {
			StringTokenizer st = new StringTokenizer(input,"^%*/+-()",true);
            while (st.hasMoreTokens()) {
                Qin.enqueue(st.nextToken());
			
		}
	}

		
			
		
		public double FinalResult(Queue Input) {
			Stack Data = new Stack();
			
			while (Input.front != null) {		
				String j = Input.dequeue();
				if (j.matches("[-+]?\\d+(\\.\\d+)?")) { 
					Data.push(j);
				} else {
					Double A = Double.parseDouble(Data.pop());
					Double B = Double.parseDouble(Data.pop());
					Double result = null;
					switch (j) {
						case "+":
							result = B+A;
							break;
						case "-":
							result = B-A;
							break;
						case "*":
							result = B*A;
							break;
						case "/":
							result = B/A;
							break;
						default:
							break;
						}
					Data.push(Double.toString(result));
				}
			}
			
			return Double.parseDouble(Data.pop());
			}
			
	
	private boolean isOperator(String s)
	{
		for (int i=0; i<operators.length; i++) {
		     if (s.charAt(0) == operators[i]) return true;
		    }
		return false;
	}
	 private int Precedence(String s) {
		   for (int i=0; i<operators.length; i++) {
		     if (s.charAt(0) == operators[i]) return oPrecedence[i];
		    }
		   return 0;
		  }
		}
	}

	

			