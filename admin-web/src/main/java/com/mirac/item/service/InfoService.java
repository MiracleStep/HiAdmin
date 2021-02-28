package com.mirac.item.service;

import com.mirac.item.api.ImagesApi;
import com.mirac.item.client.CategoryClient;
import com.mirac.item.client.ImagesClient;
import com.mirac.item.client.NewsCLient;
import com.mirac.item.pojo.Images;
import com.mirac.item.pojo.News;
import com.mirac.item.pojo.Ztree;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InfoService {
    @Autowired
    private NewsCLient newsCLient;
    @Autowired
    private ImagesClient imagesClient;
    @Autowired
    private CategoryClient categoryClient;

    public News SelectByPrimaryId(Long id) {
        News news = this.newsCLient.searchByPrimaryKey(id);
        return news;
    }

    public Images selectImgById(Long id) {
        return this.imagesClient.queryById(id);
    }

    public List<News> SelectByNewsCategoryId(int id) {
        Ztree ztreeCategoryId = this.categoryClient.findZtreeCategoryId(id);
        int categoryId = ztreeCategoryId.getCategoryId();
        try {
            List<News> news = this.newsCLient.selectBycategoryId(categoryId);
            return news;
        }catch (Exception e){
            System.out.println("categoryId:"+categoryId);
            System.out.println("当前分类无内容");
            return null;
        }
    }

    public List<Images> SelectByImagesCategoryId(int id) {
        Ztree ztreeCategoryId = this.categoryClient.findZtreeCategoryId(id);
        int categoryId = ztreeCategoryId.getCategoryId();
        try {
            List<Images> images = imagesClient.selectBycategoryId(categoryId);
            return images;
        }catch (Exception e){
            System.out.println("当前分类无内容");
            return null;
        }


    }
}
