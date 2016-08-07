package org.lewis.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.lewis.connection.ConnectionFactory;
import org.lewis.dao.DAO;
import org.lewis.dao.FilmDao;
import org.lewis.entity.Film;

public class DeleteService {
private DAO filmdao = new FilmDao();
	
	public int deleteFilm(Film film){
		int count=0;
		Connection conn=null;
		try {

			/*Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sakila", "root", "root");*/
			conn=ConnectionFactory.getInstance().makeConnection();
			conn.setAutoCommit(false);

			count=filmdao.delete(conn,film);
            if(count>0){
               conn.commit();
            }else{
            	conn.rollback();
            }
            
            return count;
	       
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
		
		return count;
		
	}
}
