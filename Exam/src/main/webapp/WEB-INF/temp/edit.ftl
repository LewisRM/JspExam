<!DOCTYPE HTML>  
<html>  
  <head>  
  <meta http-equiv=Content-Type content="text/html; charset="utf-8">  
  <title>EditPage</title>  
  </head>  
  <body>  
    <form>
      Title: <input type="text" value=${thisfilm.title}><br>
      Description: <textarea  style="width:40% height:60px">${thisfilm.des}</textarea><br>
      Language: <input type="text" value=${thisfilm.lang}><br>
      <input type="button" value="submit the edition">     
    </form>
    <br>
    <a href="http://localhost:8080/film.jsp">Come Back</a>
  </body>  
</html>  