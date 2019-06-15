package com.gl.hystrixDemo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    private NumberService numberService;

    public MainController(NumberService numberService) {
        this.numberService = numberService;
    }

    @GetMapping("/message")
    public String testCall()  {
        return numberService.deriveStringWithNumber();
    }

}
