package luzq.std.jstd.spcld.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("spcld-ribbon-client")
public interface RibbonClient {
    @RequestMapping(value = "hi", method = RequestMethod.GET)
    String hi();
}
