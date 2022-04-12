package edu.school21.restful.repo;

import edu.school21.restful.model.Usr;
import org.springframework.data.repository.CrudRepository;

public interface UsrRepository extends CrudRepository<Usr, Long> {
}
