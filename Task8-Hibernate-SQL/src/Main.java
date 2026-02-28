import com.myApp.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {

        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate-config.xml")
                .addAnnotatedClass(User.class)
                .buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();
        //Create user
//
        User user = new User(2L, "tala", "mansour", "tala@gmail.com");
        session.beginTransaction();
        session.save(user);
        session.getTransaction().commit();
        System.out.println("User saved");
        //Update user
        session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        user = session.get(User.class, 1L);

        System.out.println(user);
        user.setPassword("333333f");
        session.save(user);
        session.getTransaction().commit();
        System.out.println("User Updated!");
        //Delete user
        session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        user = session.get(User.class, 1L);

        session.delete(user);
        session.save(user);
        session.getTransaction().commit();

    }
}