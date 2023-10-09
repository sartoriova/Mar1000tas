package br.edu.ifsp.dsw3.mar1000tas.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home(){
        return "/marmita/lista";
    }

}
