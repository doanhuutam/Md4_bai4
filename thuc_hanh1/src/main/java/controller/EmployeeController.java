package controller;
import model.EmployList;
import model.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EmployeeController {

   EmployList lista =new EmployList();
   @RequestMapping("/employ")

   public ModelAndView show(){
      ModelAndView modelAndView=new ModelAndView("/info");
      modelAndView.addObject("list",  lista.list);
      return modelAndView;
   }
   @GetMapping("create")
   public ModelAndView showcreate(){
      ModelAndView modelAndView=new ModelAndView("/create");
      modelAndView.addObject("list",new Employee());
      return modelAndView;
   }
   @PostMapping("create")
   public ModelAndView create(@ModelAttribute Employee employee){
      lista.save(employee);
      return new ModelAndView("redirect:/employ");
   }

}
