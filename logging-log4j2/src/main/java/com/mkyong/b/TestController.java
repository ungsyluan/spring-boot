package com.mkyong.b;

import java.util.Arrays;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

//https://docs.spring.io/spring-boot/docs/current/reference/html/howto-logging.html
@Controller
public class TestController {

    private static final Logger logger = LogManager.getLogger(TestController.class);

    private List<Integer> num = Arrays.asList(6, 2, 3, 4, 5);

    @GetMapping("/test")
    public String writeLog() {

        // pre-java 8
        if (logger.isDebugEnabled()) {
            logger.debug("Test Log4j 2 - num : {}", num);
        }

        // java 8 lambda, no need to check log level
        logger.debug("Test Log4j 2 - num : {}", () -> num);
        logger.error("ERROR Test from Log4j 2 - num : {}", () -> num);

        return "welcome"; //view
    }

    private int getNum() {
        return 100;
    }

}
