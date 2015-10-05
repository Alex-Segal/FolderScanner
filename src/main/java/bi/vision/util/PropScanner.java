package bi.vision.util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

import bi.vision.dataObject.Properties;

public class PropScanner {
	
	public Properties getTransferProperties(String path){
		Properties prop = new Properties();
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
            prop.setSourceDir((String) confMap.get("sourceDir"));
            prop.setTargetDir((String) confMap.get("targetDir"));
            prop.setCompressionSupported((String) confMap.get("compressionSupported"));
        }
        catch(FileNotFoundException ex) {
            System.out.println("Unable to open file '" + path + "'");                
        }
        catch(IOException ex) {
            System.out.println("Error reading file '" + path + "'");                  
        }
        return prop;
	}

}
