package com.personTest.dao;


import com.edutilos.javaFX.model.Person;
import com.personTest.model.PersonTest;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


import javax.persistence.NoResultException;
import java.util.List;

public class _PersonDAO implements PDAO<PersonTest, Integer> {

    public _PersonDAO(){intSessionFactory();}
    private SessionFactory factory;
    private void intSessionFactory() {
        factory=new Configuration().configure().buildSessionFactory();
    }


    private void closeSessionFactory() {
        if(factory != null && factory.isOpen())
            factory.close();
    }

    @Override
    public void create(PersonTest personTest) {
        Session session=factory.openSession();
        try{
            session.getTransaction().begin();
            session.save(personTest);

        }catch(Exception ex){
            ex.printStackTrace();
            session.getTransaction().rollback();
        }finally{
            session.close();
        }


    }

    @Override
    public void update(Integer id, PersonTest ps) {
        Session session = factory.openSession();
        try {
            session.getTransaction().begin();
            PersonTest p=find(id);
            p.setName(ps.getName());
            p.setAdress(ps.getAdress());
            p.setVorname(ps.getVorname());
            session.merge(p);
            session.getTransaction().commit();
        } catch(Exception ex) {
            ex.printStackTrace();
            session.getTransaction().rollback();
        } finally {
            session.close();
        }

    }

    @Override
    public void delete(Integer integer) {

    }

    @Override
    public PersonTest find(Integer id) {
        Session session = factory.openSession();
        try {
            return  session.createQuery("from PersonTest where id = :id", PersonTest.class)
                    .setParameter("id", id)
                    .getSingleResult();
        }catch (NoResultException e){
            return null;
        }
    }


    public PersonTest findByName(String name) {
        Session session = factory.openSession();

        PersonTest person = session.createQuery("from PersonTest where name = :name",PersonTest.class)
                .setParameter("name", name)
                .getSingleResult();

        session.close();
        return person;
    }

    @Override
    public List<PersonTest> findAll() {
        Session session = factory.openSession();
        List<PersonTest> allUnis = session.createQuery("from PersonTest", PersonTest.class)
                .getResultList();
        session.close();
        return allUnis;
    }

}
