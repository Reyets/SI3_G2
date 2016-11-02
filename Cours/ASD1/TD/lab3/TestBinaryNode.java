package lab3.corr;

import util.TestClass;
import java.util.Scanner;

/**
 * A class for interactive testing binary nodes
 */
public class TestBinaryNode extends TestClass<TestBinaryNode> {

	private BinaryNode<String> tree;
	private Scanner input;
	
	public TestBinaryNode() {
		tree = BinaryNode.read("A ");
		input = new Scanner(System.in);
	}
	
	public void readTree() {
		System.out.print("enter the tree in linear form: ");
		String linear = input.nextLine();
		tree = BinaryNode.read(linear);
	}
	
	public void showTree() {
		tree.display();
	}
	
	public void height() {
		System.out.println(tree.height());
	}
	
	public void lowness() {
		System.out.println(tree.lowness());
	}
	
	public void size() {
		System.out.println(tree.size());
	}
	
	public void leaves() {
		System.out.println(tree.leaves());
	}		
	
	public void balanced1() {
		if ( tree.balanced1() )
			System.out.println("the tree is balanced");
		else
			System.out.println("the tree is not balanced");
	}		
	
	public void balanced2() {
		if ( tree.balanced2() )
			System.out.println("the tree is balanced");
		else
			System.out.println("the tree is not balanced");
	}		
	
	public void shapely1() {
		if ( tree.shapely1() )
			System.out.println("the tree is balanced");
		else
			System.out.println("the tree is not balanced");
	}		
	
	public void shapely2() {
		if ( tree.shapely2() )
			System.out.println("the tree is balanced");
		else
			System.out.println("the tree is not balanced");
	}		
	
    public static void main(String[] args) {
    	TestBinaryNode test = new TestBinaryNode();
        test.tester();
    }
}
