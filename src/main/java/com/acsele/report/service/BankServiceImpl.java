package com.acsele.report.service;

import com.acsele.report.entity.Bank;
import com.acsele.report.entity.PrimaPoliza;
import com.acsele.report.repository.BankRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedHashMap;
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
