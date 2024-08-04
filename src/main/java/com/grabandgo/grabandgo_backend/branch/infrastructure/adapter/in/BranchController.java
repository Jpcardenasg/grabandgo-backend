package com.grabandgo.grabandgo_backend.branch.infrastructure.adapter.in;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grabandgo.grabandgo_backend.branch.application.BranchService;
import com.grabandgo.grabandgo_backend.branch.domain.Branch;
    
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

/**
 * BranchAdapter
 */
@RestController
@RequestMapping("/api/branch")
public class BranchController {

    @Autowired
    private BranchService service;

    @PostMapping("/saveBranch")
    public ResponseEntity<Branch> saveBranch(@RequestBody Branch branch) {
        service.saveBranch(branch);
        return ResponseEntity.ok(branch);
    }

    @PutMapping("/updateBranch/{branchId}")
    public ResponseEntity<Branch> updateBranch(@PathVariable Long branchId, @RequestBody Branch branch) {
        service.updateBranch(branchId, branch);
        return ResponseEntity.ok(branch);
    }

    @DeleteMapping("/deleteBranch/{branchId}")
    public ResponseEntity<Long> deleteUser(@PathVariable Long branchId) {
        service.deleteBranch(branchId);
        return ResponseEntity.ok(branchId);
    }

    @GetMapping("/allBranchs")
    public ResponseEntity<List<Branch>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

}