<%-- 
    Document   : CustomerPage
    Created on : 22-03-2019, 21:44:23
    Author     : Dennis
--%>

<%@page import="logic.Entities.HouseInfo"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="logic.Entities.Customer"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            h1{
                text-align: center;
            }
            .topright{
                position:absolute;
                top: 8px;
                right: 35px;
                font-size: 14px;

            }
            table {
                font-family: arial, sans-serif;
                border-collapse: collapse;
                width: 40%;
            }

            td, th {
                border: 1px solid #dddddd;
                text-align: left;
                padding: 8px;
                color: white;
            }

            tr:nth-child(even) {
                background-color: blue;
                color: white;
            }
            tr:nth-child(odd) {
                background-color: darkblue;
                color: white;
            }
            .topLeft{
                position: absolute;
                top: 20px;
                left: 10px;
                
            }

        </style>
    </head>
    <body>
        <b><h1>Shop</h1></b>
        <% Customer cust = (Customer) session.getAttribute("customer");
            List<HouseInfo> houseList = (ArrayList) session.getAttribute("houselist");
        %>


        <form method="POST">
            <center>
                <br><input placeholder="Length..." type="text" name="length" value="">
                <br><input placeholder="Width..." type="text" name="width" value="">
                <br><input placeholder="Height..." type="text" name="height" value="">
                <br><input type="submit" name="choice" value="Calculate price" formaction="ShopServlet">
            </center>

        </form>

        <form method="GET">
            <div class="topright">
                <p><%out.print("Hello " + "<i>" + cust.getUsername() + "</i>");%></p>
                <p><%out.print("Balance: " + cust.getBalance());%></p>
                <br>

                <br>
                <input type="submit" name="choice" value="Add funds" formaction="ShopServlet">
                <br>
                <br>
                <input type="submit" name="choice" value="See Bricklist" formaction="ShopServlet">
                <br>
                <br>
                <input type="submit" name="choice" value="Log out" formaction="ShopServlet">
            </div>
                <div class="topLeft">
            <table>
                <tr>
                    <th>Length</th>
                    <th>Width</th>
                    <th>Height</th>
                    <th>Price</th>
                    <th>Date</th>
                    <th>Status</th>
                </tr>
                <%for (HouseInfo houseInfo : houseList) {%>
                <tr>
                    <td><%out.print(houseInfo.getLength());%></td>
                    <td><%out.print(houseInfo.getWidth());%></td>
                    <td><%out.print(houseInfo.getHeight());%></td>
                    <td><%out.print(houseInfo.getPrice() + " kr");%></td>
                    <td><%out.print(houseInfo.getOrderDate());%></td>
                    <td><%out.print(houseInfo.getShippingStatus());%></td>
                    <%int orderId = houseInfo.getOrderId();%>
                    <td><input type="radio" name="order" value = "<%out.print(orderId);%>"</td>
                </tr>     
                <%}%>

            </table>
                </div>
        </form>


        <br>
        <br>





    </body>
</html>
