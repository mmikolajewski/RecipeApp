package pl.javastart.recipeapp.author;

import org.springframework.data.repository.CrudRepository;
import pl.javastart.recipeapp.author.Author;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
