package com.java.goit.dao.hibernate;

import com.java.goit.dao.DishDao;
import com.java.goit.model.Dish;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class HDishDao implements DishDao {

    private SessionFactory sessionFactory;

    @Override
    @Transactional
    public void save(Dish dish) {
        sessionFactory.getCurrentSession().save(dish);
    }

    @Override
    @Transactional
    public List<Dish> findAll() {
        return sessionFactory.getCurrentSession().createQuery("select d from Dish d").list();
    }

    @Override
    public Dish findByName(String name) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select e from Dish e where e.name like :name");
        query.setParameter("name", name);
        return (Dish) query.uniqueResult();
    }

    @Override
    public void removeAll() {
        sessionFactory.getCurrentSession().createQuery("delete from Dish").executeUpdate();
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
