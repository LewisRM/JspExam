package org.lewis.servlet;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.lewis.entity.Customer;
import org.lewis.entity.FF;

import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapper;
import freemarker.template.Template;
import freemarker.template.TemplateException;



public class EditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Configuration cfg; 

    public EditServlet() {
        super();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String title=request.getParameter("title");
		String des=request.getParameter("des");
		String lang=request.getParameter("lang");
		
		System.out.println(title);
		System.out.println(des);
		System.out.println(lang);
		
		
		FF thisfilm= new FF();
		thisfilm.setTitle(title);
		thisfilm.setDes(des);
		thisfilm.setLang(lang);
		
		//初始化FreeMarker配置
        //创建一个Configuration实例
        cfg = new Configuration();
        //设置FreeMarker的模版文件位置
        cfg.setServletContextForTemplateLoading(getServletContext(), "WEB-INF/temp");
        
        
		Map<String,Object> root=new HashMap<String, Object>();  
		root.put("thisfilm", thisfilm); 
		    
        //取得模版文件
        Template t = cfg.getTemplate("edit.ftl");        
        // 开始准备生成输出
        // - 使用模版文件的charset作为本页面的charset
        // - 使用text/html MIME-type
        response.setContentType("text/html; charset=" + t.getEncoding());
        Writer out = response.getWriter();
        
        //合并数据模型和模版，并将结果输出到out中
        try
        {
            t.process(root, out);
        } 
          catch (TemplateException e){
            throw new ServletException("处理Template模版中出现错误", e);
        }
    }
	}
	
	
	
	
	
	
	

     
     
   





 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 


