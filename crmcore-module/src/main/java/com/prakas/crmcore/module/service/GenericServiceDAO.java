/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prakas.crmcore.module.service;

import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Prakas
 * @param <T>
 */
public interface GenericServiceDAO<T,TDAO> {
    List<T> getAll()throws ClassNotFoundException, SQLException;
    
    T getById(int id)throws ClassNotFoundException, SQLException;

    void insert(T t)throws ClassNotFoundException, SQLException;

    void delete(int id)throws ClassNotFoundException, SQLException;

    void update(T t)throws ClassNotFoundException, SQLException;

    
}
