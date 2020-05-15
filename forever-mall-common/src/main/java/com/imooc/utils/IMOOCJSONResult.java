package com.imooc.utils;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @Title: IMOOCJSONResult.java
 * @Pachage: com.imocc.utils
 * @Description: 自定义响应数据结构
 *                  本类可以提供给H5/ios/安卓，公众号，小程序等使用
 *                  前端接受这类数据之后json object， 可以自行根据业务实现相关的功能
 *
 *                  200:成功
 *                  500:错误
 *                  501：bean验证信息错误，不管多少个错无都是用map的形式返回
 *                  502：拦截器拦截到用户token出错
 *                  555：异常抛出信息
 *                  556：用户qq校验异常
 * @Copyright:
 * @Company:
 * @author: chengyiming
 * @version
 */
public class IMOOCJSONResult {

    //定义jackson对象
    private static final ObjectMapper MAPPER = new ObjectMapper();

    //相应业务状态
    private Integer status;

    //响应消息
    private String msg;

    //响应中的数据
    private Object data;

    @JsonIgnore
    private String ok;

    //--------下面是一些构造函数
    public IMOOCJSONResult() {}

    public IMOOCJSONResult(Integer status, String msg, Object data) {
        this.status = status;
        this.msg = msg;
        this.data = data;
    }

    public IMOOCJSONResult(Object data) {
        this.data = data;
    }

    public IMOOCJSONResult(Integer status, String msg, Object data, String ok) {
        this.status = status;
        this.msg = msg;
        this.data = data;
        this.ok = ok;
    }

    //------常用的函数
    public static IMOOCJSONResult build(Integer status, String msg, Object data) {
        return new IMOOCJSONResult(status, msg, data);
    }

    public static IMOOCJSONResult build(Integer status, String msg, Object data, String ok) {
        return new IMOOCJSONResult(status, msg, data, ok);
    }

    public static IMOOCJSONResult ok(Object data) {
        return new IMOOCJSONResult(data);
    }

    public static IMOOCJSONResult ok() {
        return new IMOOCJSONResult(null);
    }

    public static IMOOCJSONResult errorMsg(String msg) {
        return new IMOOCJSONResult(500, msg, null);
    }

    public static IMOOCJSONResult errorMap(Object data) {
        return new IMOOCJSONResult(501, "error", data);
    }

    public static IMOOCJSONResult errorTokenMsg(String msg) {
        return new IMOOCJSONResult(502, msg, null);
    }

    public static IMOOCJSONResult errorException(String msg) {
        return new IMOOCJSONResult(555, msg, null);
    }

    public static IMOOCJSONResult errorUserQQ(String msg) {
        return new IMOOCJSONResult(556, msg, null);
    }

    public Boolean isOk() {
        return this.status == 200;
    }

    public Integer getStatus() {
        return status;
    }
    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getOk() {
        return ok;
    }

    public void setOk(String ok) {
        this.ok = ok;
    }
}
