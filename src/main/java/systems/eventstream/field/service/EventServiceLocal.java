package systems.eventstream.field.service;

import java.util.List;

import systems.eventstream.field.model.Event;

public interface EventServiceLocal {

	List<Event> events();
	void populate();

}
