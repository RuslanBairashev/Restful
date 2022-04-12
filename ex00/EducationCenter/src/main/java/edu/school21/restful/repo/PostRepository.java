package edu.school21.restful.repo;

import edu.school21.restful.model.Post;
import org.springframework.data.repository.CrudRepository;

public interface PostRepository extends CrudRepository<Post, Long> {
}
