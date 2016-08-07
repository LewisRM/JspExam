package org.lewis.freemarker;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Map;

import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapper;
import freemarker.template.Template;
import freemarker.template.TemplateException;

public class FreeMarkerUtil {
	public static void analysisTemplate(String templatePath,String templateName,String fileName,Map<?,?>root){  
		try {  
		   Configuration config=new Configuration();  
	  
		  config.setDirectoryForTemplateLoading(new File(templatePath));  

		   config.setObjectWrapper(new DefaultObjectWrapper());  
		     

		Template template=config.getTemplate(templateName,"UTF-8");  
	 
		   FileOutputStream fos = new FileOutputStream(fileName);  
		   Writer out = new OutputStreamWriter(fos,"UTF-8");  
		      template.process(root, out);  
		      out.flush();  
		      out.close();  
		  } catch (IOException e) {  
		   e.printStackTrace();  
		  }catch (TemplateException e) {  
		   e.printStackTrace();  
		  }  
		 }  
	
	
	
}
