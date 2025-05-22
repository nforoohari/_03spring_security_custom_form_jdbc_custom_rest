package ir.digixo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class RstController {

    @GetMapping("/home")
    public String home() {
        return "home";
    }

    @GetMapping("/system")
    public String system() {
        return "system";
    }

    @GetMapping("/config")
    public String config() {
        return "config";
    }

}
