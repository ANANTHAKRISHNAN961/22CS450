package com.example.payment.service;

import java.util.List;

import com.example.payment.entity.Bill;

public interface BillService {
    List<Bill> getAllBills();
    
    Bill saveBill(Bill bill);
    
    Bill updateBill(Bill bill);
    
    Bill getBill(Long id); // Corrected method name
    
    void deleteBillById(Long id);
}
