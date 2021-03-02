
package systems.eventstream.field.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import systems.eventstream.field.model.Health;

@Validated
@Api(value = "health", description = "the health API")
public interface HealthApi {

    default HealthApiDelegate getDelegate() {
        return new HealthApiDelegate() {};
    }

    /**
     * GET /health/ : readiness
     *
     * @return ok (status code 200)
     *         or Unexpected error (status code 200)
     */
    @ApiOperation(value = "readiness", nickname = "health", notes = "", response = Health.class, tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "ok", response = Health.class),
        @ApiResponse(code = 200, message = "Unexpected error") })
    @RequestMapping(value = "/health/",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    default ResponseEntity<Health> health() {
        return getDelegate().health();
    }

}
