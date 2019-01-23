package com.draper.spring_rmi_service_second;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@Slf4j
public class App {

    public static void main(String[] args) {
        new ClassPathXmlApplicationContext("classpath:spring/spring-*.xml");
        log.warn("------SpringRMI-service has start------");
    }

}
