package com.example.wooden_home.controller;

import com.example.wooden_home.dto.NewsDTO;
import com.example.wooden_home.model.Admin;
import com.example.wooden_home.model.News;
import com.example.wooden_home.service.AdminService;
import com.example.wooden_home.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.sql.Date;
import java.util.Optional;

@Controller
public class NewsController {
    @Autowired
    AdminService adminService;
    @Autowired
    NewsService newsService;
    @GetMapping("/admin/news")
    public String listNews(ModelMap modelMap){
        modelMap.addAttribute("news", newsService.findAll());
        return "newsCms";
    }
    @GetMapping("/news/create")
    public String addNews(ModelMap modelMap){
        NewsDTO newsDTO = new NewsDTO();
        modelMap.addAttribute("admin", adminService.findAll());
        modelMap.addAttribute("newsDTO", newsDTO);
        return "addNews";
    }

    @PostMapping("/user/insertOrUpdate")
    public String insertOrUpdate(ModelMap modelMap, @ModelAttribute("NewsDTO") NewsDTO dto, RedirectAttributes attributes){
        Integer id = dto.getId();
        String title = dto.getTitle();
        Admin admin = dto.getAdmin();
        String des = dto.getDescription();
        String content = dto.getContent();
        MultipartFile img = dto.getImage();
        Optional<News> optionalNews = newsService.findById(id);
        String image = "logo1.jpg";
        Path path = Paths.get("uploads");
        Date creatAt = new Date(System.currentTimeMillis());
        if(optionalNews.isPresent()){
            try{
                image = img.getOriginalFilename().toString();
                if(image.equals("")){
                    image = optionalNews.get().getImage();
                } else {
                    InputStream inputStream = img.getInputStream();
                    Files.copy(inputStream, path.resolve(img.getOriginalFilename()), StandardCopyOption.REPLACE_EXISTING);
                    image =img.getOriginalFilename().toString();
                }
                News news = new News(id, admin, title, des, content, image, creatAt);
                newsService.save(news);
                attributes.addFlashAttribute("success", "Sửa thành công");
            } catch (Exception e) {
                attributes.addFlashAttribute("error", "Sửa thất bại");
            }
        }else {
            if(!img.isEmpty()){
               try{
                   InputStream inputStream = img.getInputStream();
                   Files.copy(inputStream, path.resolve(img.getOriginalFilename()), StandardCopyOption.REPLACE_EXISTING);
                   image =img.getOriginalFilename().toString();
                   News news = new News(admin, title, des, content, image, creatAt);
                   newsService.save(news);
                   attributes.addFlashAttribute("success", "Thêm thành công");
               } catch (Exception e) {
                   attributes.addFlashAttribute("error", "Thêm thất bại");
               }
            }
        }

        return "redirect:/admin/news";
    }

    @GetMapping("/edit/{id}")
    public String editNews(ModelMap modelMap, @PathVariable Integer id){
        Optional<News> newsOptional = newsService.findById(id);
        NewsDTO newsDTO = null;
        if(newsOptional.isPresent()){
            News news = newsOptional.get();
            modelMap.addAttribute("newsDTO", news);
        } else {
            modelMap.addAttribute("newsDTO", new NewsDTO());
        }
        modelMap.addAttribute("admin", adminService.findAll());
        return "editNews";
    }

    @RequestMapping("/news/delete/{id}")
    public String delete(@PathVariable Integer id, RedirectAttributes attributes){
        newsService.deleteById(id);
        attributes.addFlashAttribute("success", "Xoá thành công");
        return "redirect:/admin/news";
    }
}
