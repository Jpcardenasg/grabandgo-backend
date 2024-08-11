package com.grabandgo.grabandgo_backend.user.domain;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.grabandgo.grabandgo_backend.customer.domain.Customer;
import com.grabandgo.grabandgo_backend.employee.domain.Employee;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * User
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "\"user\"", uniqueConstraints = { @UniqueConstraint(columnNames = "username") })
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(nullable = false)
    private String username;
    private String password;
    @Enumerated(EnumType.STRING)
    private Role role;

    @JsonBackReference("employee-user")
    @OneToOne(mappedBy = "user")
    @JoinColumn(name = "employeeId")
    private Employee employee;

    @JsonBackReference("customer-user")
    @OneToOne(mappedBy = "user")
    @JoinColumn(name = "customerId")
    private Customer customer;

    @Transactional
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role.name()));
    }

    @Transactional
    @Override
    public String getPassword() {
        return this.password;
    }

    @Transactional
    @Override
    public String getUsername() {
        return this.username;
    }

    @Transactional
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Transactional
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Transactional
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Transactional
    @Override
    public boolean isEnabled() {
        return true;
    }

}