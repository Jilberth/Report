package com.acsele.report.service;

import com.acsele.report.jasper.bean.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> findAll();
}
