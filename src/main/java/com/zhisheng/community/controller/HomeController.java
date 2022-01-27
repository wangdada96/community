package com.zhisheng.community.controller;

import com.zhisheng.community.entity.DiscussPost;
import com.zhisheng.community.entity.Page;
import com.zhisheng.community.entity.User;
import com.zhisheng.community.service.DiscussPostService;
import com.zhisheng.community.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class HomeController {

    @Autowired
    private DiscussPostService discussPostService;

    @Autowired
    private UserService userService;

    @RequestMapping(path="/index",method= RequestMethod.GET)
    public String getIndexPage(Model model, Page page){
        //dispacherservlet 自动帮我们创建好了model 和page，并且自动将page装入model 返回给页面
        page.setRows(discussPostService.findDiscussPostRows(0)); //这里显示的是首页内容，userId为0表示查所有数据
        page.setPath("/index");

        List<DiscussPost> list = discussPostService.findDiscussPosts(0, page.getOffset(), page.getLimit());
        List<Map<String,Object>> discussPosts = new ArrayList<>();
        if(list!=null){
            for(DiscussPost post:list){
                Map<String,Object> map = new HashMap<>();
                User user = userService.findUserById(post.getUserId());
                map.put("post",post);
                map.put("user",user);
                discussPosts.add(map);
            }
        }
        model.addAttribute("discussPosts",discussPosts);
        return "/index";

    }

//    @RequestMapping(path="/indextest",method= RequestMethod.GET)
//    @ResponseBody
//    public void test(Model model) {
//        List<DiscussPost> list = discussPostService.findDiscussPosts(0, 0, 10);
//        List<Map<String, Object>> discussPosts = new ArrayList<>();
//        if (list != null) {
//            for (DiscussPost post : list) {
//                Map<String, Object> map = new HashMap<>();
//                User user = userService.findUserById(post.getUserId());
//                map.put("post", post);
//                map.put("user", user);
//                discussPosts.add(map);
//            }
//        }
//        for (Map<String, Object> map : discussPosts) {
//            System.out.println(map);
//        }
//    }

}
