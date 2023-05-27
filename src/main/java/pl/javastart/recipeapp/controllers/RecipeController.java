package pl.javastart.recipeapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import pl.javastart.recipeapp.recipe.Recipe;
import pl.javastart.recipeapp.recipe.RecipeCategory;
import pl.javastart.recipeapp.recipe.RecipeRepository;
import pl.javastart.recipeapp.recipe.RecipeService;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;

@Controller
public class RecipeController {

    private static final String UPLOADED_FOLDER = "/resources/static";
    private RecipeService recipeService;
    private RecipeRepository recipeRepository;

    public RecipeController(RecipeService recipeService, RecipeRepository recipeRepository) {
        this.recipeService = recipeService;
        this.recipeRepository = recipeRepository;
    }

    @GetMapping("/recipe")
    public String recipe(@RequestParam Long id, Model model, RedirectAttributes ra) {
        Optional<Recipe> optionalRecipe = recipeService.findById(id);
        if (optionalRecipe.isPresent()) {
            Recipe recipe = optionalRecipe.get();
            model.addAttribute("recipe", recipe);
            return "recipe";
        } else {
            ra.addFlashAttribute("flashAttr", "Nie odnaleziono szukanego przepisu");
            return "redirect:/error/{id}";
        }
    }

    @GetMapping("/edit")
    public String showRecipeEditForm(@RequestParam Long id, Model model) {
        Optional<Recipe> taskOptional = recipeRepository.findById(id);

        if (taskOptional.isPresent()) {
            Recipe recipe = taskOptional.get();
            model.addAttribute("recipeToEdit", recipe);

            return "editRecipe";
        } else {
            return "redirect:/";
        }
    }

    @PostMapping("/edit")
    public String editRecipe(Recipe recipe) {
        Optional<Recipe> returnedRecipe = recipeRepository.findById(recipe.getId());

        if (returnedRecipe.isPresent()) {
            Recipe recipe1 = returnedRecipe.get();
            recipe1.setName(recipe.getName());
            recipe1.setDescription(recipe.getDescription());
            recipe1.setCategory(recipe.getCategory());
            recipe1.setText(recipe.getText());
            recipe1.setTiming(recipe.getTiming());
            recipe1.setEditTime(LocalDateTime.now().truncatedTo(ChronoUnit.MINUTES));

            recipeRepository.save(recipe1);
            return "redirect:/recipe?id=" + recipe.getId();
        }
        return "redirect:/";
    }

    @GetMapping("/delete")
    public String deleteRecipe(@RequestParam Long id) {
        Optional<Recipe> taskOptional = recipeRepository.findById(id);

        if (taskOptional.isPresent()) {
            Recipe recipe = taskOptional.get();
            recipeRepository.delete(recipe);

            return "redirect:/";
        } else {
            return "redirect:/";
        }
    }

    @RequestMapping("error/{id}")
    public String handleRequest (@PathVariable("id") String id,
                                 @ModelAttribute("flashAttr") String flashAttr,
                                 Model model) {

        model.addAttribute("id", id);
        model.addAttribute("flashAttr", flashAttr+"");
        return "e";
    }


    @GetMapping("/list")
    public String home(Model model,  @RequestParam(required = false) RecipeCategory category) {
        List<Recipe> recipes;

        if (category != null) {
            recipes = recipeService.findByCategory(category);
        } else {
            recipes = recipeService.findAll();
        }

        model.addAttribute("recipes", recipes);
        return "list";

    }
    @GetMapping("/add")
    public String taskToCreate(Model model) {
        Recipe recipe = new Recipe();
        model.addAttribute("recipeToCreate", recipe);
        return "add";
    }

    @PostMapping("/add")
    public String addTask(Recipe recipe) {
        recipe.setAddTime(LocalDateTime.now().truncatedTo(ChronoUnit.MINUTES));
        recipeRepository.save(recipe);

        return "redirect:/list";
    }

    @GetMapping("{page}/like/{id}")
    public String like(@PathVariable("id") Long id,
                       Model model, RedirectAttributes ra,
                       @PathVariable(value = "page", required = false)  String page) {

        Optional<Recipe> optionalRecipe = recipeService.findById(id);
        if (optionalRecipe.isPresent()) {
            Recipe recipe = optionalRecipe.get();
            recipe.setLikes(recipe.getLikes() + 1);
            recipeRepository.save(recipe);
            if (page.equals("main") ) {
                return "redirect:/";
            }
            return "redirect:/{page}";
        }
        return "redirect:/{page}";
    }


}


