package com.best.info.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

//@Configuration
//@PropertySources({ @PropertySource(value = "file:/Users/raghu/application.properties", ignoreResourceNotFound = true)
//})
public class Propertieswithjavaconfig {
	@Bean
	public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
		return new PropertySourcesPlaceholderConfigurer();
	}
}
