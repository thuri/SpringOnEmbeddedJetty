package net.lueckonline.jetty;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.springframework.web.WebApplicationInitializer;

public class WebAppInitializer implements WebApplicationInitializer {

  public void onStartup(ServletContext servletContext) throws ServletException {
    System.out.println("Not it is called");
  }

}
