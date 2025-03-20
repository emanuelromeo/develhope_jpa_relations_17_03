package com.crud.jpa_relations_17_03.service.one_to_one;

import com.crud.jpa_relations_17_03.entity.one_to_one.Address;
import com.crud.jpa_relations_17_03.repository.one_to_one.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddressService {

    @Autowired
    private AddressRepository addressRepository;

    public Address saveAddress(Address address) {
        return addressRepository.save(address);
    }

    public Optional<Address> findAddressById(Long id) {
        return addressRepository.findById(id);
    }

    public List<Address> findAllAddresses() {
        return addressRepository.findAll();
    }

    public Optional<Address> updateAddress(Long id, Address address) {
        Optional<Address> optionalAddress = addressRepository.findById(id);

        if (optionalAddress.isPresent()) {
            optionalAddress.get().setStreet(address.getStreet());
            optionalAddress.get().setCity(address.getCity());

            Address updatedAddress = addressRepository.save(optionalAddress.get());
            return Optional.of(updatedAddress);
        }

        return Optional.empty();
    }

    public Optional<Address> deleteAddressById(Long id) {
        Optional<Address> optionalAddress = addressRepository.findById(id);

        if (optionalAddress.isPresent()) {
            optionalAddress.get().setDeleted(true);

            Address deletedAddress = addressRepository.save(optionalAddress.get());
            return Optional.of(deletedAddress);
        }

        return Optional.empty();
    }
}
