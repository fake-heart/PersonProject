package com.example.hometown.user.userController;

import com.example.hometown.admin.adminEntity.food;
import com.example.hometown.admin.adminEntity.scenic;
import com.example.hometown.user.userEntity.culture_collection;
import com.example.hometown.user.userEntity.food_collection;
import com.example.hometown.user.userEntity.scenic_collection;
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
public class userIndex {
    @Autowired
    private UserService userService;


    //跳转到用户首页界面
    @GetMapping("/user")
    public String index(Model model, HttpSession session) {

        if (session.getAttribute("loginUser") == null){
            return "redirect:/user/login";
        }
        List<scenic> scenic = userService.getScenic();
        List<food>  food = userService.getFood();
        model.addAttribute("scenic", scenic);
        model.addAttribute("food", food);
        Object obj = session.getAttribute("loginUser");
        if (obj != null && obj instanceof user) {
            String username = ((user) obj).getUsername();
            model.addAttribute("username", username);
        }
        return "user/user";
    }
    //跳转到用户中心界面
    @GetMapping("/userCenter")
    public String showUserCenter(Model model, HttpSession session) {
        // 从 session 中获取 loginUser
        Object obj = session.getAttribute("loginUser");

        // 判断是否登录
        if (obj == null || !(obj instanceof user)) {
            return "redirect:/user/login"; // 未登录，跳转登录页
        }

        // 获取用户对象和用户名
        user loginUser = (user) obj;
        String username = loginUser.getUsername();

        // 传入模板
        model.addAttribute("user", loginUser);
        model.addAttribute("username", username);
        return "user/userCenter";
    }
    @GetMapping("/editUser")
    public String editUser(Model model, HttpSession session) {
        Object obj = session.getAttribute("loginUser");
        // 获取用户对象和用户名
        user loginUser = (user) obj;
        String username = loginUser.getUsername();
        String phone = loginUser.getPhone();
        String password = loginUser.getPassword();
        // 传入模板
        model.addAttribute("user", loginUser);
        model.addAttribute("username", username);
        model.addAttribute("phone", phone);
        model.addAttribute("password", password);
        return "user/editUser";
    }

    //修改个人信息
    @PostMapping("/editUser")
    public String editUser(
            @RequestParam String username,
            @RequestParam String phone,
            @RequestParam String password,
            Model model, HttpSession session) {

        Object obj = session.getAttribute("loginUser");
        if (obj == null || !(obj instanceof user)) {
            return "redirect:/user/login";
        }

        user loginUser = (user) obj;
        loginUser.setId(((user) obj).getId()); // 保留原 ID
        loginUser.setUsername(username);
        loginUser.setPhone(phone);
        loginUser.setPassword(password);
        userService.updateUser(loginUser); // 这里会调用 MyBatis 更新数据库
        return "redirect:/user/userCenter"; // 修改后跳转个人中心
    }
    //个人收藏
    @GetMapping("/collection")
    public String collect(Model model, HttpSession session) {
        Object obj = session.getAttribute("loginUser");
        if (obj != null && obj instanceof user) {
            String username = ((user) obj).getUsername();
            model.addAttribute("username", username);
        }
        if (obj == null || !(obj instanceof user)) {
            return "redirect:/user/login";
        }
        Integer userId = ((user) obj).getId();

        //展示文化收藏
        List<culture_collection> culture_collection = userService.showCultureCollection(userId);
        //展示美食收藏
        List<food_collection> food_collection = userService.showFoodCollection(userId);
        //展示景点收藏
        List<scenic_collection> scenic_collection = userService.showScenicCollection(userId);
        Integer cultureTotal= userService.selectCultureTotal(userId);
        Integer foodTotal= userService.selectFoodTotal(userId);
        Integer scenicTotal= userService.selectScenicTotal(userId);
        Integer total= cultureTotal+foodTotal+scenicTotal;
        model.addAttribute("cultureTotal", cultureTotal);
        model.addAttribute("foodTotal", foodTotal);
        model.addAttribute("scenicTotal", scenicTotal);
        model.addAttribute("total", total);
        model.addAttribute("food_collection", food_collection);
        model.addAttribute("culture_collection", culture_collection);
        model.addAttribute("scenic_collection", scenic_collection);
        return "user/collect";
    }


}
