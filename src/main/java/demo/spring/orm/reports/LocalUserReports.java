package demo.spring.orm.reports;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.util.ResourceUtils;
import demo.spring.orm.userEntity.LocalUser;
import demo.spring.orm.userService.UserService;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

public class LocalUserReports {

	public String generateReport(UserService userService,String reportFormat) throws FileNotFoundException, JRException {
        //....................................................................................
		List<LocalUser> localUsers=userService.list();
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(localUsers);
        Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("ItemDataSource", dataSource);
        
        File file=ResourceUtils.getFile("classpath:localUser.jrxml");  
        JasperReport jasperReport=JasperCompileManager.compileReport(file.getAbsolutePath()); 
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, new JREmptyDataSource());

        JasperExportManager.exportReportToPdfFile(jasperPrint, "report.pdf");
        System.out.println("File Generated");
        return "Report Generated...";
        //...................................................................................
	}
}
