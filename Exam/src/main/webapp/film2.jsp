<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.sql.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>电影列表</title>
</head>
<body>
    <table border="1" width="80%" align="center">
    <caption><h1>电影列表</h1></caption>
        <tr>
            <th>film_id</th>
   			<th>title</th>
   			<th>description</th>
  			<th>language</th>
        </tr>
        <%
        Class.forName("com.mysql.jdbc.Driver");
        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sakila","root","root");
        PreparedStatement ps=con.prepareStatement("select film_id,title,description,language.name as ln from film,language where film.language_id=language.language_id");
        ResultSet rs=ps.executeQuery();
        while(rs.next()){
        %>
        <tr>
            <td><%out.println(rs.getInt("film_id")); %></td>
            <td><%out.println(rs.getString("title"));%></td>
            <td><%out.println(rs.getString("description"));%></td>
            <td><%out.println(rs.getString("ln"));%></td>
        </tr> 
        <%}%>     
    </table>
</body>
</html>