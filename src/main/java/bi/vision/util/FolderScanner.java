package bi.vision.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

import bi.vision.dataObject.FileMetadata;

public class FolderScanner {

	public ArrayList<FileMetadata> scanFolder(String path) {

		File folder = new File(path);
		File[] listOfFiles = folder.listFiles();
		ArrayList<FileMetadata> fileMetaList = new ArrayList<FileMetadata>();
		FileMetadata fileMeta = new FileMetadata();
		
		
		for (int i = 0; i < listOfFiles.length; i++) {
			if (listOfFiles[i].isFile()) {

				fileMeta.setSource("tempSource");
				fileMeta.setName(listOfFiles[i].getName());
				fileMeta.setLocation(listOfFiles[i].getPath());
				fileMeta.setFormat(getFileFormat(fileMeta));
				fileMeta.setSizeKb(Objects.toString(listOfFiles[i].length()));
				fileMeta.setSizeByte(Objects.toString(listOfFiles[i].length()/1024));
				fileMeta.setPermissions("temp 777");
				fileMeta.setOwner("temp owner");
				fileMeta.setGroup("temp group");
				fileMeta.setNumOfRecords(getFileLines(listOfFiles[i]));
				fileMeta.setCreateDate("temp create date");
				fileMeta.setUpdateDate("temp updateDate");
				fileMeta.setLoadStatus("temp loadStatus");
				fileMeta.setErrorMessage("temp errorMessage");
				fileMeta.setRecordCreatedBy(" temp recordCreatedBy");
				fileMeta.setCompressed("true");
				fileMeta.setTimeStamp(Objects.toString(System.currentTimeMillis()));
				
				// ... the rest of settings
			} else if (listOfFiles[i].isDirectory()) {
				System.out.println("Directory " + listOfFiles[i].getName());
			}
		}
		return fileMetaList;
	}
	
	private String getFileFormat(FileMetadata fileMeta){
		String format = fileMeta.getName();
		String [] formatArr = format.split(".");
		format = formatArr[formatArr.length -1];
		return format;
	}
	
	private String getFileLines(File file){	
		int count = 0;
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
	        while((br.readLine()) != null) {
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

}
