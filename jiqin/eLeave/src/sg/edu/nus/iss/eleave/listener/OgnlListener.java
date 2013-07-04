package sg.edu.nus.iss.eleave.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import ognl.OgnlRuntime;
 
public class OgnlListener implements ServletContextListener, HttpSessionListener, HttpSessionAttributeListener {
 
    @Override
    public void contextDestroyed(ServletContextEvent arg0) {}
 
    @Override
    public void contextInitialized(ServletContextEvent arg0) {
        OgnlRuntime.setSecurityManager(null);
    }
    
    @Override
    public void sessionCreated(HttpSessionEvent arg0) {}

    @Override
    public void sessionDestroyed(HttpSessionEvent arg0) {}  
  
    @Override
    public void attributeAdded(HttpSessionBindingEvent arg0) {}  
  
    @Override
    public void attributeRemoved(HttpSessionBindingEvent arg0) {}  
  
    @Override
    public void attributeReplaced(HttpSessionBindingEvent arg0) {}  
}