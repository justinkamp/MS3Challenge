package Main;

import Main.entity.Entity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Database {

    public static void dataEntry(String[] profile) {
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Entity.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            Entity newProfile = new Entity(
                    profile[0],
                    profile[1],
                    profile[2],
                    profile[3],
                    profile[4],
                    profile[5],
                    profile[6],
                    profile[7],
                    profile[8],
                    profile[9]);
            session.beginTransaction();
            session.save(newProfile);
            session.getTransaction().commit();

        } finally {
            factory.close();

        }

    }

}
