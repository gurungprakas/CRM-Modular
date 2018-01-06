/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prakas.crmcore.module.service.impl;

import com.prakas.crmcore.module.dao.GenericDAO;
import com.prakas.crmcore.module.service.GenericServiceDAO;
import java.lang.reflect.ParameterizedType;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Prakas
 * @param <T>
 * @param <TDAO>
 */
public abstract class GenericServiceImpl<T, TDAO> implements GenericServiceDAO<T, TDAO> {
    @Autowired
    private GenericDAO<T> genericdao;

    public GenericServiceImpl() {
        genericdao = (GenericDAO<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[1];
    }

    @Override
    public List<T> getAll() throws ClassNotFoundException, SQLException {
        return genericdao.getAll();
    }

    @Override
    public T getById(int id) throws ClassNotFoundException, SQLException {
        return genericdao.getById(id);
    }

    @Override
    public void update(T t) throws ClassNotFoundException, SQLException {
        genericdao.update(t);
    }

    @Override
    public void delete(int id) throws ClassNotFoundException, SQLException {
        genericdao.delete(id);
    }

    @Override
    public void insert(T t) throws ClassNotFoundException, SQLException {
        genericdao.insert(t);
    }

}
