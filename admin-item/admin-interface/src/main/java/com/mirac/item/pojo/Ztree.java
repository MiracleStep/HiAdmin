package com.mirac.item.pojo;

import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "ztree")
public class Ztree {
    @Id
    private int id;
    private int parentId;
    private String menuName;
    private int categoryId;

    @Override
    public String toString() {
        return "Ztree{" +
                "id=" + id +
                ", parentId=" + parentId +
                ", menuName='" + menuName + '\'' +
                ", categoryId=" + categoryId +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }
}
