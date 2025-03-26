package com.manlio.backend.carapp.backend_carapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {
    @GetMapping("/test")
    public String test(Model model) {
        model.addAttribute("nombre", "Manlio");
        return "test"; // Carga templates/test.html
    }
}
