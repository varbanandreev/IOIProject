package com.java.untitled.data.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
@Table(name = "country")
public class Country extends BaseEntity {
    @NotBlank
    @Size(min = 5, max = 25, message = "Name must be between 5 and 25 characters long!")
    private String name;

    @OneToMany(mappedBy = "country")
    @JsonIgnoreProperties("country")
    private List<Result> results;
}
