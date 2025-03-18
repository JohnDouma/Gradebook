package disorg.douma.gradebook.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {

    @GetMapping
    public String helloWorld(Model model) {
        model.addAttribute("message", "Welcome to the Gradebook");
        return "welcome";
    }
}
