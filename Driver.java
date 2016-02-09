import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;


/**
 * 
 * @author Kate
 * ID #: 011047098
 * Project Title: Binary Trees and Hashing
 * Project Description: This program uses binary trees to organize data and hashing to more easily find certain elements within that data
 * Date: August 9, 2015
 * How to Start the Project: Run the driver class
 * User Instructions: Once you are prompted, enter your searches
 *
 */

public class Driver {

	public static void main(String[] args) throws IOException {
		PrintWriter pw = new PrintWriter(new FileWriter("csis.txt"));
		Xref xr = new Xref(pw);
		xr.importWords();
		System.out.println(" ");
		pw.println(" ");
		pw.println("Word Stats: ");
		xr.AlphaList();
		xr.processQueries();
		Hash hash = new Hash(pw);
		//hash.displayInfo();
		hash.getCollisions();
		hash.description();
		
		pw.close();

	}

}
