//Saghar Sahebi  260908343   ECSE202 assignment 4    
import acm.gui.*;
import acm.program.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import javax.swing.*;

public class JCalcGUI extends Program {
	JCalc calc = new JCalc();		
	Queue Qin = new Queue();
	
	DoubleField input;			//the input 
	DoubleField output;			//the output (answer)
			
	
	public void init() {
		
	JPanel Calc = new JPanel();			
	add(Calc);							
	Calc.setLayout(new GridLayout(2,1));	
	JPanel Screens = new JPanel();		
	Calc.add(Screens);					
	Screens.setLayout(new GridLayout(2,1));		
	JPanel Buttons = new JPanel();		
	Calc.add(Buttons);					
	Buttons.setLayout(new GridLayout(5,6));		
	input = new DoubleField();                                 
	Screens.add(input);															
	output = new DoubleField();                                              
	Screens.add(output);
	
	//the buttons
	JButton b0 = new JButton("0");
	b0.addActionListener(this);    
	JButton b1 = new JButton("1");
	b1.addActionListener(this); 
	JButton b2 = new JButton("2");
	b2.addActionListener(this); 
	JButton b3 = new JButton("3");
	b3.addActionListener(this); 
	JButton b4 = new JButton("4");
	b4.addActionListener(this); 
	JButton b5 = new JButton("5");
	b5.addActionListener(this); 
	JButton b6 = new JButton("6");
	b6.addActionListener(this); 
	JButton b7 = new JButton("7");
	b7.addActionListener(this); 
	JButton b8 = new JButton("8");
	b8.addActionListener(this); 
	JButton b9 = new JButton("9");
	b9.addActionListener(this); 

	//operators
	JButton bplus = new JButton("+");
	bplus.addActionListener(this);  
	JButton bminus = new JButton("-");
	bminus.addActionListener(this);  
	JButton bmulty = new JButton("*");
	bmulty.addActionListener(this);
	JButton bdiv = new JButton("/");
	bdiv.addActionListener(this); 
	JButton bequal = new JButton("="); 
	bequal.addActionListener(this); 

	//extra buttons
	JButton bC = new JButton("C");
	bC.addActionListener(this); 
	JButton leftbr = new JButton("(");
	leftbr.addActionListener(this);
	JButton rightbr = new JButton(")");
	rightbr.addActionListener(this); 
	JButton bdec = new JButton(".");
	bdec.addActionListener(this); 

	Buttons.add(b0);
	Buttons.add(b1);
	Buttons.add(b2);
	Buttons.add(b3);
	Buttons.add(b4);
	Buttons.add(b5);
	Buttons.add(b6);
	Buttons.add(b7);
	Buttons.add(b8);
	Buttons.add(b9);

	Buttons.add(bplus);
	Buttons.add(bminus);
	Buttons.add(bmulty);
	Buttons.add(bdiv);
	Buttons.add(bequal);

	Buttons.add(bC);
	Buttons.add(leftbr);
	Buttons.add(rightbr);
	Buttons.add(bdec);

	addActionListeners();
	}
		
			
	
	public void actionPerformed(ActionEvent e) {
		String pressed = e.getActionCommand();
		if (equal && !pressed.equals("=")) {		 
			input.setText("");						
			enter = false;
			equal = false;
			if (pressed.equals("+") || pressed.equals("-") || pressed.equals("*") || pressed.equals("/")) {
				input.setText(output.getText() + pressed);		
			}													
		} 
		if (enter) {												
			String lastchar = Character.toString(input.getText().charAt(input.getText().length() - 1));		
			if (lastchar.matches("[-+]?\\d+(\\.\\d+)?")) {					
				if (pressed.equals("1") || pressed.equals("2") || pressed.equals("3") || pressed.equals("4") || pressed.equals("5") || pressed.equals("6") || pressed.equals("7") || pressed.equals("8") || pressed.equals("9") || pressed.equals("0") || pressed.equals("+") || pressed.equals("-") || pressed.equals("*") || pressed.equals("/") || pressed.equals(")")) {
					input.setText(input.getText()+pressed); 
				} 
				else if (pressed.equals("(")) {			
					input.setText(input.getText()+"*(");
				  }
			} 
			else if (pressed.equals("1") || pressed.equals("2") || pressed.equals("3") || pressed.equals("4") || pressed.equals("5") || pressed.equals("6") || pressed.equals("7") || pressed.equals("8") || pressed.equals("9") || pressed.equals("0") || pressed.equals("(") || pressed.equals(")")) {
				input.setText(input.getText()+pressed);		
			}	
			 
		} 
		else {
			if (pressed.equals("1") || pressed.equals("2") || pressed.equals("3") || pressed.equals("4") || pressed.equals("5") || pressed.equals("6") || pressed.equals("7") || pressed.equals("8") || pressed.equals("9") || pressed.equals("0")) 
			{
				input.setText(input.getText()+pressed);		
				enter = true;									
			} 
		}
		
		if (pressed.equals("C")) {		
      	input.setText("");
      	output.setText("");
      	enter = false;
      	
      } 
		else if (pressed.equals("=") && enter) {		
      	calc.pf.parse(input.getText(), Qin);		
      	double result = calc.pf.doExpression(Qin);	
      	output.setText(Double.toString(result));		
      	equal = true;		
      	
	   }
	}
	public boolean enter = false;		
	public boolean equal = false;
}

