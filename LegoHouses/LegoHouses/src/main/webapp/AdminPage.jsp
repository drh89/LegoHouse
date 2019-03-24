<%-- 
    Document   : AdminPage
    Created on : 23-03-2019, 00:48:26
    Author     : Dennis
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="logic.Entities.HouseInfo"%>
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
        <h1>Admin Page</h1>
        <form method="POST">
            <center>
                <%List<HouseInfo> houseList = (ArrayList) session.getAttribute("houselist");%>
                <table>
                    <tr>
                        <th>Length</th>
                        <th>Width</th>
                        <th>Height</th>
                        <th>Price</th>
                        <th>Date</th>
                        <th>Status</th>
                        <th>CustomerId</th>
                    </tr>
                    <%for (HouseInfo houseInfo : houseList) {%>
                    <tr>
                        <td><%out.print(houseInfo.getLength());%></td>
                        <td><%out.print(houseInfo.getWidth());%></td>
                        <td><%out.print(houseInfo.getHeight());%></td>
                        <td><%out.print(houseInfo.getPrice() + " kr");%></td>
                        <td><%out.print(houseInfo.getOrderDate());%></td>
                        <td><%out.print(houseInfo.getShippingStatus());%></td>
                        <td><%out.print(houseInfo.getCustomerId());%></td>
                        <%int orderId = houseInfo.getOrderId();%>
                        <td><input type="radio" name="order" value = "<%out.print(orderId);%>"</td>
                    </tr>     
                    <%}%>
                </table>
            </center>
                <div class="topright">
                    <input type="submit" name="choice" value="Send Order" formaction="AdminServlet">
                </div>

        </form>
        <div class="topLeft">
            <br>
            <br>
            <form method="GET">
            <input type="submit" name="choice" value="Log out" formaction="AdminServlet">
            </form>
        </div>
    </body>
</html>
