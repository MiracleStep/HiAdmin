package com.mirac.item.controller;

import com.mirac.item.pojo.Images;
import com.mirac.item.pojo.News;
import com.mirac.item.service.InfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("item")
public class CategoryListController {
    @Autowired
    private InfoService infoService;

    @RequestMapping("category/{id}")
    public String categoryList(@PathVariable("id")int id, @RequestParam("parentId")int parentId, Model model){
        if(parentId==2){
            List<News> lists = this.infoService.SelectByNewsCategoryId(id);
            model.addAttribute("lists",lists);
            return "article-category";
        }else {
            List<Images> lists = this.infoService.SelectByImagesCategoryId(id);
            model.addAttribute("lists",lists);
            return "picture-category";
        }
    }
}
