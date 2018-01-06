/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prakas.crmcore.module.dao.impl;

import com.prakas.crmcore.module.dao.GenericDAO;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Prakas
 * @param <T>
 */
public abstract class GenericDAOImpl <T> implements GenericDAO<T>{
    @Autowired
    protected SessionFactory sessionFactory;
    protected Session session;
    protected Transaction trans;
    private Class <T> persistentClass;
    public GenericDAOImpl(){ 
        this.persistentClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    } 
   
       @Override 
    public void insert(T t) {
        session = sessionFactory.openSession();
        trans = session.getTransaction();
        trans.begin();
        session.save(t);
        trans.commit();
        session.close(); 
    } 
 
    @Override 
    public void update(T t) {
        session = sessionFactory.openSession();
        trans = session.getTransaction();
        trans.begin();
        session.update(t);
        trans.commit();
        session.close(); 
    } 
 
    @Override 
    public void delete(int id) {
        session=sessionFactory.openSession();
        trans=session.getTransaction();
        trans.begin();
        session.delete(session.get(persistentClass, id));
        trans.commit();
        session.close(); 
    } 
     
    @Override 
    public T getById(int id) {
        session=sessionFactory.openSession();
        T obj=(T)session.get(persistentClass, id);
        session.close(); 
        return obj;
    } 
 
    @Override 
    public List<T> getAll() {
        session=sessionFactory.openSession();
        return session.createCriteria(this.persistentClass).list();
    } 
}
