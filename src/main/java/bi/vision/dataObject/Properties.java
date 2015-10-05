package bi.vision.dataObject;

public class Properties {
	
	private String sourceDir;
	private String targetDir;
	private String compressionSupported;
	
	public String getSourceDir() {
		return sourceDir;
	}
	public void setSourceDir(String sourceDir) {
		this.sourceDir = sourceDir;
	}
	public String getTargetDir() {
		return targetDir;
	}
	public void setTargetDir(String targetDir) {
		this.targetDir = targetDir;
	}
	public String getCompressionSupported() {
		return compressionSupported;
	}
	public void setCompressionSupported(String compressionSupported) {
		this.compressionSupported = compressionSupported;
	}
}
