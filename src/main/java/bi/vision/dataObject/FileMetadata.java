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
	private int id;
	private String source;
	private String name;
	private String location;
	private String format;
	private String sizeByte;
	private String permissions;
	private String owner;
	private String group;
	private String numOfRecords;
	private String createDate;
	private String updateDate;
	private String loadStatus;
	private String errorMessage;
	private String recordCreatedBy;
	private String timeStamp;
	private String compressed;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false, precision = 100, scale = 0)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "source", nullable = true, length = 100)
	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	@Column(name = "name", nullable = true, length = 100)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	@Column(name = "permissions", nullable = true, length = 100)
	public String getPermissions() {
		return permissions;
	}

	public void setPermissions(String permissions) {
		this.permissions = permissions;
	}

	@Column(name = "owner", nullable = true, length = 100)
	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	@Column(name = "perGroup", nullable = true, length = 100)
	public String getGroup() {
		return group;
	}

	public void setGroup(String group) {
		this.group = group;
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

	@Column(name = "recordCreatedBy", nullable = true, length = 100)
	public String getRecordCreatedBy() {
		return recordCreatedBy;
	}

	public void setRecordCreatedBy(String recordCreatedBy) {
		this.recordCreatedBy = recordCreatedBy;
	}

	@Column(name = "timeStamp", nullable = true, length = 100)
	public String getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(String timeStamp) {
		this.timeStamp = timeStamp;
	}
	
	public String getCompressed() {
		return compressed;
	}
	
	@Column(name = "timeStamp", nullable = true, length = 100)
	public void setCompressed(String compressed) {
		this.compressed = compressed;
	}

	@Override
	public String toString() {
		return "FileMetadata [id=" + id + ", source=" + source + ", name=" + name + ", location=" + location
				+ permissions + ", owner=" + owner + ", group=" + group + ", numOfRecords=" + numOfRecords
				+ ", createDate=" + createDate + ", updateDate=" + updateDate + ", loadStatus=" + loadStatus
				+ ", errorMessage=" + errorMessage + ", recordCreatedBy=" + recordCreatedBy + ", timeStamp=" + timeStamp
				+ "]";
	}

}
