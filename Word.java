import java.io.PrintWriter;


/*
 * This class is the constructor for the Object Word
 * It includes setters, getters, visit(), operate(), and compareTo()
 */

public class Word implements TreeComparable{
	
	private PrintWriter pw;

	public Word(PrintWriter pw) {
		this.pw = pw;
	}
	
	private String word;
	private ObjectList instList;
	//number of times word appears in text
	
	public Word(String word, LinePosition lp){ //L.L. holds: int line number, int position number
		this.word = word;
		instList = new ObjectList();
		instList.addFirst(lp);
	}

	public String getInfo() {
		return word;
	}

	public void setInfo(String word) {
		this.word = word;
	}

	public int getCount(){
		return instList.size();
	}
	
	public ObjectList getList() {
		return instList;
	}

	public void addInstance(LinePosition lp) {
		instList.addLast(lp);
	}

	public int compareTo(Object o){
		Word w = (Word) o;
		return word.compareToIgnoreCase(w.getInfo());
	}
	
	public void operate(Object o) {
		Word e = (Word) o;
		ObjectListNode r = e.getList().getFirstNode();
		LinePosition newInstance = (LinePosition) r.getInfo();
		instList.addLast(newInstance);
	}
	
	public void visit() {
	 	 ObjectListNode  p = instList.getFirstNode();
	 	 String  instances = "" ;
	 	 while ( p  !=  null ){
	 	 	 instances  += (((LinePosition) p .getInfo()).getLine() +  "-"  + ((LinePosition) p .getInfo()).getPosition() +  "    " );
	 	 	 p  =  p .getNext();
	 	 }
	 	 System.out.format( "%-20s%-5s%-40s" , getInfo(), getCount(),  instances );
	 	 System.out.print( "\n" );
	 }
	

}