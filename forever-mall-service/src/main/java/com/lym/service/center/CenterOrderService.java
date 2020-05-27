package com.lym.service.center;

import com.lym.pojo.vo.center.OrderVO;
import com.lym.utils.PagedGridResult;

import java.util.List;

/**
 * 和订单相关的服务类
 */
public interface CenterOrderService {

    /**
     * 根据用户的userId以及订单的状态orderStatus查询订单
     * @param userId
     * @param orderStatus
     * @param page
     * @param pageSize
     * @return
     */
    public PagedGridResult queryMyOrders(String userId,
                                         Integer orderStatus,
                                         Integer page,
                                         Integer pageSize);
}
