package com.github.magyariotto.config;

import com.github.magyariotto.Application;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackages = "com.github.magyariotto")
@EntityScan(basePackageClasses = Application.class)
@Configuration
public class DatabaseConfiguration {

}
