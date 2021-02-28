package com.mirac.item.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
@Table(name="news")
public class News {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    @Column(name = "category")
    private int category;
    @Column( name = "txt_category")
    private int txtCategory;
    @Column(name = "orderby")
    private int orderby;
    private String keyword;
    private String abstractText;
    private String author;
    private String subtitle;
    private String dataFrom;
    private boolean isComment;
    private String updateTime;
    private String deleteTime;
    private String file;
    private String text;
    private Long viewNum;
    private String releaseStatus;
    private String operation;


    @Override
    public String toString() {
        return "News{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", category=" + category +
                ", txtCategory=" + txtCategory +
                ", orderby=" + orderby +
                ", keyword='" + keyword + '\'' +
                ", abstractText='" + abstractText + '\'' +
                ", author='" + author + '\'' +
                ", subtitle='" + subtitle + '\'' +
                ", dataFrom='" + dataFrom + '\'' +
                ", isComment=" + isComment +
                ", updateTime='" + updateTime + '\'' +
                ", deleteTime='" + deleteTime + '\'' +
                ", file='" + file + '\'' +
                ", text='" + text + '\'' +
                ", viewNum=" + viewNum +
                ", releaseStatus='" + releaseStatus + '\'' +
                ", operation='" + operation + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    public int getTxtCategory() {
        return txtCategory;
    }

    public void setTxtCategory(int txtCategory) {
        this.txtCategory = txtCategory;
    }

    public int getOrderby() {
        return orderby;
    }

    public void setOrderby(int orderby) {
        this.orderby = orderby;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public String getAbstractText() {
        return abstractText;
    }

    public void setAbstractText(String abstractText) {
        this.abstractText = abstractText;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public String getDataFrom() {
        return dataFrom;
    }

    public void setDataFrom(String dataFrom) {
        this.dataFrom = dataFrom;
    }

    public boolean isComment() {
        return isComment;
    }

    public void setComment(boolean comment) {
        isComment = comment;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public String getDeleteTime() {
        return deleteTime;
    }

    public void setDeleteTime(String deleteTime) {
        this.deleteTime = deleteTime;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Long getViewNum() {
        return viewNum;
    }

    public void setViewNum(Long viewNum) {
        this.viewNum = viewNum;
    }

    public String getReleaseStatus() {
        return releaseStatus;
    }

    public void setReleaseStatus(String releaseStatus) {
        this.releaseStatus = releaseStatus;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }
}
