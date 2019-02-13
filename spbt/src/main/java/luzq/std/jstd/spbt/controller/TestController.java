package luzq.std.jstd.spbt.controller;

import luzq.std.jstd.spbt.config.SiteConfig;
import luzq.std.jstd.spbt.model.TestModel;
import luzq.std.jstd.spbt.model.cluster.AreaCity;
import luzq.std.jstd.spbt.model.master.User;
import luzq.std.jstd.spbt.service.AreaService;
import luzq.std.jstd.spbt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "", produces = "application/json; charset=utf-8")
public class TestController {

    @Autowired
    SiteConfig siteConfig;
    @Autowired
    UserService userService;
    @Autowired
    AreaService areaService;

    @RequestMapping("/hello")
    public String hello() {
        return "hello";
    }

    @RequestMapping("/mode")
    public String runModel() {
        return "name:" + siteConfig.getServerName()
                + "\r\nmode:" + siteConfig.getRunMode();
    }

    @RequestMapping("/cfg")
    public SiteConfig config() {
        return siteConfig;
    }

    @RequestMapping(value = "/testjson")
    public TestModel testJSON() {
        TestModel model = new TestModel();
        model.setId(1);
        model.setName("luzq");
        return model;
    }

    @RequestMapping(value = "/user")
    public User getUser(int id) {
        return userService.getUserById(id);
    }

    @RequestMapping(value = "/city")
    public List<AreaCity> getCity() {
        return areaService.getAllCity();
    }
}
