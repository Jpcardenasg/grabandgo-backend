package com.grabandgo.grabandgo_backend.branch.infrastructure.adapter.out;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.grabandgo.grabandgo_backend.branch.domain.Branch;;

/**
 * BranchRepository
 */
@Repository
public interface BranchRepository extends JpaRepository<Branch, Long> {

    Branch findByName(String name);

}