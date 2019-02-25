package luzq.std.jstd.base.ds;

import java.util.HashSet;
import java.util.Set;

public class DataStruct {

    public static void main(String[] args) {
        Set<String> set = new HashSet<>();

        //HashSet插入重复值 不会引起异常  也不会重复插入
        System.out.println(set.add("luzq"));
        System.out.println(set.add("cj"));
        System.out.println(set.add("luzq"));

        System.out.println(set);
        //[luzq, cj]
    }
}
