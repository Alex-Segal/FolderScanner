package bi.vision.util;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import bi.vision.Exceptions.FolderScannerException;
import bi.vision.dataObject.FileMetadata;

public class FolderScanner {

	public ArrayList<FileMetadata> scanFolder(String path) throws FolderScannerException, SecurityException {

		File folder = new File(path);
		File[] listOfFiles = folder.listFiles();
		if (listOfFiles == null){
			throw new FolderScannerException("No files found in directory: " + path);
		}
		
		ArrayList<FileMetadata> fileMetaList = new ArrayList<FileMetadata>();
		CollectMetadata meta = new CollectMetadata();
	
		for (int i = 0; i < listOfFiles.length; i++) {
			try {
				fileMetaList.add(meta.getMetadata(listOfFiles[i]));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return fileMetaList;
	}
}
