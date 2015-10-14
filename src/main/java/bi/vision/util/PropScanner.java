package bi.vision.util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

import bi.vision.Exceptions.FolderScannerException;
import bi.vision.Exceptions.InvalidSourceDirException;
import bi.vision.Exceptions.InvalidTargetDirException;
import bi.vision.dataObject.AppProperties;
import bi.vision.dataObject.LoadMetadata;

public class PropScanner {
	
	public PropScanner LoadProperties(final String path) throws FolderScannerException{
		HashMap<String, String> confMap = new HashMap<String, String>();
		if (path.equals("")){
			throw new FolderScannerException("Configuration file path not found! Please pass path as argument");
		}

        // This will reference one line at a time
        String line = null;
        try {
            FileReader fileReader = new FileReader(path);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            while((line = bufferedReader.readLine()) != null) {
            	line = line.trim();
            	if (line.length() == 0){
            		continue;
            	}
                String[] propLine = line.split("=");
                if (propLine.length != 2){
                	throw new FolderScannerException("Configuration values are incorrect. Please make sure all values delimited by '='! Example: sourceDir=C:\\...");
                }else{
                    confMap.put(propLine[0], propLine[1]);
                }
            }
            bufferedReader.close();
        }
        catch(FileNotFoundException ex) {
        	System.out.println("Unable to open file '" + path + "'");
        	throw new FolderScannerException("Unable to open file '" + path + "'\n" + ex);
                         
        }
        catch(IOException ex) {
            System.out.println("Error reading file '" + path + "'");
            throw new FolderScannerException("Error reading file '" + path + "'\n" + ex);
        }
        AppProperties.sourceDir = confMap.get("sourceDir");
        AppProperties.targetDir = confMap.get("targetDir");
        AppProperties.compressionSupported = confMap.get("compressionSupported");
        AppProperties.retentionPolicy = confMap.get("retentionPolicy");
        
		try{
			if (AppProperties.sourceDir == null || AppProperties.sourceDir.length() < 1){
				throw new InvalidSourceDirException("Invalid source directory, please check configuration file");
			}
			if (AppProperties.targetDir == null || AppProperties.targetDir.length() < 1){
				throw new InvalidTargetDirException("Invalid target directory, please check configuration file");
			}
		}catch (InvalidSourceDirException e){
			e.printStackTrace();
		}catch (InvalidTargetDirException e){
			e.printStackTrace();
		}
		return this;
	}
	
	public LoadMetadata getConfigInstance(){

		LoadMetadata lm = new LoadMetadata();
		lm.setSourceDir(AppProperties.sourceDir);
		lm.setTargetDir(AppProperties.targetDir);
		lm.setCompressionSupported(AppProperties.compressionSupported);
		lm.setRetentionPolicy(AppProperties.retentionPolicy);
		return lm;
	}

}
