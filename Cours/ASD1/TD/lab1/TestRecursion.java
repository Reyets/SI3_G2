package lab1.corr;

import util.TestClass;
import java.util.Scanner;

/**
 * A class for interactive testing recursive methods from class Recursion
 */
public class TestRecursion extends TestClass<TestRecursion> {
	
	private Scanner input;
	
	public TestRecursion() {
		input = new Scanner(System.in);
	}
	
	public void binary() {
		System.out.print("how many digits ? ");
		int d = input.nextInt();
		Recursion.binary(d);
		System.out.println();
	}
	
	public void words() {
		System.out.print("how many 'A' ? ");
		int a = input.nextInt();
		System.out.print("how many 'B' ? ");
		int b = input.nextInt();
		Recursion.words(a, b);
		System.out.println();
	}
	
	public void permutations() {
		System.out.print("size of the permutation ? ");
		int n = input.nextInt();
		Recursion.permutations(n);
		System.out.println();
	}
	
	public void sum() {
		System.out.print("size of the array ? ");
		int n = input.nextInt();
		int[] A = new int[n];
		for ( int i = 0; i < A.length; i++ ) {
			System.out.print("integer #" + (i + 1) + " ? ");
			A[i] = input.nextInt();
		}
		System.out.print("the sum to make ? ");
		int N = input.nextInt();
		if ( Recursion.sum(A, N) )
			System.out.println("you can make " + N + " from these values!");
		else
			System.out.println("impossible to make " + N + " from these values");
	}
	
    public static void main(String[] args) {
    	TestRecursion test = new TestRecursion();
        test.tester();
    }
}
