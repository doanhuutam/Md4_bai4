package Controller;

import dao.UserDao;
import model.Login;
import model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {
@GetMapping("/home")
    public ModelAndView home(){
    ModelAndView modelAndView=new ModelAndView("/home","login" ,new Login());
    return modelAndView;
}
@PostMapping("/login")
    public ModelAndView login(@ModelAttribute("login") Login login){

    User userDao=UserDao.checklogin(login);

    if (userDao== null){
        ModelAndView modelAndView=new ModelAndView("/error");
        return modelAndView;
    }else {
        ModelAndView modelAndView=new ModelAndView("/user");
        modelAndView.addObject("user",userDao);
        return modelAndView;
    }

}

}
