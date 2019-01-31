package luzq.std.jstd.spmvc;

import luzq.std.jstd.spmvc.config.WebConfig;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.Registration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

public class WebInitializer implements WebApplicationInitializer {
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        AnnotationConfigWebApplicationContext context =
                new AnnotationConfigWebApplicationContext();
        context.register(WebConfig.class);
        context.setServletContext(servletContext);

        Registration.Dynamic servlet = servletContext.addServlet("dispatcher", new DispatcherServlet(context));
        ((ServletRegistration.Dynamic) servlet).addMapping("/");
        ((ServletRegistration.Dynamic) servlet).setLoadOnStartup(1);
    }
}
