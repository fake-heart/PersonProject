package com.example.hometown.user.userController;

import com.example.hometown.admin.adminEntity.culture;
import com.example.hometown.user.userEntity.culture_collection;
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
public class userCulture {
    @Autowired
    private UserService userService;
    //跳转到文化展览页面
    @GetMapping("/culture")
    public String culture(Model model, HttpSession session)
            {
                if (session.getAttribute("loginUser") == null){
                    return "redirect:/user/login";
                }
                List<culture> culture= userService.SelectAllCulture();
                model.addAttribute("culture", culture);
                Object obj = session.getAttribute("loginUser");
                if (obj != null && obj instanceof user) {
                    String username = ((user) obj).getUsername();
                    model.addAttribute("username", username);
                }
                return "user/culture";
            }
    //根据文化名称搜索
    @PostMapping("/culture/search")
    public String search(@RequestParam String name, Model model,HttpSession session) {
        Object obj = session.getAttribute("loginUser");
        if (obj != null && obj instanceof user) {
            String username = ((user) obj).getUsername();
            model.addAttribute("username", username);
        }
        List<culture> culture = userService.searchCulture(name);
        model.addAttribute("culture", culture);
        return "user/culture";
    }
    //收藏文化
    @PostMapping("/collect")
    public String  addCollect(@RequestParam Integer cultureId,@RequestParam String name, HttpSession session,Model model){
        Object obj = session.getAttribute("loginUser");
        if (obj != null && obj instanceof user) {
            String username = ((user) obj).getUsername();
            model.addAttribute("username", username);
        }
        Integer userId = ((user) obj).getId();
        userService.addCollect(userId,cultureId,name);
//  重定向到文化页面
        return "redirect:/user/culture";
    }




}
