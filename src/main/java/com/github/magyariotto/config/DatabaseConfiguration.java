package com.github.magyariotto.config;

import com.github.magyariotto.repository.DatabaseConnection;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DatabaseConfiguration {
    @Value("${database.driver}")
    private String driver;

    @Value("${database.url}")
    private String url;

    @Value("${database.username}")
    private String username;

    @Value("${database.password}")
    private String password;

    @Bean
    public DatabaseConnection databaseConnection(){
        return DatabaseConnection.builder()
                .driver(driver)
                .databaseUrl(url)
                .databaseUsername(username)
                .databasePassword(password)
                .build();
    }
}
