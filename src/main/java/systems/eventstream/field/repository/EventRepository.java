package systems.eventstream.field.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import systems.eventstream.field.model.Event;

public interface EventRepository extends CrudRepository<Event, Long> {

	  List<Event> findByCategory(String category);
	  Event findByKey(String key);
	  Event findById(long id);
	}

