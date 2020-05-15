package com.lym.pojo.vo;

import java.util.List;

/**
 * 最新的商品Vo
 */
public class NewItemsVo {
    private Integer rootCatId;
    private String rootCatName;
    private String slogan;
    private String catImg;
    private String bgColor;
    private List<SimpleItemVo> simpleItemList;

    public Integer getRootCatId() {
        return rootCatId;
    }

    public void setRootCatId(Integer rootCatId) {
        this.rootCatId = rootCatId;
    }

    public String getRootCatName() {
        return rootCatName;
    }

    public void setRootCatName(String rootCatName) {
        this.rootCatName = rootCatName;
    }

    public String getSlogan() {
        return slogan;
    }

    public void setSlogan(String slogan) {
        this.slogan = slogan;
    }

    public String getCatImg() {
        return catImg;
    }

    public void setCatImg(String catImg) {
        this.catImg = catImg;
    }

    public String getBgColor() {
        return bgColor;
    }

    public void setBgColor(String bgColor) {
        this.bgColor = bgColor;
    }

    public List<SimpleItemVo> getSubItemsList() {
        return simpleItemList;
    }

    public void setSubItemsList(List<SimpleItemVo> simpleItemList) {
        this.simpleItemList = simpleItemList;
    }
}
