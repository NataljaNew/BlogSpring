//package com.example.blogspring.controller;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.validation.BindingResult;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//import javax.validation.Valid;
//
//@Controller
//@RequestMapping("/public/users")
//public class UserRegistrationController {
//
//    private static final Logger LOG = LoggerFactory.getLogger(UserRegistrationController.class);
//
//    private final UserRegistrationValidator userRegistrationValidator;
//    private final UserService userService;
//
//    public UserRegistrationController(UserRegistrationValidator userRegistrationValidator,UserService userService) {
//        this.userRegistrationValidator = userRegistrationValidator;
//        this.userService = userService;
//    }
//
//    @GetMapping("/create")
//    public String openRegistrationPage(Model model){
//        model.addAttribute("userRegistration", new UserRegistration());
//        LOG.info("user registration opened ");
//        return "userRegistration";
//    }
//
//    @PostMapping("/create")
//    public String createUser(@Valid UserRegistration userRegistration, BindingResult bindingResult){
//        userRegistrationValidator.validate(userRegistration, bindingResult);
//        if(bindingResult.hasErrors()){
//            LOG.warn("user cannot be created {}", userRegistration);
//            return "userRegistration";
//        }
//
//        userService.createNewUser(userRegistration);
//
//        return "redirect:/public/users/create";
//    }
//
//}
