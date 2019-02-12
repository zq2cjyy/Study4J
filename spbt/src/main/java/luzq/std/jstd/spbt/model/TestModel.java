package luzq.std.jstd.spbt.model;

import com.alibaba.fastjson.annotation.JSONField;

public class TestModel {
    @JSONField(name = "test-id")
    private int id;
    @JSONField(name = "test-name")
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
