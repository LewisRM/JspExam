package org.lewis.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.lewis.entity.Customer;
import org.lewis.entity.Film;

public class FilmDao implements DAO {

	public ResultSet query(Connection conn, Customer customer) {
		return null;
	}
	
	public void insert(Connection conn, Film film){
		try {
			PreparedStatement ps=
					conn.prepareStatement("insert into film(title,description,language_id) values(?,?,?)");
			ps.setString(1, film.getTitle());
			ps.setString(2, film.getDescription());
			ps.setLong(3, film.getLanguageId());
			ps.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
