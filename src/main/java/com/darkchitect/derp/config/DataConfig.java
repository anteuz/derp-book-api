package com.darkchitect.derp.config;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.darkchitect.derp.model.dao.DaoPackage;

@EnableJpaRepositories(basePackageClasses = DaoPackage.class)
public class DataConfig {

}