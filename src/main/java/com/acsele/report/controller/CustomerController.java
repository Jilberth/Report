package com.acsele.report.controller;

import com.acsele.report.GenerarJasper;
import com.acsele.report.entity.Bank;
import com.acsele.report.model.Customer;
import com.acsele.report.service.BankService;
import com.acsele.report.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class CustomerController {

    private BankService bankService;
    private CustomerService customerService;

    @Autowired
    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }

    @Autowired
    public void setBankService(BankService bankService) {
        this.bankService = bankService;
    }

    @GetMapping("/pruebaPDF")
    public void pruebaPrint(Model model, HttpServletRequest httpRequest, HttpServletResponse httpResponse) throws Exception {

        //Obtengo pojo
        List<Customer> itemList = customerService.findAll();

        //fill the report with data source objects
        Map<String, Object> parameters = new HashMap();
        parameters.put("format", "pdf");
        parameters.put("AUTOR", "Jilberth");

        GenerarJasper generar = new GenerarJasper();
        generar.generarJasper("/jasperreport/customer_report.jrxml", parameters, itemList, httpResponse);

    }

    @GetMapping("/pruebaHTML")
    public void pruebaPrintHtml(Model model, HttpServletRequest httpRequest, HttpServletResponse httpResponse) throws Exception {

        //Obtengo pojo
        List<Customer> itemList = customerService.findAll();

        List<Bank> bankList = bankService.findAll();
        bankList.forEach(x -> System.out.println(x.getName()));

        //fill the report with data source objects
        Map<String, Object> parameters = new HashMap();
        parameters.put("format", "html");
        parameters.put("AUTOR", "Jilberth");

        GenerarJasper generar = new GenerarJasper();
        generar.generarJasper("/jasperreport/customer_report.jrxml", parameters, itemList, httpResponse);

    }
}