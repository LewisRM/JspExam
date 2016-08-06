<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
   <form name="form1" method="post" action="<%=request.getContextPath()%>/checkServlet">
     姓名：<input type="text" name="username"><br>
        <input type="button" value="submit" onclick="check()" name="sub">
   </form>
   
   <script>
         function check(){
        	 if(document.forms.form1.username.value==""){
        		 alert("请输入名户名");
        		 document.forms.form1.username.focus();
        	 }else{
        		 document.forms.form1.submit();
        	 }       	
         }
   </script>
</body>
</html>