/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic.Interfaces;

import java.util.List;
import logic.Entities.Customer;
import logic.Entities.HouseInfo;
import logic.Entities.Order;
import logic.Exceptions.OrderException;

/**
 *
 * @author Dennis
 */
public interface OrderMapperIF {
    
    
    
    void createOrder(Order order, HouseInfo houseInfo) throws OrderException;
    
    void sendOrder(int orderId) throws OrderException;
    
    HouseInfo getHouseInfo(int orderId) throws OrderException;
    
    
    
    
    
    
    
    
    
}
