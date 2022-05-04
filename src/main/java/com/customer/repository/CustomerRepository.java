package com.customer.repository;

import com.customer.model.Customer;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    Customer save(Customer customer);

    @Query(value = "SELECT * FROM customer WHERE is_active=TRUE", nativeQuery = true)
    List<Customer> findActiveCustomers();

    @Query(value = "SELECT * FROM customer WHERE is_active=TRUE AND id = ?1", nativeQuery = true)
    Optional<Customer> findById(Long id);

    @Transactional
    @Modifying
    @Query(value = "UPDATE customer SET is_active = FALSE WHERE id = ?1", nativeQuery = true)
    void removeById(Long id);
}
