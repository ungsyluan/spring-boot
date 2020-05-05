package com.mkyong;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.mkyong.a.HelloController;

@SpringBootApplication
//@PropertySource(value = "classpath:log4j2-${spring.profiles.active}.yml", factory = YamlPropertySourceFactory.class)
public class StartApplication {
	
	private static final Logger logger = LogManager.getLogger(StartApplication.class);
    public static void main(String[] args) {
//		try {
//			Resource resource = new ClassPathResource("log4j2-dev.yml");
//			ConfigurationSource source = new ConfigurationSource(resource.getInputStream());
//	    	Configurator.initialize(null, source);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
    	
        SpringApplication.run(StartApplication.class, args);
    }

}
