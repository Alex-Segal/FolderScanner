package bi.vision.util;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import bi.vision.dataObject.FileMetadata;

public class FolderScanner {

	public ArrayList<FileMetadata> scanFolder(String path) {

		File folder = new File(path);
		File[] listOfFiles = folder.listFiles();
		ArrayList<FileMetadata> fileMetaList = new ArrayList<FileMetadata>();
		CollectMetadata meta = new CollectMetadata();
	
		for (int i = 0; i < listOfFiles.length; i++) {
			try {
				fileMetaList.add(meta.getMetadata(listOfFiles[i]));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return fileMetaList;
	}
}
