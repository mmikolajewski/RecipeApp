package pl.javastart.recipeapp.recipe;

public enum RecipeCategory {

    BREAKFAST("Śniadanie"), DINNER("Objad"), SUPPER("Kolacja"), SNACK("Przekąska");

    private final String description;

    RecipeCategory(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
