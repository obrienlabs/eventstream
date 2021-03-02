package systems.eventstream.field.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import systems.eventstream.field.model.Event;

//@RepositoryRestResource(collectionResourceRel = "event", path = "event")
//public interface EventRepository extends PagingAndSortingRepository<Event, Long> {//CrudRepository<Event, Long> {
public interface EventRepository extends CrudRepository<Event, Long> {

	  //List<Event> findByCategory(@Param("category") String category);
	  List<Event> findByCategory(String category);
	  Event findByKey(String key);
	  Event findById(long id);
	  List<Event> findAll();
	}

