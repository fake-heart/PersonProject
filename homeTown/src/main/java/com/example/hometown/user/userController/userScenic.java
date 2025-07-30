package com.example.hometown.user.userController;

import com.example.hometown.admin.adminEntity.scenic;
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
public class userScenic {
    @Autowired
    private UserService userService;

    //跳转景点页面
    @GetMapping("/scenic")
    public String scenic(Model model, HttpSession session) {
        if (session.getAttribute("loginUser") == null){
            return "redirect:/user/login";
        }
        List<scenic>  scenic = userService.SelectAllScenic();
        model.addAttribute("scenic", scenic);
        Object obj = session.getAttribute("loginUser");
        if (obj != null && obj instanceof user) {
            String username = ((user) obj).getUsername();
            model.addAttribute("username", username);
        }
        return "user/scenic";
    }
    //根据景点名称搜索景点
    @PostMapping("/scenic/search")
    public  String search(@RequestParam String name, Model model, HttpSession session){
        Object obj = session.getAttribute("loginUser");
        if (obj != null && obj instanceof user) {
            String username = ((user) obj).getUsername();
            model.addAttribute("username", username);
        }
        List<scenic>  scenic = userService.selectScenicByName(name);
        model.addAttribute("scenic", scenic);
        return "user/scenic";
    }
//    添加景点收藏
    @PostMapping("/scenicCollect")
    public String addCollect(@RequestParam Integer scenicId, @RequestParam String name, HttpSession session, Model model) {
        Object obj = session.getAttribute("loginUser");
        if (obj != null && obj instanceof user) {
            user loginUser = (user) obj;
            String username = ((user) obj).getUsername();
            model.addAttribute("username", username);
        }
        Integer userId = ((user) obj).getId();
        userService.addScenicCollect(userId,scenicId,name);

        return "redirect:/user/scenic";
    }
}
