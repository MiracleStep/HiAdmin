package com.mirac.item.api;


import com.mirac.item.pojo.News;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@RequestMapping("news")
public interface NewsApi {

    @RequestMapping("list")
    public List<News> showList(@RequestParam(value = "key",required = false)String key);

    @RequestMapping("add")
    public String addNews(News news);

    @RequestMapping("del")
    public String delNews(@RequestParam("id")Long id);

    @RequestMapping("info")
    public News searchByPrimaryKey(@RequestParam("id")Long id);

    @RequestMapping("category")
    public List<News> selectBycategoryId(@RequestParam("categoryId")int categoryId);


}
