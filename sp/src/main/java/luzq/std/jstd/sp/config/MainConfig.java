package luzq.std.jstd.sp.config;

import luzq.std.jstd.sp.bean.ProfileBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
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
}
