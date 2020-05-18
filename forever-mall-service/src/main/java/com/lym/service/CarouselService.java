package com.lym.service;

import com.lym.pojo.Carousel;

import java.util.List;

public interface CarouselService {

    /**
     * 查询所有的轮播图列表
     * @param isShow
     * @return
     */
    public List<Carousel> queryAll(Integer isShow);
}
