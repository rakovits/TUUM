package com.example.tuum;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TuumController {
    @GetMapping("/")
    public String rootPage() {
        return "Midagi töötab.";
    }
}
