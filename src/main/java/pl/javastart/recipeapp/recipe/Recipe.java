package pl.javastart.recipeapp.recipe;

import jakarta.persistence.*;
import pl.javastart.recipeapp.author.Author;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@Entity
public class Recipe {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    @Column(length = 4000)
    private String text;
    private int timing;
    private int likes;

    private LocalDateTime addTime;
    private LocalDateTime editTime;

    @Lob
    private File image;
    @Enumerated(EnumType.STRING)
    private RecipeCategory category;
    @Enumerated(EnumType.STRING)
    private RecipeDifficultyLevel difficultyLevel;

    @ManyToOne()
    @JoinColumn(name = "author_id")
    private Author author;

    public Recipe() {
    }

    public Recipe(String name, String description, String text, int timing, int likes, File image, RecipeCategory category, RecipeDifficultyLevel difficultyLevel) {
        this.name = name;
        this.description = description;
        this.text = text;
        this.timing = timing;
        this.likes = likes;
        this.image = image;
        this.category = category;
        this.difficultyLevel = difficultyLevel;
        this.addTime = LocalDateTime.now().truncatedTo(ChronoUnit.MINUTES);
    }

    public LocalDateTime getEditTime() {
        return editTime;
    }

    public void setEditTime(LocalDateTime editTime) {
        this.editTime = editTime;
    }

    public File getImage() {
        return image;
    }

    public void setImage(File image) {
        this.image = image;
    }

    public void addAuthor(Author author) {
        setAuthor(author);
    }

    public int getLikes() {
        return likes;
    }

    public File getImageAddress() {
        return image;
    }

    public LocalDateTime getAddTime() {
        return addTime;
    }

    public void setAddTime(LocalDateTime addTime) {
        this.addTime = addTime;
    }

    public void setImageAddress(File image) {
        this.image = image;
    }

    public void setLikes(int likes) {
        this.likes = likes;
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
