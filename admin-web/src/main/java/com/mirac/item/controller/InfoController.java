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

@Controller
@RequestMapping("item")
public class InfoController {
    @Autowired
    private InfoService infoService;
    @RequestMapping("/info/{id}")
    public String editInfo(@PathVariable("id")Long id, Model model){
        News news = this.infoService.SelectByPrimaryId(id);
        if(news!=null){
            model.addAttribute("news",news);
        }
        return "article-edit";
    }

    @RequestMapping("/image/{id}")
    public String queryImgById(@PathVariable("id")Long id,Model model){
        Images images = this.infoService.selectImgById(id);
        model.addAttribute("images",images);
        return "picture-show";
    }
    @RequestMapping("/img/{id}")
    public String editImgById(@PathVariable("id")Long id,Model model){
        Images images = this.infoService.selectImgById(id);
        model.addAttribute("images",images);
        return "picture-edit";
    }
}
