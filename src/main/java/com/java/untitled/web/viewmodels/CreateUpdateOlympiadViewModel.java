package com.java.untitled.web.viewmodels;

import com.java.untitled.data.entity.Country;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Getter
@Setter
public class CreateUpdateOlympiadViewModel {
    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date;

    private Country host;

    @NotBlank
    @Size(min = 5, max = 15, message = "City must be between 5 and 15 characters long!")
    private String city;

    @NotNull
    private Integer contestants;

    @NotNull
    private Integer countries;
}
