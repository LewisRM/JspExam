package org.lewis.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.lewis.entity.Film;
import org.lewis.service.DeleteService;



public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DeleteService ds=new  DeleteService();

    public DeleteServlet() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String id=request.getParameter("id");
		short Id=(short)Integer.parseInt(id);
        
        RequestDispatcher rd=null;
        
        String forward=null;

        Film film= new Film();
        film.setFilmId(Id);
   
        	
        int count=ds.deleteFilm(film);
            
        if(count>0){
            	forward="success1.jsp";
        }else{
            	forward="error1.jsp";
        }
            rd=request.getRequestDispatcher(forward);
            rd.forward(request, response);
	}

	}


