package com.rest.crudRest.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rest.crudRest.entities.Customer;

public interface CustomerRepository extends JpaRepository<Customer, UUID>{

}
