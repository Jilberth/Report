package com.acsele.report.service;

import com.acsele.report.jasper.bean.Customer;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {


    @Override
    public List<Customer> findAll() {
        return Arrays.asList(
                new Customer(0, "Laura", "Steel", "429 Seventh Av.", "Dallas"),
                new Customer(1, "Susanne", "King", "366 - 20th Ave.", "Olten")
        );
    }
}
