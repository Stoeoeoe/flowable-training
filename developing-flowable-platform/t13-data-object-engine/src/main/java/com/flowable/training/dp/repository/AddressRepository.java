package com.flowable.training.dp.repository;

import com.flowable.training.dp.dataobject.Address;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Service;

/**
 * Repository that gives us access to the addresses in a convenient way.
 * We use the PagingAndSortingRepository to make it easier for our REST endpoint to create such requests.
 * In a process, we should NOT use this service but instead rely on the DataObjectRuntimeService.
 * If we use this class, the resulting variables will be
 */
@Service
public interface AddressRepository extends PagingAndSortingRepository<Address, String> {

    Page<Address> findByName(String name, Pageable pageable);
    Address findAddressById(String id);
    Address findAddressesByCity(String city);
    Address findAddressesByCityEqualsAndAndFieldName();

    // This is silly, but it shows what you could do.
    Page<Address> findByNameContainingOrStreetContainingOrCityContainingOrZipCodeContainingOrCountryContaining(String name, String street, String city, String zipCode, String country, Pageable pageable);
}
