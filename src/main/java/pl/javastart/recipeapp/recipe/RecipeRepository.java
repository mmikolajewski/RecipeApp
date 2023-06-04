package pl.javastart.recipeapp.recipe;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface RecipeRepository extends JpaRepository<Recipe, Long> {
    List<Recipe> findTop3ByOrderByLikesDesc();
    List<Recipe> findAllByCategoryId(Long id);
}
