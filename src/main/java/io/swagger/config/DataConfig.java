package io.swagger.config;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import io.swagger.model.dao.DaoPackage;

@EnableJpaRepositories(basePackageClasses = DaoPackage.class)
public class DataConfig {

}