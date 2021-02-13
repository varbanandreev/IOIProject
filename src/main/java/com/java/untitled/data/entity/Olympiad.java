package com.java.untitled.data.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "olympiad")
public class Olympiad extends BaseEntity {
    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date;

    @ManyToOne
    @JoinColumn(name = "country_id")
    private Country host;

    @NotBlank
    @Size(min = 5, max = 15, message = "City must be between 5 and 15 characters long!")
    private String city;

    @NotNull
    private Integer contestants;

    @NotNull
    private Integer countries;

    @OneToMany(mappedBy = "olympiad")
    @JsonIgnoreProperties("olympiad")
    private List<Result> results;
}
