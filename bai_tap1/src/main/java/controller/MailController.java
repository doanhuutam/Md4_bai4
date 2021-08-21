package controller;

import model.Email;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.beans.IntrospectionException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class MailController {
    @GetMapping("/seting")
    public String show(Model model) {
        model.addAttribute("list", new Email());
        return "/index1";
    }

    @ModelAttribute("language")
    public Map<String, String> getlanguage() {
        Map<String, String> language = new HashMap<String, String>();
        language.put("tiengviet", "tiengviet");
        language.put("tienganh", "tienganh");
        language.put("tiengtay", "tiengtay");
        return language;
    }

    @ModelAttribute("size")
    public List<Integer> getsize() {
        List<Integer> size = new ArrayList<>();
        size.add(5);
        size.add(25);
        size.add(50);
        size.add(75);
        return size;
    }

    @PostMapping("/show")
    public ModelAndView show(@ModelAttribute("list") Email email) {
        ModelAndView modelAndView = new ModelAndView("/result");
        modelAndView.addObject("list", email);
        return modelAndView;

    }

}

