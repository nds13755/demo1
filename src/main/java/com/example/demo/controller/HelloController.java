// 文件位置: src/main/java/com/example/demo/controller/HelloController.java
package com.example.demo.controller;  // 注意包名要对应

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class HelloController {

    @RequestMapping("/hello1")
    public String hello() {
        return "Hello Springboot!";
    }
}