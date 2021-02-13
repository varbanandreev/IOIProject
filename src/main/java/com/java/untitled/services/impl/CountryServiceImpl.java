package com.java.untitled.services.impl;

import com.java.untitled.data.entity.Country;
import com.java.untitled.data.repository.CountryRepository;
import com.java.untitled.dto.CountryDTO;
import com.java.untitled.services.CountryService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CountryServiceImpl implements CountryService {
    private final CountryRepository countryRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<CountryDTO> get() {
        return countryRepository.findAll().stream()
                .map(this::convertToCountryDto)
                .collect(Collectors.toList());
    }

    @Override
    public CountryDTO get(long id) {
        return modelMapper.map(countryRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid country id:" + id)), CountryDTO.class);
    }

    @Override
    public Country create(CountryDTO countryDTO) {
        return countryRepository.save(modelMapper.map(countryDTO, Country.class));
    }

    @Override
    public Country update(long id, CountryDTO countryDTO) {
        Country country = modelMapper.map(countryDTO, Country.class);
        country.setId(id);
        return countryRepository.save(country);
    }

    @Override
    public void delete(long id) {
        countryRepository.deleteById(id);
    }

    private CountryDTO convertToCountryDto(Country country) {
        return modelMapper.map(country, CountryDTO.class);
    }
}
