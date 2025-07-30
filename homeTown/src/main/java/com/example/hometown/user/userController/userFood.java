package com.example.hometown.user.userController;

import com.example.hometown.admin.adminEntity.food;
import com.example.hometown.user.userEntity.user;
import com.example.hometown.user.userService.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/user")
public class userFood {
    @Autowired
    private UserService userService;

    // 跳转到美食页面
    @RequestMapping("/food")
    public String food(Model model, HttpSession session) {
        if (session.getAttribute("loginUser") == null){
            return "redirect:/user/login";
        }
        List food = userService.SelectAllFood();
        model.addAttribute("food", food);
        Object obj = session.getAttribute("loginUser");
        if (obj != null && obj instanceof user) {
            String username = ((user) obj).getUsername();
            model.addAttribute("username", username);
        }
        return "user/food";
    }
    //根据美食名称搜索美食
    @PostMapping("/food/search")
    public String search(@RequestParam String name, Model model, HttpSession session) {
        Object obj = session.getAttribute("loginUser");
        if (obj != null && obj instanceof user) {
            String username = ((user) obj).getUsername();
            model.addAttribute("username", username);
        }
        List<food> food = userService.SelectFoodByName(name);
        model.addAttribute("food", food);
        return "user/food";
    }
    //添加美食收藏
    @PostMapping("/foodCollect")
    public String addCollect(@RequestParam Integer cuisineId, @RequestParam String name, HttpSession session, Model model) {
        Object obj = session.getAttribute("loginUser");
        if (obj != null && obj instanceof user) {
            String username = ((user) obj).getUsername();
            model.addAttribute("username", username);
        }
        Integer userId = ((user) obj).getId();
        userService.addFoodCollect(cuisineId,userId,name);
//        重定向到美食页面
        return "redirect:/user/food";

    }

}
