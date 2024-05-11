package com.apple.shop;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class ItemController {

    private final ItemRepository itemRepository;
    private final AlertRepository alertRepository;

    @GetMapping("/list")
    String list(Model model) {
        List<Item> result = itemRepository.findAll();
        System.out.println(result.get(0).price);
        System.out.println(result.get(0).title);
//        List<Object> a = new ArrayList<>();

        model.addAttribute("items", result);


        var a = new Item();
        System.out.println(a.title);
        System.out.println(a.toString());

        return "list.html";
    }
}