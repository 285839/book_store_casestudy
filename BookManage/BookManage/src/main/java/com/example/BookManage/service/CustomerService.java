package com.example.BookManage.service;

import com.example.BookManage.domain.Customer;
import com.example.BookManage.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    public List<Customer> getAllCustomers(){
        return customerRepository.findAll();
    }
    public Optional<Customer> getCustomerById(Long id){
        return customerRepository.findById(id);
    }
    public Customer addCustomer(Customer customer){
        return customerRepository.save(customer);
    }
    public Customer updateCustomer(Long id,Customer customerDetails){

        Customer customer = customerRepository.getById(id);

        if(customer != null){
            customer.setName(customerDetails.getName());
            customer.setEmail(customerDetails.getEmail());
            return customer;

        }
        throw new RuntimeException();


//        return customerRepository.findById(id)
//                .map(customer -> {
//                    customer.setName(customerDetails.getName());
//                    customer.setEmail(customerDetails.getEmail());
//                    customer.setPhoneNumber(customerDetails.getPhoneNumber());
//                    return customerRepository.save(customer);
//                }
//                );
    }
}
