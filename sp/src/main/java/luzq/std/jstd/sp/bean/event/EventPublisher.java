package luzq.std.jstd.sp.bean.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class EventPublisher {
    @Autowired
    ApplicationContext applicationContext;

    public void publishDemoEvent() {
        DemoEvent event = new DemoEvent(this);
        event.setMsg("do sth plz.");
        applicationContext.publishEvent(event);
    }
}
