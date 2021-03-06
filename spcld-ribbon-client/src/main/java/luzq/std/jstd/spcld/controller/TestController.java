package luzq.std.jstd.spcld.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import luzq.std.jstd.spcld.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @Autowired
    HelloService helloService;

    /**
     * ribbon+rest
     * 参考:https://blog.csdn.net/forezp/article/details/81040946
     *
     * @return
     */
    @RequestMapping("/hi")
    @HystrixCommand(fallbackMethod = "error")
    public String hi() {
        return "ribbon-" + helloService.getHello();
    }

    public String error() {
        return "error";
    }
}
