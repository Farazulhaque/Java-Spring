package com.eazybytes.accounts.repository;

import com.eazybytes.accounts.entity.Accounts;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountsRepository extends JpaRepository<Accounts, Long> {

    /**
     * Retrieves an account by the customer ID.
     *
     * @param customerId The customer ID to search for.
     * @return An Optional containing the account if found, or an empty Optional otherwise.
     */
    Optional<Accounts> findByCustomerId(Long customerId);

    /**
     * Deletes an account by the customer ID.
     *
     * @param customerId The customer ID to search for.
     */
    @Transactional
    @Modifying
    void deleteByCustomerId(Long customerId);

}