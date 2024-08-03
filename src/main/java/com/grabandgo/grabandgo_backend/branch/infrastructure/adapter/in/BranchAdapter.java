package com.grabandgo.grabandgo_backend.branch.infrastructure.adapter.in;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grabandgo.grabandgo_backend.branch.application.BranchService;

/**
 * BranchAdapter
 */
@RestController
@RequestMapping("/api/branch")
public class BranchAdapter {

    @Autowired
    private BranchService servide;
}