package systems.eventstream.field.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import systems.eventstream.field.model.Label;

public interface LabelRepository extends CrudRepository<Label, Long> {

}
