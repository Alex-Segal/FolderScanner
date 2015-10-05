package bi.vision.dataObject;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class LoadMetadata {
	
	private int id;
	private String sourceDir;
	private String targetDir;
	private String compressionSupported;
	private String retentionPolicy;
	private String status;
	
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false, precision = 100, scale = 0)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	@Column(name = "sourceDir", nullable = true, length = 100)
	public String getSourceDir() {
		return sourceDir;
	}	
	public void setSourceDir(String sourceDir) {
		this.sourceDir = sourceDir;
	}
	
	@Column(name = "targetDir", nullable = true, length = 100)
	public String getTargetDir() {
		return targetDir;
	}
	public void setTargetDir(String targetDir) {
		this.targetDir = targetDir;
	}
	
	@Column(name = "compressionSupported", nullable = true, length = 100)
	public String getCompressionSupported() {
		return compressionSupported;
	}
	public void setCompressionSupported(String compressionSupported) {
		this.compressionSupported = compressionSupported;
	}
	
	@Column(name = "retentionPolicy", nullable = true, length = 100)
	public String getRetentionPolicy() {
		return retentionPolicy;
	}
	public void setRetentionPolicy(String retentionPolicy) {
		this.retentionPolicy = retentionPolicy;
	}
	
	@Column(name = "status", nullable = true, length = 100)
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	

}
