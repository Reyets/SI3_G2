package lab2.corr;

import util.TestClass;

import java.util.Scanner;

/**
 * A class for interactive testing list-based queues
 */
public class TestListQueue extends TestClass<TestListQueue> {

	private ListQueue<String> queue;
	private Scanner input;
	
	public TestListQueue() {
		queue = new ListQueue<String>();
		input = new Scanner(System.in);
	}
	
	public void isEmpty() {
		if ( queue.isEmpty() )
			System.out.println("the queue is empty");
		else
			System.out.println("the queue is not empty");
	}
	
	public void size() {
		System.out.println("the size of the queue is " + queue.size());
	}
	
	public void peek() {
		try {
			System.out.println(queue.peek());
		}
		catch ( EmptyQueueException eqe ) {
			System.out.println("oops! the queue is empty!");
		}
	}
	
	public void enqueue() {
		System.out.print("next string to enqueue ? ");
		String s = input.next();
		queue.enqueue(s);
	}
	
	public void dequeue() {
		try {
			System.out.println(queue.dequeue());
		}
		catch ( EmptyQueueException eqe ) {
			System.out.println("oops! the queue is empty!");
		}		
	}
	
	public void showQueue() {
		System.out.println(queue);
	}
	
    public static void main(String[] args) {
    	TestListQueue test = new TestListQueue();
        test.tester();
    }
}