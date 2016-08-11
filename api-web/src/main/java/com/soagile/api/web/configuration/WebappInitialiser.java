package com.soagile.api.web.configuration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletRegistration;


public class WebappInitialiser implements WebApplicationInitializer {

    @Override
    public void onStartup(ServletContext container) {

        // Create the 'root' Spring application context
        AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();
//        rootContext.register(ServiceConfiguration.class);

        // Manage the lifecycle of the root application context
        container.addListener(new ContextLoaderListener(rootContext));

        // Create the dispatcher servlet's Spring application context
        AnnotationConfigWebApplicationContext dispatcherServlet = new AnnotationConfigWebApplicationContext();
        dispatcherServlet.register(WebappConfiguration.class);

        // Register and map the dispatcher servlet
        ServletRegistration.Dynamic dispatcher = container.addServlet("dispatcher", new DispatcherServlet(dispatcherServlet));
        dispatcher.setLoadOnStartup(1);
        dispatcher.addMapping("/");
    }

//    @Override    protected String[] getServletMappings()  {
//        return new String[]{"/"};
//    }
//
//    /**
//     * @return
//     */
//    @Override
//    protected Class<?>[] getRootConfigClasses() {
//        return new Class<?>[0];
//    }
//
//    @Override
//    protected Class<?>[] getServletConfigClasses() {
//        return new Class<?>[] {WebappConfiguration.class};
//
//    }
}
