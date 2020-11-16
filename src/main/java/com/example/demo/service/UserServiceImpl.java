package com.example.demo.service;

import com.example.demo.api.UserService;
import org.springframework.stereotype.Component;

import javax.jws.WebService;

@WebService(serviceName = "helloWebService", //web服务名称
        endpointInterface = "com.example.demo.api.UserService",//接口全包名
        targetNamespace = "http://webservices.study.chenhui.org")
@Component
public class UserServiceImpl implements UserService {
    @Override
    public String sayHi() {
        System.out.println("say Hi!");
        return "hello world,spring-boot-ws";
    }
}
