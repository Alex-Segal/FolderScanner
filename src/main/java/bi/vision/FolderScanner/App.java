package bi.vision.FolderScanner;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import bi.vision.dataObject.FileMetadata;
import bi.vision.dataObject.LoadMetadata;
import bi.vision.dataObject.AppProperties;
import bi.vision.db.HibernateUtil;
import bi.vision.util.FolderScanner;
import bi.vision.util.PropScanner;

public class App 
{
    public static void main( String[] args )
    {
        Session session = HibernateUtil.getSessionFactory().openSession();
        FolderScanner fs = new FolderScanner();
        LoadMetadata lm = new LoadMetadata();
        PropScanner ps = new PropScanner();
        ArrayList<FileMetadata> fileMetaList = new ArrayList<FileMetadata>();
        String configPath = "";
        if (args.length > 0){
        	configPath = args[0];
        }
        lm = ps.LoadProperties(configPath).getConfigInstance();
        fileMetaList = fs.scanFolder(AppProperties.sourceDir);        
        session.beginTransaction();
        for (FileMetadata fm : fileMetaList){
        	session.save(fm);
        }
        session.save(lm);
        
        session.getTransaction().commit();
        session.close();
        System.exit(0);
    }
}
