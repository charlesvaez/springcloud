package com.hgsoft.springcloud.servicestreamtest.controller;

import com.hgsoft.springcloud.servicestreamtest.entity.Greetings;
import com.hgsoft.springcloud.servicestreamtest.service.GreetingsService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingsController {
    private final GreetingsService greetingsService;

    public GreetingsController(GreetingsService greetingsService) {
        this.greetingsService = greetingsService;
    }
    @GetMapping("/greetings")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void greetings(@RequestParam("message") String message) {
        Greetings greetings = new Greetings();
        greetings.setMessage(message);
        greetings.setTimestamp(System.currentTimeMillis());

        greetingsService.sendGreeting(greetings);
    }
}

