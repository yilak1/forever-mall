package com.lym.service.impl.center;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lym.mapper.OrdersMapperCustom;
import com.lym.pojo.vo.center.OrderVO;
import com.lym.service.center.CenterOrderService;
import com.lym.utils.PagedGridResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * 和提供订单查询的相关功能
 * @author: chengyiming
 * @Date: 2020-05-27
 *
 */
@Service
public class CenterOrderServiceImpl implements CenterOrderService {

    @Autowired
    private OrdersMapperCustom ordersMapperCustom;


    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public PagedGridResult queryMyOrders(String userId, Integer orderStatus, Integer page, Integer pageSize) {
        Map<String, Object> map = new HashMap<>();
        map.put("userId", userId);
        if(orderStatus != null) {
            map.put("orderStatus", orderStatus);
        }

        map.put("page", page);
        map.put("pageSize", pageSize);
        PageHelper.startPage(page, pageSize);
        List<OrderVO> orderVOS = ordersMapperCustom.queryOrders(map);
        return setterPagedGrid(orderVOS, page);
    }

    private PagedGridResult setterPagedGrid(List<?> list, Integer page) {
        PageInfo<?> pageList = new PageInfo<>(list);
        PagedGridResult pagedGridResult = new PagedGridResult();
        pagedGridResult.setPage(page);
        pagedGridResult.setRows(list);
        pagedGridResult.setTotal(pageList.getPages());
        pagedGridResult.setRecords(pageList.getTotal());
        return pagedGridResult;
    }


}
