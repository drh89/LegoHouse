/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import logic.CustomerValidater;
import logic.Entities.Customer;
import logic.Exceptions.CustomerException;
import logic.Exceptions.InvalidCustomerException;
import logic.Facades.CustomerMapperFacade;

/**
 *
 * @author Dennis
 */
@WebServlet(name = "LoginServlet", urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {

    private CustomerValidater cv;
    private CustomerMapperFacade cmf;

    /**
     *
     */
    public LoginServlet() {
        cv = new CustomerValidater();
        cmf = new CustomerMapperFacade();
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

        switch (choice) {
            
            case "Back":
                loginRequest(request, response);
                break;

            case "Login":
                loginRequest(request, response);
                break;

            case "Sign up":
                newUserRequest(request, response);
                break;
        }
    }

    /**
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void loginRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String email = request.getParameter("email");
        String pass = request.getParameter("pass");
        Customer cust = new Customer(email, pass);

        HttpSession session = request.getSession();
        try {
            if (cv.validCustomer(cust)) {

                cust = cmf.getCustomer(cust);
             ;
                if (cust.getAdminId() == 1) {
                    session.setAttribute("customer", cust);
                    session.setAttribute("houselist", cmf.getAllHouseInfos());
                    request.getRequestDispatcher("AdminPage.jsp").forward(request, response);
                    return;
                }

                session.setAttribute("customer", cust);
                session.setAttribute("houselist", cmf.getAllHouseInfosByCustomerId(cust.getId()));
                request.getRequestDispatcher("CustomerPage.jsp").forward(request, response);

            }
        } catch (CustomerException | InvalidCustomerException ex) {
            ex.printStackTrace();
            session.setAttribute("errormessage", "Something went wrong... Try again.");
            session.setAttribute("supportmessage", " If the problem continues please contact support...");
            request.getRequestDispatcher("LoginErrorPage.jsp").forward(request, response);
        }

    }

    /**
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void newUserRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String pass = request.getParameter("pass");
        Customer cust = new Customer(username, email, pass);

        HttpSession session = request.getSession();
        try {
            if (cv.newCustomerIsValid(cust)) {

                cmf.createCustomer(cust);
                session.setAttribute("confirmation", "Congratulations... You are now ready to log in");
                request.getRequestDispatcher("UserCreatedPage.jsp").forward(request, response);

            }
        } catch (CustomerException | InvalidCustomerException ex) {
            session.setAttribute("errormessage", "Something went wrong... Try again.");
            session.setAttribute("supportmessage", " If the problem continues please contact support...");
            request.getRequestDispatcher("LoginErrorPage.jsp").forward(request, response);
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
