package com.example.hometown.admin.adminController;

import com.example.hometown.admin.adminEntity.*;
import com.example.hometown.admin.adminService.scenic_mangeService;
import jakarta.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.time.LocalDate;

@Controller
@RequestMapping("/admin")
public class scenic_manage {
    private static final Logger log = LoggerFactory.getLogger(scenic_manage.class);
    @Autowired
    private scenic_mangeService scenic_mangeService;
    //跳转到景点管理页面
    @GetMapping("/scenic_manage")
    public String Scenic_manage(@ModelAttribute scenicPage scenicPage, Model model,  HttpSession session){


        if (session.getAttribute("loginAdmin")==null){
            return "redirect:/admin/login";
        }
        // 查询数据
        scenicPageResult<scenic> result = scenic_mangeService.page(scenicPage);
        model.addAttribute("records", result.getRecords());
        model.addAttribute("total", result.getTotal());
        model.addAttribute("page", scenicPage.getPage());
        model.addAttribute("pageSize", scenicPage.getPageSize());
        model.addAttribute("scenicPage", scenicPage); // 用于保留搜索条件

        // 计算总页数
        int totalPages = (int) Math.ceil((double) result.getTotal() / scenicPage.getPageSize());
        model.addAttribute("totalPages", totalPages);

        Object obj = session.getAttribute("loginAdmin");
        if (obj != null && obj instanceof admin) {
            String username = ((admin) obj).getUsername();
            model.addAttribute("username", username);
        }

        return "admin/scenic_manage";
    }
    //根据景点id查询景点
    @GetMapping("/scenic_edit")
    public String edit(Integer id, Model model){
        scenic scenic = scenic_mangeService.getById(id);
        model.addAttribute("scenic",scenic);
        return "admin/scenic_edit";
    }
    //更新景点信息
    @PostMapping("/scenic_update")
    public String updateScenic(
            @RequestParam Integer id,
            @RequestParam String location,
            @RequestParam String description,
            @RequestParam Double rating,
            @RequestParam Double ticketPrice,
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate updateTime,
            Model model) {

        // 1. 获取原始景点信息
        scenic existingScenic = scenic_mangeService.getById(id);
        if (existingScenic == null) {
            return "redirect:/admin/scenic_manage?error";
        }
        // 4. 更新景点信息
        scenic updatedScenic = new scenic();
        updatedScenic.setId(id);
        updatedScenic.setLocation(location);
        updatedScenic.setDescription(description);
        updatedScenic.setRating(rating);
        updatedScenic.setTicketPrice(ticketPrice);
        updatedScenic.setUpdateTime(updateTime);
        scenic_mangeService.update(updatedScenic);
        return "redirect:/admin/scenic_manage";
    }
    @GetMapping("/scenic_add")
    public String addScenic() {
        return "admin/scenic_add";
    }
    //新增景点
    @PostMapping("/scenic_add")
    public String addScenic(
            @RequestParam String name,
            @RequestParam String description,
            @RequestParam Double rating,
            @RequestParam Double ticketPrice,
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate updateTime,
            @RequestParam("image") MultipartFile image,
            @RequestParam Integer createBy,
            @RequestParam String location,Model model){
        scenic scenic = new scenic();
        scenic.setName(name);
        scenic.setDescription(description);
        scenic.setRating(rating);
        scenic.setTicketPrice(ticketPrice);
        scenic.setUpdateTime(updateTime);
        scenic.setCreateBy(createBy);
        scenic.setLocation(location);
        scenic_mangeService.add(scenic);
        String uploadPath = "E:\\电脑桌面\\spring_期末设计\\homeTown\\";
        String uploadDir = uploadPath + "src\\main\\resources\\static\\images/scenic/";
        String  dest = uploadDir + name+ ".jpg";
        scenic.setImage(dest);

        return "redirect:/admin/scenic_manage";
    }
    //根据id删除景点
    @PostMapping("/scenic_delete")
    public String deleteScenic(Integer id) {
        scenic_mangeService.delete(id);
        return "redirect:/admin/scenic_manage";
    }


    }

