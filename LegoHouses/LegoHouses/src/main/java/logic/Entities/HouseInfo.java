/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic.Entities;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Dennis
 */
public class HouseInfo implements Serializable {
    
    private int length;
    private int width;
    private int height;
    private int orderId;
    private int customerId;
    private double price;
    private String orderDate;
    private String shippingStatus;
    private String username;
    
    
    //Used when writing to DB
    public HouseInfo(int length, int width, int height, int orderId, double price){
        this.length = length;
        this.width = width;
        this.height = height;
        this.orderId = orderId;
        this.price = price;
        
    }
    
    //Used for customers input... will be used to calculate price.
    public HouseInfo(int length, int width, int height){
        this.length = length;
        this.width = width;
        this.height = height;
    }
    
    public HouseInfo(int length, int width, int height, double price){
        this.length = length;
        this.width = width;
        this.height = height;
        this.price = price;
    }
    
    //Used when getting from DB view (GetHouseInfo)
    public HouseInfo(int length, int width, int height, double price, String orderDate, String shippingStatus, int orderId, String username, int customerId){
        this.length = length;
        this.width = width;
        this.height = height;
        this.price = price;
        this.orderDate = orderDate;
        this.shippingStatus = shippingStatus;
        this.orderId = orderId;
        this.username = username;
        this.customerId = customerId;
    }

    /**
     * @return the length
     */
    public int getLength() {
        return length;
    }

    /**
     * @param length the length to set
     */
    public void setLength(int length) {
        this.length = length;
    }

    /**
     * @return the width
     */
    public int getWidth() {
        return width;
    }

    /**
     * @param width the width to set
     */
    public void setWidth(int width) {
        this.width = width;
    }

    /**
     * @return the height
     */
    public int getHeight() {
        return height;
    }

    /**
     * @param height the height to set
     */
    public void setHeight(int height) {
        this.height = height;
    }

    /**
     * @return the orderId
     */
    public int getOrderId() {
        return orderId;
    }

    /**
     * @param orderId the orderId to set
     */
    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    /**
     * @return the orderDate
     */
    public String getOrderDate() {
        return orderDate;
    }

    /**
     * @param orderDate the orderDate to set
     */
    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    /**
     * @return the price
     */
    public double getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * @return the customerId
     */
    public int getCustomerId() {
        return customerId;
    }

    /**
     * @param customerId the customerId to set
     */
    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    /**
     * @return the shippingStatus
     */
    public String getShippingStatus() {
        return shippingStatus;
    }

    /**
     * @param shippingStatus the shippingStatus to set
     */
    public void setShippingStatus(String shippingStatus) {
        this.shippingStatus = shippingStatus;
    }

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    
}
