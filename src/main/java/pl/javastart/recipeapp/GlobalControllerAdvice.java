package pl.javastart.recipeapp;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import pl.javastart.recipeapp.category.Category;
import pl.javastart.recipeapp.category.CategoryRepository;
import pl.javastart.recipeapp.recipe.Recipe;
import pl.javastart.recipeapp.recipe.RecipeRepository;

import java.util.List;

@Controller
@ControllerAdvice
public class GlobalControllerAdvice {

    private CategoryRepository categoryRepository;
    private RecipeRepository recipeRepository;

    public GlobalControllerAdvice(CategoryRepository categoryRepository, RecipeRepository recipeRepository) {
        this.categoryRepository = categoryRepository;
        this.recipeRepository = recipeRepository;
    }

    @ModelAttribute("categories")
    public List<Category> categoryList() {
        List<Category> all = categoryRepository.findAll();
        return all;
    }
}
