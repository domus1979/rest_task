package by.dvn.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "by.dvn.rest_task")
public class ProjectConfiguration {
	
	@Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();

        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUrl("jdbc:postgresql://127.0.0.1:5432/employeedb");
//		dataSource.setUrl("jdbc:postgresql://tran-vmware-pc:5432/employeedb");
        dataSource.setUsername("postgres");
        dataSource.setPassword("1");

        return dataSource;
    }
	
//	@Bean
//	public EmployeeDAO employeeDAO(DataSource dataSourse) {
//		return new EmployeeDAO(dataSourse); 
//	}
}
