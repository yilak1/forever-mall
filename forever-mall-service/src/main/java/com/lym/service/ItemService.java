package com.lym.service;

import com.lym.pojo.Items;
import com.lym.pojo.ItemsImg;
import com.lym.pojo.ItemsParam;
import com.lym.pojo.ItemsSpec;
import com.lym.pojo.vo.CommentLevelCountsVO;
import com.lym.pojo.vo.ShopcartVO;
import com.lym.utils.PagedGridResult;

import java.util.List;

public interface ItemService {

    /**
     * 根据商品id查询详情
     * @param itemId
     * @return
     */
    public Items queryItemById(String itemId);

    /**
     * 根据商品的id查询商品的图片
     * @param itemId
     * @return
     */
    public List<ItemsImg> queryItemImgList(String itemId);

    /**
     * 根据商品的id查询商品的规格
     * @param itemId
     * @return
     */
    public List<ItemsSpec> queryItemSpecList(String itemId);

    /**
     * 根据商品id查询商品的参数
     * @param itemId
     * @return
     */
    public ItemsParam queryItemParam(String itemId);

    /**
     * 根据商品id查到商品对应等级和评价数量
     * @param itemId
     */
    public CommentLevelCountsVO queryCommentCounts(String itemId);

    /**
     * 根据商品id查询商品的评价，进行分页展示
     * @param itemId
     * @param level
     * @param page
     * @param pageSize
     * @return
     */
    public PagedGridResult queryPagedComments(String itemId, Integer level, Integer page, Integer pageSize);

    /**
     * 根据关键字搜索某种类型的商品，可以选择排序类型
     * @param keywords
     * @param sort
     * @param page
     * @param pageSize
     * @return
     */
    public PagedGridResult searchItems(String keywords, String sort, Integer page, Integer pageSize);

    /**
     * 根据关键字搜索某种类型的商品，可以选择排序类型
     * @param catId
     * @param sort
     * @param page
     * @param pageSize
     * @return
     */
    public PagedGridResult searchItemsByThirdCat(String catId, String sort, Integer page, Integer pageSize);

    /**
     * 传入cookie中的商品id拼接的字符串，使用这些id更新cookie信息
     * @param itemSpecIds
     * @return
     */
    public List<ShopcartVO> queryItemsBySpecIds(String itemSpecIds);

}
