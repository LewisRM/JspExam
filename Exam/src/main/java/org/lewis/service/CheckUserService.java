package org.lewis.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.lewis.connection.ConnectionFactory;
import org.lewis.dao.DAO;
import org.lewis.dao.UserDaoImpl;
import org.lewis.entity.Customer;


public class CheckUserService {
	private DAO userdao = new UserDaoImpl();
	
	Connection conn=null;
	public boolean checkUser(Customer customer)  {

		try {

			/*Class.forName("com.mysql.jdbc.Driver");

			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sakila", "root", "root");
*/
			conn=ConnectionFactory.getInstance().makeConnection();
			ResultSet resultset = userdao.query(conn, customer);

			while (resultset.next()) {
				return true;
			}

		} catch (Exception e) {
			e.printStackTrace();
			}finally{
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} 
		 

		return false;
	}
}
