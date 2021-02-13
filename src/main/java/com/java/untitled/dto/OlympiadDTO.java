package com.java.untitled.dto;

import com.java.untitled.data.entity.Country;
import com.java.untitled.data.entity.Result;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class OlympiadDTO {
    private long id;
    private Date date;
    private Country host;
    private String city;
    private Integer contestants;
    private Integer countries;
    private List<Result> results;
}
