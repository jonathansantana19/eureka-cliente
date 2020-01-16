package br.com.teste.eurekaclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.ApplicationContext;
import org.springframework.jms.core.JmsTemplate;

@SpringBootApplication
@EnableDiscoveryClient
public class EurekaClientApplication {

	public static void main(String[] args) {
//		SpringApplication.run(EurekaClientApplication.class, args);
		ApplicationContext ctx =  SpringApplication.run(EurekaClientApplication.class, args);
		
//		JmsTemplate jms = ctx.getBean (JmsTemplate.class);
//		jms.convertAndSend ("javainuse", "mensagem de teste");
	}

}
