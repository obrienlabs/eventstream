package systems.eventstream.field;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import systems.eventstream.field.model.Event;
import systems.eventstream.field.repository.EventRepository;


@SpringBootApplication
public class FieldApplication {

	private static final Logger log = LoggerFactory.getLogger(FieldApplication.class);

	// OpenAPI2SpringBoot has the single main method
	public static void main(String[] args) {
		SpringApplication.run(FieldApplication.class, args);
	}
	
	
/*	@Bean
	  public CommandLineRunner demo(EventRepository repository) {
	    return (args) -> {
	      // import rows
	      repository.save(new Event(System.nanoTime(), "1", "4", "new", "off", "category1"));
	      Thread.sleep(1);
	      repository.save(new Event(System.nanoTime(), "2", "5", "new", "time", "category2"));
	      Thread.sleep(1);
	      repository.save(new Event(System.nanoTime(), "3", "6", "done", "time", "category1"));

	      log.info("Events found with findAll():");
	      log.info("-------------------------------");
	      for (Event event : repository.findAll()) {
	        log.info(event.toString());
	      }
	      log.info("");

	      Event event = repository.findByKey("2");
	      log.info("Events found with findByKey(2):");
	      log.info("--------------------------------");
	      if(null != event) {
	    	  log.info(event.toString());
	      }
	      log.info("");

	      log.info("Events found with findByCategory('category1'):");
	      log.info("--------------------------------------------");
	      repository.findByCategory("category1").forEach(anEvent -> log.info(anEvent.toString()));
	      log.info("");
	    };
	  }*/
	
}
