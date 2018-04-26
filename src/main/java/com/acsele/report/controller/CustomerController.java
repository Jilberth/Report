package com.acsele.report.controller;

import com.acsele.report.GenerarJasper;
import com.acsele.report.entity.Bank;
import com.acsele.report.jasper.bean.Customer;
import com.acsele.report.service.BankService;
import com.acsele.report.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Controller
public class CustomerController {

    private BankService bankService;
    private CustomerService customerService;
    public static final String REST_SERVICE_URI = "http://localhost:8080/consultas/";

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

    @GetMapping("/pruebaHTMLPrimaPoliza")
    private static void listAllUsers(Model model, HttpServletRequest httpRequest, HttpServletResponse httpResponse) throws Exception{
        System.out.println("Testing listAllUsers API-----------");

        RestTemplate restTemplate = new RestTemplate();
        List<LinkedHashMap<String, Object>> usersMap = restTemplate.getForObject(REST_SERVICE_URI, List.class);

        if(usersMap!=null){
            for(LinkedHashMap<String, Object> map : usersMap){
                System.out.println("Report : codBank="+map.get("codBank")+", Name="+map.get("name")+", telephone="+map.get("telephone")+", address="+map.get("address"));;
            }
        }else{
            System.out.println("No user exist----------");
        }
    }


}