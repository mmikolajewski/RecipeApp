package pl.javastart.recipeapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import pl.javastart.recipeapp.author.Author;
import pl.javastart.recipeapp.author.AuthorRepository;
import pl.javastart.recipeapp.recipe.Recipe;
import pl.javastart.recipeapp.recipe.RecipeCategory;
import pl.javastart.recipeapp.recipe.RecipeDifficultyLevel;
import pl.javastart.recipeapp.recipe.RecipeRepository;

import java.io.File;

@SpringBootApplication
public class RecipeAppApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(RecipeAppApplication.class, args);
        AuthorRepository authorRepository = context.getBean(AuthorRepository.class);
        RecipeRepository recipeRepository = context.getBean(RecipeRepository.class);
        save(authorRepository, recipeRepository);
    }
    
    private static void save(AuthorRepository authorRepository, RecipeRepository recipeRepository) {
        Author author1 = new Author("Agnieszka", "Spała");
        Author author2 = new Author("Tomasz", "Zajadał");
        Author author3 = new Author("Irena", "Podmiotła");
        Author author4 = new Author("Igor", "Przespał");
        Author author5 = new Author("Karol", "Dotykał");
        authorRepository.save(author1);
        authorRepository.save(author2);
        authorRepository.save(author3);
        authorRepository.save(author4);
        authorRepository.save(author5);


        Recipe recipe1 = new Recipe("Kisiel", "Dla klasy średniej. Poczuj się jak elita","Dodaj tyle i tyle", 15, 1, new File("kisiel.jpg"), RecipeCategory.SNACK, RecipeDifficultyLevel.EASY );
        Recipe recipe2 = new Recipe("Kurczak z ryżem", "Monotonnie, ale z klasą","Pamiętaj aby najpierw ubić kurczaka przed ugotowaniem ryżu", 45, 2,new File("chicken.jpg"), RecipeCategory.DINNER, RecipeDifficultyLevel.MODERATE);
        Recipe recipe3 = new Recipe("Krewetki burdyliańskie w kawiorze bumberiańskim ", "Zacznij dzień z godnością","Dodaj tyle i tyle", 20, 3,  new File("krewetki.jpg"),  RecipeCategory.BREAKFAST, RecipeDifficultyLevel.HARD);
        Recipe recipe4 = new Recipe("Kremówka", "Coś słodkiego","Tradycyjnie", 30, 4, new File("kremowka.jpg"), RecipeCategory.SNACK, RecipeDifficultyLevel.EASY);
        Recipe recipe5 = new Recipe("Kora drzewna", "Z braku laku","Gdy wyprowadzisz się od mamy", 10, 5, new File("kora.jpg"), RecipeCategory.SUPPER, RecipeDifficultyLevel.HARD);

        recipe1.addAuthor(author1);
        recipe2.addAuthor(author2);
        recipe3.addAuthor(author3);
        recipe4.addAuthor(author4);
        recipe5.addAuthor(author5);

        recipeRepository.save(recipe1);
        recipeRepository.save(recipe2);
        recipeRepository.save(recipe3);
        recipeRepository.save(recipe4);
        recipeRepository.save(recipe5);
    }
}
