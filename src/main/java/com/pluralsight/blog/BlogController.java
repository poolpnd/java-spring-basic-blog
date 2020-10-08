package com.pluralsight.blog;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
public class BlogController {
    @RequestMapping("/")
    public String listPosts(ModelMap modelMap){
        modelMap.put("title", "Blog post 1");
        return "home";
    }
}
