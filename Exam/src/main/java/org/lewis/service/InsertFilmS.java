package org.lewis.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import org.lewis.dao.DAO;
import org.lewis.dao.FilmDao;
import org.lewis.entity.Film;


public class InsertFilmS {
	private DAO filmdao = new FilmDao();
	
	public void insertFilm(Film film){
		try {

			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sakila", "root", "root");
			conn.setAutoCommit(false);

			filmdao.insert(conn,film);

	

		} catch (Exception e) {
			e.printStackTrace();
			} 
		
	}
}
