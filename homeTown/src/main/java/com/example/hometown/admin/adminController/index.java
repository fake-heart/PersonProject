package com.example.hometown.admin.adminController;

import com.example.hometown.admin.adminEntity.*;
import com.example.hometown.admin.adminMapper.adminMapper;
import com.example.hometown.admin.adminMapper.adminTotal;
import com.example.hometown.admin.adminMapper.indexSelectMapper;
import com.example.hometown.admin.adminService.TotalService;
import com.example.hometown.admin.adminService.adminLogin;
import com.example.hometown.admin.adminService.indexSelectService;
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
public class index {

    @Autowired
    private TotalService totalService;
    @Autowired
    private indexSelectService indexSelectService;


    // 跳转首页
    @GetMapping("/admin")
    public String index(@ModelAttribute("Total") Total total, Model model, HttpSession session){

        if (session.getAttribute("loginAdmin") == null){
            return "redirect:/admin/login";
        }

        total=totalService.getTotal();
         newUser newUser = indexSelectService.selectNewUser();
        culture  culture  = indexSelectService.selectNewCulture();
        food food = indexSelectService.selectNewFood();
        scenic scenic = indexSelectService.selectNewScenic();
        model.addAttribute("newUser",newUser);// 最新用户
        model.addAttribute("culture",culture);// 最新文化
        model.addAttribute("food",food);// 最新美食
        model.addAttribute("scenic",scenic);//  最新景点
        model.addAttribute("Total",total);// 总数
      log.info("total: " + total.getUserNum());
        Object obj = session.getAttribute("loginAdmin");
        if (obj != null && obj instanceof admin) {
            String username = ((admin) obj).getUsername();
            model.addAttribute("username", username);
        }

        return "admin/admin";
    }


}
