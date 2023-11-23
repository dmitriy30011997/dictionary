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
    public DataSource dataSource()  {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();

        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUrl("jdbc:postgresql://localhost:5432/dictionary");
        dataSource.setUsername("postgres");
        dataSource.setPassword("inudug95");

        return dataSource;
    }

    @Bean
    public SpringLiquibase liquibase()  {
        SpringLiquibase liquibase = new SpringLiquibase();

        liquibase.setDataSource(dataSource());
        liquibase.setChangeLog("classpath:db/changelog/changelog.yaml");

        return liquibase;
    }
}