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
		
		// global entities
		
		
	      // import rows
		  List<String> tags = new ArrayList<>();
		  tags.add("fte");
		  tags.add("team1");
		  tags.add("proj1");
		  tags.add("proj2");
	      repository.save(new Event(System.nanoTime(), "1"));
	      
	      try {
	    	  Thread.sleep(1);
	      } catch (Exception e) { }

		  tags = new ArrayList<>();
		  tags.add("contract");
		  tags.add("team2");
		  tags.add("proj2");
	      repository.save(new Event(System.nanoTime(), "2"));
	      
	      try {
	    	  Thread.sleep(1);
	      } catch (Exception e) { }
	      
		  tags = new ArrayList<>();
		  tags.add("contract");
		  tags.add("team2");
		  tags.add("proj1");
	      repository.save(new Event(System.nanoTime(), "3"));

	      log.info("Events found with findAll():");
	      log.info("-------------------------------");
	      for (Event event : repository.findAll()) {
	        log.info(event.toString());
	      }

	      /*Event event = repository.findByKey("time");
	      log.info("Events found with findByKey(time):");
	      log.info("--------------------------------");
	      if(null != event) {
	    	  log.info(event.toString());
	      }*/

	      log.info("Events found with findByState('1'):");
	      log.info("--------------------------------------------");
	      repository.findByState("1").forEach(anEvent -> log.info(anEvent.toString()));
	}

	@Override
	public Event saveUpdateEvent(Event event) {
		return repository.save(event);
	}

}
