package luzq.std.jstd.spcld.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class HelloService {

    @Autowired
    RestTemplate restTemplate;

    public String getHello() {
        return restTemplate.getForObject("http://spcld-eureka-client1/hello", String.class);
    }
}
