package com.mirac.item.service;

import com.mirac.item.mapper.ZtreeMapper;
import com.mirac.item.pojo.Ztree;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private ZtreeMapper ztreeMapper;


    public List<Ztree> selectZtreeNode() {
        return this.ztreeMapper.getTreeNodes();
    }

    public Ztree selectZtreeNodeByCategoryId(int id) {
        return this.ztreeMapper.selectBycategoryId(id);
    }
}
