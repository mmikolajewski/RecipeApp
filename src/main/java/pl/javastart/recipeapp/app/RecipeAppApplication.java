package pl.javastart.recipeapp.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import pl.javastart.recipeapp.author.Author;
import pl.javastart.recipeapp.author.AuthorRepository;
import pl.javastart.recipeapp.recipe.Recipe;
import pl.javastart.recipeapp.recipe.RecipeCategory;
import pl.javastart.recipeapp.recipe.RecipeDifficultyLevel;
import pl.javastart.recipeapp.recipe.RecipeRepository;

@SpringBootApplication
public class RecipeAppApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(RecipeAppApplication.class, args);
        AuthorRepository authorRepository = context.getBean(AuthorRepository.class);


        RecipeRepository recipeRepository = context.getBean(RecipeRepository.class);
        save(authorRepository, recipeRepository);

    }

    public static void save(AuthorRepository authorRepository, RecipeRepository recipeRepository) {

        Author author = new Author("Jan", "Kowalski");
        authorRepository.save(author);

        Recipe recipe1 = new Recipe("Woda", "Odrobina rozkoszy", "woda iwoda", 15, RecipeCategory.SNACK, RecipeDifficultyLevel.EASY, author);
        Recipe recipe2 = new Recipe("fff", "aaa", "woda iwoda", 1, RecipeCategory.SNACK, RecipeDifficultyLevel.EASY, author);

        recipeRepository.save(recipe1);
    }
}
