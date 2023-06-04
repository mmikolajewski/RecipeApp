package pl.javastart.recipeapp.recipe;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.javastart.recipeapp.category.Category;
import pl.javastart.recipeapp.category.CategoryRepository;
import pl.javastart.recipeapp.category.CategoryService;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;

@Service
public class RecipeService {

    private final RecipeRepository recipeRepository;
    private final CategoryService categoryService;

    public RecipeService(RecipeRepository recipeRepository, CategoryService categoryService) {
        this.recipeRepository = recipeRepository;
        this.categoryService = categoryService;
    }

    public List<Recipe>find3MostLikeableRecipes() {
        return recipeRepository.findTop3ByOrderByLikesDesc();
    }

    public List<Recipe> findAll(){
        return recipeRepository.findAll();
    }

    public Recipe findById(Long id){
        return recipeRepository.findById(id).orElseThrow();
    }

    public List<Recipe> findAllByCategory(Long id){
        return recipeRepository.findAllByCategoryId(id);
    }

    @Transactional
    public void likeRecipe(Long id) {
        Recipe recipe = recipeRepository.findById(id).orElseThrow();
        recipe.setLikes(recipe.getLikes() + 1);
    }

    public void addAddTimeAndSave(Recipe recipe) {
        recipe.setAddTime(LocalDateTime.now().truncatedTo(ChronoUnit.MINUTES));
        recipeRepository.save(recipe);
    }

    public void deleteRecipeIfExist(Long id) {
        Recipe recipe = recipeRepository.findById(id).orElseThrow();
        recipeRepository.delete(recipe);
    }

    @Transactional
    public void editRecipeParameters(Recipe recipe) {
        Recipe recipeFromRepo = findById(recipe.getId());
        recipeFromRepo.setName(recipe.getName());
        recipeFromRepo.setAuthor(recipe.getAuthor());
        recipeFromRepo.setDescription(recipe.getDescription());
        recipeFromRepo.setDifficultyLevel(recipe.getDifficultyLevel());
        recipeFromRepo.setText(recipe.getText());
        recipeFromRepo.setTiming(recipe.getTiming());
        recipeFromRepo.setImageAddress(recipe.getImageAddress());
        recipeFromRepo.setEditTime(LocalDateTime.now().truncatedTo(ChronoUnit.MINUTES));
    }


    public Category findCategory(Long id) {
        return categoryService.findById(id);
    }
    public List<Category> findCategories() {
        return categoryService.findAll();
    }
}
