package com.mirac.item.mapper;

import com.mirac.item.pojo.Ztree;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Locale;

public interface ZtreeMapper {

    @Select("select id as id,parent_id as parentId,menu_name as menuName from ztree")
    List<Ztree> getTreeNodes();

    @Select("select a.categories_name,b.category_name from categories a inner join category b on a.id = b.categories.id")
    List<Locale.Category> selectAllCategories();

    @Select("select id as id,parent_id as parentId,menu_name as menuName,category_id as categoryId from ztree where id = #{id}")
    Ztree selectBycategoryId(int id);
}
