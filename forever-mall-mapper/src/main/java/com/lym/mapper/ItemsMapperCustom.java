package com.lym.mapper;

import com.lym.my.mapper.MyMapper;
import com.lym.pojo.Items;
import com.lym.pojo.vo.ItemCommentVO;
import com.lym.pojo.vo.SearchItemsVO;
import com.lym.pojo.vo.ShopcartVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface ItemsMapperCustom {

    public List<ItemCommentVO> queryItemComments(@Param("paramsMap") Map<String, Object> map);

    public List<SearchItemsVO> searchItems(@Param("paramsMap") Map<String, Object> map);

    public List<SearchItemsVO> searchItemsByThirdCat(@Param("paramsMap") Map<String, Object> map);

    public List<ShopcartVO> queryItemsBySpecIds(@Param("paramsList") List<String> list);
}