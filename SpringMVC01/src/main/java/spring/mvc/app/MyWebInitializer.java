package spring.mvc.app;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import spring.mvc.config.MyWebConfig;

public class MyWebInitializer implements WebApplicationInitializer {

	public void onStartup(ServletContext servletContext) throws ServletException {
		// TODO Auto-generated method stub
        AnnotationConfigWebApplicationContext ctx =
                new AnnotationConfigWebApplicationContext();
        //register our config class
		ctx.register(MyWebConfig.class);
		
		ctx.setServletContext(servletContext);
		
		//using servlet 3 api to dynamically create
		//spring dispatcher servlet
		ServletRegistration.Dynamic servlet =
		                servletContext.addServlet("springDispatcherServlet",
		                                          new DispatcherServlet(ctx));
		
		servlet.setLoadOnStartup(1);
		servlet.addMapping("/");
	}

}
