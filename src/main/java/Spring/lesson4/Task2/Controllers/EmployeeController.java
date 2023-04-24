package Spring.lesson4.Task2.Controllers;

import Spring.lesson4.Task2.persistence.dao.services.interfaces.EmployeeServices;
import Spring.lesson4.Task2.persistence.models.Employee;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
    private static final Log LOG = LogFactory.getLog(EmployeeController.class);

    @Autowired
    private EmployeeServices employeeServices;

    @GetMapping(value = "/add")
    public String employee() {
        return "employees.jsp";
    }

    @PostMapping(value = "/add")
    public String addNewEmployee(HttpServletRequest request) {
        Employee employee = new Employee();

        employee.setName(request.getParameter("name"));
        employee.setSurname(request.getParameter("surname"));
        employee.setPhone(request.getParameter("phone"));
        employee.setEmail(request.getParameter("email"));
        employee.setPosition(request.getParameter("position"));

        try {
            LOG.info("New employee with id " + employeeServices.addEmployee(employee).getId() +
                    " was added!");
        } catch (Exception e){
            e.printStackTrace();
        }
        return "redirect:/employee/all";
    }

    @GetMapping(value = "/all")
    public ModelAndView listAllEmployees(ModelAndView modelAndView) {
        employeeServices.listAllEmployee();

        modelAndView.addObject("employees", employeeServices.findAll());
        modelAndView.setViewName("employees.jsp");
        return modelAndView;
    }

    @GetMapping(value = "/remove/{id}")
    public ModelAndView removeEmployeeById(@PathVariable("id") long id, ModelAndView modelAndView) {
        employeeServices.removeById(id);
        modelAndView.addObject("employees", employeeServices.findAll());
        modelAndView.setViewName("redirect:/employee/all");
        return modelAndView;
    }

    @PostMapping(value = "/findByName")
    public ModelAndView findEmployeeByName(@RequestParam("name") String name, ModelAndView modelAndView) {
        modelAndView.addObject("employees", employeeServices.findAllByName(name));

        modelAndView.setViewName("redirect:/employee/search-results.jsp");
        return modelAndView;
    }

    @PostMapping(value = "/findByNameAndPosition")
    public ModelAndView findEmployeeByNameAndPosition(@RequestParam("name") String name,
                                                      @RequestParam("position") String position,
                                                      ModelAndView modelAndView) {
        modelAndView.addObject("employees", employeeServices
                .findAllByNameAndPosition(name, position));

        modelAndView.setViewName("/employee/search-results.jsp");
        return modelAndView;
    }

    @PatchMapping(value = "/update")
    public ModelAndView update(@RequestParam("id") long id,
                               @RequestParam("position") String position,
                               ModelAndView modelAndView){
        employeeServices.updateEmployeeById(id, position);
        modelAndView.addObject("employees", employeeServices.findAll());
        modelAndView.setViewName("redirect:/employee/all");
        return modelAndView;
    }
}
