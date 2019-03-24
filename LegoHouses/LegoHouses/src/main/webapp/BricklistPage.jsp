<%-- 
    Document   : BricklistPage
    Created on : 23-03-2019, 01:43:59
    Author     : Dennis
--%>

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
            h1{
                text-align: center;
            }
        </style>
    </head>
    <body>
        <h1>Bricklist Page</h1>
        <%List<Integer> brickList = (ArrayList) session.getAttribute("bricklist");%>
    <center>
        <table>
            <tr>
            <th>Bricksize:</th>
            <th>1x2:</th>
            <th>2x2:</th>
            <th>4x2:</th>
            </tr>
            <tr>
                <th>Quantity:</th>
                <td><%out.print(brickList.get(0));%></td>
                <td><%out.print(brickList.get(1));%></td>
                <td><%out.print(brickList.get(2));%></td>
                
            </tr>
        </table>

    </center>
    <form method="POST">
        <div class="topright">
            <br>
            <input type="submit" name="choice" value="Back" formaction="LoginServlet">





        </div>
        <%Customer cust = (Customer) session.getAttribute("customer");%>
        <input type ="hidden" name ="email" value="<%out.print(cust.getEmail());%>">
        <input type ="hidden" name ="pass" value="<%out.print(cust.getPass());%>">
    </form>
</body>
</html>
