package com.wz;

import com.wz.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

/**
 * <p></p>
 *
 * @author wangzi
 */
@SpringBootApplication
public class ConsumerTwoApplication {
    @Autowired
    private HelloService service;

    public static void main(String[] args) {
        SpringApplication.run(ConsumerTwoApplication.class, args);
    }

    @PostConstruct
    public void test(){
        System.out.println(service.hello("dubbo"));
    }
}
