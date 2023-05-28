package pl.javastart.recipeapp.recipe;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import pl.javastart.recipeapp.category.Category;
import pl.javastart.recipeapp.category.CategoryRepository;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;

@Service
public class RecipeService {

    private final RecipeRepository recipeRepository;
    private final CategoryRepository categoryRepository;

    public RecipeService(RecipeRepository recipeRepository, CategoryRepository categoryRepository) {
        this.recipeRepository = recipeRepository;
        this.categoryRepository = categoryRepository;
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

    public List<Recipe> findAllByCategory(Long id){
        return recipeRepository.findAllByCategoryId(id);
    }

    public String getLikeRecipe(Long id, String referer) {
        Optional<Recipe> optionalRecipe = recipeRepository.findById(id);
        if (optionalRecipe.isPresent()) {
            Recipe recipe = optionalRecipe.get();
            recipe.setLikes(recipe.getLikes() + 1);
            recipeRepository.save(recipe);
            return "redirect:" + referer;
        } else {
            return "redirect:/e";
        }
    }

    public String addAddTimeAndSave(Recipe recipe) {
        recipe.setAddTime(LocalDateTime.now().truncatedTo(ChronoUnit.MINUTES));
        recipeRepository.save(recipe);

        return "redirect:/list";
    }

    public void deleteRecipeIfExist(Long id) {
        Optional<Recipe> taskOptional = recipeRepository.findById(id);
        if (taskOptional.isPresent()) {
            Recipe recipe = taskOptional.get();
            recipeRepository.delete(recipe);
        }
    }

    public static Recipe editRecipeParameters(Recipe recipe, Optional<Recipe> returnedRecipe) {
        Recipe recipe1 = returnedRecipe.get();
        recipe1.setName(recipe.getName());
        recipe1.setDescription(recipe.getDescription());
        recipe1.setDifficultyLevel(recipe.getDifficultyLevel());
        recipe1.setText(recipe.getText());
        recipe1.setTiming(recipe.getTiming());
        recipe1.setEditTime(LocalDateTime.now().truncatedTo(ChronoUnit.MINUTES));
        return recipe1;
    }

    public void save(Recipe recipe1) {
        recipeRepository.save(recipe1);
    }

    public Category findCategory(Long id) {
        Optional<Category> byId = categoryRepository.findById(id);
        return byId.orElseThrow();
    }
    public List<Category> findCategories() {
        return categoryRepository.findAll();
    }

    public void addCategoryAtrubiteAndRecipeList(Model model, Long id) {
        List<Recipe> recipesByCategory = findAllByCategory(id);
        Category category = findCategory(id);
        model.addAttribute("category", category);
        model.addAttribute("recipes", recipesByCategory);
    }
}
