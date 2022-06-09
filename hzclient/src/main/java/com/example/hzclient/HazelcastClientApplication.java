package com.example.hzclient;


import com.example.hzclient.model.User;
import com.hazelcast.client.HazelcastClient;
import com.hazelcast.client.config.ClientConfig;

import com.hazelcast.core.HazelcastInstance;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import java.util.Map;


@SpringBootApplication
public class HazelcastClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(HazelcastClientApplication.class, args);
	}


	@Bean
	public ClientConfig hazelCastConfig() {
		ClientConfig clientConfig = new ClientConfig();
		clientConfig.setClusterName("hzserver");
		return clientConfig;
	}

	@Bean
	public HazelcastInstance hazelcastInstance(ClientConfig hazelCastConfig) {
		return HazelcastClient.newHazelcastClient(hazelCastConfig);
	}

	@Bean
	public Map<String, User> accountMap(HazelcastInstance hazelcastInstance) {
		return hazelcastInstance.getMap("accountMap");
	}


}
