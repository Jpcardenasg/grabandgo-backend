package com.grabandgo.grabandgo_backend.branch.application;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grabandgo.grabandgo_backend.branch.domain.Branch;
import com.grabandgo.grabandgo_backend.branch.infrastructure.adapter.out.BranchRepository;

/**
 * BranchServiceImp
 */
@Service
public class BranchServiceImp implements BranchService {

    @Autowired
    private BranchRepository branchRepository;

    @Override
    public void deleteBranch(Long id) {
        branchRepository.deleteById(id);
    }

    @Override
    public List<Branch> findAll() {
        return branchRepository.findAll();
    }

    @Override
    public Branch saveBranch(Branch branch) {
        return branchRepository.save(branch);
    }

    @Override
    public Branch updateBranch(Long id, Branch branch) {
        if (branchRepository.existsById(id)) {
            branch.setId(id);
            return branchRepository.save(branch);
        } else {
            throw new RuntimeException("branch not found with id: " + id);
        }
    }

}