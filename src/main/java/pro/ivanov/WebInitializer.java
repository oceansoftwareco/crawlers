package pro.ivanov;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRegistration.Dynamic;

import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;

public class WebInitializer implements WebApplicationInitializer {
	
	 @Override
	 public void onStartup(ServletContext container) throws ServletException {
		 AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();  
	     
		 ctx.register(WebInitializer.class);
	     ctx.setServletContext(container);
		 ctx.setConfigLocation("pro.ivanov");

		 Dynamic registration = container.addServlet("DispatcherServlet", new DispatcherServlet(ctx));
		 
	     registration.setLoadOnStartup(1);
	     registration.addMapping("/");
	 }
}