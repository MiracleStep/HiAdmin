package com.mirac.item.api;

import com.mirac.item.pojo.Images;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


@RequestMapping("img")
public interface ImagesApi {

    @RequestMapping("{id}")
    public Images queryById(@PathVariable("id")Long id);

    @RequestMapping("category")
    public List<Images> selectBycategoryId(@RequestParam("categoryId")int categoryId);
}
