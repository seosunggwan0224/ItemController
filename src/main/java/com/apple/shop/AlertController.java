package com.apple.shop;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class AlertController {

    private final AlertRepository alertRepository;

    @GetMapping("/list")
    String list(Model model) {

        List<Alert> result2 = alertRepository.findAll();
        System.out.println(result2.get(0).date);

        return "list.html";
    }
}
