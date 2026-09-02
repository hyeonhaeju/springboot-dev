package dev.hyeon.springbootdeveloper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @GetMapping("/hi")
    public String hi() {
        return "안녕하세요! 에 대한 응답 리턴입니다.";
    }
}