package pl.javastart.recipeapp.recipe;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class RecipeController {

    private RecipeService recipeService;

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @GetMapping("/recipe")
    public String recipe(@RequestParam Long id, Model model) {
        Optional<Recipe> optionalRecipe = recipeService.findById(id);
        if (optionalRecipe.isPresent()) {
            Recipe recipe = optionalRecipe.get();
            model.addAttribute("recipe", recipe);
            return "recipe";
        } else {
            return "redirect:/e";
        }
    }

    @GetMapping("/add")
    public String recipeToCreate(@RequestParam(required = false) Long id, Model model) {
        model.addAttribute("categoryElement", recipeService.findCategories());

        if (id == null) {
            Recipe recipe = new Recipe();
            model.addAttribute("recipeToCreate", recipe);
            return "add";
        } else {
            Optional<Recipe> taskOptional = recipeService.findById(id);
            if (taskOptional.isPresent()) {
                Recipe recipe = taskOptional.get();
                model.addAttribute("recipeToCreate", recipe);
                return "add";
            }
        }
        return "redirect:/";
    }

    @PostMapping("/add")
    public String addRecipe(Recipe recipe) {

        if (recipe.getId() != null) {
            Optional<Recipe> returnedRecipe = recipeService.findById(recipe.getId());
            if (returnedRecipe.isPresent()) {
                Recipe recipe1 = RecipeService.editRecipeParameters(recipe, returnedRecipe);
                recipeService.save(recipe1);
                return "redirect:/recipe?id=" + recipe.getId();
            }
        } else {
            return recipeService.addAddTimeAndSave(recipe);
        }
        return "redirect:/";
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
        recipeService.addCategoryAtrubiteAndRecipeList(model, id);
        return "/category";
    }

    @GetMapping("/like/{id}")
    public String like(@PathVariable("id") Long id,
                 @RequestHeader String referer) {
        return recipeService.getLikeRecipe(id, referer);
    }





}


