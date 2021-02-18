package com.java.untitled.web.viewmodels;

import com.java.untitled.data.entity.Country;
import com.java.untitled.data.entity.Medal;
import com.java.untitled.data.entity.Olympiad;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateResultViewModel {
    private Olympiad olympiad;
    private Country country;
    private String contestantName;
    private Integer olymRank;
    private Medal medal;

}
