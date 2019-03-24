/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import com.mysql.cj.protocol.Resultset;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import logic.Entities.Customer;
import logic.Entities.HouseInfo;
import logic.Exceptions.CustomerException;
import logic.Exceptions.OrderException;
import logic.Interfaces.CustomerMapperIF;

/**
 *
 * @author Dennis
 */
public class CustomerMapper implements CustomerMapperIF {

    private DBConnector dbc;

    /**
     *
     */
    public CustomerMapper() {
        dbc = new DBConnector();
    }

    /**
     *
     * @param args
     * @throws CustomerException
     */
    public static void main(String[] args) throws CustomerException {
        CustomerMapper cm = new CustomerMapper();
        Customer temp = new Customer("Lone","lone@test.dk","1234");
        

        cm.createCustomer(temp);
    }

    /**
     *
     * @return
     * @throws CustomerException
     */
    @Override
    public List<Customer> getCustomers() throws CustomerException {

        try {
            List<Customer> customers = new ArrayList();
            Customer temp = null;

            String query = "SELECT * FROM Customers;";

            PreparedStatement stmt = dbc.preparedStatement(query);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {

                int id = rs.getInt("id");
                int adminId = rs.getInt("adminId");
                String username = rs.getString("username");
                String email = rs.getString("email");
                String pass = rs.getString("pass");
                double balance = rs.getDouble("balance");

                temp = new Customer(id, adminId, username, email, pass, balance);
                customers.add(temp);
            }
            return customers;

        } catch (ClassNotFoundException | SQLException ex) {
            throw new CustomerException();
            
        }

    }

    /**
     *
     * @param c
     * @throws CustomerException
     */
    @Override
    public void createCustomer(Customer c) throws CustomerException {
        
        try {
            String query = "INSERT INTO Customers(username, email, pass)VALUES(?,?,?);";
            
            String username = c.getUsername();
            String email = c.getEmail();
            String pass = c.getPass();
            
            PreparedStatement stmt = dbc.preparedStatement(query);
            
            stmt.setString(1, username);
            stmt.setString(2, email);
            stmt.setString(3, pass);
            stmt.executeUpdate();
        } catch (ClassNotFoundException | SQLException ex) {
            throw new CustomerException();
        }
        
    }

    /**
     *
     * @param c
     * @return
     * @throws CustomerException
     */
    @Override
    public Customer getCustomer(Customer c) throws CustomerException {
        try {
            Customer result = null;
            
            String query = "SELECT * FROM Customers WHERE email = (?) AND pass = (?);";
            
            String email = c.getEmail();
            String pass = c.getPass();
            
            PreparedStatement stmt = dbc.preparedStatement(query);
            stmt.setString(1, email);
            stmt.setString(2, pass);
            
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                
                int id = rs.getInt("id");
                int adminId = rs.getInt("adminId");
                String username = rs.getString("username");
                String _email = rs.getString("email");
                String _pass = rs.getString("pass");
                double balance = rs.getDouble("balance");
                
                result = new Customer(id, adminId, username, _email, _pass, balance);
                
                
            }
            if(!email.equalsIgnoreCase(result.getEmail()) || !pass.equalsIgnoreCase(result.getPass())){
            
                throw new CustomerException();
            }
            
            return result;
            
            
        } catch (ClassNotFoundException | SQLException ex) {
            throw new CustomerException();
        }
        
    }
    
    /**
     *
     * @param c
     * @param orderPrice
     * @throws CustomerException
     */
    @Override
    public void updateBalance(Customer c, double orderPrice) throws CustomerException {
        try {
            double newBalance = c.getBalance() - orderPrice;
            int customerId = c.getId();
            
            String query = "UPDATE Customers SET balance = (?) WHERE id = (?);";
            PreparedStatement stmt = dbc.preparedStatement(query);
            
            stmt.setDouble(1, newBalance);
            stmt.setInt(2, customerId);
            
            stmt.executeUpdate();
        } catch (ClassNotFoundException | SQLException ex) {
            throw new CustomerException();
        }
        
    }

    /**
     *
     * @param c
     * @param moneyToAdd
     * @throws CustomerException
     */
    @Override
    public void addToBalance(Customer c, double moneyToAdd) throws CustomerException {
        try {
            double newBalance = c.getBalance() + moneyToAdd;
            int customerId = c.getId();
            
            String query = "UPDATE Customers SET balance = (?) WHERE id = (?);";
            PreparedStatement stmt = dbc.preparedStatement(query);
            
            stmt.setDouble(1, newBalance);
            stmt.setInt(2, customerId);
            stmt.executeUpdate();
        } catch (ClassNotFoundException | SQLException ex) {
            throw new CustomerException();
        }
    }

    /**
     *
     * @param id
     * @return
     * @throws CustomerException
     */
    @Override
    public List<HouseInfo> getAllHouseInfosByCustomerId(int id) throws CustomerException {
        try {
            List<HouseInfo> his = new ArrayList();
            HouseInfo hi = null;
            

            String query = "SELECT * FROM OrderHouseInfo WHERE customerId = (?);";

            PreparedStatement stmt = dbc.preparedStatement(query);
            stmt.setInt(1, id);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {

                int length = rs.getInt("length");
                int width = rs.getInt("width");
                int height = rs.getInt("height");
                double price = rs.getDouble("price");
                String orderDate = rs.getDate("orderDate").toString();
                String shippingStatus = rs.getString("shippingStatus");
                int orderId = rs.getInt("orderId");
                String username = rs.getString("username");
                int _customerId = rs.getInt("customerId");

                hi = new HouseInfo(length, width, height, price, orderDate, shippingStatus, orderId, username, _customerId);
                his.add(hi);

            }
            return his;
        } catch (ClassNotFoundException | SQLException ex) {
            throw new CustomerException();
        }
    }

    /**
     *
     * @return
     * @throws CustomerException
     */
    @Override
    public List<HouseInfo> getAllHouseInfos() throws CustomerException {
         try {
            List<HouseInfo> his = new ArrayList();
            HouseInfo hi = null;

            String query = "SELECT * FROM OrderHouseInfo;";
            PreparedStatement stmt = dbc.preparedStatement(query);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {

                int length = rs.getInt("length");
                int width = rs.getInt("width");
                int height = rs.getInt("height");
                double price = rs.getDouble("price");
                String orderDate = rs.getDate("orderDate").toString();
                String shippingStatus = rs.getString("shippingStatus");
                int orderId = rs.getInt("orderId");
                String username = rs.getString("username");
                int customerId = rs.getInt("customerId");

                hi = new HouseInfo(length, width, height, price, orderDate, shippingStatus, orderId, username, customerId);
                his.add(hi);

            }
            return his;
        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
            throw new CustomerException();
        }
    }
    



    

}
