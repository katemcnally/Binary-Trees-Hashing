import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/*
 * This class holds the methods necessary to perform the run-time queries
 */

public class Query {
	
	private Word query;

	public Query() {
		query = new Word("", null);
	}
	
	public Word InputQuery(PrintWriter pw){
		Scanner scan = new Scanner(System.in);
		System.out.println("Input Query:");
		pw.println("Input Query:");
		String input = scan.nextLine();
		Word w = new Word(input, null);
		return w;
	}
	
	public void DisplayResults(PrintWriter pw, ObjectBinaryTree t, Word w){
		ObjectTreeNode q = new ObjectTreeNode(w);
		ObjectTreeNode r = t.searchBST(q);
		if( r == null){
			System.out.println(w.getInfo() + ": This term is not in the file.");
			pw.println(w.getInfo() + ":This term is not in the file.");
		}
		else{
			//print out word, number of times it appears, line and position
			r.visit();
		}
	}
	
	public void run(PrintWriter pw, ObjectBinaryTree t){
		query = InputQuery(pw);
		while(!((String)query.getInfo()).equalsIgnoreCase("exit")){
			DisplayResults(pw, t, query);
			query = InputQuery(pw);
		}
	}

}