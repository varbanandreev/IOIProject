package com.java.untitled.web.controllers;

import com.java.untitled.dto.OlympiadDTO;
import com.java.untitled.services.CountryService;
import com.java.untitled.services.OlympiadService;
import com.java.untitled.web.viewmodels.CreateUpdateOlympiadViewModel;
import com.java.untitled.web.viewmodels.OlympiadViewModel;
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
@RequestMapping("/olympiads")
public class OlympiadController {
    private final OlympiadService olympiadService;
    private final CountryService countryService;
    private final ModelMapper modelMapper;

    @GetMapping
    public String getOlympiads(Model model) {
        final List<OlympiadViewModel> olympiads = olympiadService.get()
                .stream()
                .map(this::convertToOlympiadViewModel)
                .collect(Collectors.toList());
        model.addAttribute("olympiads", olympiads);
        return "/olympiads/olympiads";
    }

    @GetMapping("/create-olympiad")
    public String createOlympiadForm(Model model) {
        model.addAttribute("olympiad", new CreateUpdateOlympiadViewModel());
        model.addAttribute("countries", countryService.get());
        return "/olympiads/create-olympiad";
    }

    @PostMapping("/create")
    public String createOlympiad(@Valid @ModelAttribute("olympiad") CreateUpdateOlympiadViewModel olympiad,
                                 BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("countries", countryService.get());
            return "/olympiads/create-olympiad";
        }
        olympiadService.create(modelMapper.map(olympiad, OlympiadDTO.class));
        return "redirect:/olympiads";
    }

    @GetMapping("/edit-olympiad/{id}")
    public String editOlympiadForm(Model model, @PathVariable Long id) {
        model.addAttribute("olympiad", modelMapper.map(olympiadService.get(id),
                CreateUpdateOlympiadViewModel.class));
        model.addAttribute("countries", countryService.get());
        return "/olympiads/edit-olympiad";
    }

    @PostMapping("/update/{id}")
    public String updateOlympiad(@PathVariable long id, @Valid @ModelAttribute("olympiad") CreateUpdateOlympiadViewModel olympiad,
                                 BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("countries", countryService.get());
            return "/olympiads/edit-olympiad";
        }
        olympiadService.update(id, modelMapper.map(olympiad, OlympiadDTO.class));
        return "redirect:/olympiads";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id) {
        olympiadService.delete(id);
        return "redirect:/olympiads";
    }

    private OlympiadViewModel convertToOlympiadViewModel(OlympiadDTO olympiadDTO) {
        return modelMapper.map(olympiadDTO, OlympiadViewModel.class);
    }
}
