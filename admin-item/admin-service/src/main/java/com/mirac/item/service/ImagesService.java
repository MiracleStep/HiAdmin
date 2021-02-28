package com.mirac.item.service;

import com.mirac.item.mapper.ImagesMapper;
import com.mirac.item.pojo.Images;
import com.mirac.item.pojo.News;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class ImagesService {

    @Autowired
    private ImagesMapper imagesMapper;


    public int addAll(Images images) {
        return this.imagesMapper.insertSelective(images);
    }

    public List<Images> queryNewsByExampleOrNot(String key) {
        Example example = new Example(Images.class);
        example.setOrderByClause("orderby asc");
        if(StringUtils.isNotBlank(key)){
            Example.Criteria criteria = example.createCriteria();
            criteria.andLike("title","%"+key+"%");
        }
        List<Images> images = this.imagesMapper.selectByExample(example);
        return images;
    }

    public Images queryImageById(Long id) {
        Images images = this.imagesMapper.selectByPrimaryKey(id);
        return images;
    }

    public int delImageInfo(Long id) {
        int i = this.imagesMapper.deleteByPrimaryKey(id);
        return i;
    }

    public int updateById(Images images) {
        int i = this.imagesMapper.updateByPrimaryKeySelective(images);
        return i;
    }

    public List<Images> selectByCategoryId(int categoryId) {
        Example example = new Example(Images.class);
        example.setOrderByClause("orderby asc");
        Example.Criteria criteria = example.createCriteria();
        criteria.andLike("category",""+categoryId);
        List<Images> images = this.imagesMapper.selectByExample(example);
        return images;
    }
}
