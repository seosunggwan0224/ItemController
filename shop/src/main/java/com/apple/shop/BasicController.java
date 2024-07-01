package com.apple.shop;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Controller
public class BasicController {
    @GetMapping("/")
    String hello() {
        return "index.html";
    }

    @GetMapping("/about")
    @ResponseBody
    String about() {
        return "피싱사이트에요.";
    }

    @GetMapping("/mypage")
    @ResponseBody
    String mypage() {
        return "<h4>서성관의 마이페이지</h4>서성관의 마이페이지";
    }

    @GetMapping("/date")
    @ResponseBody
    String date() {
        // 오늘 날짜 가져오기
        LocalDate today = LocalDate.now();

        // 원하는 형식으로 날짜 포맷터 생성
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        // 날짜를 포맷하여 문자열로 변환
        String formattedDate = today.format(formatter);

        return "오늘 날짜: " + formattedDate;
    }

}