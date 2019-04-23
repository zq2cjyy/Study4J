package luzq.std.jstd.spbt.controller;

import luzq.std.jstd.spbt.config.SiteConfig;
import luzq.std.jstd.spbt.model.TestModel;
import luzq.std.jstd.spbt.model.cluster.AreaCity;
import luzq.std.jstd.spbt.model.cluster.SeriesModel;
import luzq.std.jstd.spbt.model.master.User;
import luzq.std.jstd.spbt.service.AreaService;
import luzq.std.jstd.spbt.service.MQService;
import luzq.std.jstd.spbt.service.UserService;
import luzq.std.jstd.spbt.utils.JedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "", produces = "application/json; charset=utf-8")
public class TestController {

    @Autowired
    SiteConfig siteConfig;
    @Autowired
    UserService userService;
    @Autowired
    AreaService areaService;
    @Autowired
    MQService mqService;
    @Autowired
    JedisUtil jedisUtil;

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

    @RequestMapping(value = "/json")
    public List<SeriesModel> getJson() {
        return areaService.getAllJson();
    }

    @RequestMapping(value = "/mq/send")
    public String sendMsg(String msg) {
        mqService.sendToRabbit(msg);
        return "ok";
    }

    @PostMapping(value = "/mq/post")
    public String postMsg(@RequestParam Map<String, Object> reqMap) {
        String msg = reqMap.get("_appid") + " send:" + reqMap.get("msg");
        mqService.sendToRabbit(msg);
        return "ok";
    }

    @RequestMapping(value = "exception")
    public String exception() throws Exception {
        throw new Exception("出现错误");
    }

    @GetMapping("jedis")
    public String jedis(String key) {
        String val = jedisUtil.get(key, 0);
        return val;
    }
}
