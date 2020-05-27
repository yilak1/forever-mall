package com.lym.controller.center;

import com.lym.controller.BaseController;
import com.lym.pojo.vo.center.OrderVO;
import com.lym.service.center.CenterOrderService;
import com.lym.utils.IMOOCJSONResult;
import com.lym.utils.PagedGridResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(value = "用户的订单", tags = {"用户的订单"})
@RestController
@RequestMapping("myorders")
public class CenterOrderController extends BaseController {

    @Autowired
    private CenterOrderService centerOrderService;


    @ApiOperation(value = "查询用户的订单", notes = "查询用户的订单", httpMethod = "POST")
    @PostMapping("query")
    public IMOOCJSONResult query(
            @ApiParam(name = "userId", value = "用户的id", required = true)
            @RequestParam String userId,
            @ApiParam(name = "orderStatus", value = "订单的状态", example = "未结账", required = false)
            @RequestParam Integer orderStatus,
            @ApiParam(name = "page", value = "当前页数", required = false)
            @RequestParam Integer page,
            @ApiParam(name = "pageSize", value = "数据的条目数", required = false)
            @RequestParam Integer pageSize
            ) {
        if(StringUtils.isBlank(userId)) {
            return IMOOCJSONResult.errorMsg("用户id不能是空");
        }

        if (page == null) {
            page = 1;
        }

        if (pageSize == null) {
            pageSize = COMMON_PAGE_SIZE;
        }
        PagedGridResult grid = centerOrderService.queryMyOrders(userId, orderStatus, page, pageSize);

        return IMOOCJSONResult.ok(grid);
    }
}
