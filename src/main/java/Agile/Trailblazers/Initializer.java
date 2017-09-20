package Agile.Trailblazers;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
public class Initializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{ApplicationInitializer.class, SwaggerConfig.class};
    }

    protected Class<?>[] getServletConfigClasses() {
        return new Class[0];
    }

    protected String[] getServletMappings() {
        return new String[]{"/api/*"};
    }
}
