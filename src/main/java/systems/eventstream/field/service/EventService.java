package systems.eventstream.field.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import systems.eventstream.field.FieldApplication;
import systems.eventstream.field.model.Event;
import systems.eventstream.field.model.Label;
import systems.eventstream.field.model.Selector;
import systems.eventstream.field.repository.EventRepository;
import systems.eventstream.field.repository.LabelRepository;
import systems.eventstream.field.repository.SelectorRepository;

@Service
public class EventService implements EventServiceLocal {

	private static final Logger log = LoggerFactory.getLogger(EventService.class);

	@Autowired
	EventRepository eventRepository;

	@Autowired
	LabelRepository labelRepository;

	@Autowired
	SelectorRepository selectorRepository;

	@Override
	public List<Event> events() {
		return eventRepository.findAll();
	}

	@Override
	public void populate() {

		// global selectors
		String[] selectorStrings = { "fte", "team1", "proj1", "proj2" };
		Set<Selector> selectors = new HashSet<>();
		Arrays.stream(selectorStrings).forEach(i -> selectors.add(selectorRepository.save(new Selector(i))));
		eventRepository.save(new Event(System.nanoTime(), "1")).setSelectors(selectors);

		try {
			Thread.sleep(1);
		} catch (Exception e) {
			e.printStackTrace();
		}

		List<Label> labels = new ArrayList<>();
		labels.add(labelRepository.save(new Label("week1", "55")));
		labels.add(labelRepository.save(new Label("week2", "30.5")));
		labels.add(labelRepository.save(new Label("start", "20201230")));
		labels.add(labelRepository.save(new Label("end", "20211201")));
		Event event2 = new Event(System.nanoTime(), "2");
		event2.setSelectors(selectors);
		eventRepository.save(event2);

		log.info("Events found with findAll():");
		eventRepository.findAll().forEach(i -> log.info(i.toString()));

		log.info("Events found with findByState('1'):");
		eventRepository.findByState("1").forEach(anEvent -> log.info(anEvent.toString()));
	}

	@Override
	public Event saveUpdateEvent(Event event) {
		return eventRepository.save(event);
	}

}
