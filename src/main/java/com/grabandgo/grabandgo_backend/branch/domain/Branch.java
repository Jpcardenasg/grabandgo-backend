package com.grabandgo.grabandgo_backend.branch.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Branch {

    @Id
    private Long id;
    private String direction;

    @ManyToOne
    private Long nit;
    @ManyToOne
    private Long cityId;

    public Branch() {
    }

    public Branch(Long id, String direction, Long nit, Long cityId) {
        this.id = id;
        this.direction = direction;
        this.nit = nit;
        this.cityId = cityId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public Long getNit() {
        return nit;
    }

    public void setNit(Long nit) {
        this.nit = nit;
    }

    public Long getCityId() {
        return cityId;
    }

    public void setCityId(Long cityId) {
        this.cityId = cityId;
    }

    @Override
    public String toString() {
        return "Branch [id=" + id + ", direction=" + direction + ", nit=" + nit + ", cityId=" + cityId + "]";
    }

}