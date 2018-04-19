package com.acsele.report.service;

import com.acsele.report.entity.Bank;
import com.acsele.report.repository.BankRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BankServiceImpl implements BankService {

    private BankRepository repository;

    public BankServiceImpl(BankRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Bank> findAll() {
        List<Bank> bankList = new ArrayList<>();
        repository.findAll().forEach(bankList::add);
        return bankList;
    }
}
