package com.krokodillLl.promoSite.controller;

import com.krokodillLl.promoSite.domain.User;
import com.krokodillLl.promoSite.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class RegistrationController {

    private PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
    @Autowired
    private UserService userService;
    @Autowired
    private AuthenticationManager authManager;

    private Logger logger = LoggerFactory.getLogger(RegistrationController.class);

    @GetMapping("/registration")
    public String getRegistration(Model model) {

        return"registration";
    }

    @PostMapping("/registration")
    public String addUser(User user, HttpServletRequest request, Model model) {
        if (!userService.addUser(user)) {
            model.addAttribute("error", "Я уже зарегистрирован, а другие аккаунты мне пока не нужны с:");
            logger.info("error registration");
            return "registration";
        }
        login(request, user);
        return "login";
    }

    public void login(HttpServletRequest req, User user) {
        UsernamePasswordAuthenticationToken authReq
                = new UsernamePasswordAuthenticationToken(user.getEmail(), passwordEncoder.encode(user.getPassword()));
        Authentication auth = authManager.authenticate(authReq);
        SecurityContext sc = SecurityContextHolder.getContext();
        sc.setAuthentication(auth);
    }
}
