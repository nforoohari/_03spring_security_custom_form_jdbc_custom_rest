package ir.digixo.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/api/v1")
public class RestController {


    @GetMapping("/home")
    public String home()
    {
        return "home";
    }

    @GetMapping("/config")
    public String config()
    {
        return "config";
    }

    @GetMapping("/system")
    public String system()
    {
        return "system";
    }


}
