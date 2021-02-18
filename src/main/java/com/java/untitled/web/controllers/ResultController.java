package com.java.untitled.web.controllers;

import com.java.untitled.dto.OlympiadDTO;
import com.java.untitled.dto.ResultDTO;
import com.java.untitled.services.CountryService;
import com.java.untitled.services.OlympiadService;
import com.java.untitled.services.ResultService;
import com.java.untitled.web.viewmodels.CountryViewModel;
import com.java.untitled.web.viewmodels.CreateResultViewModel;
import com.java.untitled.web.viewmodels.OlympiadViewModel;
import com.java.untitled.web.viewmodels.ResultViewModel;
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
@RequestMapping("/results")
public class ResultController {
    private final ResultService resultService;
    private final OlympiadService olympiadService;
    private final CountryService countryService;
    private final ModelMapper modelMapper;

    @GetMapping
    public String getResults(Model model) {
        return "/results/search";
    }

//    @GetMapping("/olympiad")
//    public String getResultsByPatientName(Model model, @RequestParam String patientName) {
//        final List<ResultViewModel> results = resultService.getResultsByPatientName(patientName)
//                .stream()
//                .map(this::convertToResultViewModel)
//                .collect(Collectors.toList());
//        model.addAttribute("results", results);
//        return "/results/results";
//    }

    @GetMapping("/create-result")
    public String createResultForm(Model model) {

        model.addAttribute("result", new CreateResultViewModel());
        model.addAttribute("olympiads", olympiadService.get());
        model.addAttribute("countries", countryService.get());
        return "/results/create-result";
    }

    @PostMapping("/create")
    public String createResult(@Valid @ModelAttribute("result") CreateResultViewModel result,
                               BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "/results/create-result";
        }
        resultService.create(modelMapper.map(result, ResultDTO.class));
        return "redirect:/results";
    }

    private ResultViewModel convertToResultViewModel(ResultDTO resultDTO) {
        return modelMapper.map(resultDTO, ResultViewModel.class);
    }
}
