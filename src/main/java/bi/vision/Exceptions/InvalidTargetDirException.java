package bi.vision.Exceptions;

public class InvalidTargetDirException extends Exception{

	private static final long serialVersionUID = -2099065287465810719L;
	
	public InvalidTargetDirException() {
	}
	
	public InvalidTargetDirException(String message){
		super(message);
	}
	
	public InvalidTargetDirException(Throwable cause){
		super(cause);
	}
	
	public InvalidTargetDirException(String message, Throwable cause){
		super(message,cause);
	}

}
