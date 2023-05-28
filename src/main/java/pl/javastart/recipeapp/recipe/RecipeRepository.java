package pl.javastart.recipeapp.recipe;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RecipeRepository extends CrudRepository<Recipe, Long> {

    List<Recipe> findTop3ByOrderByLikesDesc();
    List<Recipe> findAll();

    List<Recipe> findAllByCategoryId(Long id);
}
