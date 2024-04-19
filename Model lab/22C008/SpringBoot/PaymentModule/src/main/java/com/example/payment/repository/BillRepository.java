package com.example.payment.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.payment.entity.Bill;

public interface BillRepository extends JpaRepository<Bill, Long> {
    void deleteById(Long id);
}
