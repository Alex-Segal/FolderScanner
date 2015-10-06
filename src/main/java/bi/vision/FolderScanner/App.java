package bi.vision.FolderScanner;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import bi.vision.dataObject.FileMetadata;
import bi.vision.dataObject.AppProperties;
import bi.vision.db.HibernateUtil;
import bi.vision.util.FolderScanner;
import bi.vision.util.PropScanner;

public class App 
{
    public static void main( String[] args )
    {
        Session session = HibernateUtil.getSessionFactory().openSession();
        // FileMetadata fm = new FileMetadata();
        FolderScanner fs = new FolderScanner();
        PropScanner ps = new PropScanner();
        ArrayList<FileMetadata> fileMetaList = new ArrayList<FileMetadata>();        
//        AppProperties prop = ps.getTransferProperties("");
        String configPath = "";
        if (args.length > 0){
        	configPath = args[0];
        }
        ps.LoadProperties(configPath);
        
        
        fileMetaList = fs.scanFolder(AppProperties.sourceDir);
        
        session.beginTransaction();
        for (FileMetadata fm : fileMetaList){
        	session.save(fm);
        }
        session.getTransaction().commit();
        session.close();
        System.exit(0);
    }
}
