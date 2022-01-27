package com.zhisheng.community.controller;

import com.zhisheng.community.service.AlphaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/demo")
public class demoController {

    @Autowired
    private AlphaService alphaService;
    @RequestMapping("/hello")
    @ResponseBody //声明返回的字符串不是网页
    public String test(){
        return "hello spring boot";
    }
    @RequestMapping("/hello1")
    @ResponseBody
    public String test1(){
        return alphaService.find();
    }

    //Get请求获取参数
    // /hello2?current=1&limit=20
    @RequestMapping(path = "/hello2", method = RequestMethod.GET)
    @ResponseBody
    public String test2(
            @RequestParam(name = "current", required = false, defaultValue = "1") int current,
            @RequestParam(name = "limit", required = false, defaultValue = "20") int limit
    ){
        System.out.println(current);
        System.out.println(limit);
        return "success";
    }

    // /hello2/123 请求参数成为路径的一部分
    @RequestMapping(path = "/hello3/{id}",method = RequestMethod.GET)
    @ResponseBody
    public String test3(@PathVariable("id") int id){
        System.out.println(id);
        return "success ok";
    }

    //Post请求获取参数(参数名和html中对应name值一样)
    @RequestMapping(path="/hello4", method= RequestMethod.POST)
    @ResponseBody
    public String test4(String name, int age){
        System.out.println(name);
        System.out.println(age);
        return "success";
    }

    //响应html数据(使用templates文件夹下的模板引擎)
    @RequestMapping(path="/hello5",method=RequestMethod.GET)
    public ModelAndView test5(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("name","zhisheng");
        modelAndView.addObject("age","25");
        modelAndView.setViewName("/demo/view");
        return modelAndView;
    }

    @RequestMapping(path="/hello6", method=RequestMethod.GET)
    public String test6(Model model){
        model.addAttribute("name","北大");
        model.addAttribute("age","80");
        return "/demo/view";
    }

    //响应JSON数据（异步请求）
    //JAVA对象->JSON对象->JS对象
    @RequestMapping(path="/hello7",method=RequestMethod.GET)
    @ResponseBody
    //Map<>自动被封装成JSON
    public Map<String,Object> test7(){
        Map<String,Object> map = new HashMap<>();
        map.put("name","zhisheng");
        map.put("age",18);
        map.put("salary",10000);
        return map;
    }

    @RequestMapping(path="/hello8",method=RequestMethod.GET)
    @ResponseBody
    public List<Map<String,Object>> test8(){
        List<Map<String,Object>> lis = new ArrayList<>();

        Map<String,Object> map = new HashMap<>();
        map.put("name","zhisheng");
        map.put("age",18);
        map.put("salary",10000);
        lis.add(map);

        map = new HashMap<>();
        map.put("name","zhangsan");
        map.put("age",20);
        map.put("salary",1000);
        lis.add(map);

        map = new HashMap<>();
        map.put("name","lisi");
        map.put("age",22);
        map.put("salary",2000);
        lis.add(map);
        return lis;
    }
}
