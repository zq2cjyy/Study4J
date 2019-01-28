package luzq.std.jstd.sp;

import luzq.std.jstd.sp.bean.ProfileBean;
import luzq.std.jstd.sp.bean.event.EventPublisher;
import luzq.std.jstd.sp.config.MainConfig;
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

        //profile
        ProfileBean bean = context.getBean(ProfileBean.class);
        System.out.println(bean.getId());
        System.out.println(bean.getName());

        //event
        EventPublisher publisher = context.getBean(EventPublisher.class);
        publisher.publishDemoEvent();

        context.close();
    }
}
