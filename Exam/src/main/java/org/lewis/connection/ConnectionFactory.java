package org.lewis.connection;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionFactory {
    private static String driver;
    private static String dburl;
    private static String name;
    private static String password;
    
    /**
     * 单例化
     */
    private static final ConnectionFactory factory= new ConnectionFactory();
    private ConnectionFactory(){   	
    }
    public static ConnectionFactory getInstance(){
    	return factory;
    }
    
    /**
     * 读取文件，把配置信息里的信息读取出来,放到一个代码块里
     */
    
    static{
    	Properties prop= new Properties();
    	
    	
    	try {
			prop.load(new FileReader(new File("jdbc.properties")));
			driver= prop.getProperty("driver");
			dburl= prop.getProperty("dburl");
			name= prop.getProperty("name");
			password= prop.getProperty("password");
			
			System.out.println(driver);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
    	
    }
    
    
    
    
    /**
     * 构建一个链接方法
     * @return
     */
    public Connection makeConnection(){
    	Connection conn=null;
    	try {
			Class.forName(driver);
			conn = DriverManager.getConnection(dburl,name,password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	return conn;
    	
    }
}