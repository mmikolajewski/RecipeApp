package pl.javastart.recipeapp.recipe;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RecipeService {

    private final RecipeRepository recipeRepository;

    public RecipeService(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    public List<Recipe> findByCategory(RecipeCategory category) {
        return recipeRepository.findByCategory(category);

    }

    public List<Recipe>find3MostLikeableRecipes() {
        return recipeRepository.findTop3ByOrderByLikesDesc();
    }

    public List<Recipe> findAll(){
        return recipeRepository.findAll();
    }
    public Optional<Recipe> findById(Long id){
        return recipeRepository.findById(id);


    }
}
