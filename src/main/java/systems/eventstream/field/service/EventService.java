package systems.eventstream.field.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import systems.eventstream.field.model.Event;
import systems.eventstream.field.repository.EventRepository;

@Service
public class EventService implements EventServiceLocal {

	@Autowired
	EventRepository repository;
	
	@Override
	public List<Event> events() {
		return repository.findAll();
	}

}
