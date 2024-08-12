package com.grabandgo.grabandgo_backend.branch.domain.DTO;

import com.grabandgo.grabandgo_backend.branch.domain.Branch;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * BranchDTO
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BranchDTO {

    private Long id;
    private String direction;
    private String supplier_id;
    private Long city_id;

}