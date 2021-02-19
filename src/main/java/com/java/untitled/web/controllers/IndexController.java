package com.java.untitled.web.controllers;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.java.untitled.services.CountryService;
import com.java.untitled.services.OlympiadService;
@Controller
@AllArgsConstructor
@RequestMapping("/")
public class IndexController {

    private final OlympiadService olympiadService;
    private final CountryService countryService;

    @GetMapping
    public String getIndex(Model model) {
        final String welcomeMessage = "Welcome to the IOI Statistics System!";
        model.addAttribute("welcome", welcomeMessage);
        model.addAttribute("countries", countryService.get());
        model.addAttribute("olympiads", olympiadService.get());
        return "index";
    }
}
