/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic.Interfaces;

import java.util.List;
import logic.Entities.Customer;
import logic.Exceptions.CustomerException;
import logic.Exceptions.OrderException;

/**
 *
 * @author Dennis
 */
public interface CustomerMapperIF {

    List getCustomers() throws CustomerException;

    void createCustomer(Customer c) throws CustomerException;

    Customer getCustomer(Customer c) throws CustomerException;
    
    void updateBalance (Customer c, double orderPrice) throws CustomerException;
    
    void addToBalance (Customer c, double moneyToAdd) throws CustomerException;
    
    List getAllHouseInfosByCustomerId(int id) throws CustomerException;
    
    List getAllHouseInfos() throws CustomerException;
}
