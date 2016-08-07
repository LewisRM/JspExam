package org.lewis.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class PassFilter implements Filter {

    public PassFilter() {
    }

	public void init(FilterConfig fConfig) throws ServletException {
	}


	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req=(HttpServletRequest) request;
        HttpServletResponse resp=(HttpServletResponse) response;
        
        
        String servletpath=req.getServletPath();
        HttpSession session = req.getSession();
        
        String flag=(String) session.getAttribute("flag");
        
        if(servletpath !=null &&(servletpath.equals("/login.jsp") ||servletpath.equals("/") ||servletpath.equals("/checkServlet") || servletpath.equals("/index.jsp"))){
        	chain.doFilter(request, response);
        }else if(flag!=null && flag.equals("login_success")){
        	chain.doFilter(request, response);
        }else{
        	RequestDispatcher rd=req.getRequestDispatcher("/login.jsp");      	
        	rd.forward(req, resp);
        }
	}



	
	public void destroy() {
	}

}
