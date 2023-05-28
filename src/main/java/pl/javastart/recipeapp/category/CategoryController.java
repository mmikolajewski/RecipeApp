package pl.javastart.recipeapp.category;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class CategoryController {

    private CategoryRepository categoryRepository;

    public CategoryController(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @GetMapping
    public String home(Model model) {
        List<Category> categories = categoryRepository.findAll();

        model.addAttribute("categories", categories);
        return "fragments";
    }
}

