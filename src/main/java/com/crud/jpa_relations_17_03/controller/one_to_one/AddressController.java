package com.crud.jpa_relations_17_03.controller.one_to_one;

import com.crud.jpa_relations_17_03.entity.one_to_one.Address;
import com.crud.jpa_relations_17_03.service.one_to_one.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/addresses")
public class AddressController {

    @Autowired
    private AddressService addressService;

    @PostMapping("/create")
    public ResponseEntity<Address> createAddress(@RequestBody Address address) {

        Address savedAddress = addressService.saveAddress(address);
        return ResponseEntity.ok(savedAddress);

    }

    @GetMapping("/select-by-id/{id}")
    public ResponseEntity<Address> selectAddressById(@PathVariable Long id) {

        Optional<Address> optionalAddress = addressService.findAddressById(id);

        if (optionalAddress.isPresent()) {
            return ResponseEntity.ok(optionalAddress.get());
        }

        return ResponseEntity.notFound().build();

    }

    @GetMapping("/select-all")
    public ResponseEntity<List<Address>> selectAllAddresses() {

        List<Address> addressList = addressService.findAllAddresses();
        return ResponseEntity.ok(addressList);

    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Address> updateAddress(@PathVariable Long id, @RequestBody Address address) {

        Optional<Address> optionalAddress = addressService.updateAddress(id, address);

        if (optionalAddress.isPresent()) {
            return ResponseEntity.ok(optionalAddress.get());
        }

        return ResponseEntity.notFound().build();

    }

    @DeleteMapping("/delete-by-id/{id}")
    public ResponseEntity<Address> deleteAddressById(@RequestBody Long id) {

        Optional<Address> optionalAddress = addressService.deleteAddressById(id);

        if (optionalAddress.isPresent()) {
            return ResponseEntity.ok(optionalAddress.get());
        }

        return ResponseEntity.notFound().build();

    }
}
