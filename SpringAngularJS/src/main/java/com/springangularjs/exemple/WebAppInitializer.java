package com.springangularjs.exemple;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class WebAppInitializer implements WebApplicationInitializer {

	private static final String CONFIG_LOCATION = "com.springangularjs.exemple.config";

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {

		// Create ApplicationContext
		AnnotationConfigWebApplicationContext applicationContext = new AnnotationConfigWebApplicationContext();
		applicationContext.setConfigLocation(CONFIG_LOCATION);

		// Manage the lifecycle of the application context
		servletContext.addListener(new ContextLoaderListener(applicationContext));

		// Add the servlet mapping manually and make it initialize automatically
		ServletRegistration.Dynamic servlet = servletContext.addServlet("mvc-dispatcher",
				new DispatcherServlet(applicationContext));

		servlet.addMapping("/");
		servlet.setAsyncSupported(true);
		servlet.setLoadOnStartup(1);

	}

}
