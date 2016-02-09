import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;


/*
 * This class holds the main methods for printing the getty.txt file
 * and used for outputting the alphabetical list
 */

public class Xref {
	
	private PrintWriter pw;

	public Xref(PrintWriter pw) {
		this.pw = pw;
	}
	
	ObjectBinaryTree WordTree = new ObjectBinaryTree();
	Query query = new Query();
	
	
	public void importWords() throws FileNotFoundException{
		Hash ignoreDict = new Hash();
		try {
			ignoreDict.importInfo();
		} catch (IOException e) {
			e.getMessage();
			e.printStackTrace();
		}
		
		Scanner fileScan = new Scanner(new File("getty.txt"));
		String buf;
		Word w;
		int line = 0;
		int position = 0;
		System.out.print("The Gettysburg Address");
		pw.print("The Gettysburg Address");
		
		/*
		 *  While there is content in the document...
		 */
		while (fileScan.hasNextLine()) {
			Scanner wordscan = new Scanner(fileScan.nextLine());
			line++;
			System.out.println(" ");
			System.out.print(line+" ");
			pw.println(" ");
			pw.print(line+" ");
			position = 0;
			/*
			 *  While there are words in the line...
			 */
			while(wordscan.hasNext()){
				buf = wordscan.next();
				buf = buf.replaceAll("[,.]", "");
				position++;
				System.out.print(buf+" ");
				pw.print(buf+" ");

				/*
				 *  If not in hash table of ignored words, proceed
				 */
				if(!ignoreDict.contains(buf)){ 
					
					/*
					 *  Generate word stats
					 */
					LinePosition lp = new LinePosition(line, position);
					w = new Word(buf, lp);
					ObjectTreeNode p = new ObjectTreeNode();
					p.setInfo(w);
					WordTree.insertBSTDup(p);				
				}
			}
		}
		fileScan.close();
	}
	
	public void AlphaList(){
		/*
		 *  in order traversal,
		 *  print out list of words in alphabetical order from binary tree with..
		 *  with string, #of times it appears in tree, and lines and positions it occurs
		 */
		WordTree.inTrav(WordTree.getRoot());
	}
	
	public void processQueries(){
		query.run(pw, WordTree);
	} 
	
}
