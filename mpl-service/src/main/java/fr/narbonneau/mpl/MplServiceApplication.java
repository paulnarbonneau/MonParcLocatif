package fr.narbonneau.mpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MplServiceApplication {
	
	public static final Logger LOGGER = LoggerFactory.getLogger(MplServiceApplication.class);

	public static void main(String[] args) {
		LOGGER.debug("Démarrage de l'application MplServiceApplication");
		SpringApplication.run(MplServiceApplication.class, args);
	}

}
