package bi.vision.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;
import java.nio.file.attribute.UserPrincipal;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

import bi.vision.dataObject.AppProperties;
import bi.vision.dataObject.FileMetadata;

public class CollectMetadata {
	
	private boolean compressedFlag = false;

	public FileMetadata getMetadata(File file) throws IOException {  // wrap in a custom exception 
		
		FileMetadata fileMeta = new FileMetadata();
		
		if (file.isFile()) {
			Path path = Paths.get(file.getPath());
			BasicFileAttributes attributes;
			attributes = Files.readAttributes(path, BasicFileAttributes.class);

			
			fileMeta.setSource(AppProperties.sourceDir);
			fileMeta.setName(file.getName());
			fileMeta.setCompressed(checkCompression(fileMeta));
			fileMeta.setLocation(file.getPath());
			fileMeta.setFormat(getFileFormat(fileMeta));
			fileMeta.setSizeByte(Objects.toString(file.length()));
			fileMeta.setOwner(getOwner(path)); 
			fileMeta.setNumOfRecords(getFileLines(file));
			fileMeta.setCreateDate(getCreateTime(attributes));
			fileMeta.setUpdateDate(getLastUpdate(attributes));
			fileMeta.setLoadStatus(null); // will be updated after load
			fileMeta.setErrorMessage(null); // will be updated after load if needed
			fileMeta.setTimeStamp(formatDate(FileTime.from(System.currentTimeMillis(), TimeUnit.MILLISECONDS)));

		} else if (file.isDirectory()) {
			System.out.println( file.getName() + " directory will be skipped!");
		}

		return fileMeta;
	}

	private String getFileFormat(FileMetadata fileMeta) {
		String format = fileMeta.getName();
		String[] formatArr = format.split("\\.");
		format = formatArr[formatArr.length - 1];
		return format;
	}

	private String getFileLines(File file) {
		// If file is compressed, do not count number of rows.
		if (compressedFlag == true)
			return null;
		
		int count = 0;
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			while ((br.readLine()) != null) {
				count++;
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Objects.toString(count);
	}
	
	private String getOwner(Path filePath){
		String OS = System.getProperty("os.name");
		String username = "";
		try {
		    UserPrincipal owner = Files.getOwner(filePath, LinkOption.NOFOLLOW_LINKS);
		    username = owner.getName();
		    if (OS.toLowerCase().contains("windows") && username.length() > 0){
		    	String[] fullUser = username.split("\\\\");
		    	username = fullUser[fullUser.length -1];
		    }		    
		} catch (IOException e) {
		    e.printStackTrace();
		}
		return username;
	}

	private String formatDate(FileTime ft){
		return ft.toString().split("\\.")[0].replace("T", " ");
	}
	
	private String getCreateTime(BasicFileAttributes attributes){
		FileTime creationTime;
		creationTime = attributes.creationTime();
		return formatDate(creationTime);
	}
	
	private String getLastUpdate(BasicFileAttributes attributes){
		FileTime updateTime;
		updateTime = attributes.lastModifiedTime();
		return formatDate(updateTime);
	}
	
	private String checkCompression(FileMetadata fm){
		String ext = getFileFormat(fm);
		String commpression = null;
		if (AppProperties.compressionSupported.contains(ext)){
			commpression = ext;
		}
		this.compressedFlag = commpression == null ? false : true;
		return commpression;
	}
	

}
