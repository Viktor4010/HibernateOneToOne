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

            Principal lena = new Principal("Lena", 21);
            School school = new School(777, lena);

            lena.setSchool(school);

            session.save(lena);


            //Commit transaction
            session.getTransaction().commit();

        }
    }
}
