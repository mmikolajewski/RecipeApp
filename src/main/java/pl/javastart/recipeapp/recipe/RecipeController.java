package pl.javastart.recipeapp.recipe;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.javastart.recipeapp.category.Category;
import java.util.List;

@Controller
public class RecipeController {

    private RecipeService recipeService;

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @GetMapping("/recipe")
    public String recipe(@RequestParam Long id, Model model) {
        Recipe recipe = recipeService.findById(id);
        model.addAttribute("recipe", recipe);
        return "recipe";
    }

    @GetMapping("/add")
    public String dataEntryForm(Model model) {
        Recipe recipe = new Recipe();
        model.addAttribute("categoryElement", recipeService.findCategories());
        model.addAttribute("recipeToCreate", recipe);
        return "add";
    }
    @GetMapping("/edit")
    public String editForm(@RequestParam(required = false) Long id, Model model) {
        model.addAttribute("categoryElement", recipeService.findCategories());
        Recipe recipe = recipeService.findById(id);
        model.addAttribute("recipeToCreate", recipe);
        return "add";
    }

    @PostMapping("/save")
    public String addRecipe(Recipe recipe) {
        if (recipe.getId() != null) {
            recipeService.editRecipeParameters(recipe);
            return "redirect:/recipe?id=" + recipe.getId();
        } else {
            recipeService.addAddTimeAndSave(recipe);
            return "redirect:/list";
        }
    }

    @GetMapping("/delete")
    public String deleteRecipe(@RequestParam Long id) {
        recipeService.deleteRecipeIfExist(id);
        return "redirect:/";
    }

    @GetMapping("/list")
    public String list(Model model) {
        List<Recipe> recipes = recipeService.findAll();
        model.addAttribute("recipes", recipes);
        return "list";
    }

    @GetMapping("/category")
    public String category(Model model, @RequestParam Long id) {
        List<Recipe> recipesByCategory = recipeService.findAllByCategory(id);
        Category category = recipeService.findCategory(id);
        model.addAttribute("category", category);
        model.addAttribute("recipes", recipesByCategory);
        return "category";
    }

    @GetMapping("/like/{id}")
    public String like(@PathVariable("id") Long id,
                 @RequestHeader String referer) {
        recipeService.likeRecipe(id);
        return "redirect:" + referer;
    }
}


