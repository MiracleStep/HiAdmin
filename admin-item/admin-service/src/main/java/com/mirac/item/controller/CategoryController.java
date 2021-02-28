package com.mirac.item.controller;

import com.mirac.item.pojo.Ztree;
import com.mirac.item.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @RequestMapping("list")
    @ResponseBody
    public Object ZtreeeList(){
        Map<String,Object> map = new HashMap<>();
        List<Ztree> ztrees = this.categoryService.selectZtreeNode();
        if (!CollectionUtils.isEmpty(ztrees)){
            map.put("menuList",ztrees);
            return map;

        }
        return map;
    }

    @RequestMapping("findCategoryId")
    public ResponseEntity<Ztree> findZtreeCategoryId(@RequestParam("id")int id){
        Ztree ztree = this.categoryService.selectZtreeNodeByCategoryId(id);
        if(ztree ==null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(ztree);
    }
}
