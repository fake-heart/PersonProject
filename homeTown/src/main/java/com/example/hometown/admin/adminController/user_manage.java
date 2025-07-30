package com.example.hometown.admin.adminController;


import com.example.hometown.admin.adminEntity.admin;
import com.example.hometown.admin.adminEntity.newUser;
import com.example.hometown.admin.adminEntity.userPage;
import com.example.hometown.admin.adminEntity.userPageResult;
import com.example.hometown.admin.adminService.userPageService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@Controller
@RequestMapping("/admin")
public class user_manage {
    @Autowired
    private userPageService userPageService;

    //跳转到用户管理页面
    @GetMapping("/user_manage")
    public String User_manage(@ModelAttribute userPage userPage,  Model model,  HttpSession session){
        if (session.getAttribute("loginAdmin") == null){
            return "redirect:/admin/login";
        }

        userPageResult<newUser> result = userPageService.page(userPage);
        model.addAttribute("records", result.getRecords());
        model.addAttribute("total", result.getTotal());
        model.addAttribute("page", userPage.getPage());
        model.addAttribute("pageSize", userPage.getPageSize());
        model.addAttribute("scenicPage", userPage); // 用于保留搜索条件

        // 计算总页数
        int totalPages = (int) Math.ceil((double) result.getTotal() /userPage.getPageSize());
        model.addAttribute("totalPages", totalPages);
        Object obj = session.getAttribute("loginAdmin");
        if (obj != null && obj instanceof admin) {
            String username = ((admin) obj).getUsername();
            model.addAttribute("username", username);
        }
        return "admin/user_manage";
    }
    //根据id查询用户
    @GetMapping("/user_edit")
    public String edit(Integer id, Model model){
        newUser newUser = userPageService.getById(id);
        model.addAttribute("newUser", newUser);
        return "admin/user_edit";
    }
    //修改用户信息
    @PostMapping("/user_update")
    public  String update(
            @RequestParam Integer id,
            @RequestParam String username,
            @RequestParam String phone,
            @RequestParam Integer userStatus,
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate updateTime,
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate createTime){
        newUser newUser = new newUser();
        newUser.setId(id);
        newUser.setUsername(username);
        newUser.setPhone(phone);
        newUser.setUserStatus(userStatus);
        newUser.setUpdateTime(updateTime);
        newUser.setCreateTime(createTime);
        userPageService.update(newUser);
        return "redirect:/admin/user_manage";
    }
//    添加用户
    @GetMapping("/user_add")
    public String addUser(){
        return "admin/user_add";
    }
    @PostMapping("/user_add")
    public String addUser(
            @RequestParam String username,
            @RequestParam String password,
            @RequestParam String phone,
            @RequestParam Integer userStatus,
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate updateTime,
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate createTime,
            Model model){
        newUser newUser = new newUser();
        newUser.setUsername(username);
        newUser.setPassword(password);
        newUser.setPhone(phone);
        newUser.setUserStatus(userStatus);
        newUser.setUpdateTime(updateTime);
        newUser.setCreateTime(createTime);
        userPageService.addUser(newUser);
        return "redirect:/admin/user_manage";
    }
    //注销用户
    @PostMapping("/user_delete")
    public String deleteUser(Integer id){
        userPageService.deleteUser(id);
        return "redirect:/admin/user_manage";
    }


}
