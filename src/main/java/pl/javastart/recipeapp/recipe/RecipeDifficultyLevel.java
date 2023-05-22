package pl.javastart.recipeapp.recipe;

public enum RecipeDifficultyLevel {
    EASY("Podstawowe umiejętności"), MODERATE("Wymagane dodatkowe doświadczenie"), HARD("Stalowe nerwy");

    private final String description;

    RecipeDifficultyLevel(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
