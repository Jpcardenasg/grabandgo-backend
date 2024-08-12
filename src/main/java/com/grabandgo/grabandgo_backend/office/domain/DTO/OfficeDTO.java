package com.grabandgo.grabandgo_backend.office.domain.DTO;

import java.util.List;

import com.grabandgo.grabandgo_backend.employee.domain.Employee;
import com.grabandgo.grabandgo_backend.office.domain.Office;
import lombok.Data;

/**
 * OfficeDTO
 */
@Data
public class OfficeDTO {

    private Long id;
    private String postalCode;
    private String address1;
    private String address2;
    private List<Employee> employees;
    private Long city_id;

    public OfficeDTO(Office off) {
        id = off.getId();
        postalCode = off.getPostalCode();
        address1 = off.getAddress1();
        address2 = off.getAddress2();
        employees = off.getEmployees();
        city_id = off.getCity().getId();
    }
}