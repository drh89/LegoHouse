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
public class Customer {
    
    private int id;
    private int adminId;
    private String username;
    private String email;
    private String pass;
    private double balance;
    
    
    //Used when getting customer from DB
    public Customer(int id, int adminId, String username, String email, String pass, double balance){
        this.id = id;
        this.adminId = adminId;
        this.username = username;
        this.email = email;
        this.pass = pass;
        this.balance = balance;
    }
    
    //Used when writing customer to DB... when making new user
    public Customer(String username, String email, String pass){
        this.username = username;
        this.email = email;
        this.pass = pass;
    }
    
    public Customer(String email, String pass){
        this.email = email;
        this.pass = pass;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @return the adminId
     */
    public int getAdminId() {
        return adminId;
    }

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the pass
     */
    public String getPass() {
        return pass;
    }

    /**
     * @param pass the pass to set
     */
    public void setPass(String pass) {
        this.pass = pass;
    }

    /**
     * @return the balance
     */
    public double getBalance() {
        return balance;
    }

    /**
     * @param balance the balance to set
     */
    public void setBalance(double balance) {
        this.balance = balance;
    }
    
    
}
