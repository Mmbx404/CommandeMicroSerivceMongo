package org.mmb.commandeMicroService;

import org.mmb.commandeMicroService.entities.Commande;
import org.mmb.commandeMicroService.service.CommandeService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@SpringBootApplication
@EnableFeignClients
public class CommandeMicroServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CommandeMicroServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(CommandeService commandeService) {
		return args -> {
			/*commandeService.save(new Commande(null,"ref-1",200.00,new Date().toString()));
			commandeService.save(new Commande(null,"ref-2",300.00,new Date().toString()));
			commandeService.save(new Commande(null,"ref-3",400.00,new Date().toString()));
			commandeService.save(new Commande(null,"ref-4",500.00,new Date().toString()));*/
		};
	}


}
