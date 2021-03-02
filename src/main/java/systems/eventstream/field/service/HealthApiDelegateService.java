package systems.eventstream.field.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import systems.eventstream.field.controller.HealthApiDelegate;
import systems.eventstream.field.model.Health;

@Service
public class HealthApiDelegateService implements HealthApiDelegate {

	@Override
	public ResponseEntity<Health> health() {
		Health health = new Health();
		health.setKey("state");
		health.setValue("OK");
		return ResponseEntity.ok(health);
	}
}
