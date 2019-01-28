package luzq.std.jstd.sp.bean.event;

import org.springframework.context.ApplicationEvent;

public class DemoEvent extends ApplicationEvent {

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    private String msg;

    public DemoEvent(Object source) {
        super(source);
    }
}
