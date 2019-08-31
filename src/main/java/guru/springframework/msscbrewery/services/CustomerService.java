package guru.springframework.msscbrewery.services;



import guru.springframework.msscbrewery.web.model.BeerDTO;
import guru.springframework.msscbrewery.web.model.CustomerDTO;

import java.util.UUID;

public interface CustomerService {
    CustomerDTO getCustomerById(UUID customerId);

    CustomerDTO saveCustomer(CustomerDTO customerDTO);

    void updateCustomerByID(UUID customerId, CustomerDTO customerDTO);

    void deleteCustomerbyId(UUID customerId);
}
