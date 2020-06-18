package com.flowable.training.dp.rest;

import java.util.List;

import com.flowable.training.dp.repository.AddressRepository;
import org.apache.commons.lang3.StringUtils;
import org.flowable.common.rest.api.DataResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.flowable.training.dp.dataobject.Address;

@RestController
public class AddressResource {

    private final AddressRepository addressRepository;

    public AddressResource(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    /**
     * Gets a single address by its ID.
     * @param addressId The ID of the address.
     * @return A single address with the given ID or null if there is no such address.
     */
    @GetMapping(value = "/api/addresses/{addressId}", produces = "application/json")
    public Address getAddressById(@PathVariable String addressId) {
        return addressRepository.findAddressById(addressId);
    }

    /**
     * Performs a sort of "full-text search" on all relevant fields.
     * This is a rather crude implementation and could probably be improved upon.
     * @return A list of addresses that contain the search text in a text field
     */
        @GetMapping(value = "/api/addresses", produces = "application/json")
    public DataResponse<Address> findAddresses(
            @RequestParam(required = false) String searchText,
            @RequestParam(required = false, defaultValue = "0") int start,
            @RequestParam(required = false, defaultValue = "20") int size,
            @RequestParam(required = false, defaultValue = "asc") String order,
            @RequestParam(required = false, defaultValue = "name") String sort

    ) {
        Pageable pageable = PageRequest.of(start, size, Sort.Direction.fromString(order), sort);

        long total = addressRepository.count();
        Page<Address> addresses;
        if(StringUtils.isEmpty(searchText)) {
            addresses = addressRepository.findAll(pageable);
        } else {
            addresses = addressRepository.findByNameContainingOrStreetContainingOrCityContainingOrZipCodeContainingOrCountryContaining(searchText, searchText, searchText, searchText, searchText, pageable);
        }

        DataResponse<Address> dataResponse = new DataResponse<>();
        dataResponse.setData(addresses.toList());
        dataResponse.setSize(size);
        dataResponse.setStart(start);
        dataResponse.setTotal(total);
        dataResponse.setOrder("asc");
        return dataResponse;
    }

}
