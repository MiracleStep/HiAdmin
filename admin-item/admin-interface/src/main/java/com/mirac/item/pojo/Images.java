package com.mirac.item.pojo;


import javax.persistence.*;

@Table( name = "admin_images")
public class Images {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String subtitle;
    @Column(name = "category")
    private int category;
    @Column(name = "orderby")
    private int orderby;
    @Column(name = "is_comment")
    private int isComment;
    private String releasetime;
    private String deletetime;
    private String author;
    private String dataFrom;
    private String keyword;
    private String abstractText;
    private String imgUrl;

    @Override
    public String toString() {
        return "Images{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", subtitle='" + subtitle + '\'' +
                ", category=" + category +
                ", orderby=" + orderby +
                ", isComment=" + isComment +
                ", releasetime='" + releasetime + '\'' +
                ", deletetime='" + deletetime + '\'' +
                ", author='" + author + '\'' +
                ", dataFrom='" + dataFrom + '\'' +
                ", keyword='" + keyword + '\'' +
                ", abstractText='" + abstractText + '\'' +
                ", imgUrl='" + imgUrl + '\'' +
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

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    public int getOrderby() {
        return orderby;
    }

    public void setOrderby(int orderby) {
        this.orderby = orderby;
    }

    public int getIsComment() {
        return isComment;
    }

    public void setIsComment(int isComment) {
        this.isComment = isComment;
    }

    public String getReleasetime() {
        return releasetime;
    }

    public void setReleasetime(String releasetime) {
        this.releasetime = releasetime;
    }

    public String getDeletetime() {
        return deletetime;
    }

    public void setDeletetime(String deletetime) {
        this.deletetime = deletetime;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDataFrom() {
        return dataFrom;
    }

    public void setDataFrom(String dataFrom) {
        this.dataFrom = dataFrom;
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

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }
}
