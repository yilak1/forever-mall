package com.lym.controller;

import com.lym.pojo.bo.ShopcartBO;
import com.lym.utils.IMOOCJSONResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Api(value = "购物车接口controller", tags = {"购物车接口相关的api"})
@RequestMapping("shopcart")
@RestController
public class ShopcatController {

    @ApiOperation(value = "添加商品到购物车", notes = "添加商品到购物车", httpMethod = "POST")
    @PostMapping("/add")
    public IMOOCJSONResult add(
            @RequestParam String userId,
            @RequestBody ShopcartBO shopcartBO,
            HttpServletRequest request,
            HttpServletResponse response
    ) {

        if (StringUtils.isBlank(userId)) {
            return IMOOCJSONResult.errorMsg("");
        }

        System.out.println(shopcartBO);

        // TODO 前端用户在登录的情况下，添加商品到购物车，会同时在后端同步购物车到redis缓存

        return IMOOCJSONResult.ok();
    }


    @ApiOperation(value = "登录状态删除购物车中的某规格商品", notes = "登录状态删除购物车中的某规格商品notes", httpMethod = "POST")
    @PostMapping("/del")
    public IMOOCJSONResult del(
            @ApiParam(name = "userId", value = "用户的userId", required = true)
            @RequestParam String userId,
            @ApiParam(name = "itemSpecId", value = "商品的规格id", required = true)
            @RequestParam String itemSpecId
    ) {

        if (StringUtils.isBlank(userId)) {
            return IMOOCJSONResult.errorMsg("");
        }

        if (StringUtils.isBlank(itemSpecId)) {
            return IMOOCJSONResult.errorMsg("");
        }

        // TODO 前端用户在登录的情况下， 删除商品，会同步删除缓存中的商品

        return IMOOCJSONResult.ok();
    }


}
