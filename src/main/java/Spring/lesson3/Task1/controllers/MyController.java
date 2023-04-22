package Spring.lesson3.Task1.controllers;

import Spring.lesson3.Task1.dao.PersonDAO;
import Spring.lesson3.Task1.models.Person;
import org.apache.log4j.PropertyConfigurator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/people")
public class MyController {
    private final PersonDAO personDAO;
    private static int count = 0;

    @Autowired
    public MyController(PersonDAO personDAO){
        this.personDAO = personDAO;
    }

    @GetMapping()
    public String index(Model model){
        model.addAttribute("people", personDAO.index());
        String log4jConfPath = "C:\\Users\\Вова\\IdeaProjects\\Java_ITVDN\\JavaSpring\\src\\main\\resources\\log4j.properties";
        PropertyConfigurator.configure(log4jConfPath);
        return "people/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model){
        model.addAttribute("person", personDAO.show(id));
        return "people/show";
    }

    @GetMapping("/new")
    public String newPerson(@ModelAttribute("person") Person person){
        return "people/new";
    }

    @PostMapping()
    public String create(@ModelAttribute("person") @Valid Person person,
                         BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return "people/new";
        }
        personDAO.save(person);
        personDAO.saveToFile(person);
        count++;
        return "redirect: people/success";
    }

    @GetMapping("/success")
    public String success(Model model){
        model.addAttribute("count", count);
        return "people/success";
    }

    @GetMapping("/data")
    public String data(Model model){
        model.addAttribute("data", personDAO.showFile());
        return "people/data";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id){
        model.addAttribute("person", personDAO.show(id));
        return "people/edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("person") @Valid Person person,
                         BindingResult bindingResult, @PathVariable("id") int id){
        if (bindingResult.hasErrors()){
            return "people/edit";
        }
        personDAO.update(id, person);
        return "redirect: /people";
    }

    @DeleteMapping("/{id}")
    public String remove(@PathVariable("id") int id){
        personDAO.remove(id);
        return "redirect: /people";
    }
}
