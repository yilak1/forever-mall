package com.lym.service;

import com.lym.pojo.Category;
import com.lym.pojo.vo.CategoryVo;
import com.lym.pojo.vo.NewItemsVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface CategoryService {
    /**
     * 查询所有的一级分类
     * @return
     */
    public List<Category> queryAllRootLevelCat();

    /**
     * 根据一级分类id查找二级的分类构成的类CategoryVo
     * @param rootCatId
     * @return
     */
    public List<CategoryVo> getSubCatList(Integer rootCatId);

    /**
     * 根据首页每个一级分类下的6条最新商品数据
     * @param rootCatId
     * @return
     */
    public List<NewItemsVo> getSixNewItemsLazy(Integer rootCatId);
}
