import java.util.Stack;

public class StackCalc {
	//initilazing operands with their characters and name
	static public StackCalc.Operator LEFT_PARANTHESIS_OP = null; 
	static public StackCalc.Operator RIGHT_PARANTHESIS_OP = null;
	static public StackCalc.Operator PLUS_OP = null;
	static public StackCalc.Operator MINUS_OP = null;
	static public StackCalc.Operator PRODUCT_OP = null;
	static public StackCalc.Operator DIVISION_OP = null;
	
	StackCalc() {
		if (LEFT_PARANTHESIS_OP == null) LEFT_PARANTHESIS_OP = new Operator('(');
		if (RIGHT_PARANTHESIS_OP == null) RIGHT_PARANTHESIS_OP = new Operator(')');
		if (PLUS_OP == null) PLUS_OP = new Operator('+');
		if (MINUS_OP == null) MINUS_OP = new Operator('-');
		if (PRODUCT_OP == null) PRODUCT_OP = new Operator('x');
		if (DIVISION_OP == null) DIVISION_OP = new Operator('/');
	}
	
	//Operator class include comparing operands as a objects and getting names of operands
	public class Operator {
		char name;
		final char precedence[] = {'+' , '-', 'x', '/', '('};
		
		public Operator(char op) {
			name = op;
		}

		//compare method is a object method, it compares operators and give a result as a integer -1,0 and 1.
		public int Compare(final Operator other) {
			int index1 = -1, index2 = -1; // integer initilazing 
			for (int i = 0; i < precedence.length; i++) {
				if (name == precedence[i]) {
					index1 = i;
					if (index2 >= 0) break;
				}
				if (other.getName() == precedence[i]) { //getname method returns name. Char name defined in Operator class and it is character
					index2 = i;
					if (index1 >= 0) break;
				}
			}
			if(index1 > index2) return 1;
			if(index1 == index2) return 0;	
			return -1;	
		}	
		
		public char getName() { return name; }
		
		public boolean Equals(final Operator other) { //current operator compare others. If they equal send true.
			return other.getName() == this.getName(); //we will use it to find which character come now is it left paranthesis or not
		}
	}
	
	static public boolean IsOperator(char ch) {  //operator or operand? we want to check what come now, is Digit or is operator?
		return ch == '(' || ch == ')' || ch == '+' || ch == '-' || ch == 'x' || ch == '/'; 
	}
	
	//whole operation happens with ComputePostFix method. It take in the infix string which we write examples in it
	public String ComputePostFix(String infix) {
		Stack<Character> operator_stack = new Stack<Character>(); //Initilaze a stack to save the operands in it
		String postfix = ""; //intiliaze a the postfix string and return it.
		
		int num = 0; //we want to add what we read as number from inflix to postflix
		boolean numExists = false; // if number exist this it will be true
		
		for (int i = 0; i < infix.length(); ++i) {
			char curr_char = infix.charAt(i);   //first of all we need a name to call next element can be digit, null or character

			if (IsDigit(curr_char)) {  //current character is a digit but how many digit has it
				num = num * 10 + (curr_char - '0'); //the number can be more than one digit, so read the number in decimal 
				numExists = true; //numExist became true and it is going to add to postfix string
			} else if (numExists) {   //current character is a number with some digits 
				if (postfix.isEmpty()) //add all number to postfix string
					postfix = num + "";
				else 
					postfix = postfix + " " + num;
				num = 0;
				numExists = false;
			}
			
			if (IsOperator(curr_char)) {  //current charactes is a operator?
				Operator curr_op = new Operator(curr_char);  // call curr characters with operoters name
				
				if (curr_op.Equals(StackCalc.RIGHT_PARANTHESIS_OP)) {  // add all operators on stack to postfix until '('
					boolean lp_found = false; //we want to go out the while if we found left parathesis, therefore we added a boolean
					while (!operator_stack.empty()) {
						Operator op = new Operator(operator_stack.pop());
						if (op.Equals(LEFT_PARANTHESIS_OP)) {
							lp_found = true;
							break;
						}
						postfix = postfix + " " + op.getName(); // add this operotor to postfix string
					}
					if (!lp_found) { //left parathesis is forgetton
						System.err.println("Non-matching parenthesis in expression: " + infix);
						System.exit(0);
					}
					continue; //?????
				}
				//till here all operator and operands sent related stack or string, but some operands or
				//if exist left parathesis still stay in stack. 
				Operator pre_operator = operator_stack.empty() ? null : new Operator(operator_stack.peek());
				//pre_operoter carries the stack's first element
				if (pre_operator == null || curr_op.Compare(pre_operator) >= 0) {
					operator_stack.push(curr_op.getName());
				} else {
					while (!operator_stack.empty()) {
						pre_operator = new Operator(operator_stack.peek());
						
						if (curr_op.Compare(pre_operator) == -1) {
							if (pre_operator.Equals(LEFT_PARANTHESIS_OP)) break;
							
							postfix = postfix + " " + operator_stack.pop();
						} else {
							break;
						}
					}
					operator_stack.push(curr_op.getName());
				}
			}  
		}
		
		if (numExists) { // all number should be added to postfix string, if boolean numExists is true, add number to string
			postfix = postfix + " " + num;
			numExists = false;
		}
		
		while (!operator_stack.empty()) {
			Operator curr_op = new Operator(operator_stack.pop());
			if (curr_op.Equals(LEFT_PARANTHESIS_OP)) {
				System.err.println("Expression has non-matching Left Paranthesis: " + infix);
				System.exit(0);
			}
			postfix = postfix + " " + curr_op.getName();
		}
		
		return postfix;
	}

	
	private boolean IsDigit(char ch) {
		return ch >= '0' && ch <= '9';
	}
	

}
