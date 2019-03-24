/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import java.util.List;
import logic.Entities.Customer;
import logic.Exceptions.CustomerException;
import logic.Exceptions.InvalidCustomerException;
import logic.Facades.CustomerMapperFacade;

/**
 *
 * @author Dennis
 */
public class CustomerValidater {

    private CustomerMapperFacade cmf;

    /**
     *
     */
    public CustomerValidater() {
        cmf = new CustomerMapperFacade();
    }

    /**
     *
     * @param c
     * @return
     * @throws CustomerException
     * @throws InvalidCustomerException
     */
    public boolean newCustomerIsValid(Customer c) throws CustomerException, InvalidCustomerException {
        
        List<Customer> customers = cmf.getCustomers();
        String username = c.getUsername();
        String email = c.getEmail();
        String pass = c.getPass();

        if ("".equals(username) || username.isEmpty() || "".equals(email)
                || email.isEmpty() || "".equals(pass) || pass.isEmpty()) {
            throw new InvalidCustomerException();
            
        }

        for (Customer customer : customers) {
            if (customer.getEmail().equals(email)) {
                throw new InvalidCustomerException();
            }

        }
        return true;
        
    }

    /**
     *
     * @param c
     * @return
     * @throws CustomerException
     * @throws InvalidCustomerException
     */
    public boolean validCustomer(Customer c) throws CustomerException, InvalidCustomerException{
        List<Customer> customers = cmf.getCustomers();
        String email = c.getEmail();
        String pass = c.getPass();
        
        if ("".equalsIgnoreCase(email) || null == email || email.isEmpty()){
            throw new InvalidCustomerException();
        }
        if ("".equalsIgnoreCase(pass) || null == pass || pass.isEmpty()){
            throw new InvalidCustomerException();
        }
        
        for (Customer customer : customers) {
            
            if(email.equalsIgnoreCase(customer.getEmail()) && pass.equalsIgnoreCase(customer.getPass())){
                
                return true;
               
            }
            
        }
        
        throw new InvalidCustomerException();
    }
}
