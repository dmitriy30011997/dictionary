package spring.dictionary.configs;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableTransactionManagement
public class JPAConfig {

    @Value("${SPRING_DATASOURCE_DRIVER_CLASS_NAME:org.postgresql.Driver}")
    private String defaultDriverClassName;

    @Value("${SPRING_DATASOURCE_URL:jdbc:postgresql://localhost:5432/dictionary}")
    private String defaultUrl;

    @Value("${SPRING_DATASOURCE_USERNAME:postgres}")
    private String defaultUsername;

    @Value("${SPRING_DATASOURCE_PASSWORD:inudug95}")
    private String defaultPassword;

    @Value("${SPRING_TEST_DATASOURCE_DRIVER_CLASS_NAME:org.h2.Driver}")
    private String testDriverClassName;

    @Value("${SPRING_TEST_DATASOURCE_URL:jdbc:h2:mem:testdb}")
    private String testUrl;

    @Value("${SPRING_TEST_DATASOURCE_USERNAME:testuser}")
    private String testUsername;

    @Value("${SPRING_TEST_DATASOURCE_PASSWORD:testpassword}")
    private String testPassword;

    @Bean
    @Profile("default")
    public DataSource defaultDataSource() {
        return createDataSource(defaultDriverClassName, defaultUrl, defaultUsername, defaultPassword);
    }

    @Bean
    @Profile("test")
    public DataSource testDataSource() {
        return createDataSource(testDriverClassName, testUrl, testUsername, testPassword);
    }

    private DataSource createDataSource(String driverClassName, String url, String username, String password) {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(driverClassName);
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        return dataSource;
    }

    @Bean
    public PlatformTransactionManager transactionManager() {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());
        return transactionManager;
    }

    private Properties hibernateProperties() {
        Properties properties = new Properties();
        properties.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
        return properties;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(defaultDataSource());
        em.setPackagesToScan("spring.dictionary.entities");

        JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        em.setJpaVendorAdapter(vendorAdapter);
        em.setJpaProperties(hibernateProperties());

        return em;
    }
}
