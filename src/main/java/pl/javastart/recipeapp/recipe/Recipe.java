package pl.javastart.recipeapp.recipe;

import jakarta.persistence.*;
import pl.javastart.recipeapp.category.Category;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@Entity
public class Recipe {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    @Column(length = 10000)
    private String text;
    private int timing;
    private int likes;
    private LocalDateTime addTime;
    private LocalDateTime editTime;
    private String author;
    @Lob
    private String imageAddress;
    @Enumerated(EnumType.STRING)
    private RecipeDifficultyLevel difficultyLevel;
    @ManyToOne()
    @JoinColumn(name = "category_id")
    private Category category;

    public Recipe() {
    }

    public Recipe(String name, String description, String text, int timing, int likes, String imageAddress, RecipeDifficultyLevel difficultyLevel, String author) {
        this.name = name;
        this.description = description;
        this.text = text;
        this.timing = timing;
        this.likes = likes;
        this.addTime = LocalDateTime.now().truncatedTo(ChronoUnit.MINUTES);
        this.imageAddress = imageAddress;
        this.difficultyLevel = difficultyLevel;
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
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

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public LocalDateTime getAddTime() {
        return addTime;
    }

    public void setAddTime(LocalDateTime addTime) {
        this.addTime = addTime;
    }

    public LocalDateTime getEditTime() {
        return editTime;
    }

    public void setEditTime(LocalDateTime editTime) {
        this.editTime = editTime;
    }

    public String getImageAddress() {
        return imageAddress;
    }

    public void setImageAddress(String imageAddress) {
        this.imageAddress = imageAddress;
    }

    public RecipeDifficultyLevel getDifficultyLevel() {
        return difficultyLevel;
    }

    public void setDifficultyLevel(RecipeDifficultyLevel difficultyLevel) {
        this.difficultyLevel = difficultyLevel;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public void addCategory(Category category) {
        setCategory(category);
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
                '}';
    }
}
