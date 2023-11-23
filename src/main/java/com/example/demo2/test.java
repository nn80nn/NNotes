package com.example.demo2;

import com.alibaba.fastjson.JSON;

import java.util.List;


import static com.alibaba.fastjson.JSON.parseObject;

public class test {
    public static void main(String[] args) throws Exception {
        String g = "{\"name\":\"1hjn\",\"dateOfNote\":\"Thu Nov 23 13:09:22 MSK 2023\",\"ntext\":\"nmnm\"}";
        //Note ob = parseObject(g, Note.class);
        List objectFromJsonString = parseObject(g, List.class);
        System.out.println("Object from String: " + objectFromJsonString);
        //System.out.println(ob);

    }
}
