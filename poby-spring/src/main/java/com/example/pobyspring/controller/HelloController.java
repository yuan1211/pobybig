package com.example.pobyspring.controller;


import org.springframework.stereotype.Controller; //[1]
import org.springframework.ui.Model; // [2]
import org.springframework.web.bind.annotation.GetMapping; // [3]

@Controller // [1]
public class HelloController {
    @GetMapping("hello") // [3] /hello라는 하이퍼링크가 클릭되면 아래 메서드를 호출 // http의 get 방식과 연관
    public String hello(Model model) { // [2] SpringBoot로부터 MVC 패턴 中 model을 받아와 아래 메서드를 수행한다는 뜻!
        model.addAttribute("key", "spring!!");
        return "hello"; // hello.html 파일로 가서 렌더링 해라. 근데 할 때, 해당 파일의 key 자리에 "hello!!"를 넣어서 리턴해라
    }
}


