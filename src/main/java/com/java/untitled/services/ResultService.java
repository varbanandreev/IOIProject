package com.java.untitled.services;

import com.java.untitled.data.entity.Result;
import com.java.untitled.dto.ResultDTO;

import java.util.List;

public interface ResultService {
    ResultDTO get(long id);

    List<ResultDTO> get();

    Result create(ResultDTO resultDTO);

    Result update(long id, ResultDTO resultDTO);

    List<ResultDTO> getResultsByCountryName(String countryName);

    void delete(long id);
}
