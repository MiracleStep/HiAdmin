package com.mirac.item.controller;

import com.leyou.common.pojo.PageResult;
import com.mirac.item.pojo.News;


import com.mirac.item.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("news")
public class NewsController {

    @Autowired
    private NewsService newsService;

    @RequestMapping("list")
    public ResponseEntity<PageResult<News>> showList(@RequestParam(value = "key",required = false)String key, @RequestParam(value = "page",defaultValue = "1")Integer page){
        PageResult<News> result = this.newsService.queryNewsByExampleOrNot(key,page);
        if(CollectionUtils.isEmpty(result.getItems())){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(result);
    }

    @RequestMapping("add")
    public String addNews(News news){
        System.out.println(news);
        this.newsService.insertNews(news);
        return "redirect:/article-list.html";
    }

    @RequestMapping("del")
    public ResponseEntity<String> delNews(@RequestParam("id")Long id){
           int i = this.newsService.delNewsById(id);
           if(i==0){
               return ResponseEntity.badRequest().build();
           }
           return ResponseEntity.ok().body("ok");
    }

    @RequestMapping("search")
    public ResponseEntity<List<News>> searchByExample(@RequestParam("name")String name){
        List<News> news = this.newsService.queryByExample(name);
        if(CollectionUtils.isEmpty(news)){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(news);
    }

    @RequestMapping("info")
    public ResponseEntity<News> searchByPrimaryKey(@RequestParam("id")Long id){
        News newInfo = this.newsService.SelectByPrimaryKey(id);
        if(newInfo==null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(newInfo);
    }

    @RequestMapping("edit")
    public String editNewsById(News news){
        System.out.println(news);
        int i = this.newsService.UpdateByNewsId(news);
        if(i == 1){
            System.out.println("修改成功！");
        }
        return "redirect:/article-list.html";
    }

    @RequestMapping("category")
    public ResponseEntity<List<News>> selectBycategoryId(@RequestParam("categoryId")int categoryId){
        List<News> news = this.newsService.selectByCategoryId(categoryId);
        if(CollectionUtils.isEmpty(news)){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(news);
    }
}
