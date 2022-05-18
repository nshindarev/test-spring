package component;

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
                .buildSessionFactory();

     /*   try{
            Session session = factory.getCurrentSession();
            Employee employee = new Employee("Dasha","Chupyrkina","DT IT", 100);
            session.beginTransaction();
            session.save(employee);

            int myId = employee.getId();


            Employee employee1 = session.get(Employee.class, myId);
            session.getTransaction().commit();

            log.info(employee1.toString());
        }*/

        try{
            Session session = factory.getCurrentSession();
            Employee employee = new Employee("Dasha","Chupyrkina","DT IT", 100);
            session.beginTransaction();

            List<Employee> employeeList = session.createQuery("from Employee").getResultList();
            for (Employee emp: employeeList) log.info(emp.toString());
        }
        finally{
            factory.close();
        }
    }
}
