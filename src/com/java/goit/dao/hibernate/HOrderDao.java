package com.java.goit.dao.hibernate;

import com.java.goit.dao.OrderDao;
import com.java.goit.model.Orders;
import org.hibernate.SessionFactory;

import java.util.List;

public class HOrderDao implements OrderDao{

    private SessionFactory sessionFactory;

    @Override
    public void save(Orders orders) {
        sessionFactory.getCurrentSession().save(orders);
    }

    @Override
    public List<Orders> findAllOrders() {
        return sessionFactory.getCurrentSession().createQuery("select o from Orders o").list();
    }

    @Override
    public void removeAll() {
        sessionFactory.getCurrentSession().createQuery("delete from Orders").executeUpdate();
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
