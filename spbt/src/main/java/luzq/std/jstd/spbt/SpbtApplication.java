package luzq.std.jstd.spbt;

import luzq.std.jstd.spbt.config.InterceptorConfig;
import luzq.std.jstd.spbt.config.MainConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import({MainConfig.class, InterceptorConfig.class})
public class SpbtApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpbtApplication.class, args);
    }

}

