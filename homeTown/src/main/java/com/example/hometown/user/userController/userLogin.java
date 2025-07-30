package com.example.hometown.user.userController;

import com.example.hometown.user.Mapper.LoginMapper;
import com.example.hometown.user.userEntity.user;
import jakarta.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/user")
public class userLogin {
    private static final Logger log = LoggerFactory.getLogger(userLogin.class);
    @Autowired
    private LoginMapper  loginMapper;
    //跳转用户登录
    @GetMapping("/login")
    public String login(@ModelAttribute("user") user user,  Model model) {
        model.addAttribute("user",new user());
        return "user/login";
    }

    @PostMapping("/login")
    public String userLogin(@ModelAttribute("user") user user, Model model, HttpSession session) {

    String username = user.getUsername();
    String password = user.getPassword();

        List<user> userList = loginMapper.selectUser(username,  password);
        if (userList==null||userList.isEmpty()){
            model.addAttribute("error","用户名或密码错误");
            return "user/login";
        }
        model.addAttribute("user",userList);
        // 将用户对象存入 Session（关键步骤）
        session.setAttribute("loginUser", userList.get(0));
        return "redirect:/user/user";
    }

}
