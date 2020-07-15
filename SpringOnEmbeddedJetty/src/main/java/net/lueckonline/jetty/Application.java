package net.lueckonline.jetty;

import java.util.Collections;

import org.eclipse.jetty.annotations.AnnotationConfiguration;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.Configuration;
import org.eclipse.jetty.webapp.WebAppContext;
import org.springframework.web.WebApplicationInitializer;

public class Application {

  public static void main(String[] args) throws Exception {

    Server server = new Server();
    
    WebAppContext webAppContext = new WebAppContext();
    webAppContext.setContextPath("/api");
    webAppContext.setConfigurations(new Configuration[] {new AnnotationConfiguration() {

      @Override
      public void preConfigure(WebAppContext context) throws Exception {
        super.preConfigure(context);
        ClassInheritanceMap cim = new ClassInheritanceMap();
        cim.put(WebApplicationInitializer.class.getName(), Collections.singleton(WebAppInitializer.class.getName()));
        context.setAttribute(AnnotationConfiguration.CLASS_INHERITANCE_MAP, cim);
      }
    }});
    
    server.setHandler(webAppContext);
    
    server.start();
    System.in.read();
    server.stop();
    
  }

}
