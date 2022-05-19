package hibernate.main;

import hibernate.entities.Child;
import hibernate.entities.Section;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

@Slf4j
public class Main {
    public static void main(String[] args) {


        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Child.class)
                .addAnnotatedClass(Section.class)
                .buildSessionFactory();

        try{
            Session session = factory.getCurrentSession();

            Child roma = new Child(14, "Roma");
            Section swim = new Section("swim");
            Section eat = new Section("eat");
            Section chess = new Section("chess");

            roma.addSection(swim).addSection(eat).addSection(chess);

            session.beginTransaction();
            session.save(roma);
            session.getTransaction().commit();
        }
        finally{
            factory.close();
        }
    }
}
