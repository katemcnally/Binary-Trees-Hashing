
/*
 * This serves as the interface for the ObjectListNode methods,
 * within the ObjectListNode class
 */

public interface ObjectListNodeInterface {
	
	public void setInfo(Object o);
	public Object getInfo();
	public void setNext(ObjectListNode p);
	public ObjectListNode getNext();

}
