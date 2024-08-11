package com.grabandgo.grabandgo_backend.country.domain.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * CountryDTO
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CountryDTO {

    private Long id;
    private String name;

}