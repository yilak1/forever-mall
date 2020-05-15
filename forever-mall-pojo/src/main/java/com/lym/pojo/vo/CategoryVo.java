package com.lym.pojo.vo;

import javax.security.auth.Subject;
import java.util.List;

/**
 * 二级分类的VO，表示专门用来进行展示的，显示层的数据结构
 */
public class CategoryVo {
    private Integer id;
    private String name;
    private String type;
    private Integer fatherId;
    //三级分类的vo list
    private List<SubCategoryVo> subCatList;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getFatherId() {
        return fatherId;
    }

    public void setFatherId(Integer fatherId) {
        this.fatherId = fatherId;
    }

    public List<SubCategoryVo> getSubCatList() {
        return subCatList;
    }

    public void setSubCatList(List<SubCategoryVo> subCatList) {
        this.subCatList = subCatList;
    }
}
