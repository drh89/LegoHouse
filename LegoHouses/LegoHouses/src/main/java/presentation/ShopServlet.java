/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import logic.Calculator;
import logic.CustomerValidater;
import logic.Entities.Customer;
import logic.Entities.HouseInfo;
import logic.Entities.Order;
import logic.Exceptions.CustomerException;
import logic.Exceptions.InvalidCustomerException;
import logic.Exceptions.OrderException;
import logic.Facades.CustomerMapperFacade;
import logic.Facades.OrderMapperFacade;

/**
 *
 * @author Dennis
 */
@WebServlet(name = "ShopServlet", urlPatterns = {"/ShopServlet"})
public class ShopServlet extends HttpServlet {

    private CustomerValidater cv;
    private CustomerMapperFacade cmf;
    private OrderMapperFacade omf;
    private Calculator calc;

    /**
     *
     */
    public ShopServlet() {
        cv = new CustomerValidater();
        cmf = new CustomerMapperFacade();
        omf = new OrderMapperFacade();
        calc = new Calculator();
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String choice = request.getParameter("choice");
        HttpSession session = request.getSession();
        Customer cust = (Customer) session.getAttribute("customer");
        try {
            if (cv.validCustomer(cust)) {

                switch (choice) {

                    case "See Bricklist":                        
                        int orderId = Integer.valueOf(request.getParameter("order"));                      

                        List<Integer> brickList = calc.calculateHouse(omf.getHouseInfo(orderId));
                        session.setAttribute("bricklist", brickList);
                        request.getRequestDispatcher("BricklistPage.jsp").forward(request, response);

                        break;

                    case "Add funds":
                        request.getRequestDispatcher("AddFundsPage.jsp").forward(request, response);

                        break;
                        
                    case "Log out":
                        session.invalidate();
                        request.getRequestDispatcher("index.html").forward(request, response);

                }
            }
        } catch (CustomerException | InvalidCustomerException | OrderException | NumberFormatException | NullPointerException ex) {
            session.setAttribute("errormessage", "Something went wrong... Try again.");
            session.setAttribute("supportmessage", " If the problem continues please contact support...");
            request.getRequestDispatcher("ShopErrorPage.jsp").forward(request, response);
           
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String choice = request.getParameter("choice");
        HttpSession session = request.getSession();
        Customer cust = (Customer) session.getAttribute("customer");
        try {
            if (cv.validCustomer(cust)) {
                switch (choice) {
                    case "Calculate price":
                        int length = Integer.valueOf(request.getParameter("length"));
                        int width = Integer.valueOf(request.getParameter("width"));
                        int height = Integer.valueOf(request.getParameter("height"));
                        if (length <= 0 || width <= 0 || height <= 0) {
                            throw new NullPointerException();
                        }
                        HouseInfo houseInfo = new HouseInfo(length, width, height, 0);
                        double price = calc.calculatePrice(houseInfo);
                        houseInfo.setPrice(price);
                        session.setAttribute("houseinfo", houseInfo);
                        request.getRequestDispatcher("CheckoutPage.jsp").forward(request, response);

                        break;

                    case "Buy":
                        HouseInfo house = (HouseInfo) session.getAttribute("houseinfo");
                        
                        if (cust.getBalance() < house.getPrice()) {
                            session.setAttribute("errormessage", "Insufficient funds... Add more funds!");                            
                            request.getRequestDispatcher("ShopErrorPage.jsp").forward(request, response);
                            return;
                        }
                        
                        Order order = new Order(cust.getId());
                        omf.createOrder(order, house);
                        cmf.updateBalance(cust, house.getPrice());
                        request.getRequestDispatcher("OrderConfirmationPage.jsp").forward(request, response);
                        break;
                        
                    case"Add funds":
                        double moneyToAdd = Double.valueOf(request.getParameter("funds"));
                        cmf.addToBalance(cust, moneyToAdd);
                        request.getRequestDispatcher("FundsAddedPage.jsp").forward(request, response);
                }

            }
        } catch (CustomerException | InvalidCustomerException | NullPointerException | OrderException | NumberFormatException ex) {
            session.setAttribute("errormessage", "Something went wrong... Try again.");
            session.setAttribute("supportmessage", " If the problem continues please contact support...");
            request.getRequestDispatcher("ShopErrorPage.jsp").forward(request, response);
        }

    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
