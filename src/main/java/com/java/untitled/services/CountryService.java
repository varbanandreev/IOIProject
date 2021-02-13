package com.java.untitled.services;

import com.java.untitled.data.entity.Country;
import com.java.untitled.dto.CountryDTO;

import java.util.List;

public interface CountryService {
    CountryDTO get(long id);

    List<CountryDTO> get();

    Country create(CountryDTO countryDTO);

    Country update(long id, CountryDTO countryDTO);

    void delete(long id);
}
