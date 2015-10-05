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
		CollectMetadata meta = new CollectMetadata();
	
		for (int i = 0; i < listOfFiles.length; i++) {
			fileMetaList.add(meta.getMetadata(listOfFiles[i]));
		}
		return fileMetaList;
	}
}