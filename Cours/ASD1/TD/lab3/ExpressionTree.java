package lab3.corr;

import java.util.*;

/**
 * A class for arithmetic expression tree
 */
public class ExpressionTree extends BinaryNode<String> {
		
	/**
	 * Build a leaf expression (a number)
	 */
	public ExpressionTree(String x) {
		super(x);
	}
	
	/**
	 * Build a tree expression 'left op right'
	 * where 'op' is "+", "*", "/" or "^"
	 */
	public ExpressionTree(String op, ExpressionTree left, ExpressionTree right) {
		super(op,left,right);
	}
	
	/**
	 * Return the value of the expression
	 */
	public double eval() throws NumberFormatException {
		if ( isLeaf() )
			return Double.valueOf(data());
		return eval(data(),
					((ExpressionTree) left()).eval(),
					((ExpressionTree) right()).eval());
	}
	
	/**
	 * Return the value of 'x op y'
	 * where 'op' is "+", "*", "/" or "^"
	 */
	private double eval(String op, double x, double y) {
		if ( op.equals("+") )
			return x + y;
		if ( op.equals("-") )
			return x - y;		
		if ( op.equals("*") )
			return x * y;
		if ( op.equals("/") )
			return x / y;
		if ( op.equals("^") )
			return Math.pow(x,y);
		return 0;
	}
	
    ////////////////////////////////////
    
	/**
	 * Return an expression tree whose linear form
	 * is given as the string 'inputstring'
	 */
    public static ExpressionTree read(String inputString) {
    	Scanner input = new Scanner(inputString);
    	return read(input);
    }
    
    private static ExpressionTree read(Scanner input) {
    	if ( ! input.hasNext() )
    		return null;
    	String s = input.next();
    	if ( s.equals("$") )
    		return null;
    	if ( s.endsWith("$") )
    		return new ExpressionTree(s.substring(0,s.length()-1));
    	return new ExpressionTree(s,read(input),read(input));
    }
	
    /**
     * A short main for quick testing
     */
	public static void main(String[] args) {
		ExpressionTree e = read("- * 2$ 5$ ^ 3$ 2$");
		e.display();
		System.out.println(e.eval());

	}
}
