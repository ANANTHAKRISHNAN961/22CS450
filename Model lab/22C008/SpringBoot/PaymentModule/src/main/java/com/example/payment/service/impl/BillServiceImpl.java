package com.example.payment.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.payment.entity.Bill;
import com.example.payment.repository.BillRepository;
import com.example.payment.service.BillService;

@Service
public class BillServiceImpl implements BillService {
    
    private BillRepository billRepository;
    
    public BillServiceImpl(BillRepository billRepository) {
        this.billRepository = billRepository;
    }
    
    @Override
    public List<Bill> getAllBills() {
        return billRepository.findAll();
    }
    
    @Override
    public Bill saveBill(Bill bill) {
        return billRepository.save(bill);
    }

    @Override
    public Bill updateBill(Bill bill) {
        return billRepository.save(bill);
    }

    @Override
    public Bill getBill(Long id) { // Corrected method name
        return billRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteBillById(Long id) {
        billRepository.deleteById(id);
    }
}
