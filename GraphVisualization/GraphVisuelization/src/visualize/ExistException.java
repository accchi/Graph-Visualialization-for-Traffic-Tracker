package visualize;

public class ExistException extends Exception { // exception if node or edge already exist

	private String message;
	
	public ExistException(String m) {
		
		message=m;
		
	}
	
	public String toString() {
		
		return message;
		
	}
}
