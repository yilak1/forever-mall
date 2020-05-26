package com.lym.controller;

import org.springframework.stereotype.Controller;

import java.io.File;

/**
 * 这里为啥至于专门搞一个类，不明白
 */
@Controller
public class BaseController {

    public static final Integer COMMON_PAGE_SIZE = 10;
    public static final Integer PAGE_SIZE = 20;

    //服务器上面头像的保存位置
    public static final String IMAGE_USER_FACE_LOCATION =
                                        "D:" + File.separator +
                                        "java" + File.separator +
                                        "code"+ File.separator +
                                        "forever_mall_uploaddir";

}
