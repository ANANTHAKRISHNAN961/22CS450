package com.Project.SpringAngular.CustomerController;

import com.Project.SpringAngular.DTO.CustomerDTO;
import com.Project.SpringAngular.DTO.CustomerSaveDTO;
import com.Project.SpringAngular.DTO.CustomerUpdateDTO;
import com.Project.SpringAngular.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin //3rd party agencies
@RequestMapping("api/v1/customer") //path for api-working
public class CustomerController {

    @Autowired //request work :
    private CustomerService customerService;

    @PostMapping(path = "/save")
    public String saveCustomer(@RequestBody CustomerSaveDTO customerSaveDTO){
        String id = customerService.addCustomer(customerSaveDTO);
        return id;
    }
    @GetMapping(path = "/getAllCustomer")
    public List<CustomerDTO> getAllCustomer(){
        List<CustomerDTO> allCustomers = customerService.getAllCustomer();
        return allCustomers;
    }
    @PostMapping(path = "/update")
    public String updatesaveCustomer(@RequestBody CustomerUpdateDTO customerUpdateDTO){
        String id = customerService.updateCustomers(customerUpdateDTO);
        return id;
    }
    @DeleteMapping(path = "/deletecustomer/{id}")
    public String deleteCustomer(@PathVariable(value = "id") int id){
        boolean deletecustomer = customerService.deletecustomer(id);
        return "deleted";
    }
}
