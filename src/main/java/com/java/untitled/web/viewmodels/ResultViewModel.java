package com.java.untitled.web.viewmodels;

import com.java.untitled.data.entity.Country;
import com.java.untitled.data.entity.Medal;
import com.java.untitled.data.entity.Olympiad;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ResultViewModel {
    private long id;
    private String contestantName;
    private Country country;
    private Olympiad olympiad;
    private Integer olympiadRank;
    private Medal medal;
}
