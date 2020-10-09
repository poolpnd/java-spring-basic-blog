package com.pluralsight.blog;

import com.pluralsight.blog.data.PostRepository;
import com.pluralsight.blog.model.Post;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class BlogController {

    private PostRepository postRepository;

    public BlogController(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @RequestMapping("/")
    public String listPosts(ModelMap modelMap){

       List<Post> post = this.postRepository.getAllPosts();
        //modelMap.put("title", "Blog Post 1");
        //modelMap.putAll("posts",post);
        modelMap.put("posts", post);
        return "home";
    }

    @RequestMapping("/post/{id}")
    public String postDetails(@PathVariable Long id, ModelMap modelMap){
        Post post = this.postRepository.findById(id);
        modelMap.put("post", post);
        return "post-details";
    }
}
