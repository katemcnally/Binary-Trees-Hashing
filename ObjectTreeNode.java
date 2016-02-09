
// ObjectTreeNode.java

/*
 * This is the constructor for the Object Tree Nodes to be placed within a Object Binary Tree
 */

public class ObjectTreeNode implements ObjectTreeNodeInterface, TreeComparable {
    private Object info;
    private ObjectTreeNode left;
    private ObjectTreeNode right;
    
    public ObjectTreeNode() {
        info = null;
        left = null;
        right = null;
    }
    
    public ObjectTreeNode (Object o) {
        info = o;
        left = null;
        right = null;
    }
    
    public void setInfo(Object o) {
        info = o;
    }
    
    public Object getInfo() {
        return info;
    }
    
    public void setLeft(ObjectTreeNode p) {
        left = p;
    }
    
    public ObjectTreeNode getLeft() {
        return left;
    }
    
    public void setRight(ObjectTreeNode p) {
        right = p;
    }
    
    public ObjectTreeNode getRight() {
        return right;
    }
    
    public int compareTo(Object o){
		ObjectTreeNode e = (ObjectTreeNode) o;
		return ((TreeComparable) info).compareTo((TreeComparable)e.getInfo());		
	}
	public void operate(Object o){
		ObjectTreeNode e = (ObjectTreeNode) o;
		((TreeComparable) info).operate((TreeComparable) e.getInfo());			
	}
	public void visit(){
		((TreeComparable) info).visit();
	}
}
