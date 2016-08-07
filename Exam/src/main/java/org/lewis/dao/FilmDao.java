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
	
	public int insert(Connection conn, Film film){
		int count=0;
		try {
			PreparedStatement ps=
					conn.prepareStatement("insert into film(title,description,language_id) values(?,?,?)");
			ps.setString(1, film.getTitle());
			ps.setString(2, film.getDescription());
			ps.setByte(3, film.getLanguageId());
			count=ps.executeUpdate();
			System.out.println(count);
			return count;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}
     
	
	public int delete(Connection conn, Film film){
		int count=0;
		try {
			PreparedStatement ps1=
					conn.prepareStatement("SET FOREIGN_KEY_CHECKS = 0");
			PreparedStatement ps2=
					conn.prepareStatement("delete from film where film_id=?");
			PreparedStatement ps3=
					conn.prepareStatement("SET FOREIGN_KEY_CHECKS = 1");
			ps2.setInt(1, film.getFilmId());
			ps1.execute();
			count=ps2.executeUpdate();
			ps3.execute();
			System.out.println(count);
			return count;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}
}
