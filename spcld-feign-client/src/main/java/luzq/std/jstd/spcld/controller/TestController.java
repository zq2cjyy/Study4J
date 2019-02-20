package luzq.std.jstd.spcld.controller;

import luzq.std.jstd.spcld.service.RibbonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    /**
     * 这里会报错 接着运行  运行的时候 会自动加载
     */
    @Autowired
    RibbonClient ribbonClient;

    @GetMapping("hi")
    public String hi() {
        return "feign-" + ribbonClient.hi();
    }
}
