package com.acsele.report;

import com.acsele.report.command.PrintHTML;
import com.acsele.report.command.PrintPDF;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;
import java.util.Collection;
import java.util.Map;

public class GenerarJasper {

    public void generarJasper(String reportName, Map<String, Object> parameters, Collection<?> beanCollection, HttpServletResponse httpResponse) throws Exception {

        //compile jrxml template and get report
        InputStream stream = getClass().getResourceAsStream(reportName);
        JasperReport report = JasperCompileManager.compileReport(stream);

        //data source
        JRDataSource dataSource = new JRBeanCollectionDataSource(beanCollection);
        JasperPrint jasperPrint = JasperFillManager.fillReport(report, parameters, dataSource);

        AcselePrint pintReport = null;
        switch ((String) parameters.get("format")) {
            case "xls":
                break;
            case "html":
                pintReport = new PrintHTML(jasperPrint, httpResponse);
                break;
            case "pdf":
            default:
                pintReport = new PrintPDF(jasperPrint, httpResponse);
                break;

        }

        Invoker invoker = new Invoker();
        invoker.ejecutarReporte(pintReport);
    }
}
