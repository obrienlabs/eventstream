package systems.eventstream.field.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import systems.eventstream.field.model.Event;
import systems.eventstream.field.service.EventService;
import systems.eventstream.field.service.EventServiceLocal;

@RestController
@RequestMapping("/")
public class EventController {

	@Autowired
	EventServiceLocal applicationService;
	
	//@GET
	//@Path("/health")
	//@Produces(MediaType.TEXT_HTML)
	//@RequestMapping("/test")
	/*@ApiOperation(value="health check", notes="health check for auto scaling")
	@ApiResponses (value= {
			@ApiResponse(code=200, message="OK - success"),
			@ApiResponse(code=400, message="Bad Request"),
			@ApiResponse(code=401, message="Unauthorized"),
			@ApiResponse(code=403, message="Forbidden"),
			@ApiResponse(code=404, message="NotFound"),
			@ApiResponse(code=409, message="Conflict"),
			@ApiResponse(code=500, message="Internal Server Error")
	})*/
	@GetMapping("/events")
	public List<Event> getEvents() {
		return applicationService.events();
	}
}