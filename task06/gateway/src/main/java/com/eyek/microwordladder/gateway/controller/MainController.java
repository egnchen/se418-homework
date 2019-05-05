package com.eyek.microwordladder.gateway.controller;

import com.eyek.microwordladder.gateway.dto.UserDto;
import com.eyek.microwordladder.gateway.dto.WordLadderDto;
import com.eyek.microwordladder.gateway.service.AuthenticationService;
import com.eyek.microwordladder.gateway.service.WordLadderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
public class MainController {

    @Autowired
    AuthenticationService authenticationService;
    @Autowired
    WordLadderService wordLadderService;

    @GetMapping("/")
    public String index(Model model, HttpSession session) {
        if(session.getAttribute("token") == null)
            return "redirect:login";
        else
            return "index";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/login")
    public String doLogin(String username, String password, Model model, HttpSession session) {
        UserDto userDto = new UserDto();
        userDto.setUsername(username);
        userDto.setPassword(password);
        String token = authenticationService.login(userDto);
        if(token != null) {
            session.setAttribute("token", token);
            return "index";
        } else {
            model.addAttribute("status", "Error username or password");
            return "login";
        }
    }

    @GetMapping("/get-ladder")
    public String getLadder(
            @RequestParam String src, @RequestParam String dst,
            Model model, HttpSession session) {
        String token = session.getAttribute("token").toString();
        if(token == null)
            return "redirect:login";
        WordLadderDto ladder = wordLadderService.getWordLadder(src, dst, token);
        model.addAttribute("ladder", ladder);
        return "ladder";
    }
}
