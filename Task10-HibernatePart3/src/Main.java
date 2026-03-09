import com.myApp.entitiy.Student;
import com.myApp.entitiy.Transcript;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import java.time.LocalDate;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
//        SessionFactory Setting
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate-config.xml")
                .addAnnotatedClass(Student.class)
                .addAnnotatedClass(Transcript.class)
                .buildSessionFactory();

//      Open Session
        Session session = sessionFactory.getCurrentSession();
        try {
            //==Save Object
            session.beginTransaction();

            Student student = new Student(
                    "Faten",
                    "faten@gmail.com",
                    LocalDate.of(1999, 8, 1),
                    500
            );

            Transcript transcript = new Transcript(student, 3.6, "2024");


            session.save(student);
            session.save(transcript);

            session.getTransaction().commit();

            //HQL calculate avg and Pagination
            session = sessionFactory.getCurrentSession();
            session.beginTransaction();

            Double avgFees = (Double) session
                    .createQuery("select avg(s.fees) from Student s")
                    .getSingleResult();

            System.out.println("Average Fees = " + avgFees);

            List<Student> students = session
                    .createQuery("from Student", Student.class)
                    .setFirstResult(0)
                    .setMaxResults(2)
                    .list();

            students.forEach(System.out::println);

            session.getTransaction().commit();

        }
        finally {
            //  CLOSE database connection
            sessionFactory.close();


        }
    }
}
