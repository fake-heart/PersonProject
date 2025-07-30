package com.example.hometown.admin.adminController;

import com.example.hometown.admin.adminEntity.admin;
import com.example.hometown.admin.adminEntity.food;
import com.example.hometown.admin.adminEntity.foodPage;
import com.example.hometown.admin.adminEntity.foodPageResult;
import com.example.hometown.admin.adminService.food_manageService;
import jakarta.servlet.http.HttpSession;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;

@Controller
@RequestMapping("/admin")
public class food_manage {
    @Autowired
    private food_manageService food_manageService;

    //跳转到美食管理页面
    @GetMapping("/food_manage")
    public String Food_manage(@ModelAttribute foodPage foodPage, Model model, HttpSession session){
        if (session.getAttribute("loginAdmin") == null){
            return "redirect:/admin/login";
        }
       foodPageResult<food> result = food_manageService.page(foodPage);
        model.addAttribute("records", result.getRecords());
        model.addAttribute("total", result.getTotal());
        model.addAttribute("page", foodPage.getPage());
        model.addAttribute("pageSize", foodPage.getPageSize());
        model.addAttribute("scenicPage", foodPage); // 用于保留搜索条件

        // 计算总页数
        int totalPages = (int) Math.ceil((double) result.getTotal() / foodPage.getPageSize());
        model.addAttribute("totalPages", totalPages);
        Object obj = session.getAttribute("loginAdmin");
        if (obj != null && obj instanceof admin) {
            String username = ((admin) obj).getUsername();
            model.addAttribute("username", username);
        }

        return "admin/food_manage";
    }
    //根据id查询美食
    @GetMapping("/food_edit")
    public String edit(Integer id, Model model){
        food food = food_manageService.getById(id);
        model.addAttribute("food", food);
        return "admin/food_edit";
    }
    //修改美食
    @PostMapping("/food_update")
    public String updateFood(
            @RequestParam Integer id,
            @RequestParam String ingredients,
            @RequestParam String originLocation,
            @RequestParam  @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate updateTime){
        food food = new food();
        food.setId(id);
        food.setIngredients(ingredients);
        food.setOriginLocation(originLocation);
        food.setUpdateTime(updateTime);
        food_manageService.update(food);
        return "redirect:/admin/food_manage";

    }
    @GetMapping("/food_add")
    public String addFood(){
        return "admin/food_add";
    }
    //添加美食
    @PostMapping("/food_add")
    public String addFood(
            @RequestParam String name,
            @RequestParam String description,
            @RequestParam String ingredients,
            @RequestParam String originLocation,
            @RequestParam String recommendedRestaurant,
            @RequestParam Integer createBy,
            @RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate updateTime,
            @RequestParam("image" )MultipartFile image,Model model
            ) {
        food food = new food();
        food.setName(name);
        food.setDescription(description);
        food.setIngredients(ingredients);
        food.setOriginLocation(originLocation);
        food.setRecommendedRestaurant(recommendedRestaurant);
        food.setCreateBy(createBy);
        food.setUpdateTime(updateTime);
        food_manageService.add(food);

        String uploadPath = "E:\\电脑桌面\\spring_期末设计\\homeTown\\";
        // 使用配置文件中的路径（推荐）
        String uploadDir = uploadPath + "src\\main\\resources\\static\\images/food/";
        String  dest = uploadDir + name+ ".jpg";
        food.setImage(dest);

        return "redirect:/admin/food_manage";

    }
    @PostMapping("/food_delete")
    public String deleteFood(Integer id){
        food_manageService.delete(id);
        return "redirect:/admin/food_manage";
    }
}
