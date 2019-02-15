package luzq.std.jstd.spcld;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class SpcldEurekaServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpcldEurekaServerApplication.class, args);
    }

}

