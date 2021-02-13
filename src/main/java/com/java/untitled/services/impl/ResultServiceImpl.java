package com.java.untitled.services.impl;

import com.java.untitled.data.entity.Result;
import com.java.untitled.data.repository.ResultRepository;
import com.java.untitled.dto.ResultDTO;
import com.java.untitled.services.ResultService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ResultServiceImpl implements ResultService {
    private final ResultRepository resultRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<ResultDTO> get() {
        return resultRepository.findAll().stream()
                .map(this::convertToResultDto)
                .collect(Collectors.toList());
    }

    @Override
    public ResultDTO get(long id) {
        return modelMapper.map(resultRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid result id:" + id)), ResultDTO.class);
    }

    @Override
    public Result create(ResultDTO resultDTO) {
        return resultRepository.save(modelMapper.map(resultDTO, Result.class));
    }

    @Override
    public Result update(long id, ResultDTO resultDTO) {
        Result result = modelMapper.map(resultDTO, Result.class);
        result.setId(id);
        return resultRepository.save(result);
    }

    @Override
    public void delete(long id) {
        resultRepository.deleteById(id);
    }

    private ResultDTO convertToResultDto(Result result) {
        return modelMapper.map(result, ResultDTO.class);
    }
}
