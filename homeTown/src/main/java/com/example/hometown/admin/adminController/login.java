package com.example.hometown.admin.adminController;

import com.example.hometown.admin.adminEntity.admin;
import com.example.hometown.admin.adminService.adminLogin;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/admin")
@Slf4j
public class login {
    @Autowired
    private com.example.hometown.admin.adminService.adminLogin adminLogin;

    //跳转到登录页面
    @GetMapping("/login")
    public String login(@ModelAttribute("admin") admin admin){

        return "admin/login";
    }
    @PostMapping("/login")
    public String logins(@ModelAttribute("admin") admin admin, Model model, HttpSession session) {

        String username = admin.getUsername();
        String password = admin.getPassword();

        List<admin> adminList = adminLogin.selectAdmin(username, password);
        if (adminList == null || adminList.isEmpty()) {
            model.addAttribute("errorMessage", "用户名或密码错误");
            return "admin/login";
        }
        // 可选：传递登录用户的部分信息用于展示
        model.addAttribute("admin", adminList);
        session.setAttribute("loginAdmin", adminList.get(0));
        return "redirect:/admin/admin";
    }

}
