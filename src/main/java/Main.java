import org.apache.log4j.BasicConfigurator;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {

    private static SessionFactory sessionFactory;

    public static void main(String[] args) {

        BasicConfigurator.configure();

        sessionFactory = new Configuration().
                configure().
                addAnnotatedClass(Client.class).
                buildSessionFactory();

        Main m = new Main();

        Integer clientID1 = m.addClient("Ivan", 33);

    }

    private Integer addClient(String name, Integer age) {

        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        Integer clientID = null;

        try {
            transaction = session.beginTransaction();
            Client client = new Client();
            client.setName(name);
            client.setAge(age);
            clientID = (Integer) session.save(client);
            transaction.commit();
        } catch (HibernateException e1) {
            if (transaction != null) transaction.rollback();
            e1.printStackTrace();
        } finally {
            session.close();
        }

        return clientID;
    }

}
