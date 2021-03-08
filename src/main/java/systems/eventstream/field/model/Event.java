package systems.eventstream.field.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Event {

  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  private Long id;
  private Long timestamp;
  private String state;
  
  @ElementCollection
  private Map<String, String> map = new HashMap<>();
  
  @ElementCollection
  private List<String> tags;
  

  

  protected Event() {}

  public Event(Long timestamp, String state) {
	  this.timestamp = timestamp;
	  this.state = state;

  }
  
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public List<String> getTags() {
		return tags;
	}

	public void setTags(List<String> tags) {
		this.tags = tags;
	}

	@Override
	public String toString() {
		return "Event [id=" + id + ", timestamp=" + timestamp + ", state=" + state
				+ ", tags=" + tags + "]";
	}


}
