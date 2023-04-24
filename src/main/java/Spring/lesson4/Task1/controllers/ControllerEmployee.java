package Spring.lesson4.Task1.controllers;

import Spring.lesson4.Task1.dao.EmployeeDAO;
import Spring.lesson4.Task1.models.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/employees")
public class ControllerEmployee {
    private EmployeeDAO personDAO;

    @Autowired
    public ControllerEmployee(EmployeeDAO personDAO) {
        this.personDAO = personDAO;
    }

    @GetMapping()
    public String index(Model model){
        model.addAttribute("employees", personDAO.index());
        return "employees/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model){
        model.addAttribute("employee", personDAO.show(id));
        return "employees/show";
    }

    @GetMapping("/new")
    public String newEmployee(@ModelAttribute("employee")Employee employee){
        return "employees/new";
    }

    @PostMapping()
    public String create(@ModelAttribute("employee") @Valid Employee employee, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return "employees/new";
        }
        personDAO.save(employee);
        return "redirect:/employees";
    }

    @GetMapping("/{id}/edit")
    public String edit (Model model, @PathVariable("id") int id){
        model.addAttribute("employee", personDAO.show(id));
        return "employees/edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("employee") @Valid Employee employee, BindingResult bindingResult,
                         @PathVariable("id") int id){
        if (bindingResult.hasErrors()){
            return "employees/edit";
        }
        personDAO.update(id, employee);
        return "redirect:/employees";
    }

    @DeleteMapping("/{id}")
    public String remove(@PathVariable("id") int id){
        personDAO.remove(id);
        return "redirect:/people";
    }
}

