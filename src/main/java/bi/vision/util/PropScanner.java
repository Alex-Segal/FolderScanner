package bi.vision.util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

import bi.vision.dataObject.AppProperties;

public class PropScanner {
	
	public void LoadProperties(String path){
//		LoadProperties  prop = new LoadProperties();
		HashMap confMap = new HashMap();
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
            AppProperties.sourceDir = ((String) confMap.get("sourceDir"));
            AppProperties.targetDir = ((String) confMap.get("targetDir"));
            AppProperties.compressionSupported = ((String) confMap.get("compressionSupported"));
        }
        catch(FileNotFoundException ex) {
            System.out.println("Unable to open file '" + path + "'");                
        }
        catch(IOException ex) {
            System.out.println("Error reading file '" + path + "'");                  
        }
	}

}
