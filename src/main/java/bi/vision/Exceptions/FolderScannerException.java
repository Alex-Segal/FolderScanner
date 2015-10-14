package bi.vision.Exceptions;

public class FolderScannerException extends Exception {

	private static final long serialVersionUID = -338577498465313050L;
	
	public FolderScannerException() {
	}
	
	public FolderScannerException(String message){
		super(message);
	}
	
	public FolderScannerException(Throwable cause){
		super(cause);
	}
	
	public FolderScannerException(String message, Throwable cause){
		super(message,cause);
	}
}
