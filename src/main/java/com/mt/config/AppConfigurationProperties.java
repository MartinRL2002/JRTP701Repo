package com.mt.config;

import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
@ConfigurationProperties(prefix="details.module")
public class AppConfigurationProperties {
	
	public Map<String,String> messages;

}
