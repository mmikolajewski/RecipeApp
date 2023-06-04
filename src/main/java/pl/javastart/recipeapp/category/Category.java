package pl.javastart.recipeapp.category;

import jakarta.persistence.*;
import pl.javastart.recipeapp.recipe.Recipe;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nameInPL;
    @Column(length = 500)
    private String text;
    private String imageAddress;
    @OneToMany(mappedBy = "category")
    private List<Recipe> recipes = new ArrayList<>();

    public Category() {
    }

    public Category(String nameInPL, String text, String imageAddress) {
        this.nameInPL = nameInPL;
        this.text = text;
        this.imageAddress = imageAddress;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameInPL() {
        return nameInPL;
    }

    public void setNameInPL(String nameInPL) {
        this.nameInPL = nameInPL;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getImageAddress() {
        return imageAddress;
    }

    public void setImageAddress(String imageAddress) {
        this.imageAddress = imageAddress;
    }
}


