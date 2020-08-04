package com.api.memory.config;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import javax.sql.DataSource;

@Configuration
@EnableJpaAuditing
public class DataSourceConfigurationJava {

    @Bean
    public DataSource getDataSource() {
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.username(System.getenv("db_user"));
        dataSourceBuilder.password(System.getenv("db_password"));
        dataSourceBuilder.url(System.getenv("db_url"));

        return dataSourceBuilder.build();
    }
}
