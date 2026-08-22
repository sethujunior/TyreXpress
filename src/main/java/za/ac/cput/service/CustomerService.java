package za.ac.cput.service;

import org.springframework.stereotype.Service;
import za.ac.cput.domain.*;
import za.ac.cput.repository.*;
import java.util.*;

@Service
public class CustomerService implements ICustomerService{

    private ICustomerRepository repository;
    private IAddressRepository addressRepository;
    private IUserRepository userRepository;

    public CustomerService(ICustomerRepository repository, IAddressRepository addressRepository, IUserRepository userRepository) {
        this.repository = repository;
        this.addressRepository = addressRepository;
        this.userRepository = userRepository;
    }

    @Override
    public Customer create(Customer customer) {
        User user = userRepository.findById(customer.getUser().getUserId())
                .orElseThrow(()-> new RuntimeException("User not found"));
        Address address = addressRepository.findById(customer.getAddress().getAddressId()   )
                .orElseThrow(()-> new RuntimeException("Address not found"));
        Customer newCustomer = new Customer.Builder()
                .copy(customer)
                .setUser(user)
                .setaddress(address)
                .build();

        return repository.save(newCustomer);

    }

    @Override
    public Customer read(Long customerId) {
        return repository.findById(customerId).orElse(null);
    }

    @Override
    public Customer update(Customer customer) {
        return repository.save(customer);
    }

    @Override
    public boolean delete(Long customerId) {
        if (repository.existsById(customerId)){
            repository.deleteById(customerId);
            return true;
        }
        return false;
    }

    @Override
    public List<Customer> getAll() {
        return repository.findAll();
    }
}
