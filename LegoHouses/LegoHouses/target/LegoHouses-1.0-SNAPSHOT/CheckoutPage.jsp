<%-- 
    Document   : CheckoutPage
    Created on : 23-03-2019, 02:17:36
    Author     : Dennis
--%>

<%@page import="logic.Entities.Customer"%>
<%@page import="logic.Entities.HouseInfo"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
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
        </style>
    </head>
    <body>
    <center> <b><h1>Checkout</h1></b></center>
    <form method="POST">
        <div class="topright">
            <%Customer cust = (Customer) session.getAttribute("customer");%>
            <p><%out.print("Hello " + "<i>" + cust.getUsername() + "</i>");%></p>
            <p><%out.print("Balance: " + cust.getBalance());%></p>
            <br>

            <br>
            <input type="submit" name="choice" value="Buy" formaction="ShopServlet">
            <br>
            <br>
            <input type="submit" name="choice" value="Back" formaction="LoginServlet">


        </div>
        <input type ="hidden" name ="email" value="<%out.print(cust.getEmail());%>">
        <input type ="hidden" name ="pass" value="<%out.print(cust.getPass());%>">
    </form>

    <%HouseInfo houseInfo = (HouseInfo) session.getAttribute("houseinfo");%>
    <center><table>
            <tr>
                <th>Length</th>
                <th>Width</th>
                <th>Height</th>
                <th>Price</th>
            </tr>
            <tr>
                <td><%out.print(houseInfo.getLength());%></td>
                <td><%out.print(houseInfo.getWidth());%></td>
                <td><%out.print(houseInfo.getHeight());%></td>
                <td><%out.print(houseInfo.getPrice() + " kr");%></td>
            </tr>

        </table></center>


</body>
</html>
