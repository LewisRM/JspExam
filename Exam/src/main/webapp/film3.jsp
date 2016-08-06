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

    <form name="form2" >
       title： <input type="text" name="title" ><br>
       description:  <input type="text" name="description"><br>
       language:
        <%
        Class.forName("com.mysql.jdbc.Driver");
        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sakila","root","root");
        PreparedStatement ps=con.prepareStatement("select language_id,name from language");
        ResultSet rs=ps.executeQuery();
        while(rs.next()){
        %>
         <input name="language" type="radio" value="<%=rs.getInt("language_id")%>"/><%out.println(rs.getString("name")); %>
        <%}%> 
        <br>
        <br>
        <input type="button" value="submit" onclick="check()" name="sub">
    </form>
    
     <script>
         function check(){
        	 if(document.forms.form2.title.value==""){
        		 alert("please write the title");
        		 document.forms.form2.title.focus();
        	 }else if(document.forms.form2.description.value==""){
        		 alert("please write the description");
        		 document.forms.form2.description.focus();
        	 }else if(document.forms.form2.fruit.value==""){
        		 alert("please select the language");
        	 }
        	 else{
        		 //alert(document.forms.form2.title.value+document.forms.form2.description.value+document.forms.form2.fruit.value);
        		 document.forms.form2.submit();
        		 
        	 }       	
         }
   </script>
   
</body>
</html>