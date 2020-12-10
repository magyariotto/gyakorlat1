package com.github.magyariotto.controller;

import com.github.magyariotto.request.UsernameRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@Controller
public class PageController {
    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/ajax_input")
    public String ajaxInput() {
        return "ajax_input";
    }

    @PostMapping("/input")
    public ModelAndView input(UsernameRequest request) {
        log.info("/input - request: {}", request);
        ModelAndView mav = new ModelAndView("input");
        mav.addObject("username", request.getUsername());
        return mav;
    }
}
