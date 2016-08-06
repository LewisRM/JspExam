package org.lewis.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.lewis.entity.Customer;
import org.lewis.entity.Film;


public class UserDaoImpl implements DAO {

	public ResultSet query(Connection conn, Customer customer) {
		 try {
			PreparedStatement ps=
					conn.prepareStatement("select * from customer where first_name=?");
			ps.setString(1, customer.getFirstName());
			ResultSet re=ps.executeQuery();
			return re;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		 System.out.println("没有该用户 ");
		return null;
	}

	public void insert(Connection conn, Film film) {
		// TODO Auto-generated method stub
		
	}

}
