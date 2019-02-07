package luzq.std.jstd.spbt.controller;

import luzq.std.jstd.spbt.config.SiteConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Autowired
    SiteConfig siteConfig;

    @RequestMapping("/hello")
    public String hello() {
        return "hello";
    }

    @RequestMapping("mode")
    public String runModel() {
        return "name:" + siteConfig.getServerName()
                + "\r\nmode:" + siteConfig.getRunMode();
    }


}
