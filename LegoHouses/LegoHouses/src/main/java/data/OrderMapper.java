/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import logic.Entities.Customer;
import logic.Entities.HouseInfo;
import logic.Entities.Order;
import logic.Exceptions.OrderException;
import logic.Interfaces.OrderMapperIF;

/**
 *
 * @author Dennis
 */
public class OrderMapper implements OrderMapperIF {

    private DBConnector dbc;

    /**
     *
     */
    public OrderMapper() {
        dbc = new DBConnector();
    }

    /**
     *
     * @param orderId
     * @throws OrderException
     */
    @Override
    public void sendOrder(int orderId) throws OrderException {
        
        try {
            String status = "Shipped";
            
            String query = "UPDATE Orders SET shippingStatus = (?) WHERE id = (?)";
            PreparedStatement stmt = dbc.preparedStatement(query);
            
            stmt.setString(1, status);
            stmt.setInt(2, orderId);
            stmt.executeUpdate();
        } catch (ClassNotFoundException | SQLException ex) {
            throw new OrderException();
        }
    }

    /**
     *
     * @param args
     * @throws OrderException
     */
    public static void main(String[] args) throws OrderException {
        OrderMapper om = new OrderMapper();
        System.out.println(om.getHouseInfo(1));
    }

    /**
     *
     * @param orderId
     * @return
     * @throws OrderException
     */
    @Override
    public HouseInfo getHouseInfo(int orderId) throws OrderException {
        try {
            HouseInfo result = null;

            String query = "SELECT * FROM OrderHouseInfo WHERE orderId = (?);";
            PreparedStatement stmt = dbc.preparedStatement(query);

            stmt.setInt(1, orderId);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {

                int length = rs.getInt("length");
                int width = rs.getInt("width");
                int height = rs.getInt("height");
                double price = rs.getDouble("price");
                String orderDate = rs.getDate("orderDate").toString();
                String shippingStatus = rs.getString("shippingStatus");
                int _orderId = rs.getInt("orderId");
                String username = rs.getString("username");
                int customerId = rs.getInt("customerId");

                result = new HouseInfo(length, width, height, price, orderDate, shippingStatus, _orderId, username, customerId);

            }

            return result;

        } catch (SQLException | ClassNotFoundException ex) {
//            ex.printStackTrace();
                        throw new OrderException();

        }
    }

    /**
     *
     * @param order
     * @param houseInfo
     * @throws OrderException
     */
    @Override
    public void createOrder(Order order, HouseInfo houseInfo) throws OrderException {
        
        try {
            int customerId = order.getCustomerId();
            int length = houseInfo.getLength();
            int width = houseInfo.getWidth();
            int height = houseInfo.getHeight();
            double price = houseInfo.getPrice();
            
            String orderQuery = "INSERT INTO Orders(customerId) VALUES(?);";
            PreparedStatement orderStmt = dbc.prepareKeys(orderQuery, Statement.RETURN_GENERATED_KEYS);
            
            orderStmt.setInt(1, customerId);
            orderStmt.executeUpdate();
            
            ResultSet rs = orderStmt.getGeneratedKeys();
            
            while(rs.next()){
            int orderId = rs.getInt(1);
            
            String infoQuery = "INSERT INTO HouseInfo(length, width, height, price, orderId) VALUES(?,?,?,?,?);";
            PreparedStatement infoStmt = dbc.preparedStatement(infoQuery);
            
            infoStmt.setInt(1, length);
            infoStmt.setInt(2, width);
            infoStmt.setInt(3, height);
            infoStmt.setDouble(4, price);
            infoStmt.setInt(5, orderId);
            infoStmt.executeUpdate();
            }
        } catch (ClassNotFoundException | SQLException ex) {
            throw new OrderException();
        }
        
                
        
    }

//    @Override
//    public List<HouseInfo> getAllHouseInfos() throws OrderException {
//        try {
//            List<HouseInfo> his = new ArrayList();
//            HouseInfo hi = null;
//
//            String query = "SELECT * FROM OrderHouseInfo;";
//            PreparedStatement stmt = dbc.preparedStatement(query);
//            ResultSet rs = stmt.executeQuery();
//
//            while (rs.next()) {
//
//                int length = rs.getInt("length");
//                int width = rs.getInt("width");
//                int height = rs.getInt("height");
//                double price = rs.getDouble("price");
//                String orderDate = rs.getDate("orderDate").toString();
//                String shippingStatus = rs.getString("shippingStatus");
//                int orderId = rs.getInt("orderId");
//                String username = rs.getString("username");
//                int customerId = rs.getInt("custromerId");
//
//                hi = new HouseInfo(length, width, height, price, orderDate, shippingStatus, orderId, username, customerId);
//                his.add(hi);
//
//            }
//            return his;
//        } catch (ClassNotFoundException | SQLException ex) {
//            throw new OrderException();
//        }
//    }

//    @Override
//    public List<HouseInfo> getAllHouseInfosByCustomerId(int customerId) throws OrderException {
//        try {
//            List<HouseInfo> his = new ArrayList();
//            HouseInfo hi = null;
//            
//
//            String query = "SELECT * FROM OrderHouseInfo WHERE customerId = (?);";
//
//            PreparedStatement stmt = dbc.preparedStatement(query);
//            stmt.setInt(1, customerId);
//
//            ResultSet rs = stmt.executeQuery();
//
//            while (rs.next()) {
//
//                int length = rs.getInt("length");
//                int width = rs.getInt("width");
//                int height = rs.getInt("height");
//                double price = rs.getDouble("price");
//                String orderDate = rs.getDate("orderDate").toString();
//                String shippingStatus = rs.getString("shippingStatus");
//                int orderId = rs.getInt("orderId");
//                String username = rs.getString("username");
//                int _customerId = rs.getInt("customerId");
//
//                hi = new HouseInfo(length, width, height, price, orderDate, shippingStatus, orderId, username, _customerId);
//                his.add(hi);
//
//            }
//            return his;
//        } catch (ClassNotFoundException | SQLException ex) {
//            throw new OrderException();
//        }
//
//    }

   

}
