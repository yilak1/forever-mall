package com.lym.pojo.vo.center;

/**
 * order中的itemSpec类
 * 因为每一个订单中可能存在多个itemSpec
 * */
public class OrderItemSpec {
    private String itemId;
    private String itemImg;
    private String itemName;
    private String itemSpecName;
    private int price;
    private int buyCounts;

    private String itemSpecId;

    public String getItemSpecId() {
        return itemSpecId;
    }

    public void setItemSpecId(String itemSpecId) {
        this.itemSpecId = itemSpecId;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getItemImg() {
        return itemImg;
    }

    public void setItemImg(String itemImg) {
        this.itemImg = itemImg;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemSpecName() {
        return itemSpecName;
    }

    public void setItemSpecName(String itemSpecName) {
        this.itemSpecName = itemSpecName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getBuyCounts() {
        return buyCounts;
    }

    public void setBuyCounts(int buyCounts) {
        this.buyCounts = buyCounts;
    }
}