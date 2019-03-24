/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic.Facades;

import data.CustomerMapper;
import java.util.List;
import logic.Entities.Customer;
import logic.Entities.HouseInfo;
import logic.Exceptions.CustomerException;
import logic.Interfaces.CustomerMapperIF;

/**
 *
 * @author Dennis
 */
public class CustomerMapperFacade implements CustomerMapperIF {

    private CustomerMapper cm;

    public CustomerMapperFacade() {
        cm = new CustomerMapper();
    }

    @Override
    public List<Customer> getCustomers() throws CustomerException {
        List<Customer> result = cm.getCustomers();
        return result;

    }

    @Override
    public void createCustomer(Customer c) throws CustomerException {
        cm.createCustomer(c);
    }

    @Override
    public Customer getCustomer(Customer c) throws CustomerException {
        Customer result = cm.getCustomer(c);
        return result;
    }

    @Override
    public void updateBalance(Customer c, double orderPrice) throws CustomerException {
        cm.updateBalance(c, orderPrice);
    }

    @Override
    public void addToBalance(Customer c, double moneyToAdd) throws CustomerException {
        cm.addToBalance(c, moneyToAdd);
    }

    @Override
    public List<HouseInfo> getAllHouseInfosByCustomerId(int id) throws CustomerException {
        List<HouseInfo> his = cm.getAllHouseInfosByCustomerId(id);
        return his;
    }

    @Override
    public List<HouseInfo> getAllHouseInfos() throws CustomerException {
        List<HouseInfo> his = cm.getAllHouseInfos();
        return his;
    }

}
