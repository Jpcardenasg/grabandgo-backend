package com.grabandgo.grabandgo_backend.region.domain.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * RegionDTO
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RegionDTO {

    private Long id;
    private String name;
    private Long countryId;
}