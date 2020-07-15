package net.lueckonline.jetty;

import org.eclipse.jetty.annotations.AnnotationConfiguration;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.Configuration;
import org.eclipse.jetty.webapp.WebAppContext;

public class Application {

  public static void main(String[] args) throws Exception {

    Server server = new Server();
    
    WebAppContext webAppContext = new WebAppContext();
    webAppContext.setContextPath("/api");
    webAppContext.setConfigurations(new Configuration[] {new AnnotationConfiguration()});
    
    server.setHandler(webAppContext);
    
    server.start();
    System.in.read();
    server.stop();
    
  }

}
