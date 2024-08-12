package stack;

import java.util.Scanner;
import java.util.Stack;

public class InfixPostfix {
	
	// Function to return precedence of operators
	public int precedence(char c) {
		if(c=='^')
			return 3;
		else if(c=='/' || c=='*')
			return 2;
		else if(c=='+' || c=='-')
			return 1;
		else 
			return -1;
	}
	
	// Function to return associativity of operators
	public char associativity(char c) {
		if(c=='^')
			return 'R';
		else
			return 'L';	// Default to left-associative
	}
	
	public String infixToPostfix(String infix) {
		
		StringBuilder postfix = new StringBuilder();
		StringBuilder input = new StringBuilder(infix);
		Stack<Character> stk = new Stack<>();
		
		stk.push('(');		//Push '(' into stack
		input.append(')');	//Add ')' to the end of infix expression
		
		for(int i=0;i<input.length();i++) {
			char ch = input.charAt(i);
			
			// If the scanned character is an operand, add it to the output string.
			if((ch>='a' && ch<='z') || (ch>='A' && ch<='Z') || (ch>='0' && ch<='9')) {
				postfix.append(ch);
			}
			
			// If the scanned character is an ‘(‘, push it to the stack.
			else if(ch=='(') {
				stk.push(ch);
			}
			
			// If the scanned character is an ‘)’, pop and add to the output string from the stack
            // until an ‘(‘ is encountered.
			else if(ch==')') {
				while(!stk.isEmpty() && stk.peek()!='(') {
					postfix.append(stk.pop());
				}
				stk.pop();
			}
			
			// If an operator is scanned
			else {
				while(!stk.isEmpty() && (precedence(ch) <= precedence(stk.peek())) && (associativity(ch)=='L')) {
					postfix.append(stk.pop());
				}
				stk.push(ch);
			}
			
		}
 
		return new String(postfix);
	}
	
	public static void main(String[] args) {
//		InfixPostfix infixPostfix = new InfixPostfix();
//		String infix = "a+b*(c^d-e)^(f+g*h)-i";
//		System.out.println("Infix expression" + infix);
//		String postfix = infixPostfix.infixToPostfix(infix);
//		System.out.println("Postfix expression : " + postfix);
		
		InfixPostfix infixPostfix1 = new InfixPostfix();
		try (Scanner sc = new Scanner(System.in)) {
			System.out.print("Enter infix expression : ");
			String infix1 = sc.next();
			System.out.println("Infix expression : " + infix1);
			String postfix1 = infixPostfix1.infixToPostfix(infix1);
			System.out.println("Postfix expression : " + postfix1);
		}
	}

}
