package com.java.untitled.services.impl;

import com.java.untitled.data.entity.Olympiad;
import com.java.untitled.data.repository.OlympiadRepository;
import com.java.untitled.dto.OlympiadDTO;
import com.java.untitled.services.OlympiadService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class OlympiadServiceImpl implements OlympiadService {
    private final OlympiadRepository olympiadRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<OlympiadDTO> get() {
        return olympiadRepository.findAll().stream()
                .map(this::convertToOlympiadDto)
                .collect(Collectors.toList());
    }

    @Override
    public OlympiadDTO get(long id) {
        return modelMapper.map(olympiadRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid olympiad id:" + id)), OlympiadDTO.class);
    }

    @Override
    public Olympiad create(OlympiadDTO olympiadDTO) {
        return olympiadRepository.save(modelMapper.map(olympiadDTO, Olympiad.class));
    }

    @Override
    public Olympiad update(long id, OlympiadDTO olympiadDTO) {
        Olympiad olympiad = modelMapper.map(olympiadDTO, Olympiad.class);
        olympiad.setId(id);
        return olympiadRepository.save(olympiad);
    }

    @Override
    public void delete(long id) {
        olympiadRepository.deleteById(id);
    }

    private OlympiadDTO convertToOlympiadDto(Olympiad olympiad) {
        return modelMapper.map(olympiad, OlympiadDTO.class);
    }
}
