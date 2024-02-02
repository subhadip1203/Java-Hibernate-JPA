package com.subhadip;

import com.subhadip.Items.Employee;
import com.subhadip.Items.Person;
import com.subhadip.Items.Address;
import com.subhadip.Items.Project;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;


public class App 
{
    public static void main( String[] args )
    {



        try{
            Configuration config = new Configuration().configure()
                    .addAnnotatedClass(Person.class)
                    .addAnnotatedClass(Address.class)
                    .addAnnotatedClass(Employee.class)
                    .addAnnotatedClass(Project.class);

            StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();
            SessionFactory sessionFactory = config.buildSessionFactory(serviceRegistry);
            Session session = sessionFactory.openSession();
            Transaction tx =  session.beginTransaction();

//            Person user = new Person();
//            user.setAge(30);
//            user.setName("amit");
//            System.out.println(user);
//            session.persist(user);

//            Person findUser = new Person();
//            findUser = (Person)session.get(Person.class, 3);
//            System.out.println(findUser);





            Person user = new Person();
            user.setAge(20);
            user.setName("user1");


            Address address1 = new Address();
            address1.setUser(user);
            address1.setLocation("some address 1");


            Address address2 = new Address();
            address2.setUser(user);
            address2.setLocation("some address 2");

            session.persist(address2);
            session.persist(address1);
            session.persist(user);


            Employee emp = new Employee();
            emp.setName("emp2");

            Project proj1 = new Project();
            proj1.setProjectName("project x");
            proj1.addEmployees(emp);

            Project proj2 = new Project();
            proj2.setProjectName("project y");
            proj2.addEmployees(emp);


            emp.addProjects(proj1);
            emp.addProjects(proj2);

            session.persist(emp);
            session.persist(proj1);
            session.persist(proj2);


            tx.commit();
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }

    }
}
