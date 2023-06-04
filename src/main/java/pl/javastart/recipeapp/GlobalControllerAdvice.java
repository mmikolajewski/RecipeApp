package pl.javastart.recipeapp;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;
import pl.javastart.recipeapp.category.Category;
import pl.javastart.recipeapp.category.CategoryRepository;

import java.util.List;

@Controller
@ControllerAdvice
public class GlobalControllerAdvice {

    private CategoryRepository categoryRepository;

    public GlobalControllerAdvice(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @ModelAttribute("categories")
    public List<Category> categoryList() {
        List<Category> all = categoryRepository.findAll();
        return all;
    }
}
