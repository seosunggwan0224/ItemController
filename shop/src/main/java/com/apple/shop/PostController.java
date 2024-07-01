package com.apple.shop;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class PostController {
    private final PostRepository postRepository;//itemRepository()에는 new ItemRepository() 들어있음.

    @GetMapping("/post")
        // 매핑
    String list(Model model) {

        List<Post> result4 = postRepository.findAll();
        model.addAttribute("posts", result4);
        var a = new Item();
        System.out.println(a.toString());
        return "post.html";
    }
}