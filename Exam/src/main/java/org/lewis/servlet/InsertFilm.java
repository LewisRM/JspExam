package org.lewis.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.lewis.entity.Film;
import org.lewis.service.CheckUserService;
import org.lewis.service.InsertFilmS;


public class InsertFilm extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private InsertFilmS ifs=new  InsertFilmS();
  
    public InsertFilm() {
        super();
        
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String title=request.getParameter("title");
		String description=request.getParameter("description");
		String language=request.getParameter("language");
		byte languageId=(byte)Integer.parseInt(language);
        
        RequestDispatcher rd=null;
        
        String forward=null;

        Film film= new Film();
        film.setTitle(title);
        film.setDescription(description);
        film.setLanguageId(languageId);
   
        	
        int count=ifs.insertFilm(film);
            
        if(count>0){
            	forward="success1.jsp";
        }else{
            	forward="error1.jsp";
        }
            rd=request.getRequestDispatcher(forward);
            rd.forward(request, response);
	}

}
