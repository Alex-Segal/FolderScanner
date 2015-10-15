package bi.vision.dataObject;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "FileMetadata") // Table name in SQL Server is FileMetadata
public class FileMetadata implements java.io.Serializable {

	private static final long serialVersionUID = -2113581398584198581L;
	private int fileId;
	private String source;
	private String fileName;
	private String location;
	private String format;
	private String sizeByte;
	private String fileOwner;
	private String numOfRecords;
	private String createDate;
	private String updateDate;
	private String loadStatus;
	private String errorMessage;
	private String fileTimeStamp;
	private String compressed;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "fileId", unique = true, nullable = false, precision = 100, scale = 0)
	public int getId() {
		return fileId;
	}

	public void setId(int id) {
		this.fileId = id;
	}

	@Column(name = "source", nullable = true, length = 100)
	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	@Column(name = "FileName", nullable = true, length = 100, unique=true)
	public String getName() {
		return fileName;
	}

	public void setName(String name) {
		this.fileName = name;
	}

	@Column(name = "location", nullable = true, length = 100)
	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	@Column(name = "format", nullable = true, length = 100)
	public String getFormat() {
		return format;
	}

	public void setFormat(String format) {
		this.format = format;
	}

	@Column(name = "sizeByte", nullable = true, length = 100)
	public String getSizeByte() {
		return sizeByte;
	}

	public void setSizeByte(String sizeByte) {
		this.sizeByte = sizeByte;
	}

	@Column(name = "fileOwner", nullable = true, length = 100)
	public String getOwner() {
		return fileOwner;
	}

	public void setOwner(String owner) {
		this.fileOwner = owner;
	}

	@Column(name = "numOfRecords", nullable = true, length = 100)
	public String getNumOfRecords() {
		return numOfRecords;
	}

	public void setNumOfRecords(String numOfRecords) {
		this.numOfRecords = numOfRecords;
	}

	@Column(name = "createDate", nullable = true, length = 100)
	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	@Column(name = "updateDate", nullable = true, length = 100)
	public String getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}

	@Column(name = "loadStatus", nullable = true, length = 100)
	public String getLoadStatus() {
		return loadStatus;
	}

	public void setLoadStatus(String loadStatus) {
		this.loadStatus = loadStatus;
	}

	@Column(name = "errorMessage", nullable = true, length = 100)
	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	@Column(name = "fileTimeStamp", nullable = true, length = 100)
	public String getTimeStamp() {
		return fileTimeStamp;
	}

	public void setTimeStamp(String timeStamp) {
		this.fileTimeStamp = timeStamp;
	}
	
	@Column(name = "compressed", nullable = true, length = 100)
	public String getCompressed() {
		return compressed;
	}
	
	public void setCompressed(String compressed) {
		this.compressed = compressed;
	}

	@Override
	public String toString() {
		return "FileMetadata [id=" + fileId + ", source=" + source + ", name=" + fileName + ", location=" + location
				+ ", owner=" + fileOwner + ", numOfRecords=" + numOfRecords
				+ ", createDate=" + createDate + ", updateDate=" + updateDate + ", loadStatus=" + loadStatus
				+ ", errorMessage=" + errorMessage + ", timeStamp=" + fileTimeStamp
				+ "]";
	}

}
