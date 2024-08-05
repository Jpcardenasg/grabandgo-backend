package com.grabandgo.grabandgo_backend.branch.application;

import java.util.List;

import com.grabandgo.grabandgo_backend.branch.domain.Branch;

public interface BranchService {

    Branch saveBranch(Branch branch);

    Branch updateBranch(Long id, Branch branch);

    void deleteBranch(Long id);

    List<Branch> findAll();

    Branch findByName(String name);
}