/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic.Entities;

/**
 *
 * @author Dennis
 */
public class Order {
    
    private int id;
    private int customerId;
    private String shippingStatus;
    private String orderDate;
    
    
    //Used for when getting an order from DB
    public Order(int id, int customerId, String shippingStatus, String orderDate){
        this.id = id;
        this.customerId = customerId;
        this.shippingStatus = shippingStatus;
        this.orderDate = orderDate;
    }
    
    //Used when writing an order to DB
    public Order(int customerId){
        this.customerId = customerId;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @return the customerId
     */
    public int getCustomerId() {
        return customerId;
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
    
}
