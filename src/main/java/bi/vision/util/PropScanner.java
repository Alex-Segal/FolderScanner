package bi.vision.util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

import Exceptions.InvalidSourceDirException;
import Exceptions.InvalidTargetDirException;
import bi.vision.dataObject.AppProperties;
import bi.vision.dataObject.LoadMetadata;

public class PropScanner {
	
	public PropScanner LoadProperties(String path){
//		LoadProperties  prop = new LoadProperties();
		HashMap<String, String> confMap = new HashMap<String, String>();
		if (path.equals("")){
			path = "config.properties";
		}

        // This will reference one line at a time
        String line = null;
        try {
            FileReader fileReader = new FileReader(path);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            while((line = bufferedReader.readLine()) != null) {
                String[] propLine = line.split("=");
                confMap.put(propLine[0], propLine[1]);
            }
            bufferedReader.close();
//            AppProperties.sourceDir = confMap.get("sourceDir");
            AppProperties.targetDir = confMap.get("targetDir");
            AppProperties.compressionSupported = confMap.get("compressionSupported");
            AppProperties.retentionPolicy = confMap.get("retentionPolicy");
        }
        catch(FileNotFoundException ex) {
            System.out.println("Unable to open file '" + path + "'");                
        }
        catch(IOException ex) {
            System.out.println("Error reading file '" + path + "'");                  
        }
        
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
