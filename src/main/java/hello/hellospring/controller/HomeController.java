package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    // index.html 있지만 Controller가 우선순위이기 때문에 home이 호출됨
    @GetMapping("/")
    public String home(){
        return "home";
    }
}
