package src.objektorienterat;

public enum Mark {
	NULL(""),X("X"),O("O");
	
	String theString;
	
	Mark(String theString) {
		this.theString = theString;
	}
	
	@Override
	public String toString() {
		return this.theString;
	}
}
