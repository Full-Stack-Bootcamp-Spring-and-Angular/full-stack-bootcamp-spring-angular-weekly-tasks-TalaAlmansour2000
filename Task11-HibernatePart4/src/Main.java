import com.myApp.entity.OrderIteams;
import com.myApp.entity.Orders;
import com.myApp.entity.Product;
import com.myApp.entity.User;
import com.myApp.service.OrderService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new org.hibernate.cfg.Configuration().configure("hibernate-config.xml")
                .addAnnotatedClass(User.class)
                .addAnnotatedClass(Orders.class)
                .addAnnotatedClass(OrderIteams.class)
                .addAnnotatedClass(Product.class)
                .buildSessionFactory();
        //      Open Session
        Session session = sessionFactory.getCurrentSession();
        try {
            session.beginTransaction();
            //save new products
            Product p1=new Product();
            p1.setName("Laptop IDEAPAD Slim3");
            p1.setPrice(5000.0);
            p1.setManufacturer("Lenovo");
            p1.setStockQuantity(7);
            p1.setProductionDate(LocalDate.now());
            session.save(p1);
            Product p2 =new Product();
            p2.setName("Redmi note14");
            p2.setPrice(500.0);
            p2.setManufacturer("Xaomi");
            p2.setStockQuantity(50);
            p2.setProductionDate(LocalDate.now());
            session.save(p2);
            Product p3 =new Product();
            p3.setName("Redmi A7");
            p3.setPrice(200.0);
            p3.setManufacturer("Xaomi");
            p3.setStockQuantity(100);
            p3.setProductionDate(LocalDate.now());
            session.save(p3);
            Product p4 = new Product();
            p4.setName("Wireless mouse");
            p4.setPrice(25.0);
            p4.setStockQuantity(50);
            session.save(p4);

            //save new user
            User newUser=new User("1","alaa@gmail.com","alaa",null);
            session.save(newUser);
            //save new order
            Orders userOrder1= new Orders();
            userOrder1.setOrderDate(LocalDate.now());
            userOrder1.setUser(newUser);

//save ordersiteam
            OrderIteams iteam1=new OrderIteams();
            iteam1.setQuantity(1);
            iteam1.setProduct(p1);

            OrderIteams iteam2 =new OrderIteams();
            iteam2.setQuantity(4);
            iteam2.setProduct(p4);


//Count the total price & update quantity
            OrderService service = new OrderService();
            service.addOrderItem(userOrder1,iteam1);
            service.addOrderItem(userOrder1,iteam2);

            session.save(userOrder1);
            session.getTransaction().commit();
//print
            session = sessionFactory.getCurrentSession();
            session.beginTransaction();

            User loadedUser = session.get(User.class, newUser.getId());
            System.out.println("User : " + loadedUser.getUsername());


            System.out.println("Orders: " + loadedUser.getOrders());
            System.out.println("Orders count: " + loadedUser.getOrders().size());
            session.getTransaction().commit();

        } finally {
            sessionFactory.close();
        }

    }
}