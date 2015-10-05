package bi.vision.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Objects;

import bi.vision.dataObject.FileMetadata;

public class CollectMetadata {

	public FileMetadata getMetadata(File file) {
		FileMetadata fileMeta = new FileMetadata();

		if (file.isFile()) {

			fileMeta.setSource("tempSource");
			fileMeta.setName(file.getName());
			fileMeta.setLocation(file.getPath());
			fileMeta.setFormat(getFileFormat(fileMeta));
			fileMeta.setSizeByte(Objects.toString(file.length()));
			fileMeta.setPermissions("temp 777");
			fileMeta.setOwner("temp owner");
			fileMeta.setGroup("temp group");
			fileMeta.setNumOfRecords(getFileLines(file));
			fileMeta.setCreateDate("temp create date");
			fileMeta.setUpdateDate("temp updateDate");
			fileMeta.setLoadStatus("temp loadStatus");
			fileMeta.setErrorMessage("temp errorMessage");
			fileMeta.setRecordCreatedBy(" temp recordCreatedBy");
			fileMeta.setCompressed("true");
			fileMeta.setTimeStamp(Objects.toString(System.currentTimeMillis()));

			// ... the rest of settings
		} else if (file.isDirectory()) {
			System.out.println( file.getName() + " is a directory!");
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

}
