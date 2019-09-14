package com.rest.bbs.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.rest.bbs.beans.User;

@Configuration
@ComponentScan(basePackageClasses = User.class)
public class UserConfig {
	
	
}
