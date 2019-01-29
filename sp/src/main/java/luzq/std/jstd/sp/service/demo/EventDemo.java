package luzq.std.jstd.sp.service.demo;

import luzq.std.jstd.sp.bean.event.EventPublisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("event")
public class EventDemo implements DemoService {
    @Autowired
    EventPublisher eventPublisher;

    @Override
    public void run() {
        eventPublisher.publishDemoEvent();
    }
}
