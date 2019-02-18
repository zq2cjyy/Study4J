package luzq.std.jstd.spcld.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @Value("${server.port}")
    String port;

    @RequestMapping("/hello")
    public String hello() {
        return "Hello:" + port;
    }
}
