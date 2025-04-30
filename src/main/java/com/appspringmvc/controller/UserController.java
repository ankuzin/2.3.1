package com.appspringmvc.controller;

import com.appspringmvc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String getAllUsers(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "listUser";
    }

    @GetMapping("/add")
    public String showAddForm() {
        return "addUser";
    }

    @GetMapping("/edit")
    public String showEditForm(@RequestParam("id") Long id, Model model) {
        model.addAttribute("user", userService.getUserById(id));
        return "editUser";
    }

    @PostMapping("/delete")
    public String deleteUser(@RequestParam("id") Long id) {
        userService.deleteUser(id);
        return "redirect:/";
    }

    @PostMapping("/add")
    public String addUser(
            @RequestParam("name") String name,
            @RequestParam("address") String address,
            @RequestParam(value = "email", required = false) String email) {
        userService.createUser(name, address, email);
        return "redirect:/";
    }

    @PostMapping("/update")
    public String updateUser(
            @RequestParam("id") Long id,
            @RequestParam("name") String name,
            @RequestParam("address") String address,
            @RequestParam(value = "email", required = false) String email) {
        userService.updateUser(id, name, address, email);
        return "redirect:/";
    }
}