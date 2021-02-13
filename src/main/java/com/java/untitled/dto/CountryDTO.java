package com.java.untitled.dto;

import com.java.untitled.data.entity.Result;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class CountryDTO {
    private long id;
    private String name;
    private List<Result> results;
}
