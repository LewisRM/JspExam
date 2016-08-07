package org.lewis.dao;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.lewis.entity.Customer;
import org.lewis.entity.Film;


public interface DAO {
       public ResultSet query(Connection conn,Customer customer);

	   public int insert(Connection conn, Film film);

	   public int delete(Connection conn, Film film);
    
}
