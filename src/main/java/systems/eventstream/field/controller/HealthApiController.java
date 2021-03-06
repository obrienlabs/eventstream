package systems.eventstream.field.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.Optional;

@Controller
@RequestMapping("/")
public class HealthApiController implements HealthApi {

    private final HealthApiDelegate delegate;

    public HealthApiController(@org.springframework.beans.factory.annotation.Autowired(required = false) HealthApiDelegate delegate) {
        this.delegate = Optional.ofNullable(delegate).orElse(new HealthApiDelegate() {});
    }

    @Override
    public HealthApiDelegate getDelegate() {
        return delegate;
    }

}
