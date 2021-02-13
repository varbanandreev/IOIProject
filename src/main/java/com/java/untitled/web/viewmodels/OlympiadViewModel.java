package com.java.untitled.web.viewmodels;

import com.java.untitled.data.entity.Country;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class OlympiadViewModel {
    private long id;
    private Date date;
    private Country host;
    private String city;
    private Integer contestants;
    private Integer countries;
}
