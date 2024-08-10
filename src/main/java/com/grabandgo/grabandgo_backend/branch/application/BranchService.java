package com.grabandgo.grabandgo_backend.branch.application;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ProblemDetail;

import com.grabandgo.grabandgo_backend.branch.domain.Branch;

public interface BranchService {

    Branch saveBranch(Branch branch);

    Branch updateBranch(Long id, Branch branch);

    void deleteBranch(Long id);

    List<Branch> findAll();

    Optional<Branch> findById(Long id);

}