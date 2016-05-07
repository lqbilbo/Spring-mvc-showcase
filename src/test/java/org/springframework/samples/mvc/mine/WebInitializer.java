package org.springframework.samples.mvc.mine;

import java.util.EnumSet;

import javax.servlet.DispatcherType;
import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration.Dynamic;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.DispatcherServlet;

public class WebInitializer implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		
		AnnotationConfigWebApplicationContext rootContext = 
			new AnnotationConfigWebApplicationContext();
		rootContext.register(AppConfig.class);
		servletContext.addListener(new ContextLoaderListener(rootContext));
		
		//2. springmvc上下文
		AnnotationConfigWebApplicationContext springMvcContext =
			new AnnotationConfigWebApplicationContext()	;
		springMvcContext.register(MvcConfig.class);
		//3. DispatcherServlet
		DispatcherServlet dispatcherServlet = new DispatcherServlet(springMvcContext);
		
		Dynamic dynamic = servletContext.addServlet("dispatcherServlet", dispatcherServlet);
		dynamic.setLoadOnStartup(1);
		dynamic.addMapping("/");
		
		//4. CharacterEncodingFilter
		CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
		characterEncodingFilter.setEncoding("utf-8");
		FilterRegistration filterRegistration =
			servletContext.addFilter("characterEncodingFilter", characterEncodingFilter);
		filterRegistration.addMappingForUrlPatterns(EnumSet.of(DispatcherType.REQUEST), 
				false, "/");
		
	}

}
