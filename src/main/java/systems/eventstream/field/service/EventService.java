package systems.eventstream.field.service;

import java.util.ArrayList;
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
		  List<String> labels = new ArrayList<>();
		  labels.add("fte");
		  labels.add("team1");
		  labels.add("proj1");
		  labels.add("proj2");
		  
	      repository.save(new Event(System.nanoTime(), "time", "2", "1", "category1", labels));
	      try {
	    	  Thread.sleep(1);
	      } catch (Exception e) { }

		  labels = new ArrayList<>();
		  labels.add("contract");
		  labels.add("team2");
		  labels.add("proj2");
	      repository.save(new Event(System.nanoTime(), "hours", "2", "1", "category2", labels));
	      try {
	    	  Thread.sleep(1);
	      } catch (Exception e) { }
	      
		  labels = new ArrayList<>();
		  labels.add("contract");
		  labels.add("team2");
		  labels.add("proj1");
	      repository.save(new Event(System.nanoTime(), "days", "4", "2", "category1", labels));

	      log.info("Events found with findAll():");
	      log.info("-------------------------------");
	      for (Event event : repository.findAll()) {
	        log.info(event.toString());
	      }
	      log.info("");

	      Event event = repository.findByKey("time");
	      log.info("Events found with findByKey(time):");
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
