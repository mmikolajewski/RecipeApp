package pl.javastart.recipeapp.recipe;

public enum RecipeDifficultyLevel {
    EASY("Łatwy"), MODERATE("Średni"), HARD("Trudny");

    private final String description;

    RecipeDifficultyLevel(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
