package bi.vision.FolderScanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import bi.vision.dataObject.FileMetadata;
import bi.vision.db.HibernateUtil;

public class App 
{
    public static void main( String[] args )
    {
        Session session = HibernateUtil.getSessionFactory().openSession();
        FileMetadata fm = new FileMetadata();
        fm.setName("Alex");
        session.beginTransaction();
        session.save(fm);
        session.getTransaction().commit();
        session.close();
        System.exit(0);
    }
}
