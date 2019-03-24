/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic.Facades;

import data.OrderMapper;
import java.util.List;
import logic.Entities.Customer;
import logic.Entities.HouseInfo;
import logic.Entities.Order;
import logic.Exceptions.OrderException;
import logic.Interfaces.OrderMapperIF;

/**
 *
 * @author Dennis
 */
public class OrderMapperFacade implements OrderMapperIF {
    
    private OrderMapper om;
    
    public OrderMapperFacade(){
        om = new OrderMapper();        
    }

    @Override
    public void createOrder(Order order, HouseInfo houseInfo) throws OrderException {
        om.createOrder(order, houseInfo);
    }

    @Override
    public void sendOrder(int orderId) throws OrderException {
        om.sendOrder(orderId);
    }

    @Override
    public HouseInfo getHouseInfo(int orderId) throws OrderException {
        HouseInfo hi = om.getHouseInfo(orderId);
        return hi;
    }

//    @Override
//    public List getAllHouseInfos() throws OrderException {
//        List<HouseInfo> his = om.getAllHouseInfos();
//        return his;
//    }

//    @Override
//    public List getAllHouseInfosByCustomerId(int id) throws OrderException {
//        List<HouseInfo> his = om.getAllHouseInfosByCustomerId(id);
//        return his;
//    }

  

   
}
