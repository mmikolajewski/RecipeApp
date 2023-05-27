package pl.javastart.recipeapp.recipe;

public enum RecipeCategory {

    BREAKFAST("Śniadanie", "Lorem Ipsum is simply dummy text of the printing and typesetting industry. ", "breakfast.jpg"),
    DINNER("Obiad","Lorem Ipsum is simply dummy text of the printing and typesetting industry. ", "dinner.jpg"),
    SUPPER("Kolacja", "Lorem Ipsum is simply dummy text of the printing and typesetting industry. ", "supper.jpg"),
    SNACK("Przekąska", "Lorem Ipsum is simply dummy text of the printing and typesetting industry. ", "snack.jpg ");

    private final String description;
    private final String text;
    private final String imageAddress;

    RecipeCategory(String description, String text, String imageAddress) {
        this.description = description;
        this.text = text;
        this.imageAddress = imageAddress;
    }

    public String getDescription() {
        return description;
    }

    public String getText() {
        return text;
    }

    public String getImageAddress() {
        return imageAddress;
    }
}
