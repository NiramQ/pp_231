package avm.web.controllers;

import avm.web.models.Person;
import avm.web.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("")
    public String getListUsers(Model model) {
        model.addAttribute("user", userService.getListUsers());
        return "main";
    }

    @GetMapping("new")
    public String getNewPerson(Model model) {
        model.addAttribute("user", new Person());
        return "new";
    }

    @PostMapping("new")
    public String setNewPerson(@ModelAttribute("user") Person user) {
        userService.saveUser(user);
        return "redirect:/";
    }

    @GetMapping("edit/{id}")
    public String getPersonForEdit(Model model, @PathVariable("id") int id) {
        model.addAttribute("user", userService.getUserById(id));
        return "edit";
    }

    @DeleteMapping("edit/{id}")
    public String deletePerson(@PathVariable("id") int id) {
        userService.removeUser(id);
        return "redirect:/";
    }

    @PatchMapping("edit/{id}")
    public String updatePerson(@ModelAttribute("user") Person user, @PathVariable("id") int id) {
        userService.updateUser(user, id);
        return "redirect:/";
    }
}