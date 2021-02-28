package com.mirac.item.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.leyou.common.pojo.PageResult;
import com.mirac.item.mapper.NewsMapper;
import com.mirac.item.pojo.News;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class NewsService {
    @Autowired
    private NewsMapper newsMapper;
    private static final int ROWS = 5;

    public PageResult<News> queryNewsByExampleOrNot(String key,Integer page) {
        PageHelper.startPage(page,ROWS);
        Example example = new Example(News.class);
        example.setOrderByClause("orderby asc");
        Example.Criteria criteria = example.createCriteria();
        if(StringUtils.isNotBlank(key)){
            criteria.andLike("title","%"+key+"%");
        }
        List<News> news = this.newsMapper.selectByExample(example);

        PageInfo<News> pageInfo = new PageInfo<>(news);


        return new PageResult<News>(pageInfo.getTotal(),pageInfo.getPages(),pageInfo.getList());


    }
    @Transactional
    public void insertNews(News news) {
        news.setViewNum(0L);
        news.setReleaseStatus("已发布");
        news.setOperation("下架");
        this.newsMapper.insert(news);
    }
    @Transactional
    public int delNewsById(Long id) {
        return this.newsMapper.deleteByPrimaryKey(id);
    }

    public List<News> queryByExample(String name) {
        Example example = new Example(News.class);
        example.setOrderByClause("orderby asc");
        Example.Criteria criteria = example.createCriteria();
        if(StringUtils.isNotBlank(name)){
            criteria.andLike("title","%"+name+"%");
        }
        List<News> news = this.newsMapper.selectByExample(example);

        return news;
    }

    public News SelectByPrimaryKey(Long id) {
        News news = this.newsMapper.selectByPrimaryKey(id);
        return news;
    }

    @Transactional
    public int UpdateByNewsId(News news) {
        int i = this.newsMapper.updateByPrimaryKeySelective(news);
        return i;
    }

    public List<News> selectByCategoryId(int categoryId) {
        Example example = new Example(News.class);
        example.setOrderByClause("orderby asc");
        Example.Criteria criteria = example.createCriteria();
        criteria.andLike("category",""+categoryId);

        List<News> news = this.newsMapper.selectByExample(example);

        return news;
    }
}
