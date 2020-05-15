package com.lym.controller;

import com.imooc.utils.IMOOCJSONResult;
import com.lym.pojo.Items;
import com.lym.pojo.ItemsImg;
import com.lym.pojo.ItemsParam;
import com.lym.pojo.ItemsSpec;
import com.lym.pojo.vo.NewItemsVo;
import com.lym.service.ItemService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @author chengyiming
 * @Date 2020-05-10
 */
//@Api(value = "商品接口", tags = {"商品信息展示的相关接口"})
@RestController
@RequestMapping("items")
public class ItemsController {

    @Autowired
    private ItemService itemService;

    @ApiOperation(value = "查询商品详情", notes = "查询商品详情", httpMethod = "GET")
    //路由地址需要参考前端
    @GetMapping("/info/{itemId}")
    public IMOOCJSONResult info(
            //说明这个参数是必须要填的
            @ApiParam(name = "itemId", value = "商品id", required = true)
            @PathVariable String itemId) {

        if(StringUtils.isEmpty(itemId)) {
            //这里的检查是为了避免恶意的攻击或者爬虫
            return IMOOCJSONResult.errorMsg("商品不存在 ");
        }
        Items items = itemService.queryItemById(itemId);
        List<ItemsImg> itemsImgs = itemService.queryItemImgList(itemId);
        List<ItemsSpec> itemsSpecs = itemService.queryItemSpecList(itemId);
        ItemsParam itemsParam = itemService.queryItemParam(itemId);
        return IMOOCJSONResult.ok();
    }


}
