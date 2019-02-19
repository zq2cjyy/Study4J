package luzq.std.jstd.spcld.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "spcld-eureka-client1", fallback = RibbonService.class)
public interface RibbonClient {
    @RequestMapping(value = "hello", method = RequestMethod.GET)
    String hi();
}
