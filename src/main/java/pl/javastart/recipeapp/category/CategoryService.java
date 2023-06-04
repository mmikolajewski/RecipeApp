package pl.javastart.recipeapp.category;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    private CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public Category findById(Long id) {
        return categoryRepository.findById(id).orElseThrow();

    }

    public List<Category> findAll() {
        return categoryRepository.findAll();
    }
}
