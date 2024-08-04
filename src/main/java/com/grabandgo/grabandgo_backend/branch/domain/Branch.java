package com.grabandgo.grabandgo_backend.branch.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Branch {

    @Id
    private Long id;
    private String direction;

    @ManyToOne
    private Long nit;
    @ManyToOne
    private Long cityId;

}