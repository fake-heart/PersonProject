package com.example.hometown.user.userController;

import com.example.hometown.user.userEntity.user;
import com.example.hometown.user.userService.registerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class userRegister {
    @Autowired
    private registerService registerService;
    //跳转到注册页面
    @GetMapping("/register")
    public String register(@ModelAttribute("user") user user)
    {

        return "user/register";
    }
    //用户注册
    @PostMapping("/register")
    public String registers(@ModelAttribute("user")user user, Model model){
        if (!user.getPassword().equals(user.getRePassword())){
            model.addAttribute("error","密码不一致");
            return "user/register";
        }
        registerService.insertUser(user);
        model.addAttribute("user",user);
        return "redirect:/user/login";

    }

}
