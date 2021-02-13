package com.java.untitled.data.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "result")
public class Result extends BaseEntity {
    @ManyToOne
    @JoinColumn(name = "olympiad_id")
    private Olympiad olympiad;

    @ManyToOne
    @JoinColumn(name = "country_id")
    private Country country;
}
