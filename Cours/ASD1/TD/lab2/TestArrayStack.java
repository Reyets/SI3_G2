package lab2.corr;

import util.TestClass;
import java.util.Scanner;

/**
 * A class for interactive testing array-based stacks
 */
public class TestArrayStack extends TestClass<TestArrayStack> {
	
	private ArrayStack<String> stack;
	private Scanner input;
	
	public TestArrayStack() {
		stack = new ArrayStack<String>();
		input = new Scanner(System.in);
	}
	
	public void isEmpty() {
		if ( stack.isEmpty() )
			System.out.println("the stack is empty");
		else
			System.out.println("the stack is not empty");
	}
	
	public void push() {
		System.out.print("next string to push ? ");
		String s = input.next();
		try {
			stack.push(s);
		}
		catch ( FullStackException fse ) {
			System.out.println("oops! stack is full!");
		}
	}
	
	public void pop() {
		try {
			System.out.println(stack.pop());
		}
		catch ( EmptyStackException ese ) {
			System.out.println("oops! stack is empty!");
		}
	}
	
	public void peek() {
		try {
			System.out.println(stack.peek());
		}
		catch ( EmptyStackException ese ) {
			System.out.println("oops! stack is empty!");
		}
	}
	
	public void showStack() {
		System.out.println(stack);
	}
	
    public static void main(String[] args) {
    	TestArrayStack test = new TestArrayStack();
        test.tester();
    }
}
