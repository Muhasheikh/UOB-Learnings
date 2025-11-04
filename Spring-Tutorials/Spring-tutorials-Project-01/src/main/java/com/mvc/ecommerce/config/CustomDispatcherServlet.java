package com.mvc.ecommerce.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class CustomDispatcherServlet extends AbstractAnnotationConfigDispatcherServletInitializer {

    public CustomDispatcherServlet() {
        System.out.println("Initialized Dispatcher Serlvet");
    }

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[0];
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{MyAppConfig.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}
