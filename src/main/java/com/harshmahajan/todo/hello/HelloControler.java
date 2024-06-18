package com.harshmahajan.todo.hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloControler {
    @RequestMapping("hello")
    @ResponseBody
    public String sayHello(){
        return "Hello World na ah oh shit boui na na na na na na na ";
    }
    @RequestMapping("hello-jsp")
    public String hello(){
        return "hello";
    }
}
