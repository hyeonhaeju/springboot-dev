package dev.hyeon.springbootdeveloper;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;

@RestController
public class QuizController {

    // GET /quiz?code=... 요청이 오면 quiz 메서드 실행
    @GetMapping("/quiz")
    public ResponseEntity<String> quiz(@RequestParam("code") int code) {
        switch (code) {
            case 1:
                return ResponseEntity.status(201).body("Created");
            case 2:
                return ResponseEntity.badRequest().body("Bad request");
            default:
                return ResponseEntity.ok().body("OK");
        }
    }

    // POST /quiz 요청이 오면 quiz2 메서드 실행
    @PostMapping("/quiz")
    public ResponseEntity<String> quiz2(@RequestBody Code code) {
        switch (code.value()) {
            case 1:
                return ResponseEntity.status(403).body("Forbidden");
            default:
                return ResponseEntity.ok().body("OK");
        }
    }
}
record Code(int value) {}