package com.pandaria.scheduler.configuration;

import com.zaxxer.hikari.HikariDataSource;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class DBConfig {
    public final Log logger = LogFactory.getLog(getClass());

    @Bean("pandariaDS")
    public DataSource getDataSource() {
        logger.info("Initializing datasource...");
        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setJdbcUrl("jdbc:mysql://127.0.0.1:3306/scheduler?serverTimezone=UTC");
        dataSource.setUsername("root");
        dataSource.setPassword("root");
        dataSource.setPoolName("Pandaria Scheduler Datasource pool.");
        dataSource.setMaximumPoolSize(8);
        return dataSource;
    }
}
