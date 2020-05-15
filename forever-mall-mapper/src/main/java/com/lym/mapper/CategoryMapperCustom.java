package com.lym.mapper;

import com.lym.pojo.vo.CategoryVo;
import com.lym.pojo.vo.NewItemsVo;
import com.lym.pojo.vo.SubCategoryVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 *
 */
public interface CategoryMapperCustom {
    public List<CategoryVo> getSubCatList(Integer rootCatId);

    public List<NewItemsVo> getSixNewItemsLazy(@Param("paramsMap") Map<String, Object> map);
}
