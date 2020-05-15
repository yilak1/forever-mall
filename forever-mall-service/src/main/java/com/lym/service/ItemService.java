package com.lym.service;

import com.lym.pojo.Items;
import com.lym.pojo.ItemsImg;
import com.lym.pojo.ItemsParam;
import com.lym.pojo.ItemsSpec;
import com.sun.org.apache.xerces.internal.xs.ItemPSVI;

import java.util.List;

public interface ItemService {

    /**
     * 根据商品ID查询详情
     * @param itemId
     * @return
     */
    public Items queryItemById(String itemId);

    /**
     * 根据商品id查询商品图片列表
     * @param itemId
     * @return
     */
    public List<ItemsImg> queryItemImgList(String itemId);

    /**
     * 查询商品的规格列表
     * @param itemId
     * @return
     */
    public List<ItemsSpec> queryItemSpecList(String itemId);

    /**
     * 根据商品的id查询商品的参数
     * @param itemId
     * @return
     */
    public ItemsParam queryItemParam(String itemId);

}
