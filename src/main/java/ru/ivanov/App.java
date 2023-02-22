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

            Principal principal = session.get(Principal.class, 1);

            School school = principal.getSchool();
            int schoolNumber = principal.getSchool().getSchoolNumber();
            System.out.println(school);
            System.out.println(schoolNumber);


            //Commit transaction
            session.getTransaction().commit();

        }
    }
}
