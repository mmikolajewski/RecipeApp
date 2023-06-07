package pl.javastart.recipeapp;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.javastart.recipeapp.recipe.Recipe;
import pl.javastart.recipeapp.recipe.RecipeService;

import java.util.List;

@Controller
public class HomeController {

    private RecipeService recipeService;

    public HomeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @GetMapping("/")
    public String home(Model model) {
        List<Recipe> mostLikeableRecipes = recipeService.find3MostLikeableRecipes();
        model.addAttribute("recipes", mostLikeableRecipes);
        return "home";
    }


}
