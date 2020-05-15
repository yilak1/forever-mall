package com.lym.service;

import com.lym.pojo.Carousel;

import java.util.List;

/**
 * @author chengyiming
 * @Date 2020-05-09
 */
public interface CarouselService {

    //查询所有的轮播图
    public List<Carousel> queryAll(Integer isShow);
}
