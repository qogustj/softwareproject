package com.qogustj.softwareproject;

import com.qogustj.softwareproject.repository.SpRepository;
import com.qogustj.softwareproject.service.SpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

public class SpringConfig {
    private final SpRepository spRepository;
    @Autowired
    public SpringConfig(SpRepository spRepository) {
        this.spRepository = spRepository;
    }

    @Bean
    public SpService spService(){
        return new SpService((spRepository));
    }
}
