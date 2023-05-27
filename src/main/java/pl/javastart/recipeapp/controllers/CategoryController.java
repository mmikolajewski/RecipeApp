package pl.javastart.recipeapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.javastart.recipeapp.recipe.Recipe;
import pl.javastart.recipeapp.recipe.RecipeCategory;
import pl.javastart.recipeapp.recipe.RecipeRepository;
import pl.javastart.recipeapp.recipe.RecipeService;

import java.util.List;

@Controller
public class CategoryController {
    private RecipeService recipeService;
    private RecipeRepository recipeRepository;

    public CategoryController(RecipeService recipeService, RecipeRepository recipeRepository) {
        this.recipeService = recipeService;
        this.recipeRepository = recipeRepository;
    }

    @GetMapping("/category")
    public String home(Model model, @RequestParam(required = false) RecipeCategory category) {
        RecipeCategory[] values = RecipeCategory.values();
        RecipeCategory selectedCategory = null;
        for (RecipeCategory value : values) {
            if (value.equals(category)){
                selectedCategory = value;
            }
        }
        List<Recipe> recipeList;
        if (category != null) {
            recipeList = recipeRepository.findByCategory(category);
            model.addAttribute("category", selectedCategory);
            model.addAttribute("recipeList", recipeList);
        }
        return "category";
    }
}
