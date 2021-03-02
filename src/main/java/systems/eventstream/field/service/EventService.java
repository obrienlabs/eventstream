package systems.eventstream.field.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import systems.eventstream.field.FieldApplication;
import systems.eventstream.field.model.Event;
import systems.eventstream.field.repository.EventRepository;

@Service
public class EventService implements EventServiceLocal {

	private static final Logger log = LoggerFactory.getLogger(EventService.class);
	
	@Autowired
	EventRepository repository;
	
	@Override
	public List<Event> events() {
		return repository.findAll();
	}
	
	
	
	@Override
	public void populate() {
	      // import rows
	      repository.save(new Event(System.nanoTime(), "4", "new", "off", "category1"));
	      try {
	    	  Thread.sleep(1);
	      } catch (Exception e) { }
	      repository.save(new Event(System.nanoTime(), "5", "new", "time", "category2"));
	      try {
	    	  Thread.sleep(1);
	      } catch (Exception e) { }
	      repository.save(new Event(System.nanoTime(), "6", "done", "time", "category1"));

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
	
	}



	@Override
	public Event saveUpdateEvent(Event event) {
		return repository.save(event);
	}

}
