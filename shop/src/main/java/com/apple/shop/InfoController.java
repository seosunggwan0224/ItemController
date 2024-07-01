package com.apple.shop;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class InfoController {

    private final InfoRepository infoRepository;

    @GetMapping("/Info")
    String Info(Model model) {
        List<Info> result4 = infoRepository.findAll();
        model.addAttribute("Info", result4);

        var a = new Info();

        a.setName("홍길동");
        a.setAge(60);
        a.setAge2(12);
        a.plusAge(13);

        System.out.println(a.getAge());
        System.out.println(a.getName());

        return "info.html";
    }
}
