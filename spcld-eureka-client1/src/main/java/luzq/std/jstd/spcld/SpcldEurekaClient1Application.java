package luzq.std.jstd.spcld;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableDiscoveryClient
public class SpcldEurekaClient1Application {

    public static void main(String[] args) {
        SpringApplication.run(SpcldEurekaClient1Application.class, args);
    }

}

