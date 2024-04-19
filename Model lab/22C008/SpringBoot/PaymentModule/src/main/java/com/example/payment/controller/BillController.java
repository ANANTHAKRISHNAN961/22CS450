package com.example.payment.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.Model;
import com.example.payment.entity.Bill;
import com.example.payment.service.BillService;

@Controller
public class BillController {
    private final BillService billService;

    public BillController(BillService billService) {
        this.billService = billService;
    }

    @GetMapping("/bills")
    public String listBills(Model model) {
        model.addAttribute("bills", billService.getAllBills());
        return "bills";
    }

    @GetMapping("/bills/new")
    public String createBillForm(Model model) {
        Bill bill = new Bill();
        model.addAttribute("bill", bill);
        return "create";
    }

    @PostMapping("/bills")
    public String saveBill(@ModelAttribute("bill") Bill bill) {
        billService.saveBill(bill);
        return "redirect:/bills";
    }

    @GetMapping("/bills/edit/{id}")
    public String editBillForm(@PathVariable Long id, Model model) {
        model.addAttribute("bill", billService.getBill(id));
        return "edit_bill";
    }

    @PostMapping("/bills/update/{id}")
    public String updateBill(@PathVariable Long id, @ModelAttribute("bill") Bill bill) {
        Bill existingBill = billService.getBill(id);
        existingBill.setBillName(bill.getBillName());
        existingBill.setCustomerName(bill.getCustomerName());
        existingBill.setAmount(bill.getAmount());
        billService.updateBill(existingBill);
        return "redirect:/bills";
    }

    @GetMapping("/bills/delete/{id}")
    public String deleteBill(@PathVariable Long id) {
        billService.deleteBillById(id);
        return "redirect:/bills";
    }
}
