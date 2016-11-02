package lab3.corr;

import java.util.*;
import lab2.corr.ListQueue;
import lab2.corr.EmptyQueueException;

/**
 * A class for genealogy 
 */
public class GenealogyTree extends BinaryNode<String> {
	
	/**
	 * Build an orphan node of name 'name'
	 * (no father/mother genealogy)
	 */
	public GenealogyTree(String name) {
		super(name);
	}
	
	/**
	 * Build a genealogy node of name 'name'
	 * with 'father' the genealogy of the father
	 * and 'mother' the genealogy of the mother
	 */
	public GenealogyTree(String name,
						 GenealogyTree father,
						 GenealogyTree mother) {
		super(name,father,mother);
	}
	
	//////////////////////
	// ancestors
	
	/**
	 * Return the list of all ancestors from
	 * the this genealogy at level 'level'
	 */
	public List<String> ancestors(int level) {
		List<String> ancestors = new ArrayList<String>();
		ancestors(this,0,level,ancestors);
		return ancestors;
	}
	
	private void ancestors(BinaryNode<String> t, int currentLevel, int targetLevel, List<String> ancestors) {
		if ( t != null ) {
			if ( currentLevel == targetLevel )
				ancestors.add(t.data());
			else {
				ancestors(t.left(),currentLevel+1,targetLevel,ancestors);
				ancestors(t.right(),currentLevel+1,targetLevel,ancestors);
			}
		}
	}
	
	//////////////////////
	// maleAncestors
	
	/**
	 * Return the list of all male ancestors from
	 * the this genealogy at level 'level'
	 */	
	public List<String> maleAncestors(int level) {
		List<String> ancestors = new ArrayList<String>();
		maleAncestors(this,0,level,ancestors);
		return ancestors;
	}
	
	private void maleAncestors(BinaryNode<String> t, int currentLevel, int targetLevel, List<String> ancestors) {
		if ( t != null ) {
			if ( currentLevel == targetLevel - 1 ) {
				if ( t.left() != null )
					ancestors.add(t.left().data());
			}
			else {
				maleAncestors(t.left(),currentLevel+1,targetLevel,ancestors);
				maleAncestors(t.right(),currentLevel+1,targetLevel,ancestors);
			}
		}
	}
	
	//////////////////////
	// displayGenerations
	
	/**
	 * Print all the ancestors line by lie, each line
	 * being a generation (i.e. a level in the tree)
	 */
	public void displayGenerations() throws EmptyQueueException {
		ListQueue<BinaryNode<String>> q = new ListQueue<BinaryNode<String>>();
		q.enqueue(this);
		while ( ! q.isEmpty() ) {
			int size = q.size();
			for ( int i = 0; i < size; i++ ) {
				BinaryNode<String> t = q.dequeue();
				System.out.print(t.data() + " ");
				if ( t.left() != null )
					q.enqueue(t.left());
				if ( t.right() != null )
					q.enqueue(t.right());
			}
			System.out.println();
		}
	}
	
    ////////////////////////////////////
    
	/**
	 * Return a genealogy tree whose linear form
	 * is given as the string 'inputstring'
	 */
    public static GenealogyTree read(String inputString) {
    	Scanner input = new Scanner(inputString);
    	return read(input);
    }
    
    private static GenealogyTree read(Scanner input) {
    	if ( ! input.hasNext() )
    		return null;
    	String s = input.next();
    	if ( s.equals("$") )
    		return null;
    	if ( s.endsWith("$") )
    		return new GenealogyTree(s.substring(0,s.length()-1));
    	return new GenealogyTree(s,read(input),read(input));
    }

    /**
     * A main for quick testing
     */
	public static void main(String[] args){
		GenealogyTree g = read("Edward David Carl $ Barbara Anthony$ Anna$ $ Dorothy Craig Bruce Allan$ Amanda$ $ Carol Brian Andrew$ Ann$ Brenda Albert$ Alice$");
		g.display();
		System.out.println();
		
		System.out.print("Ancestors at generation 1 (parents): ");
		for ( String s : g.ancestors(1) )
			System.out.print(s + " ");
		System.out.println();
		
		System.out.print("Ancestors at generation 2 (grand-parents): ");
		for ( String s : g.ancestors(2) )
			System.out.print(s + " ");
		System.out.println();
		
		System.out.print("Ancestors at generation 3: ");
		for ( String s : g.ancestors(3) )
			System.out.print(s + " ");
		System.out.println();
		
		System.out.print("Male ancestors at generation 1 (father): ");
		for ( String s : g.maleAncestors(1) )
			System.out.print(s + " ");
		System.out.println();
		
		System.out.print("Male ancestors at generation 2 (grand-fathers): ");
		for ( String s : g.maleAncestors(2) )
			System.out.print(s + " ");
		System.out.println();
		
		System.out.print("Male ancestors at generation 3: ");
		for ( String s : g.maleAncestors(3) )
			System.out.print(s + " ");
		System.out.println();
		
		System.out.print("Ancestors at generation 10 (empty): ");
		for ( String s : g.ancestors(10) )
			System.out.print(s + " ");
		System.out.println();
		
		System.out.println("All generations:");
		try {
			g.displayGenerations();
		}
		catch ( EmptyQueueException eqe ){}
		System.out.println();
	}
	// expected output
	//
	// Edward
	// |______ Dorothy
	// |       |_______ Carol
	// |       |        |_____ Brenda
	// |       |        |      |______ Alice
	// |       |        |      |
	// |       |        |      |______ Albert
	// |       |        |
	// |       |        |_____ Brian
	// |       |               |_____ Ann
	// |       |               |
	// |       |               |_____ Andrew
	// |       |
	// |       |_______ Craig
	// |                |_____ 
	// |                |
	// |                |_____ Bruce
	// |                       |_____ Amanda
	// |                       |
	// |                       |_____ Allan
	// |
	// |______ David
	//         |_____ 
	//         |
	//        |_____ Carl
	//                |____ Barbara
	//                |     |_______ Anna
	//                |     |
	//                |     |_______ Anthony
	//                |
	//                |____ 
	// 
	// Ancestors at generation 1 (parents): David Dorothy 
	// Ancestors at generation 2 (grand-parents): Carl Craig Carol 
	// Ancestors at generation 3: Barbara Bruce Brian Brenda 
	// Male ancestors at generation 1 (father): David 
	// Male ancestors at generation 2 (grand-fathers): Carl Craig 
	// Male ancestors at generation 3: Bruce Brian 
	// Ancestors at generation 10 (empty): 
	// All generations:
	// Edward 
	// David Dorothy 
	// Carl Craig Carol 
	// Barbara Bruce Brian Brenda 
	// Anthony Anna Allan Amanda Andrew Ann Albert Alice 
}
