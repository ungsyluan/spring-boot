package com.mkyong.a;

import java.util.Arrays;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

//https://docs.spring.io/spring-boot/docs/current/reference/html/howto-logging.html
@Controller
public class HelloController {

    private static final Logger logger = LogManager.getLogger(HelloController.class);

    private List<Integer> num = Arrays.asList(1, 2, 3, 4, 5);

    @GetMapping("/")
    public String main(Model model) {

    	logger.info("INFOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO");
    	logger.warn("WARNINGNNNNNNNNNNNNNNNNNNNNIIIIIIIIIIIIIIIIIIIIIII");
    	logger.fatal("FATALLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLL");
        logger.debug("DEBUGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGG");
        logger.error("ERRORRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRR Hello from Log4j 2 - num : {}", () -> num);

        model.addAttribute("tasks", num);

        return "welcome"; //view
    }
    
    @GetMapping("/abc")
    public String test(Model model) {

     
        // java 8 lambda, no need to check log level
        logger.debug("DEBUGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGG");

        model.addAttribute("tasks", num);

        return "welcome"; //view
    }

    private int getNum() {
        return 100;
    }

}
