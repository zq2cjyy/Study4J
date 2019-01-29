package luzq.std.jstd.sp.service.demo;

import luzq.std.jstd.sp.service.async.AsyncService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("async")
public class AsyncDemo implements DemoService {
    @Autowired
    AsyncService service;

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            service.execInteger(i);
            service.execIntegerPlus(i);
        }
    }
}
