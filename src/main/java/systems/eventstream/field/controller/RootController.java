package systems.eventstream.field.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import systems.eventstream.field.model.Event;
import systems.eventstream.field.service.EventServiceLocal;

@Controller
public class RootController {

    @Value("${welcome.message}")
    private String message;
    
    private List<Event> events;
	@Autowired
	EventServiceLocal applicationService;
    
    @GetMapping("/")
    public String main(Model model) {
    	events = applicationService.events();
        model.addAttribute("message", message);
        model.addAttribute("events", events);

        return "welcome"; //view
    }

    //
    @GetMapping("/command")
    public String mainWithParam(
            @RequestParam(name = "name", required = false, defaultValue = "") 
            String name, Model model) {
        model.addAttribute("message", name);
        return "welcome";
    }
}
