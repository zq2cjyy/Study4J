package luzq.std.jstd.sp.config;

import luzq.std.jstd.sp.bean.ProfileBean;
import luzq.std.jstd.sp.bean.condition.LinuxBean;
import luzq.std.jstd.sp.bean.condition.SystemBean;
import luzq.std.jstd.sp.bean.condition.WindowsBean;
import luzq.std.jstd.sp.condition.LinuxCondition;
import luzq.std.jstd.sp.condition.WindowsCondition;
import org.springframework.amqp.core.Queue;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.*;

@Configuration
@EnableAutoConfiguration
@ComponentScan("luzq.std.jstd.sp")
@PropertySource("classpath:sys.properties")
@Import({TaskConfig.class, ScheduledConfig.class})
public class MainConfig {

    @Bean
    @Profile("dev")
    public ProfileBean devProfileBean() {
        ProfileBean bean = new ProfileBean();
        bean.setId(1);
        bean.setName("lu2c");
        return bean;
    }


    @Bean
    @Profile("prod")
    public ProfileBean prodProfileBean() {
        ProfileBean bean = new ProfileBean();
        bean.setId(2);
        bean.setName("2gui");
        return bean;
    }

    @Bean
    @Conditional(LinuxCondition.class)
    public SystemBean linux() {
        return new LinuxBean();
    }

    @Bean
    @Conditional(WindowsCondition.class)
    public SystemBean windows() {
        return new WindowsBean();
    }

    @Bean
    public Queue rabbitSender() {
        return new Queue("luzq-queue");
    }
}
