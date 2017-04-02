package com.geeth.modules.module1;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.hibernate4.HibernateExceptionTranslator;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        entityManagerFactoryRef = "module1EntityManagerFactory", 
        transactionManagerRef = "module1TransactionManager",
        basePackages = { "com.geeth.modules.module1" })
@ComponentScan(basePackages = { "com.geeth.modules.module1" })
public class Model1Config {

    /**
     * Primary because if we have activated embedded databases, we do not want
     * the application to connect to an external database.
     */
    @Bean
    public JpaVendorAdapter jpaVendorAdapter() {
        HibernateJpaVendorAdapter jpaVendorAdapter = new HibernateJpaVendorAdapter();
        jpaVendorAdapter.setShowSql(true);
        jpaVendorAdapter.setGenerateDdl(true);
        jpaVendorAdapter.setDatabase(Database.HSQL);
        return jpaVendorAdapter;
    }

    @Bean
    public HibernateExceptionTranslator hibernateExceptionTranslator() {
        return new HibernateExceptionTranslator();
    }
    
    
    @Bean(name = "module1DataSource")
    public DataSource dataSource() {
        return new EmbeddedDatabaseBuilder()
                .setName("module1db")
                .setType(EmbeddedDatabaseType.HSQL)
                .build();
    }

    @Bean(name = "module1EntityManager")
    public EntityManager entityManager() {
        return entityManagerFactory().createEntityManager();
    }

    @Bean(name = "module1EntityManagerFactory")
    public EntityManagerFactory entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean lef = new LocalContainerEntityManagerFactoryBean();
        lef.setDataSource(dataSource());
        lef.setJpaVendorAdapter(jpaVendorAdapter());
        lef.setPackagesToScan("com.geeth.modules.module1");
        lef.setPersistenceUnitName("module1PersistenceUnit");
        lef.afterPropertiesSet();
        return lef.getObject();
    }

    @Bean(name = "module1TransactionManager")
    public PlatformTransactionManager transactionManager() {
        return new JpaTransactionManager(entityManagerFactory());
    }

}
