package com.acsele.report.command;

import com.acsele.report.AcselePrint;
import net.sf.jasperreports.engine.DefaultJasperReportsContext;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.export.HtmlExporter;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleHtmlExporterOutput;

import javax.servlet.http.HttpServletResponse;

public class PrintHTML implements AcselePrint {
    private JasperPrint jasperPrint;
    HttpServletResponse response;

    public PrintHTML(JasperPrint jasperPrint, HttpServletResponse response) {
        this.jasperPrint = jasperPrint;
        this.response = response;
    }

    @Override
    public void print() throws Exception {
        response.setContentType("text/html");
        HtmlExporter exporter = new HtmlExporter(DefaultJasperReportsContext.getInstance());
        exporter.setExporterInput(new SimpleExporterInput(jasperPrint));
        exporter.setExporterOutput(new SimpleHtmlExporterOutput(response.getWriter()));
        exporter.exportReport();
    }
}
