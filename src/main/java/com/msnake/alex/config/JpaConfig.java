package com.msnake.alex.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * DB connection configure
 */
@Configuration
@EnableTransactionManagement
@ComponentScan("com.msnake.alex")
@EnableJpaRepositories("com.msnake.alex.repository")
@ConfigurationProperties(prefix = "spring.datasource.hikari")
public class JpaConfig extends HikariConfig {

    /**
     * data source init
     *
     * @return - data source
     */
    @Bean
    public DataSource dataSource() throws SQLException {
        return new HikariDataSource(this);
    }


}
