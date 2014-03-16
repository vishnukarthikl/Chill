package com.github.vishnukarthik.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class HomeController {

    @RequestMapping(value = "/")
    public String test(HttpServletResponse response) throws IOException {
        System.out.println("something");
        return "/layouts/home";
    }
}
