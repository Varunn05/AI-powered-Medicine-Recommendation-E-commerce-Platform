package com.varun.sweets.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.varun.sweets.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{
    List<Product> findAllByCategory_Id(int id);

    Optional<Product> findById(int id);
}
