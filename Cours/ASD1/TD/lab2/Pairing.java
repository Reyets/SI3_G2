package lab2.corr;

import java.io.*;
import java.util.*;

/**
 * A class to find pairs (x,y) of integers inside a file
 * matching y = x + n for a given n.
 */
public class Pairing {
	
	/**
	 * Display all the pairs (x,y), x and y  in the file, such that y = x + n
	 * The file 'fileName' contains an entirely increasing (strict) sequence of integers
	 */
	public static void showPairs(int n, String fileName) throws FileNotFoundException, EmptyQueueException {
		Scanner input = new Scanner(new File(fileName));
		ListQueue<Integer> q = new ListQueue<Integer>();
		
		while ( input.hasNextInt() ) {
			int y = input.nextInt();
			while ( ! q.isEmpty() && q.peek() + n < y )
				q.dequeue();
			if ( ! q.isEmpty() && q.peek() + n == y )
				System.out.print("(" + q.dequeue() + "," + y + ") ");
			q.enqueue(y);
		}
		System.out.println();
		input.close();
	}
	
    /**
     * A short main for quick testing
     */
	public static void main(String[] args) throws FileNotFoundException, EmptyQueueException {
		// put the right path here
		showPairs(1273,"src/lab2/corr/big-file.txt");
	}

}
