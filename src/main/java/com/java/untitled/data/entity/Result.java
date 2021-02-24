package com.java.untitled.data.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "result")
public class Result extends BaseEntity {
    @NotBlank
    private String contestantName;

    @ManyToOne
    @JoinColumn(name = "country_id")
    private Country country;

    @ManyToOne
    @JoinColumn(name = "olympiad_id")
    private Olympiad olympiad;

    @NotNull
    private Integer olympiadRank;

    @Enumerated
    private Medal medal;
}
