package org.lewis.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.lewis.entity.Customer;
import org.lewis.service.CheckUserService;

@WebServlet("/CheckServlet")
public class CheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private CheckUserService cus=new  CheckUserService();
	
	
    public CheckServlet() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doPost(request, response);
	}
	
	


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            String name=request.getParameter("username");
            
            RequestDispatcher rd=null;
            
            String forward=null;

            Customer customer= new Customer();
            customer.setFirstName(name);
       
            	
            boolean bool= cus.checkUser(customer);
                
            if(bool){
                	forward="success.jsp";
                }else{
                	request.setAttribute("msg", "用户名和密码输入错误，请重新输入");
                	forward="error.jsp";
                }
                rd=request.getRequestDispatcher(forward);
                rd.forward(request, response);
                
            }
               
            
	}


