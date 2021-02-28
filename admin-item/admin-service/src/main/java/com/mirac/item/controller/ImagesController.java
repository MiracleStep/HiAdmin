package com.mirac.item.controller;

import com.mirac.item.pojo.Images;
import com.mirac.item.pojo.News;
import com.mirac.item.service.ImagesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.awt.*;
import java.util.List;

@Controller
@RequestMapping("img")
public class ImagesController {

    @Autowired
    private ImagesService imagesService;

    @RequestMapping("add")
    public String ImagesAdd(Images images){
        System.out.println(images);
        int i = this.imagesService.addAll(images);
        if(i == 1){
            System.out.println("添加成功");
        }
        return "redirect:/picture-list.html";
    }

    @RequestMapping("list")
    public ResponseEntity<List<Images>> showList(@RequestParam(value = "key",required = false)String key){
        List<Images> images = this.imagesService.queryNewsByExampleOrNot(key);
        if(CollectionUtils.isEmpty(images)){
            return ResponseEntity.status(HttpStatus.CREATED).build();
        }
        return ResponseEntity.ok(images);
    }

    @RequestMapping("/{id}")
    public ResponseEntity<Images> queryById(@PathVariable("id")Long id){
        Images images = this.imagesService.queryImageById(id);
        System.out.println(images);
        return ResponseEntity.ok(images);
    }

    @RequestMapping("del/{id}")
    public ResponseEntity<String> delByPrimaryKey(@PathVariable("id")Long id){
        int i = this.imagesService.delImageInfo(id);
        if (i==1){
            System.out.println("已删除");
        }
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @RequestMapping("update")
    public String updateByImgId(Images images){
        int i = this.imagesService.updateById(images);
        if(i==1){
            System.out.println("修改成功！");
        }
        return "redirect:/picture-list.html";
    }

    @RequestMapping("category")
    public ResponseEntity<List<Images>> selectBycategoryId(@RequestParam("categoryId")int categoryId){
        List<Images> images = this.imagesService.selectByCategoryId(categoryId);
        if(CollectionUtils.isEmpty(images)){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(images);
    }
}
