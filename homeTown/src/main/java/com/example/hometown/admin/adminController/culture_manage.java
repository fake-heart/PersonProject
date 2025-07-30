package com.example.hometown.admin.adminController;

import com.example.hometown.admin.adminEntity.admin;
import com.example.hometown.admin.adminEntity.culture;
import com.example.hometown.admin.adminEntity.culturePage;
import com.example.hometown.admin.adminEntity.culturePageResult;
import com.example.hometown.admin.adminService.culture_manageService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Controller
@RequestMapping("/admin")
public class culture_manage {

    @Autowired
    private culture_manageService culture_manageService;

    //跳转到文化管理页面
    @GetMapping("/culture_manage")
    public String Culture_manage(@ModelAttribute culturePage culturePage, Model model,  HttpSession session){
        if (session.getAttribute("loginAdmin") == null){
            return "redirect:/Admin/login";
        }



        culturePageResult<culture> result = culture_manageService.page(culturePage);
        model.addAttribute("records", result.getRecords());
        model.addAttribute("total", result.getTotal());
        model.addAttribute("page", culturePage.getPage());
        model.addAttribute("pageSize", culturePage.getPageSize());
        model.addAttribute("scenicPage", culturePage); // 用于保留搜索条件

        // 计算总页数
        int totalPages = (int) Math.ceil((double) result.getTotal() / culturePage.getPageSize());
        model.addAttribute("totalPages", totalPages);
        Object obj = session.getAttribute("loginAdmin");
        if (obj != null && obj instanceof admin) {
            String username = ((admin) obj).getUsername();
            model.addAttribute("username", username);
        }
        return "admin/culture_manage";
    }
    //根据id查询
    @GetMapping("/culture_edit")
    public String edit(Integer id, Model model){
        culture culture = culture_manageService.getById(id);
        model.addAttribute("culture", culture);
        return "admin/culture_edit";
    }
    //修改文化活动
    @PostMapping("/culture_update")
    public String updateCulture(
            @RequestParam Integer id,
            @RequestParam String history,
            @RequestParam  @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate updateTime) { // 这里要使用 MultipartFile
        culture culture = new culture();
        culture.setId(id);
        culture.setHistory(history);
        culture.setUpdateTime(updateTime);
        culture_manageService.update(culture);
        return "redirect:/admin/culture_manage";
    }
    @GetMapping("/culture_add")
    public String addCulture(
    ){


        return "admin/culture_add";
    }
    //新增文化活动
    @PostMapping("/culture_add")
    public String addCulture(
            @RequestParam String name,
            @RequestParam String history,
            @RequestParam String description,
            @RequestParam Integer createBy,
            @RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate createTime,
            @RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate updateTime,
            @RequestParam("image") MultipartFile image,
            Model model) throws IOException {

        // 自动设置时间
        if (createTime == null) createTime = LocalDate.now();
        if (updateTime == null) updateTime = LocalDate.now();

        culture culture = new culture();
        culture.setName(name);
        culture.setHistory(history);
        culture.setDescription(description);
        culture.setCreateBy(createBy);
        culture.setCreateTime(createTime);
        culture.setUpdateTime(updateTime);
        culture_manageService.add(culture);
            String uploadPath = "E:\\电脑桌面\\spring_期末设计\\homeTown\\";
            // 使用配置文件中的路径（推荐）
            String uploadDir = uploadPath + "src\\main\\resources\\static\\images/culture/";
            String  dest = uploadDir + name+ ".jpg";
            culture.setImage(dest);

        return "redirect:/admin/culture_manage";
    }
    //根据id删除文化活动
    @PostMapping("/culture_delete")
    public String deleteCulture(Integer id){
        culture_manageService.delete(id);
        return "redirect:/admin/culture_manage";
    }
    }

