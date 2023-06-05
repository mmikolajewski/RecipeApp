package pl.javastart.recipeapp;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;
import pl.javastart.recipeapp.category.CategoryRepository;
import pl.javastart.recipeapp.recipe.Recipe;
import pl.javastart.recipeapp.recipe.RecipeService;

import java.util.List;

@ControllerAdvice
public class HomeController {

    private RecipeService recipeService;
    private CategoryRepository categoryRepository;

    public HomeController(RecipeService recipeService, CategoryRepository categoryRepository) {
        this.recipeService = recipeService;
        this.categoryRepository = categoryRepository;
    }

    @GetMapping("/")
    public String home(Model model) {
        List<Recipe> mostLikeableRecipes = recipeService.find3MostLikeableRecipes();
        model.addAttribute("recipes", mostLikeableRecipes);
        return "home";
    }


}
