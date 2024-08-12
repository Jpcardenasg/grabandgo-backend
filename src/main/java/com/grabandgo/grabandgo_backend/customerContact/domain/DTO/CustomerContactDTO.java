package com.grabandgo.grabandgo_backend.customerContact.domain.DTO;

import com.grabandgo.grabandgo_backend.customerContact.domain.CustomerContact;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * ContactDTO
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerContactDTO {

    private Long id;
    private String email;
    private String customer_id;
    private Long phone_id;

    public CustomerContactDTO(CustomerContact customerContact) {
        id = customerContact.getId();
        email = customerContact.getEmail();
        customer_id = customerContact.getCustomer().getId();
        phone_id = customerContact.getPhone().getId();
    }
}