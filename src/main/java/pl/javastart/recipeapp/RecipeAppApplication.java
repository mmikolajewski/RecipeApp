package pl.javastart.recipeapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import pl.javastart.recipeapp.category.Category;
import pl.javastart.recipeapp.category.CategoryRepository;
import pl.javastart.recipeapp.recipe.Recipe;
import pl.javastart.recipeapp.recipe.RecipeDifficultyLevel;
import pl.javastart.recipeapp.recipe.RecipeRepository;

@SpringBootApplication
public class RecipeAppApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(RecipeAppApplication.class, args);
        CategoryRepository CategoryRepository = context.getBean(CategoryRepository.class);
        RecipeRepository recipeRepository = context.getBean(RecipeRepository.class);
        save(CategoryRepository, recipeRepository);
    }

    private static void save(CategoryRepository categoryRepository, RecipeRepository recipeRepository) {
        Category Category1 = new Category("Śniadanie","Śniadanie to taka fajna rzecz...coś tam coś", "breakfast.jpg");
        Category Category2 = new Category("Objad", "Objad to taka fajna rzecz...coś tam coś", "dinner.jpg" );
        Category Category3 = new Category("Kolacja", "Kolacja to taka fajna rzecz...coś tam coś", "supper.jpg" );
        Category Category4 = new Category("Przekąska", "Przekaska to taka fajna rzecz...coś tam coś", "snack.jpg" );
        categoryRepository.save(Category1);
        categoryRepository.save(Category2);
        categoryRepository.save(Category3);
        categoryRepository.save(Category4);

        Recipe recipe1 = new Recipe("Kisiel", "Dla klasy średniej. Poczuj się jak elita","Dodaj tyle i tyle", 15, 1, "kisiel.jpg", RecipeDifficultyLevel.EASY, "Tomasz Zajadał" );
        Recipe recipe2 = new Recipe("Kurczak z ryżem", "Monotonnie, ale z klasą","Opis przepisu\n" +
                "\n" +
                "Kurczak z ryżem to danie banalnie proste do przygotowania. Bardzo sycące i jednocześnie smaczne. Przyznam, że jak tylko zaczęłam studia i zamieszkałam sama to robiłam sobie takiego kurczaka z ryżem i warzywami naprawdę często.\n" +
                "\n" +
                "Ryż z kurczakiem i warzywami\n" +
                "Ten szybki do przygotowania ryż z kurczakiem i warzywami to świetny pomysł na obiad. To danie jednogarnkowe można śmiało przygotować sobie z podwójnej porcji żeby mieć posiłki na 2-3 dni do przodu. Bez problemu zapakujesz go sobie także do szczelnie zapakowanego pudełka jako obiad na wynos do pracy!\n" +
                "\n" +
                "Ja najczęściej wykonuję ryż z kurczakiem wraz z kolorowymi paprykami, ale równie dobrze możesz je zastąpić pieczarkami, cukinią, brokułami czy użyć jakiejś gotowej mrożonki ze sklepu np. mix warzyw na patelnię. Chcesz wzbogacić smak tego dania? Proponuję dodać odrobinę gotowego sosu słodko-kwaśnego lub słodki sos chili, który można bez problemu kupić w każdym większym sklepie na dziale kuchni azjatyckiej. Palce lizać!\n" +
                "\n" +
                "Przepis na: Kurczak z ryżem\n" +
                "Składniki:\n" +
                "\n" +
                "700 g piersi z kurczaka\n" +
                "2 ząbki czosnku\n" +
                "szczypta curry\n" +
                "szczypta pieprzu czarnego\n" +
                "2 łyżki oliwy\n" +
                "1/2 łyżeczki przyprawy do kurczaka lub gyrosa\n" +
                "papryka czerwona, zielona i żółta\n" +
                "większa szczypta papryki słodkiej\n" +
                "50 ml wody lub bulionu\n" +
                "200 g ryżu białego (waga przed ugotowaniem, dwie saszetki)\n" +
                "sól i pieprz do smaku", 45, 2,"chicken.jpg", RecipeDifficultyLevel.MODERATE,"Anna Zajadał");

        Recipe recipe3 = new Recipe("Krewetki burdyliańskie w kawiorze bumberiańskim ", "Zacznij dzień z godnością","Dodaj tyle i tyle", 20, 3, "krewetki.jpg", RecipeDifficultyLevel.HARD,"Irena Przekąska");
        Recipe recipe4 = new Recipe("Kremówka", "Coś słodkiego","Tradycyjnie", 30, 4, "kremowka.jpg", RecipeDifficultyLevel.EASY,"Anna Wiatr");
        Recipe recipe5 = new Recipe("Kora drzewna", "Z braku laku","Gdy wyprowadzisz się od mamy", 10, 5, "kora.jpg" , RecipeDifficultyLevel.HARD,"Tomasz Stypa");

        recipe1.addCategory(Category4);
        recipe2.addCategory(Category2);
        recipe3.addCategory(Category1);
        recipe4.addCategory(Category4);
        recipe5.addCategory(Category3);

        recipeRepository.save(recipe1);
        recipeRepository.save(recipe2);
        recipeRepository.save(recipe3);
        recipeRepository.save(recipe4);
        recipeRepository.save(recipe5);
    }
}

