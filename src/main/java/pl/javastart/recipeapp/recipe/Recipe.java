package pl.javastart.recipeapp.recipe;

import jakarta.persistence.*;
import pl.javastart.recipeapp.author.Author;

@Entity
public class Recipe {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private String text;
    private int timing;
    @Enumerated
    private RecipeCategory category;
    @Enumerated
    private RecipeDifficultyLevel difficultyLevel;

    @ManyToOne()
    @JoinColumn(name = "author_id")
    private Author author;

    public Recipe() {
    }

    public Recipe(String name, String description, String text, int timing, RecipeCategory category, RecipeDifficultyLevel difficultyLevel, Author author) {
        this.name = name;
        this.description = description;
        this.text = text;
        this.timing = timing;
        this.category = category;
        this.difficultyLevel = difficultyLevel;
        this.author = author;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getTiming() {
        return timing;
    }

    public void setTiming(int timing) {
        this.timing = timing;
    }

    public RecipeCategory getCategory() {
        return category;
    }

    public void setCategory(RecipeCategory category) {
        this.category = category;
    }

    public RecipeDifficultyLevel getDifficultyLevel() {
        return difficultyLevel;
    }

    public void setDifficultyLevel(RecipeDifficultyLevel difficultyLevel) {
        this.difficultyLevel = difficultyLevel;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Recipe{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", text='" + text + '\'' +
                ", timing=" + timing +
                ", category=" + category +
                ", difficultyLevel=" + difficultyLevel +
                ", author=" + author +
                '}';
    }
}
