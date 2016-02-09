
/*
 * This serves as the comparable class between the node
 * and the information within the node
 * Used for classes which call these methods and must know what the method requires
 */

public interface TreeComparable {
	
	public int compareTo(Object o);
	public void operate(Object o);
	public void visit();

}
