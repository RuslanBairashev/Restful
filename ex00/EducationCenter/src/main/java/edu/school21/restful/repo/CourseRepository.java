package edu.school21.restful.repo;

import edu.school21.restful.model.Course;
import org.springframework.data.repository.CrudRepository;

public interface CourseRepository extends CrudRepository<Course, Long> {
}
