package com.lym.mapper;

import com.lym.my.mapper.MyMapper;
import com.lym.pojo.Orders;
import com.lym.pojo.vo.center.OrderVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 查询订单的结果
 */
public interface OrdersMapperCustom {

    public List<OrderVO> queryOrders(@Param("paramsMap") Map<String, Object> map);
}