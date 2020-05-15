package com.lym.controller;

import com.imooc.enums.YesOrNo;
import com.imooc.utils.IMOOCJSONResult;
import com.lym.pojo.Carousel;
import com.lym.pojo.Category;
import com.lym.pojo.vo.CategoryVo;
import com.lym.pojo.vo.NewItemsVo;
import com.lym.service.CarouselService;
import com.lym.service.CategoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(value = "首页", tags = {"首页展示的相关接口"})
@RestController
@RequestMapping("index")
public class IndexController {

    @Autowired
    private CarouselService carouselService;

    @Autowired
    private CategoryService categoryService;


    @GetMapping("/carousel")
    public IMOOCJSONResult carousel() {
        List<Carousel> list = carouselService.queryAll(YesOrNo.YES.type);
        //前端进行解析并展示到首页
        return IMOOCJSONResult.ok(list);
    }

    /**
     * 首页分类展示需求
     * 1、第一次刷新主页查询大分类，渲染展示到首页
     * 2、当鼠标上移到大分类，则加载其子分类的内容
     * 如果已经存在了子分类，则不需要加载（懒加载模式）
     */
    //这个名字是必须要和前端进行对应的
    @GetMapping("/cats")
    public IMOOCJSONResult cats() {
        List<Category> list = categoryService.queryAllRootLevelCat();
        return IMOOCJSONResult.ok(list);
    }


    //在首页移动鼠标进行查询
    @GetMapping("/subCat/{rootCatId}")
    public IMOOCJSONResult subCat(
            //说明这个参数是必须要填的
            @ApiParam(name = "rootCatId", value = "一级分类id", required = true)
            @PathVariable Integer rootCatId) {
        if(rootCatId == null) {
            //这里的检查是为了避免恶意的攻击或者爬虫
            return IMOOCJSONResult.errorMsg("分类不存在 ");
        }
        List<CategoryVo> list = categoryService.getSubCatList(rootCatId);
        return IMOOCJSONResult.ok(list);
    }


    //根据大分类推荐6种最新商品
    @ApiOperation(value = "查询每个一级分类下的最新6条商品数据", notes = "查询每个一级分类下的最新6条商品数据", httpMethod = "GET")
    //路由地址需要参考前端
    @GetMapping("/sixNewItems/{rootCatId}")
    public IMOOCJSONResult sixNewItems(
            //说明这个参数是必须要填的
            @ApiParam(name = "rootCatId", value = "一级分类id", required = true)
            @PathVariable Integer rootCatId) {
        if(rootCatId == null) {
            //这里的检查是为了避免恶意的攻击或者爬虫
            return IMOOCJSONResult.errorMsg("分类不存在 ");
        }
        List<NewItemsVo> list = categoryService.getSixNewItemsLazy(rootCatId);
        return IMOOCJSONResult.ok(list);
    }



}
