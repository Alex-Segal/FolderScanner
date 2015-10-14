package Exceptions;

public class InvalidSourceDirException extends Exception{

	private static final long serialVersionUID = -2099065287465810719L;
	
	public InvalidSourceDirException() {
	}
	
	public InvalidSourceDirException(String message){
		super(message);
	}
	
	public InvalidSourceDirException(Throwable cause){
		super(cause);
	}
	
	public InvalidSourceDirException(String message, Throwable cause){
		super(message,cause);
	}

}
