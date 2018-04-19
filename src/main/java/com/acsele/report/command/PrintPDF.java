package com.acsele.report.command;

import com.acsele.report.AcselePrint;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperPrint;

import javax.servlet.http.HttpServletResponse;

public class PrintPDF implements AcselePrint {
    private JasperPrint jasperPrint;
    HttpServletResponse response;

    public PrintPDF(JasperPrint jasperPrint, HttpServletResponse response) {
        this.jasperPrint = jasperPrint;
        this.response = response;
    }

    @Override
    public void print() throws Exception {
        response.setContentType("application/pdf");
        JasperExportManager.exportReportToPdfStream(jasperPrint, response.getOutputStream());
    }
}
