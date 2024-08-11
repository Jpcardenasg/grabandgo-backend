package com.grabandgo.grabandgo_backend.city.domain.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * CityDTO
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CityDTO {

    private Long id;
    private String name;
    private Long regionId;
}