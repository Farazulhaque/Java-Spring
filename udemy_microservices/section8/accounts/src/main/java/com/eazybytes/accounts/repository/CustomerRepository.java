package com.eazybytes.accounts.repository;

import com.eazybytes.accounts.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    /**
     * Retrieves a customer by the mobile number.
     *
     * @param mobileNumber The mobile number to search for.
     * @return An Optional containing the customer if found, or an empty Optional otherwise.
     */
    Optional<Customer> findByMobileNumber(String mobileNumber);


}