package com.lym.pojo.vo.center;


import java.util.List;

/**
 * 用户的订单返回给前端的VO
 */
public class OrderVO {
    private String orderId;
    private String createdTime;
    private int payMethod;
    private Integer realPayAmount;
    private Integer postAmount;
    private int orderStatus;
    private int isComment;
    private List<OrderItemSpec> subItem;

    public int getIsComment() {
        return isComment;
    }

    public void setIsComment(int isComment) {
        this.isComment = isComment;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(String createdTime) {
        this.createdTime = createdTime;
    }

    public int getPayMethod() {
        return payMethod;
    }

    public void setPayMethod(int payMethod) {
        this.payMethod = payMethod;
    }

    public Integer getRealPayAmount() {
        return realPayAmount;
    }

    public void setRealPayAmount(Integer realPayAmount) {
        this.realPayAmount = realPayAmount;
    }

    public Integer getPostAmount() {
        return postAmount;
    }

    public void setPostAmount(Integer postAmount) {
        this.postAmount = postAmount;
    }

    public int getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(int orderStatus) {
        this.orderStatus = orderStatus;
    }

    public List<OrderItemSpec> getSubItem() {
        return subItem;
    }

    public void setSubItem(List<OrderItemSpec> subItem) {
        this.subItem = subItem;
    }
}
