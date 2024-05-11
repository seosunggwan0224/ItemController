package com.apple.shop;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDateTime;

@Controller
public class BasicControoler {
    @GetMapping("/")
    String hello(){
        return "index.html";
    }

    @GetMapping("/about")
    @ResponseBody
    String about(){
        return "피싱사이트에요";
    }

    @GetMapping("/mypage")
    @ResponseBody
    String mypage(){
        return "마이페이지 입니다.";
    }


    @GetMapping("/date")
    @ResponseBody
    String date(){
        //현재 날짜와 시간 가져오기
        LocalDateTime time = LocalDateTime.now();
        // LocalDateTime 객체를 문자열로 변환하여 반환
        return time.toString();
    }


}
