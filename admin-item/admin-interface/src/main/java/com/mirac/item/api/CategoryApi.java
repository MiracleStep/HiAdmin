package com.mirac.item.api;

import com.mirac.item.pojo.Ztree;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("category")
public interface CategoryApi {

    @RequestMapping("findCategoryId")
    public Ztree findZtreeCategoryId(@RequestParam("id")int id);
}
