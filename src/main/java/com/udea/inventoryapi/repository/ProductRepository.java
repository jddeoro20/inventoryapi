package com.udea.inventoryapi.repository;

import com.udea.inventoryapi.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}