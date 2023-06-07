package pl.javastart.recipeapp;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;
import pl.javastart.recipeapp.category.Category;
import pl.javastart.recipeapp.category.CategoryRepository;

import java.util.List;

@ControllerAdvice
public class GlobalControllerAdvice {

    private final CategoryRepository categoryRepository;

    public GlobalControllerAdvice(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @ModelAttribute("categories")
    public List<Category> categoryList() {
        return categoryRepository.findAll();
    }
}
