package com.example.demo.controller;

import com.example.demo.model.Message;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
public class HelloWorldController {
    @Value("${word.hello}")
    private String text;

    @RequestMapping(value = "${word.hi}")
    public String hi(){
        return "hi";
    }

    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public String hello(@RequestParam String name){
        return "get method,hello "+name+"!" + "yaml中的值："+text;
    }

    @RequestMapping(value = "/post",method = RequestMethod.POST)
    public Message post(Message message){
        message.setDescription("create");
        return message;
    }

    @RequestMapping(value = "/delete/{code}", method = RequestMethod.DELETE)
    public Message delete(@PathVariable Integer code) {
        Message message = new Message();
        message.setDescription("delete");
        message.setCode(code);
        message.setMessage("how dare you delete me!");
        return message;
    }

    @RequestMapping(value = "/put", method = RequestMethod.PUT)
    public Message put(Message message) {
        Message message1 = new Message();
        message.setDescription("put");
        message.setMessage("put method update me,my code is your meg code now...");
        message.setCode(message.getCode());
        return message1;
    }
}
