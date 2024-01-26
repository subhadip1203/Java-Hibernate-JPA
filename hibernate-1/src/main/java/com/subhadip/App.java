package com.subhadip;

import com.subhadip.Items.Person;
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
            Configuration config = new Configuration().configure().addAnnotatedClass(Person.class);

            StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();
            SessionFactory sessionFactory = config.buildSessionFactory(serviceRegistry);
            Session session = sessionFactory.openSession();
            Transaction tx =  session.beginTransaction();

//            Person user = new Person();
//            user.setAge(30);
//            user.setName("amit");
//            System.out.println(user);
//            session.persist(user);

            Person findUser = new Person();
            findUser = (Person)session.get(Person.class, 3);
            System.out.println(findUser);

            tx.commit();
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }

    }
}
