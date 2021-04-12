package com.ufps.sgd.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;

@Controller
public class LoginControlador {

    @GetMapping
    public String login(Map<String, Object> model) {
        return "index";
    }
}
