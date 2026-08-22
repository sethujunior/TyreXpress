package za.ac.cput.service;

import org.springframework.stereotype.Service;
import za.ac.cput.domain.Address;
import za.ac.cput.repository.*;
import java.util.*;

@Service
public class AddressService implements IAddressService{
    private IAddressRepository repository;

    public AddressService(IAddressRepository repository) {
        this.repository = repository;
    }


    @Override
    public Address create(Address address) {
        return repository.save(address);
    }

    @Override
    public Address read(Long addressId) {
        return repository.findById(addressId).orElse(null);
    }

    @Override
    public Address update(Address address) {
        return repository.save(address);
    }

    @Override
    public boolean delete(Long addressId) {
        return repository.existsById(addressId);
    }

    @Override
    public List<Address> getAll() {
        return repository.findAll();
    }
}
