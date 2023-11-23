package spring.dictionary.configs;

import liquibase.integration.spring.SpringLiquibase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;


import javax.sql.DataSource;

@Configuration
@PropertySource("classpath:db/changelog/changelog.yaml")
public class LiquibaseConfig {


    @Bean
    public SpringLiquibase liquibase(DataSource dataSource)  {
        SpringLiquibase liquibase = new SpringLiquibase();
        liquibase.setDataSource(dataSource);
        liquibase.setChangeLog("classpath:db/changelog/changelog.yaml");

        return liquibase;
    }
}