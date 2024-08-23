package com.grabandgo.grabandgo_backend.customer.application;

import java.util.List;
import java.util.Optional;

import com.grabandgo.grabandgo_backend.city.application.CityService;
import com.grabandgo.grabandgo_backend.city.domain.City;
import com.grabandgo.grabandgo_backend.city.domain.DTO.CityDTO;
import com.grabandgo.grabandgo_backend.customer.domain.Customer;
import com.grabandgo.grabandgo_backend.customer.domain.DTO.CustomerDTO;
import com.grabandgo.grabandgo_backend.customer.domain.DTO.CustomerRegistrationDTO;
import com.grabandgo.grabandgo_backend.customer.infrastructure.adapter.out.CustomerRepository;
import com.grabandgo.grabandgo_backend.phone.application.PhoneService;
import com.grabandgo.grabandgo_backend.phone.domain.Phone;
import com.grabandgo.grabandgo_backend.user.application.UserService;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;
    private final CityService cityService;
    private final PhoneService phoneService;
    private final UserService userService;

    public CustomerServiceImpl(CustomerRepository customerRepository, CityService cityService, PhoneService phoneService, UserService userService) {
        this.customerRepository = customerRepository;
        this.cityService = cityService;
        this.phoneService = phoneService;
        this.userService = userService;
    }

    @Transactional
    @Override
    public void saveCustomer(CustomerRegistrationDTO customerDTO) {
        Customer customer = toEntity(customerDTO);
        customerRepository.save(customer);
    }

    @Transactional
    @Override
    public void updateCustomer(String id, CustomerRegistrationDTO customerDTO) {
        if (customerRepository.existsById(id)) {
            Customer customer = toEntity(customerDTO);
            customer.setId(id);
            customerRepository.save(customer);
        } else {
            throw new RuntimeException("Customer not found with id: " + id);
        }
    }

    @Transactional
    @Override
    public void deleteCustomer(String id) {
        customerRepository.deleteById(id);
    }

    @Transactional
    @Override
    public Optional<CustomerDTO> findCustomerById(String id) {
        return customerRepository.findById(id).map(this::toDTO);
    }

    @Transactional
    @Override
    public List<CustomerDTO> findAllCustomers() {
        return customerRepository.findAll().stream()
                .map(this::toDTO)
                .toList();
    }

    @Override
    public Customer toEntity(CustomerRegistrationDTO customerDTO) {

        Customer customer = new Customer();
        customer.setId(customerDTO.getId());
        customer.setName(customerDTO.getName());
        customer.setLastName(customerDTO.getLastName());
        customer.setAddress(customerDTO.getAddress());
        customer.setPostalCode(customerDTO.getPostalCode());

        CityDTO cityDTO = cityService.findCityById(customerDTO.getCityId()).orElse(null);
        City city = cityService.toEntity(cityDTO);

        customer.setCity(city);
        customer.setUser(userService.toEntity(customerDTO.getUser()));

        return customer;
    }

    @Override
    public CustomerDTO toDTO(Customer customer) {

        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setId(customer.getId());
        customerDTO.setName(customer.getName());
        customerDTO.setLastName(customer.getLastName());
        customerDTO.setAddress(customer.getAddress());
        customerDTO.setPostalCode(customer.getPostalCode());

        City city = customer.getCity();
        customerDTO.setCityId(city.getId());
        customerDTO.setCityName(city.getName());

        Phone phone =


        return customerDTO;
    }

}
