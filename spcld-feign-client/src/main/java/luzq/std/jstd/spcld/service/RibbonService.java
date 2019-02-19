package luzq.std.jstd.spcld.service;

import org.springframework.stereotype.Component;

@Component
public class RibbonService implements RibbonClient {
    @Override
    public String hi() {
        return "sorry feign";
    }
}
