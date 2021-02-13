package com.java.untitled.web.controllers;

import com.java.untitled.data.entity.Medal;
import com.java.untitled.dto.CountryDTO;
import com.java.untitled.services.CountryService;
import com.java.untitled.web.viewmodels.CreateUpdateCountryViewModel;
import com.java.untitled.web.viewmodels.CountryViewModel;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@AllArgsConstructor
@RequestMapping("/countries")
public class CountryController {
    private final CountryService countryService;
    private final ModelMapper modelMapper;

    @GetMapping
    public String getCountries(Model model) {
        final List<CountryViewModel> countries = countryService.get()
                .stream()
                .map(this::convertToCountryViewModel)
                .collect(Collectors.toList());
        model.addAttribute("countries", countries);
        return "/countries/countries";
    }

    @GetMapping("/create-country")
    public String createCountryForm(Model model) {
        model.addAttribute("country", new CreateUpdateCountryViewModel());
        return "/countries/create-country";
    }

    @PostMapping("/create")
    public String createCountry(@Valid @ModelAttribute("country") CreateUpdateCountryViewModel country,
                               BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "/countries/create-country";
        }
        countryService.create(modelMapper.map(country, CountryDTO.class));
        return "redirect:/countries";
    }

    @GetMapping("/edit-country/{id}")
    public String editCountryForm(Model model, @PathVariable Long id) {
        model.addAttribute("country", modelMapper.map(countryService.get(id),
                CreateUpdateCountryViewModel.class));
        return "/countries/edit-country";
    }

    @PostMapping("/update/{id}")
    public String updateCountry(@PathVariable long id, @Valid @ModelAttribute("country") CreateUpdateCountryViewModel country,
                               BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "/countries/edit-country";
        }
        countryService.update(id, modelMapper.map(country, CountryDTO.class));
        return "redirect:/countries";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id) {
        countryService.delete(id);
        return "redirect:/countries";
    }

    private CountryViewModel convertToCountryViewModel(CountryDTO countryDTO) {
        return modelMapper.map(countryDTO, CountryViewModel.class);
    }
}
