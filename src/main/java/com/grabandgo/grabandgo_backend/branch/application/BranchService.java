package com.grabandgo.grabandgo_backend.branch.application;

import java.util.List;
import java.util.Optional;

import com.grabandgo.grabandgo_backend.branch.domain.Branch;
import com.grabandgo.grabandgo_backend.branch.domain.DTO.BranchDTO;

public interface BranchService {

    Branch saveBranch(Branch branch);

    Branch updateBranch(Long id, Branch branch);

    void deleteBranch(Long id);

    List<BranchDTO> findAll();

    Optional<BranchDTO> findById(Long id);

}