
public class LinePosition {
	
	/*
	 * This is the constructor for the Line and Position object
	 * needed for implementation within the Object Word's internal Linked list
	 */
	
	private int line;
	private int position;
	
	public LinePosition(int line, int position){
		this.line = line;
		this.position = position;
	}

	public int getLine() {
		return line;
	}

	public void setLine(int line) {
		this.line = line;
	}

	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}
	
	

}
