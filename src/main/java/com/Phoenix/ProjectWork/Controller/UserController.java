package com.Phoenix.ProjectWork.Controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import com.Phoenix.ProjectWork.Repository.UserRepository;
import com.Phoenix.ProjectWork.Service.UserAuthenticationService;
import com.Phoenix.ProjectWork.dto.AuthenticationRequest;
import com.Phoenix.ProjectWork.dto.AuthenticationResponse;
import com.Phoenix.ProjectWork.dto.UserDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.Phoenix.ProjectWork.Service.UserService;

@Controller
@RequestMapping("/api/auth")
public class UserController {


    private final UserRepository userRepository;
    private final UserAuthenticationService userAuthenticationService;
    private final UserService userService;

    public UserController(UserService userservice, UserRepository userRepository, UserAuthenticationService userAuthenticationService, UserService userService) {
        this.userRepository = userRepository;
        this.userAuthenticationService = userAuthenticationService;
        this.userService = userService;
    }


    @GetMapping
    public String getHome() {
        return "UserLogin";
    }


    @PostMapping("/signup")
    public String createUser(@Valid @ModelAttribute UserDto userDto, Model model) {
        try {
            userService.register(userDto);
            return "UserLogin";

        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("processError", e.getMessage());
            return "UserLogin";
        }
    }

    @PostMapping("/login")
    public String authenticate(
            @RequestBody AuthenticationRequest authenticationRequest,
            Model model,
            HttpSession session) {
        AuthenticationResponse user = userAuthenticationService.authenticate(authenticationRequest);
        if (user != null) {
            session.setAttribute("activeuser", user);
            return "Home";
        }
        model.addAttribute("error", "User not found");
        return "UserLogin";
    }

}
