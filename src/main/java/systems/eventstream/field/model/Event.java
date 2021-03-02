package systems.eventstream.field.model;

import java.util.List;

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
  private String key;
  private String value;
  private String state;
  //private List<String> labels;
  private String label;
  private String type;
  private String category;

  protected Event() {}

  public Event(Long timestamp, String value, String label, String type, String category) {
	  this.timestamp = timestamp;
	  this.value = value;
	  this.label = label;
	  this.type = type;
	  this.category = category;
  }
  
  public Event(Long timestamp, String key, String value, String label, String type, String category) {
	  this.timestamp = timestamp;
	  this.key = key;
	  this.value = value;
	  this.label = label;
	  this.type = type;
	  this.category = category;
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

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "Event [id=" + id + ", timestamp=" + timestamp + ", key=" + key + ", value=" + value + ", state=" + state
				+ ", label=" + label + ", type=" + type + ", category=" + category + "]";
	}




}
