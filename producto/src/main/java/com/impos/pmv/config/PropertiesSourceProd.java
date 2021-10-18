package com.impos.pmv.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource({"classpath:prod.properties"})
@Profile("pro")
public class PropertiesSourceProd {
}

