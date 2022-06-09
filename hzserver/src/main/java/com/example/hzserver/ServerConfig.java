package com.example.hzserver;


import com.example.hzserver.model.User;
import com.hazelcast.config.Config;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.spring.context.SpringManagedContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

@Configuration
public class ServerConfig {


    @Bean
    public Config hazelCastConfig() {
        Config helloWorldConfig = new Config();
        helloWorldConfig.setClusterName("hzserver");
        helloWorldConfig.setManagedContext(managedContext());
        return helloWorldConfig;
    }

    @Bean
    public HazelcastInstance hazelcastInstance(Config hazelCastConfig) {
        return Hazelcast.newHazelcastInstance(hazelCastConfig);
    }

    @Bean
    public Map<String, User> accountMap(HazelcastInstance hazelcastInstance) {
        return hazelcastInstance.getMap("accountMap");
    }

    @Bean
    public SpringManagedContext managedContext() {
        return new SpringManagedContext();
    }
}
