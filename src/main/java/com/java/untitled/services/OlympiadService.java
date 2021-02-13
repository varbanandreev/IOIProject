package com.java.untitled.services;

import com.java.untitled.data.entity.Olympiad;
import com.java.untitled.dto.OlympiadDTO;

import java.util.List;

public interface OlympiadService {
    OlympiadDTO get(long id);

    List<OlympiadDTO> get();

    Olympiad create(OlympiadDTO olympiadDTO);

    Olympiad update(long id, OlympiadDTO olympiadDTO);

    void delete(long id);
}
