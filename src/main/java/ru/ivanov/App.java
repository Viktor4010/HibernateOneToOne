package ru.ivanov;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.ivanov.models.Principal;
import ru.ivanov.models.School;

public class App {
    public static void main(String[] args) {
        try(SessionFactory sessionFactory = new Configuration()
                .addAnnotatedClass(Principal.class)
                .addAnnotatedClass(School.class)
                .buildSessionFactory();

            Session session = sessionFactory.getCurrentSession()) {

            session.beginTransaction();
            // Perform database operations

            School school = session.get(School.class, 4);

            Principal principal = school.getPrincipal();
            System.out.println(principal);

            //Commit transaction
            session.getTransaction().commit();

        }
    }
}
