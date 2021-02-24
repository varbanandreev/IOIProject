package com.java.untitled.web.viewmodels;

import com.java.untitled.data.entity.Country;
import com.java.untitled.data.entity.Medal;
import com.java.untitled.data.entity.Olympiad;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class CreateResultViewModel {
    @NotBlank
    private String contestantName;

    @NotNull
    private Integer olympiadRank;

    private Country country;
    private Olympiad olympiad;
    private Medal medal;
}
