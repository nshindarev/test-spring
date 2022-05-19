package component;

import component.entities.Details;
import component.entities.Employee;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.slf4j.Logger;

import java.util.List;

@Slf4j
public class HibernateTest {

    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Details.class)
                .buildSessionFactory();

        try{
            Session session = factory.getCurrentSession();

            Employee employee = new Employee("Arslanchik","Nevlyaevchik","Tinkoffchik", 250);
            Details employeeDetails = new Details("Saint-Pchik", "88005553239", "anevl@gmail.com");

            //employeeDetails.setEmployee(employee);
            session.beginTransaction();
            session.save(employeeDetails);
            session.getTransaction().commit();

            log.info("Transaction successfull");
        }
        finally{
            factory.close();
        }
    }
}
