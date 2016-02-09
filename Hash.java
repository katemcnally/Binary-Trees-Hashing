import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;


public class Hash {
	
	private PrintWriter pw;

	public Hash(PrintWriter pw) {
		this.pw = pw;
	}
	
	private String[] Info;
	private int Collisions;
	
	public Hash(){
		Info = new String[37];
		
		for (int index = 0; index < Info.length; index++){
			Info[index] = "";
		}
		Collisions = 0;
	}
	
	public void importInfo() throws IOException{
		
		try {
			File file = new File("LandOfLostWords.txt");
			FileReader fileReader = new FileReader(file);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			StringBuffer stringBuffer = new StringBuffer();
			String word;
			while ((word = bufferedReader.readLine()) != null) {
				//..... Insert into actual hash table
				insert(word);
			}
			fileReader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	// Method inserts a string into the hash table
	public void insert(String s){
		// If the hashed location is not empty, count collision and resolve
		int location = hashFunction(s);
		if (Info[location] != ""){
//			System.out.println("Collision detected at word: " + s);
			Collisions++;
			location = resolveCollision(location);
		}
		// Add string to table
		Info[location] = s;
	}
	
	// Methods resolves a collision in a linear probing way. Returns the place of a new location
	public int resolveCollision(int location){
		int newLocation = location;
		while (Info[newLocation] != ""){
			newLocation = (newLocation + 2) % Info.length;
		}
		return newLocation;
	}
	
	// Method displays all information contained in hash table
	public void displayInfo(){
		System.out.println("Location \t Data \n\n");

		for (int index = 0; index < Info.length; index++){
			System.out.println(index + "\t" + Info[index]);
		}
	}
	
	// Method looks up a parameter string and returns its existence value (is it there?!)
	public boolean contains(String s){
		boolean duh = "after".equalsIgnoreCase("after");
		
		int location = hashFunction(s);
		if (Info[location].equalsIgnoreCase(s))
			return true;
		else{
			int posLoc = location;
			int count = 1;
			// If more than one pass over the structure has been reached, or the item is found...
			while (!Info[posLoc].equalsIgnoreCase(s) && count < Info.length){
				posLoc = (posLoc + 2) % Info.length;
				count ++;
			}
			if (Info[posLoc].equalsIgnoreCase(s)){
				return true;
			}
			else return false;
		}
	}
	
	public  int hashFunction(String s){
		
		int value = -1;
		for (int cIndex = 0; cIndex < s.length(); cIndex++){
			char letter = s.charAt(cIndex);
			value += (int) letter;
		}
		return ((value) % Info.length);
				
	}
	
	public void description(){
			System.out.println("This hash function uses the sum of the integer values for each character of the " + "\n" + "key as the hash of the key.");
			pw.println("This hash function uses the sum of the integer values for each character of the " + "\n" + "key as the hash of the key.");
		}
	
		public int getCollisions(){
			pw.println("The number of Collisions is: " + Collisions);
			return Collisions;
		}
}
