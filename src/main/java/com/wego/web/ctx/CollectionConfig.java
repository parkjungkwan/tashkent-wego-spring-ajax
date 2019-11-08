package com.wego.web.ctx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

import java.util.*;

@Configuration
public class CollectionConfig {

    @Bean
    public CollectionsBean getCollectionsBean() {
        return new CollectionsBean(new HashSet<>(Arrays.asList("John", "Adam", "Harry")));
    }

    @Bean
    public List<String> nameList(){
        return Arrays.asList("John", "Adam", "Harry", null);
    }

    @Bean
    public Map<Integer, String> nameMap(){
        Map<Integer, String>  nameMap = new HashMap<>();
        nameMap.put(1, "John");
        nameMap.put(2, "Adam");
        nameMap.put(3, "Harry");
        return nameMap;
    }

    @Bean
    @Qualifier("CollectionsBean")
    @Order(2)
    public MyBean getElement() {
        return new MyBean("John");
    }

    @Bean
    @Order(3)
    public MyBean getAnotherElement() {
        return new MyBean("Adam");
    }

    @Bean
    @Order(1)
    public MyBean getOneMoreElement() {
        return new MyBean("Harry");
    }
}

class MyBean {

    private String name;

    public MyBean(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}