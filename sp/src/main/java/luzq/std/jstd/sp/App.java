package luzq.std.jstd.sp;

import luzq.std.jstd.sp.config.MainConfig;
import luzq.std.jstd.sp.service.demo.DemoService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context
                = new AnnotationConfigApplicationContext();
        context.getEnvironment().setActiveProfiles("prod");
        context.register(MainConfig.class);
        context.refresh();
//        context.start();
        String demoName = context.getEnvironment().getProperty("demo.class");

        DemoService demo = (DemoService) context.getBean(demoName);
        demo.run();

        context.close();
    }
}
