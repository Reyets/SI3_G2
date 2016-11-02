package lab2.corr;

/**
 * A class to arrange train configuration
 */
public class TrainManagement {
	
	private int[] from; // the initial ordering
	private int[] to;   // the final ordering
	
	private ArrayStack<Integer> U; // to hold the cars on track U
	private ArrayStack<Integer> T; // to hold the cars on track T
	private ArrayStack<Integer> S; // to hold the cars on track S (input data)
	
	private boolean[] inU; // inU[i] == true <==> car 'i' is in the stack U
	
	/**
	 * Build a TrainManagement object
	 * Preconditions:
	 * 'from' and 'to' have the same size N and are
	 * both permutations of [ 0, 1, 2,..., N-1 ]
	 */
	public TrainManagement(int[] from, int[] to) {
		this.from = from;
		this.to = to;
		this.inU = new boolean[from.length];
		this.U = new ArrayStack<Integer>();
		this.T = new ArrayStack<Integer>();
		this.S = new ArrayStack<Integer>();
	}

	/**
	 * Output the basic move commands to transfer
	 * the cars from the 'from' order on track U
	 * to the 'to' order on track S
	 */
	public void arrange() throws EmptyStackException, FullStackException {
		
		for ( int i = from.length - 1; i >= 0; i-- ) {
			U.push(from[i]);
			S.push(to[i]);
			inU[i] = true;
		}

		while ( ! S.isEmpty() ) {
			int i = S.pop();
			if ( inU[i] )
				UtoT(i);
			else
				TtoU(i);
			display(T.pop(),"T","S");
		}
	}
	
	/**
	 * Transfer the cars from stack U to stack T
	 * until car 'i' is on top of T
	 * Precondition: car 'i' is in stack U
	 */
	private void UtoT(int i) throws EmptyStackException, FullStackException {
		int j;
		do {
			j = U.pop();
			T.push(j);
			inU[j] = false;
			display(j,"U","T");
		} while ( j != i);
	}
	
	/**
	 * Transfer the cars from stack T to stack U
	 * until car 'i' is on top of T
	 * Precondition: car 'i' is in stack T
	 */
	private void TtoU(int i) throws EmptyStackException, FullStackException {
		int j = T.peek();
		while ( j != i ) {
			U.push(T.pop());
			inU[j] = true;
			display(j,"T","U");
			j = T.peek();
		}
	}

	/**
	 * Display the basic command (message) for moving
	 * the car 'car' from tack 'from' to track 'to'
	 */
	private void display(int car, String from, String to) {
		System.out.println("move car " + car + " from " + from + " to " + to);
	}
	
    /**
     * A short main for quick testing
     */
	public static void main(String[] args) throws EmptyStackException, FullStackException {
		int[] from = { 1, 3, 0, 2 };
		int[] to   = { 2, 1, 0, 3 };
		TrainManagement tm = new TrainManagement(from,to);
		tm.arrange();
	}
	// expected output
	//
	// move car 1 from U to T
	// move car 3 from U to T
	// move car 0 from U to T
	// move car 2 from U to T
	// move car 2 from T to S
	// move car 0 from T to U
	// move car 3 from T to U
	// move car 1 from T to S
	// move car 3 from U to T
	// move car 0 from U to T
	// move car 0 from T to S
	// move car 3 from T to S
}
