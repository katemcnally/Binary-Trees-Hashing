
/*
 * This serves as the interface for the methods implemented in the Object Tree Node Class
 */

public interface ObjectTreeNodeInterface {
	
	public void setInfo(Object o);
	public Object getInfo();
	public void setLeft(ObjectTreeNode p);
	public ObjectTreeNode getLeft();
	public void setRight(ObjectTreeNode p);
	public ObjectTreeNode getRight();

}
