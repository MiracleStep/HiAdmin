package com.mirac.item.mapper;

import com.mirac.item.pojo.News;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface NewsMapper extends Mapper<News> {

    @Select("select * from news where category = #{categoryId}")
    List<News> selectBycategoryId(@Param("categoryId")int categoryId);
}
