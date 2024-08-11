package com.grabandgo.grabandgo_backend.branch.application;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grabandgo.grabandgo_backend.branch.domain.Branch;
import com.grabandgo.grabandgo_backend.branch.infrastructure.adapter.out.BranchRepository;

import jakarta.transaction.Transactional;

/**
 * BranchServiceImpl
 */
@Service
public class BranchServiceImpl implements BranchService {

    @Autowired
    private BranchRepository branchRepository;

    @Transactional
    @Override
    public void deleteBranch(Long id) {
        branchRepository.deleteById(id);
    }

    @Transactional
    @Override
    public List<Branch> findAll() {
        return branchRepository.findAll();
    }

    @Transactional
    @Override
    public Branch saveBranch(Branch branch) {
        return branchRepository.save(branch);
    }

    @Transactional
    @Override
    public Branch updateBranch(Long id, Branch branch) {
        if (branchRepository.existsById(id)) {
            branch.setId(id);
            return branchRepository.save(branch);
        } else {
            throw new RuntimeException("branch not found with id: " + id);
        }
    }

    @Transactional
    @Override
    public Optional<Branch> findById(Long id) {
        return branchRepository.findById(id);
    }

}